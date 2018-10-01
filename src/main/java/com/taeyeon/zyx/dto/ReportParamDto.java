package com.taeyeon.zyx.dto;


import java.util.Date;

public class ReportParamDto extends ParamDto {
    private static final long serialVersionUID = 4889619846804827094L;
    private Long uid;
    private String phone;
    private Date queryBeginDate;
    private Date queryEndDate;
    private Integer type;

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getQueryBeginDate() {
        return queryBeginDate;
    }

    public void setQueryBeginDate(Date queryBeginDate) {
        this.queryBeginDate = queryBeginDate;
    }

    public Date getQueryEndDate() {
        return queryEndDate;
    }

    public void setQueryEndDate(Date queryEndDate) {
        this.queryEndDate = queryEndDate;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
