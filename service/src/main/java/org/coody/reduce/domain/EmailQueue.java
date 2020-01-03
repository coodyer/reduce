package org.coody.reduce.domain;

import java.util.Date;

import org.coody.framework.jdbc.entity.DBModel;

@SuppressWarnings("serial")
public class EmailQueue extends DBModel {

	private Long id;
	private String unionId;
	private String title;
	private String context;
	private String targeEmail;
	private Integer status = 0;
	private Date createTime = new Date();
	private Long millisecond = System.currentTimeMillis();
	private Date updateTime = new Date();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getMillisecond() {
		return millisecond;
	}

	public void setMillisecond(Long millisecond) {
		this.millisecond = millisecond;
	}

	public String getTargeEmail() {
		return targeEmail;
	}

	public void setTargeEmail(String targeEmail) {
		this.targeEmail = targeEmail;
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

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getUnionId() {
		return unionId;
	}

	public void setUnionId(String unionId) {
		this.unionId = unionId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}
}