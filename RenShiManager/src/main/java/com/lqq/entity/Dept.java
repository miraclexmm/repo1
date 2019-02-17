package com.lqq.entity;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotBlank;

public class Dept implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 9164671038394485553L;

	private Integer id;

	@NotBlank(message="部门不能为空!")
	private String name;

	private String remark;

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

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "Dept [id=" + id + ", name=" + name + ", remark=" + remark + "]";
	}
}