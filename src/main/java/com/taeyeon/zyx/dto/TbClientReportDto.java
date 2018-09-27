package com.taeyeon.zyx.dto;

import java.util.Date;

public class TbClientReportDto extends DataDto {

	private static final long serialVersionUID = 1L;
	@DtoProperty("uid")
	private Long uid;
	@DtoProperty("日志上传的原因类型: 0-主动上报、1-自动拉取、2-错误触发")
	private Integer type;
	@DtoProperty("子类型")
	private Integer subType;
	@DtoProperty("文件URL")
	private String fileUrl;
	@DtoProperty("反馈内容")
	private String feedback;
	@DtoProperty("上报时间")
	private Date reportTime;
	@DtoProperty("版本名称")
	private String versionName;
	@DtoProperty("版本号")
	private Integer versionCode;
	@DtoProperty("发行渠道")
	private String channel;
	@DtoProperty("OS类型：0-Android、1-iOS、2-WinPhone、3-其它")
	private Integer osType;
	@DtoProperty("OS版本")
	private String osVersion;
	@DtoProperty("设备型号")
	private String deviceModel;
	@DtoProperty("APP名称")
	private String appName;
	@DtoProperty("设备ID")
	private String deviceId;
	@DtoProperty("MacAddress")
	private String macAddr;
	@DtoProperty("业务类型")
	private String bizType;
	@DtoProperty("业务标识")
	private String bizId;
	@DtoProperty("文件大小")
	private String fileSize;
	@DtoProperty("手机号码")
	private String phone;
	@DtoProperty("网络类型：wifi, 4g")
	private String netType;

	public TbClientReportDto() {
		super();
	}

	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getSubType() {
		return subType;
	}

	public void setSubType(Integer subType) {
		this.subType = subType;
	}

	public String getFileUrl() {
		return fileUrl;
	}

	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public Date getReportTime() {
		return reportTime;
	}

	public void setReportTime(Date reportTime) {
		this.reportTime = reportTime;
	}

	public String getVersionName() {
		return versionName;
	}

	public void setVersionName(String versionName) {
		this.versionName = versionName;
	}

	public Integer getVersionCode() {
		return versionCode;
	}

	public void setVersionCode(Integer versionCode) {
		this.versionCode = versionCode;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public Integer getOsType() {
		return osType;
	}

	public void setOsType(Integer osType) {
		this.osType = osType;
	}

	public String getOsVersion() {
		return osVersion;
	}

	public void setOsVersion(String osVersion) {
		this.osVersion = osVersion;
	}

	public String getDeviceModel() {
		return deviceModel;
	}

	public void setDeviceModel(String deviceModel) {
		this.deviceModel = deviceModel;
	}

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getMacAddr() {
		return macAddr;
	}

	public void setMacAddr(String macAddr) {
		this.macAddr = macAddr;
	}

	public String getBizType() {
		return bizType;
	}

	public void setBizType(String bizType) {
		this.bizType = bizType;
	}

	public String getBizId() {
		return bizId;
	}

	public void setBizId(String bizId) {
		this.bizId = bizId;
	}

	public String getFileSize() {
		return fileSize;
	}

	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getNetType() {
		return netType;
	}

	public void setNetType(String netType) {
		this.netType = netType;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TbClientReportDto [uid=");
		builder.append(uid);
		builder.append(", type=");
		builder.append(type);
		builder.append(", subType=");
		builder.append(subType);
		builder.append(", fileUrl=");
		builder.append(fileUrl);
		builder.append(", feedback=");
		builder.append(feedback);
		builder.append(", reportTime=");
		builder.append(reportTime);
		builder.append(", versionName=");
		builder.append(versionName);
		builder.append(", versionCode=");
		builder.append(versionCode);
		builder.append(", channel=");
		builder.append(channel);
		builder.append(", osType=");
		builder.append(osType);
		builder.append(", osVersion=");
		builder.append(osVersion);
		builder.append(", deviceModel=");
		builder.append(deviceModel);
		builder.append(", appName=");
		builder.append(appName);
		builder.append(", deviceId=");
		builder.append(deviceId);
		builder.append(", macAddr=");
		builder.append(macAddr);
		builder.append(", bizType=");
		builder.append(bizType);
		builder.append(", bizId=");
		builder.append(bizId);
		builder.append(", fileSize=");
		builder.append(fileSize);
		builder.append(", phone=");
		builder.append(phone);
		builder.append(", netType=");
		builder.append(netType);
		builder.append("]");
		return builder.toString();
	}

}
