package org.coody.reduce.dto;

import java.util.Date;

import org.coody.framework.core.model.BaseModel;

@SuppressWarnings("serial")
public class UserInfoDTO extends BaseModel {

	private Integer id;

	private String email;
	/**
	 * 1可用 0禁用
	 */
	private Integer status;

	private Date createTime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}
