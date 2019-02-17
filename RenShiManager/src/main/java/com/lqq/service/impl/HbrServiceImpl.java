package com.lqq.service.impl;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.lqq.dao.DeptMapper;
import com.lqq.dao.DocumentMapper;
import com.lqq.dao.EmployeeMapper;
import com.lqq.dao.JobMapper;
import com.lqq.dao.NoticeMapper;
import com.lqq.dao.UserMapper;
import com.lqq.entity.Dept;
import com.lqq.entity.Document;
import com.lqq.entity.Employee;
import com.lqq.entity.Job;
import com.lqq.entity.Notice;
import com.lqq.entity.User;
import com.lqq.service.HbrService;

@Transactional
@Service("hbrService")
public class HbrServiceImpl implements HbrService {

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private DeptMapper deptMapper;

	@Autowired
	private JobMapper jobMapper;

	@Autowired
	private EmployeeMapper employeeMapper;

	@Autowired
	private DocumentMapper documentMapper;

	@Autowired
	private NoticeMapper noticeMapper;

	@Override
	public User login(String loginName, String password) {
		// TODO Auto-generated method stub
		return userMapper.selectUserByLoginNameAndPassword(loginName, password);
	}

	@Override
	public User findUserById(Integer id) {
		// TODO Auto-generated method stub
		return userMapper.selectUserById(id);
	}

	@Override
	public List<User> findUserByParam(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return userMapper.selectUserByParam(params);
	}

	@Override
	public boolean updateUser(User user) {
		// TODO Auto-generated method stub
		return userMapper.updateUser(user);
	}

	@Override
	public boolean deleteUser(Integer id) {
		// TODO Auto-generated method stub
		return userMapper.deleteUserById(id);
	}

	@Override
	public boolean addUser(User user) {
		// TODO Auto-generated method stub
		return userMapper.insertUser(user);
	}

	@Override
	public Integer selectUserCount(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return userMapper.count(params);
	}

	@Override
	public List<Employee> selectEmployeeByParams(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return employeeMapper.selectByParams(params);
	}

	@Override
	public Integer selectEmployeeCount(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return employeeMapper.count(params);
	}

	@Override
	public boolean addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeMapper.insert(employee);
	}

	@Override
	public boolean updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeMapper.update(employee);
	}

	@Override
	public Employee selectEmployeeById(Integer id) {
		// TODO Auto-generated method stub
		return employeeMapper.selectById(id);
	}

	@Override
	public boolean deleteEmployee(Integer id) {
		// TODO Auto-generated method stub
		return employeeMapper.delete(id);
	}

	@Override
	public List<Job> selectJobByParams(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return jobMapper.selectJobByParams(params);
	}

	@Override
	public Job selectJobById(Integer id) {
		// TODO Auto-generated method stub
		return jobMapper.selectById(id);
	}

	@Override
	public Integer selectJobCount(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return jobMapper.count(params);
	}

	@Override
	public boolean deleteJob(Integer id) {
		// TODO Auto-generated method stub
		return jobMapper.delete(id);
	}

	@Override
	public boolean addJob(Job job) {
		// TODO Auto-generated method stub
		return jobMapper.insert(job);
	}

	@Override
	public boolean updateJob(Job job) {
		// TODO Auto-generated method stub
		return jobMapper.update(job);
	}

	@Override
	public List<Dept> selectDeptByParams(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return deptMapper.selectDeptByParams(params);
	}

	@Override
	public Integer selectDeptCount(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return deptMapper.count(params);
	}

	@Override
	public Dept selectDeptById(Integer id) {
		// TODO Auto-generated method stub
		return deptMapper.selectById(id);
	}

	@Override
	public boolean deleteDept(Integer id) {
		// TODO Auto-generated method stub
		return deptMapper.deleteDept(id);
	}

	@Override
	public boolean addDept(Dept dept) {
		// TODO Auto-generated method stub
		return deptMapper.insert(dept);
	}

	@Override
	public boolean updateDept(Dept dept) {
		// TODO Auto-generated method stub
		return deptMapper.update(dept);
	}

	@Override
	public List<Notice> selectNoticeByParams(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return noticeMapper.selectByParams(params);
	}

	@Override
	public Integer selectNoticeCount(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return noticeMapper.count(params);
	}

	@Override
	public Notice selecNoticetById(Integer id) {
		// TODO Auto-generated method stub
		return noticeMapper.selectById(id);
	}

	@Override
	public boolean updateNotice(Notice notice) {
		// TODO Auto-generated method stub
		return noticeMapper.update(notice);
	}

	@Override
	public boolean addNotice(Notice notice) {
		// TODO Auto-generated method stub
		return noticeMapper.insert(notice);
	}

	@Override
	public List<Document> selectDocumentByParams(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return documentMapper.selectByParams(params);
	}

	@Override
	public Integer selectDocumentCount(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return documentMapper.count(params);
	}

	@Override
	public Document selecDocumentById(Integer id) {
		// TODO Auto-generated method stub
		return documentMapper.selectById(id);
	}

	@Override
	public boolean deleteDocumentById(Integer id) {
		// TODO Auto-generated method stub
		return documentMapper.deleteById(id);
	}

	@Override
	public boolean addDocument(Document document) {
		// TODO Auto-generated method stub
		return documentMapper.insert(document);
	}

	@Override
	public boolean updateDocument(Document document) {
		// TODO Auto-generated method stub
		return documentMapper.update(document);
	}

	@Override
	public boolean deleteNotice(Integer id) {
		// TODO Auto-generated method stub
		return noticeMapper.deleteById(id);
	}

}
