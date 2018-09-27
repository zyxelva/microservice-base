/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.taeyeon.zyx.persistence;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.taeyeon.zyx.utils.Reflections;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

/**
 * 数据Entity类
 * @author ThinkGem
 * @version 2014-05-16
 */
public abstract class TreeEntity<T> extends DataEntity<T> {

	private static final long serialVersionUID = 1L;

	protected T parent;	// 父级编号
	protected String parentIds; // 所有父级编号
	protected String name; 	// 机构名称
	protected Integer sort;		// 排序
	protected Long parentId; //父级id
	
	public TreeEntity() {
		super();
		this.sort = 30;
	}
	
	public TreeEntity(Long id) {
		super(id);
	}
	
	/**
	 * 父对象，只能通过子类实现，父类实现mybatis无法读取
	 * @return
	 */
	@JsonBackReference
	@NotNull
	public abstract T getParent();

	/**
	 * 父对象，只能通过子类实现，父类实现mybatis无法读取
	 * @return
	 */
	public abstract void setParent(T parent);

	@Length(min=1, max=2000)
	public String getParentIds() {
		return parentIds;
	}

	public void setParentIds(String parentIds) {
		this.parentIds = parentIds;
	}

	@Length(min=1, max=100)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public Long getParentId() {
		Long id = null;
		if (parent != null){
			id = (Long) Reflections.getFieldValue(parent, "id");
		}
		if (parentId != null) {
			id = parentId;
		}
		return id == null ? 0 : id;
	}

	public void setParentId(Long parentId) {
		if (parent != null) {
			Reflections.setFieldValue(parent, "id", parentId);
		}
		this.parentId = parentId;
	}

}
