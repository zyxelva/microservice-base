/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.taeyeon.zyx.dto;

import java.util.Date;
import java.util.List;

/**
 * 河马老师Entity
 *
 * @author lizhuo
 * @version 2018-04-14
 */
public class TbTeacherDto extends DataDto {

    private static final long serialVersionUID = -1686002139318426671L;

    @DtoProperty("老师uid")
    private Long uid;
    @DtoProperty("老师昵称")
    private String nick;
    @DtoProperty("电话号码")
    private String mobile;
    @DtoProperty("老师类型")
    private Integer type;
    @DtoProperty("科目ID")
    private Integer subjectId; // 科目ID
    @DtoProperty("科目名称")
    private String subjectName; // 科目名称
    @DtoProperty("毕业学校")
    private String school; // 毕业学校
    @DtoProperty("学历")
    private String diploma; // 学历
    @DtoProperty("学历照片URL")
    private String diplomaPic; // 学历照片URL
    @DtoProperty("教龄")
    private String teachAge; // 教龄
    @DtoProperty("简介")
    private String selfIntro; // 简介
    @DtoProperty("身份证件类型")
    private Integer idType; // 身份证件类型
    @DtoProperty("身份证件号码")
    private String idCard; // 身份证件号码
    @DtoProperty("性别")
    private Integer sex;
    @DtoProperty("生日")
    private Date birthday;
    @DtoProperty("年龄")
    private Integer age;
    @DtoProperty("邮箱")
    private String email;
    @DtoProperty("国家")
    private String country;
    @DtoProperty("省市")
    private String province;
    @DtoProperty("城市")
    private String city;
    @DtoProperty("区域")
    private String district;
    @DtoProperty("介绍")
    private String intr;
    @DtoProperty("角色")
    private Long role;
    @DtoProperty("真实姓名")
    private String realname;
    @DtoProperty("老师来源")
    private Integer source;
    @DtoProperty("任教学校")
    private String teachingSchool;
    @DtoProperty("职称")
    private Integer jobTitle;
    @DtoProperty("状态")
    private Integer state;
    @DtoProperty("备注")
    private String comment;
    @DtoProperty("老师课程")
    private List<Long> courseIds;

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getTeachingSchool() {
        return teachingSchool;
    }

    public void setTeachingSchool(String teachingSchool) {
        this.teachingSchool = teachingSchool;
    }

    public Integer getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(Integer jobTitle) {
        this.jobTitle = jobTitle;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getIntr() {
        return intr;
    }

    public void setIntr(String intr) {
        this.intr = intr;
    }

    public Long getRole() {
        return role;
    }

    public void setRole(Long role) {
        this.role = role;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public Integer getSource() {
        return source;
    }

    public void setSource(Integer source) {
        this.source = source;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    // 查询参数
    private List<Long> uids;
    private String name;

    public TbTeacherDto() {
        super();
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getDiploma() {
        return diploma;
    }

    public void setDiploma(String diploma) {
        this.diploma = diploma;
    }

    public String getDiplomaPic() {
        return diplomaPic;
    }

    public void setDiplomaPic(String diplomaPic) {
        this.diplomaPic = diplomaPic;
    }

    public String getTeachAge() {
        return teachAge;
    }

    public void setTeachAge(String teachAge) {
        this.teachAge = teachAge;
    }

    public String getSelfIntro() {
        return selfIntro;
    }

    public void setSelfIntro(String selfIntro) {
        this.selfIntro = selfIntro;
    }

    public Integer getIdType() {
        return idType;
    }

    public void setIdType(Integer idType) {
        this.idType = idType;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public List<Long> getUids() {
        return uids;
    }

    public void setUids(List<Long> uids) {
        this.uids = uids;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public List<Long> getCourseIds() {
        return courseIds;
    }

    public void setCourseIds(List<Long> courseIds) {
        this.courseIds = courseIds;
    }

}