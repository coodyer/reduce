package org.coody.reduce.common.entity;

import java.util.Date;

import org.coody.framework.core.model.BaseModel;

@SuppressWarnings("serial")
public class LoginEntity extends BaseModel {

	private Integer userId;

	private Date activityTime;

	private Date createTime;

	public LoginEntity() {
		this.createTime = new Date();
		this.activityTime = new Date();
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Date getActivityTime() {
		return activityTime;
	}

	public void setActivityTime(Date activityTime) {
		this.activityTime = activityTime;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}
