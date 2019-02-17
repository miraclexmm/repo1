package com.lqq.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.mapping.FetchType;

import static com.lqq.util.common.HbrConstants.EMPLOYEE_TABLE;

import com.lqq.dao.provider.EmployeeDynaSqlProvider;
import com.lqq.entity.Employee;

public interface EmployeeMapper {

	// 动态查询员工
	@SelectProvider(type = EmployeeDynaSqlProvider.class, method = "selectByParams")
	@Results({
			@Result(column = "dept_id", property = "dept", one = @One(select = "com.lqq.dao.DeptMapper.selectById", fetchType = FetchType.EAGER)),
			@Result(column = "job_id", property = "job", one = @One(select = "com.lqq.dao.JobMapper.selectById", fetchType = FetchType.EAGER)) })
	List<Employee> selectByParams(Map<String, Object> params);

	// 动态查询员工总数
	@SelectProvider(type = EmployeeDynaSqlProvider.class, method = "count")
	@Results({
			@Result(column = "dept_id", property = "dept", one = @One(select = "com.lqq.dao.DeptMapper.selectById", fetchType = FetchType.EAGER)),
			@Result(column = "job_id", property = "job", one = @One(select = "com.lqq.dao.JobMapper.selectById", fetchType = FetchType.EAGER)) })
	Integer count(Map<String, Object> params);

	// 动态插入员工
	@InsertProvider(type = EmployeeDynaSqlProvider.class, method = "insert")
	boolean insert(Employee employee);

	// 动态修改
	@UpdateProvider(type = EmployeeDynaSqlProvider.class, method = "update")
	boolean update(Employee employee);

	// 根据id查询员工
	@Select("select * from " + EMPLOYEE_TABLE + " where id = #{id}")
	@Results({
			@Result(column = "dept_id", property = "dept", one = @One(select = "com.lqq.dao.DeptMapper.selectById", fetchType = FetchType.EAGER)),
			@Result(column = "job_id", property = "job", one = @One(select = "com.lqq.dao.JobMapper.selectById", fetchType = FetchType.EAGER)) })
	Employee selectById(Integer id);

	// 删除员工
	@Delete("delete from " + EMPLOYEE_TABLE + " where id = #{id}")
	boolean delete(Integer id);

}