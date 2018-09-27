/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.taeyeon.zyx.persistence;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.validator.constraints.Length;

import java.util.Date;

/**
 * 数据Entity类
 * @author ThinkGem
 * @version 2014-05-16
 */
public abstract class DataEntity<T> extends BaseEntity<T> {

	private static final long serialVersionUID = 1L;
	
	protected String remarks;	// 备注

	protected Long createBy;
	protected Long updateBy;
	protected Date createDate;	// 创建日期
	protected Date updateDate;	// 更新日期
	protected Integer delFlag; 	// 删除标记（0：正常；1：删除；2：审核）

	// 查询参数
	protected Date updateBeginDate;
	protected Date updateEndDate;
	protected Date createBeginDate;
	protected Date createEndDate;

	
	public DataEntity() {
		super();
		this.delFlag = DEL_FLAG_NORMAL;
	}
	
	public DataEntity(Long id) {
		super(id);
	}

	@Length(min=0, max=255)
	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Long getCreateBy() {
		return createBy;
	}

	public void setCreateBy(Long createBy) {
		this.createBy = createBy;
	}

	public Long getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(Long updateBy) {
		this.updateBy = updateBy;
	}


	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}


	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	@JsonIgnore
	public Integer getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(Integer delFlag) {
		this.delFlag = delFlag;
	}

	public Date getUpdateBeginDate() {
		return updateBeginDate;
	}

	public void setUpdateBeginDate(Date updateBeginDate) {
		this.updateBeginDate = updateBeginDate;
	}

	public Date getUpdateEndDate() {
		return updateEndDate;
	}

	public void setUpdateEndDate(Date updateEndDate) {
		this.updateEndDate = updateEndDate;
	}

	public Date getCreateBeginDate() {
		return createBeginDate;
	}

	public void setCreateBeginDate(Date createBeginDate) {
		this.createBeginDate = createBeginDate;
	}

	public Date getCreateEndDate() {
		return createEndDate;
	}

	public void setCreateEndDate(Date createEndDate) {
		this.createEndDate = createEndDate;
	}

	/**
     * 添加修改信息到详细日志中
     * 
     * @param logDetail
     *            详细日志
     * @param oldProperty
     *            原来属性值
     * @param newProperty
     *            新的属性值
     * @param propertyKey
     *            属性key
     */
    public void addLogDetail(StringBuffer logDetail, String oldProperty, String newProperty, String propertyKey) {

        if (!isSameStr(oldProperty, newProperty)) {
            if(StringUtils.isBlank(newProperty)){
                logDetail.append(propertyKey).append("取消").append("; "); 
            }else{
              /*  if (StringUtils.isBlank(oldProperty)) {
                    logDetail.append(propertyKey).append("修改为").append(newProperty).append("|");
                } else {
                    logDetail.append(propertyKey).append(oldProperty).append("修改为").append(newProperty).append("|");
                }*/
            	logDetail.append(propertyKey).append("修改为").append(newProperty).append(";");
        }}
    }
    
    /**
     * @method isSameStr: 比较属性值是否相同
     * @param oldProperty
     * @param newProperty
     * @return boolean   
     * @throws 
    */
    public boolean isSameStr(String oldProperty, String newProperty) {

        if (StringUtils.isBlank(oldProperty) && StringUtils.isBlank(newProperty)) {
            return true;
        } else if (null!=oldProperty&&oldProperty.equals(newProperty)) {
            return true;
        } else {
            return false;
        }

    }

}
