package com.taeyeon.zyx.dto;

/**
 * @Author: zhuyuanxin
 * @Date: 18/10/1 下午8:00
 * @Description:
 */

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.io.Serializable;
import java.util.Date;

public abstract class ParamDto implements Serializable {
    private static final long serialVersionUID = 1L;
    @DtoProperty("唯一标识")
    protected Long id;
    @DtoProperty("创建人")
    protected Long createBy;
    @DtoProperty("更新人")
    protected Long updateBy;
    @DtoProperty("更新开始时间")
    protected Date updateBeginDate;
    @DtoProperty("更新结束时间")
    protected Date updateEndDate;
    @DtoProperty("创建开始时间")
    protected Date createBeginDate;
    @DtoProperty("创建结束时间")
    protected Date createEndDate;
    @DtoProperty("分页参数,第N页,默认1")
    private Integer pageNo;
    @DtoProperty("分页参数,每页N条记录,默认20")
    private Integer pageSize;
    private String orderBy;

    public ParamDto() {
        this.pageNo = 1;
        this.pageSize = 20;
        this.orderBy = "";
    }

    public ParamDto(Long id) {
        this();
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getOrderBy() {
        return this.orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public void validatePage() {
        if (this.pageNo == null || this.pageNo <= 0) {
            this.pageNo = 1;
        }

        if (this.pageSize == null || this.pageSize <= 0) {
            this.pageSize = 20;
        }

        if (null == this.orderBy) {
            this.orderBy = "";
        }

    }

    public String toString() {
        return ReflectionToStringBuilder.toString(this, new NoNullStyle());
    }
}

