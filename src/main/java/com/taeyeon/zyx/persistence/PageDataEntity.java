/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.taeyeon.zyx.persistence;



/**
 * 数据Entity类
 * @author ThinkGem
 * @version 2014-05-16
 */
public abstract class PageDataEntity<T> extends DataEntity<T> {

	private static final long serialVersionUID = -4724468961405654262L;
	Integer pageNo;
	Integer pageSize;
	public Integer getPageNo() {
		return pageNo;
	}
	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

}
