package com.taeyeon.zyx.persistence.interceptor;

import com.taeyeon.zyx.persistence.DataEntity;
import com.taeyeon.zyx.session.Session;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;
import java.util.Properties;

@Intercepts({@Signature(type = Executor.class, method = "update",
        args = {MappedStatement.class, Object.class})})
public class UpdateInterceptor implements Interceptor {

    private Logger logger = LoggerFactory.getLogger(UpdateInterceptor.class);

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        MappedStatement mappedStatement = (MappedStatement) invocation.getArgs()[0];
        //sql类型
        SqlCommandType sqlCommandType = mappedStatement.getSqlCommandType();
        Object parameter = invocation.getArgs()[1];
        if ((SqlCommandType.INSERT.equals(sqlCommandType)
                || SqlCommandType.UPDATE.equals(sqlCommandType)
                || SqlCommandType.DELETE.equals(sqlCommandType))
                && StringUtils.isNotBlank(Session.getSessionUid())) {

            if (parameter instanceof DataEntity) {
                setEntityUser(parameter, sqlCommandType);
            }

            if (parameter instanceof List && ((List) parameter).size() > 0
                    && (((List) parameter).get(0) instanceof DataEntity)) {
                setEntityListUser((List) parameter, sqlCommandType);
            }

            if (parameter instanceof Map) {
                Map map = (Map) parameter;
                for (Object obj : map.values()) {
                    if (obj instanceof DataEntity) {
                        setEntityUser(obj, sqlCommandType);
                    }
                    if (obj instanceof List && ((List) obj).size() > 0
                            && (((List) obj).get(0) instanceof DataEntity)) {
                        setEntityListUser((List) obj, sqlCommandType);
                    }
                }
            }
        }
        return invocation.proceed();
    }


    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {
    }

    private void setEntityUser(Object object, SqlCommandType sqlCommandType) {
        if (SqlCommandType.INSERT.equals(sqlCommandType)) {
            setCreate(object);
        }
        if (SqlCommandType.DELETE.equals(sqlCommandType)
                || SqlCommandType.UPDATE.equals(sqlCommandType)) {
            setUpdate(object);
        }
    }

    private void setEntityListUser(List list, SqlCommandType sqlCommandType) {
        if (SqlCommandType.INSERT.equals(sqlCommandType)) {
            list.forEach(t -> setCreate(t));
        }
        if (SqlCommandType.DELETE.equals(sqlCommandType)
                || SqlCommandType.UPDATE.equals(sqlCommandType)) {
            list.forEach(t -> setUpdate(t));
        }
    }

    private void setUpdate(Object obj) {
        try {
            setProperty(obj, "updateBy");
        } catch (Exception e) {
            logger.error("setUpdate error", e);
        }
    }

    private void setCreate(Object obj) {
        try {
            setProperty(obj, "updateBy");
            setProperty(obj, "createBy");
        } catch (Exception e) {
            logger.error("setCreate error", e);
        }
    }

    private void setProperty(Object obj, String property) throws Exception {
        BeanUtils.setProperty(obj, property, Long.valueOf(Session.getSessionUid()));
    }
}
