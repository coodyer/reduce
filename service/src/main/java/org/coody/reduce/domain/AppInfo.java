package org.coody.reduce.domain;

import java.util.Date;

import org.coody.framework.jdbc.annotation.DBVague;
import org.coody.framework.jdbc.entity.DBModel;

@SuppressWarnings("serial")
public class AppInfo extends DBModel {

	private Integer id;

	@DBVague
	private String name;

	private Integer userId;

	private String unionId;

	private Date createTime;

	/**
	 * 状态 -1冻结 0待审核 1正常 2暂停
	 */
	private Integer status;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUnionId() {
		return unionId;
	}

	public void setUnionId(String unionId) {
		this.unionId = unionId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}
