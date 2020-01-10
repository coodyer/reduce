package org.coody.reduce.domain;

import java.util.Date;

import org.coody.framework.jdbc.annotation.DBVague;
import org.coody.framework.jdbc.entity.DBModel;

@SuppressWarnings("serial")
public class ShortInfo extends DBModel {

	private Long id;

	private Integer userId;

	@DBVague
	private String url;

	private Long frequency;

	private Integer appId;

	/**
	 * 1正常 2已停用
	 */
	private Integer status;

	private Date createTime;

	public Integer getAppId() {
		return appId;
	}

	public void setAppId(Integer appId) {
		this.appId = appId;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Long getFrequency() {
		return frequency;
	}

	public void setFrequency(Long frequency) {
		this.frequency = frequency;
	}

}
