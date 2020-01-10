package org.coody.reduce.vo;

import org.coody.framework.core.model.BaseModel;

@SuppressWarnings("serial")
public class AppCreateVO extends BaseModel {

	private Integer id;

	private String name;
	
	private Integer status;

	
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

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

}
