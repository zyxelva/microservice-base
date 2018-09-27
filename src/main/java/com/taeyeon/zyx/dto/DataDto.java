package com.taeyeon.zyx.dto;

/**
 * @author zyx
 * @date 2018/9/26 026 18:25
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import java.io.Serializable;
import java.util.Date;


public abstract class DataDto implements Serializable {
    private static final long serialVersionUID = 1L;
    protected Long id;
    @DtoProperty(
            value = "备注",
            accessMode = DtoProperty.AccessMode.READ_ONLY
    )
    protected String remarks;
    protected Long createBy;
    protected Long updateBy;
    @DtoProperty("创建时间")
    @JsonProperty(
            access = Access.READ_ONLY
    )
    protected Date createDate;
    @DtoProperty("更新时间")
    @JsonProperty(
            access = Access.READ_ONLY
    )
    protected Date updateDate;
    @DtoProperty("创建人名字")
    @JsonProperty(
            access = Access.READ_ONLY
    )
    protected String createUserName;
    @DtoProperty("更新人名字")
    @JsonProperty(
            access = Access.READ_ONLY
    )
    protected String updateUserName;
    @DtoProperty("更新开始时间")
    @JsonProperty(
            access = Access.WRITE_ONLY
    )
    protected Date updateBeginDate;
    @DtoProperty("更新结束时间")
    @JsonProperty(
            access = Access.WRITE_ONLY
    )
    protected Date updateEndDate;
    @DtoProperty("创建开始时间")
    @JsonProperty(
            access = Access.WRITE_ONLY
    )
    protected Date createBeginDate;
    @DtoProperty("创建结束时间")
    @JsonProperty(
            access = Access.WRITE_ONLY
    )
    protected Date createEndDate;
    @DtoProperty(
            hidden = true
    )
    @JsonIgnore
    protected Integer delFlag;
    @DtoProperty("分页参数,第N页,默认1")
    @JsonProperty(
            access = Access.WRITE_ONLY
    )
    private Integer pageNo;
    @DtoProperty("分页参数,每页N条记录,默认20")
    @JsonProperty(
            access = Access.WRITE_ONLY
    )
    private Integer pageSize;

    public DataDto() {
        this.delFlag = 0;
        this.pageNo = 1;
        this.pageSize = 20;
    }

    public DataDto(Long id) {
        this();
        this.id = id;
    }

    public boolean equals(Object obj) {
        if (null == obj) {
            return false;
        } else if (this == obj) {
            return true;
        } else if (!this.getClass().equals(obj.getClass())) {
            return false;
        } else {
            DataDto that = (DataDto)obj;
            return null == this.getId() ? false : this.getId().equals(that.getId());
        }
    }

//    public String toString() {
//        return ReflectionToStringBuilder.toString(this, new NoNullStyle());
//    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPageNo() {
        return this.pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return this.pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getRemarks() {
        return this.remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Long getCreateBy() {
        return this.createBy;
    }

    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    public Long getUpdateBy() {
        return this.updateBy;
    }

    public void setUpdateBy(Long updateBy) {
        this.updateBy = updateBy;
    }

    public Date getCreateDate() {
        return this.createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return this.updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Integer getDelFlag() {
        return this.delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    public String getCreateUserName() {
        return this.createUserName;
    }

    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName;
    }

    public String getUpdateUserName() {
        return this.updateUserName;
    }

    public void setUpdateUserName(String updateUserName) {
        this.updateUserName = updateUserName;
    }

    public Date getUpdateBeginDate() {
        return this.updateBeginDate;
    }

    public void setUpdateBeginDate(Date updateBeginDate) {
        this.updateBeginDate = updateBeginDate;
    }

    public Date getUpdateEndDate() {
        return this.updateEndDate;
    }

    public void setUpdateEndDate(Date updateEndDate) {
        this.updateEndDate = updateEndDate;
    }

    public Date getCreateBeginDate() {
        return this.createBeginDate;
    }

    public void setCreateBeginDate(Date createBeginDate) {
        this.createBeginDate = createBeginDate;
    }

    public Date getCreateEndDate() {
        return this.createEndDate;
    }

    public void setCreateEndDate(Date createEndDate) {
        this.createEndDate = createEndDate;
    }
}

