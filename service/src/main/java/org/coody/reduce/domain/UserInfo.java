package org.coody.reduce.domain;

import java.util.Date;

import org.coody.framework.jdbc.entity.DBModel;

@SuppressWarnings("serial")
public class UserInfo extends DBModel {

	private Integer id;

	private String email;

	private String password;

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
