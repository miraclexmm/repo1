package com.lqq.entity;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

public class Employee implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7263627297042913315L;

	private Integer id;

	private Dept dept;
	@NotNull(message="部门未指定!")
	private Integer deptId;
	
	private Job job;
	@NotNull(message="职位未指定")
	private Integer jobId;

	public Integer getDeptId() {
		return deptId;
	}

	public Integer getJobId() {
		return jobId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public void setJobId(Integer jobId) {
		this.jobId = jobId;
	}

	@NotEmpty(message="姓名不能为空!")
	private String name;

	@Range(min=18,max=50,message="年龄必须在18~50岁之间!")
	private String age;

	@NotBlank(message="性别未选择!")
	private String sex;

	@Pattern(regexp="[0-9]+",message="身份证号无效!")
	private String cardId;

	@NotBlank(message="地址未指定!")
	private String address;

	private String postCode;

	private String qq;
	
	@NotBlank(message="邮箱未指定!")
	@Email(message="邮箱无效!")
	private String email;

	@DateTimeFormat(iso=ISO.DATE)
	private Date createDate;

	@NotBlank(message="民族未指定!")
	private String race;

	@NotBlank(message="学历未指定!")
	private String education;

	private String hobby;

	private String remark;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Dept getDept() {
		return dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String  age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getCardId() {
		return cardId;
	}

	public void setCardId(String cardId) {
		this.cardId = cardId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getRace() {
		return race;
	}

	public void setRace(String race) {
		this.race = race;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", age=" + age + ", sex=" + sex + ", cardId=" + cardId
				+ ", address=" + address + ", postCode=" + postCode + ", qq=" + qq + ", email=" + email
				+ ", createDate=" + createDate + ", race=" + race + ", education=" + education + ", hobby=" + hobby
				+ ", remark=" + remark + "]";
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}