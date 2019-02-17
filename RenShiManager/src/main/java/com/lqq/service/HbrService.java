package com.lqq.service;

import java.util.List;
import java.util.Map;

import com.lqq.entity.Dept;
import com.lqq.entity.Document;
import com.lqq.entity.Employee;
import com.lqq.entity.Job;
import com.lqq.entity.Notice;
import com.lqq.entity.User;

public interface HbrService {

	// 用户
	User login(String loginName, String password);

	User findUserById(Integer id);

	List<User> findUserByParam(Map<String, Object> params);

	Integer selectUserCount(Map<String, Object> params);

	boolean updateUser(User user);

	boolean deleteUser(Integer id);

	boolean addUser(User user);
	// End 用户

	// 员工
	List<Employee> selectEmployeeByParams(Map<String, Object> params);

	Integer selectEmployeeCount(Map<String, Object> params);

	boolean addEmployee(Employee employee);

	boolean updateEmployee(Employee employee);

	Employee selectEmployeeById(Integer id);

	boolean deleteEmployee(Integer id);
	// End 员工

	// 职位
	List<Job> selectJobByParams(Map<String, Object> params);

	Job selectJobById(Integer id);

	Integer selectJobCount(Map<String, Object> params);

	boolean deleteJob(Integer id);

	boolean addJob(Job job);

	boolean updateJob(Job job);
	// End 职位

	// 部门
	List<Dept> selectDeptByParams(Map<String, Object> params);

	Integer selectDeptCount(Map<String, Object> params);

	Dept selectDeptById(Integer id);

	boolean deleteDept(Integer id);

	boolean addDept(Dept dept);

	boolean updateDept(Dept dept);
	// End 部门

	// 公告
	List<Notice> selectNoticeByParams(Map<String, Object> params);

	Integer selectNoticeCount(Map<String, Object> params);

	Notice selecNoticetById(Integer id);

	boolean deleteNotice(Integer id);
	
	boolean updateNotice(Notice notice);

	boolean addNotice(Notice notice);
	// End 公告

	// 文件
	List<Document> selectDocumentByParams(Map<String, Object> params);

	Integer selectDocumentCount(Map<String, Object> params);

	Document selecDocumentById(Integer id);

	boolean deleteDocumentById(Integer id);

	boolean addDocument(Document document);

	boolean updateDocument(Document document);
	// End 文件
}
