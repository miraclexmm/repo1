package com.lqq.entity;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

public class Notice implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5555256490263928076L;

	private Integer id;

	@NotBlank(message="公告标题未指定!")
	private String title;

	@NotBlank(message="公告内容未指定!")
	private String content;

	@DateTimeFormat(iso=ISO.DATE)
	private Date createDate;

	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Override
	public String toString() {
		return "Notice [id=" + id + ", title=" + title + ", content=" + content + ", createDate=" + createDate + "]";
	}
}