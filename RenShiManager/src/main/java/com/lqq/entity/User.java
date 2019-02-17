package com.lqq.entity;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8518505682280368106L;

	private Integer id;

	@Override
	public String toString() {
		return "User [id=" + id + ", loginName=" + loginName + ", password=" + password + ", status=" + status
				+ ", createDate=" + createDate + ", realName=" + realName + "]";
	}

	@NotBlank(message="登录名未指定!")
	private String loginName;

	@Size(min=5,message="密码长度不能低于5位!")
	private String password;

	private Integer status;

	@DateTimeFormat(iso=ISO.DATE)
	private Date createDate;

	@NotBlank(message="真实姓名未指定!")
	private String realName;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
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

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}
}