package com.taeyeon.zyx.persistence;

import com.taeyeon.zyx.persistence.annotation.DataSourceSetter;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.AnnotationUtils;

import java.lang.reflect.Method;

public class DataSourceSettingInterceptor {

	public String doBefore(JoinPoint joinPoint) {
		String userDefineName = DataSourceHandler.getUserDefineName();
		if (!(joinPoint.getSignature() instanceof MethodSignature)) {
			return userDefineName;
		}
		String userDefineDataSource = "";
		Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
		DataSourceSetter annotation = AnnotationUtils
				.getAnnotation(method, DataSourceSetter.class); // 这里可以先看method的annotation区分数据源的
		if (annotation == null || StringUtils
				.isBlank(annotation.source())) {// 如果method没有annotation，则进一步看看class的annotation
			annotation = AnnotationUtils.getAnnotation(method.getClass(), DataSourceSetter.class);
			if (annotation != null) {
				userDefineDataSource = annotation.source();
			}
		} else {
			userDefineDataSource = annotation.source();
		}
		if (StringUtils.isNotBlank(userDefineDataSource)) {
			// 按照自定义数据源来
			DataSourceHandler.setUserDefineDataSource(userDefineDataSource);
		} else {
			DataSourceHandler.setSlave();
		}
		return userDefineName;
	}

	public void doAfter( String userDefineDataSourceName) {
		DataSourceHandler.setUserDefineDataSource(userDefineDataSourceName);
	}

	public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
		String oldUserDefineName = doBefore(joinPoint);
		try {
			return joinPoint.proceed();
		} catch (Throwable throwable) {
			throw throwable;
		} finally {
			doAfter(oldUserDefineName);
		}
	}

}
