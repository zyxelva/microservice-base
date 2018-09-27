/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.taeyeon.zyx.persistence;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.taeyeon.zyx.common.Page;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.Map;

/**
 * Entity支持类
 * @author ThinkGem
 * @version 2014-05-16
 */
public abstract class BaseStrEntity<T> implements Serializable {

	private static final long serialVersionUID = 1L;

	protected long auto_id;

	/**
	 * 实体编号（唯一标识）
	 */
	protected String id;


	/**
	 * 当前实体分页对象
	 */
	protected Page<T> page;

	/**
	 * 自定义SQL（SQL标识，SQL内容）
	 */
	protected Map<String, String> sqlMap;

	/**
	 * 是否是新记录（默认：false），调用setIsNewRecord()设置新记录，使用自定义ID。
	 * 设置为true后强制执行插入语句，ID不会自动生成，需从手动传入。
	 */
	protected boolean isNewRecord = false;

	public BaseStrEntity() {

	}

	public Long fetchLongId(){
		if(null != id){
			return Long.valueOf(id);
		}
		return null;
	}
	public BaseStrEntity(String id) {
		this();
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public long getAuto_id() {
        return auto_id;
    }

    public void setAuto_id(long auto_id) {
        this.auto_id = auto_id;
    }

	@JsonIgnore
	@XmlTransient
	public Page<T> getPage() {
		if (page == null){
			page = new Page<T>();
		}
		return page;
	}
	
	public Page<T> setPage(Page<T> page) {
		this.page = page;
		return page;
	}


	public void setSqlMap(Map<String, String> sqlMap) {
		this.sqlMap = sqlMap;
	}
	
//	/**
//	 * 插入之前执行方法，子类实现
//	 */
//	public abstract void preInsert();
//
//	/**
//	 * 更新之前执行方法，子类实现
//	 */
//	public abstract void preUpdate();
	
    /**
	 * 是否是新记录（默认：false），调用setIsNewRecord()设置新记录，使用自定义ID。
	 * 设置为true后强制执行插入语句，ID不会自动生成，需从手动传入。
     * @return
     */
	public boolean getIsNewRecord() {
        return isNewRecord || null == getId();
    }

	/**
	 * 是否是新记录（默认：false），调用setIsNewRecord()设置新记录，使用自定义ID。
	 * 设置为true后强制执行插入语句，ID不会自动生成，需从手动传入。
	 */
	public void setIsNewRecord(boolean isNewRecord) {
		this.isNewRecord = isNewRecord;
	}
//
//	/**
//	 * 全局变量对象
//	 */
//	@JsonIgnore
//	public Global getGlobal() {
//		return Global.getInstance();
//	}
//
//	/**
//	 * 获取数据库名称
//	 */
//	@JsonIgnore
//	public String getDbName(){
//		return Global.getConfig("jdbc.type");
//	}
	
    @Override
    public boolean equals(Object obj) {
        if (null == obj) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!getClass().equals(obj.getClass())) {
            return false;
        }
        BaseStrEntity<?> that = (BaseStrEntity<?>) obj;
        return null == this.getId() ? false : this.getId().equals(that.getId());
    }
    
    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
    
	/**
	 * 删除标记（0：正常；1：删除；2：审核；）
	 */
	public static final Integer DEL_FLAG_NORMAL = 0;
	public static final Integer DEL_FLAG_DELETE = 1;
	public static final Integer DEL_FLAG_AUDIT = 2;
	
}
