package com.lqq.dao.provider;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

import com.lqq.entity.Employee;

import static com.lqq.util.common.HbrConstants.EMPLOYEE_TABLE;
import static com.lqq.util.common.HbrConstants.MAP_EMPLOYEE;
import static com.lqq.util.common.HbrUtil.isNotEmpty;

public class EmployeeDynaSqlProvider {

	public String selectByParams(Map<String, Object> params) {
		return new SQL() {
			{
				SELECT("*");
				FROM(EMPLOYEE_TABLE);
				if (params != null) {
					if (params.get(MAP_EMPLOYEE) != null) {
						Employee employee = (Employee) params.get(MAP_EMPLOYEE);
						if (employee.getDept() != null && employee.getDept().getId() != null) {
							WHERE("dept_id = #{employee.dept.id}");
						}
						if (employee.getJob() != null && employee.getJob().getId() != null) {
							WHERE("job_id = #{employee.job.id}");
						}
						if (isNotEmpty(employee.getName())) {
							WHERE("name like concat('%',#{employee.name},'%')");
						}
						if (isNotEmpty(employee.getCardId())) {
							WHERE("card_id like concat('%',#{employee.cardId},'%')");
						}
						if (isNotEmpty(employee.getSex())) {
							WHERE("sex = #{employee.sex}");
						}
					}
				}
				ORDER_BY("create_date desc ");
			}
		}.toString();
	}

	public String count(Map<String, Object> params) {
		return new SQL() {
			{
				SELECT("count(*)");
				FROM(EMPLOYEE_TABLE);
				if (params.get(MAP_EMPLOYEE) != null) {
					Employee employee = (Employee) params.get(MAP_EMPLOYEE);
					if (employee.getDept() != null && employee.getDept().getId() != null) {
						WHERE("dept_id = #{employee.dept.id}");
					}
					if (employee.getJob() != null && employee.getJob().getId() != null) {
						WHERE("job_id = #{employee.job.id}");
					}
					if (isNotEmpty(employee.getName())) {
						WHERE("name like concat('%',#{employee.name},'%')");
					}
					if (isNotEmpty(employee.getCardId())) {
						WHERE("card_id like concat('%',#{employee.cardId},'%')");
					}
					if (isNotEmpty(employee.getSex())) {
						WHERE("sex = #{employee.sex}");
					}
				}
			}
		}.toString();
	}

	public String insert(Employee employee) {
		return new SQL() {
			{
				INSERT_INTO(EMPLOYEE_TABLE);
				if (isNotEmpty(employee.getAddress())) {
					VALUES("address", "#{address}");
				}
				if (employee.getAge() != null) {
					VALUES("age", "#{age}");
				}
				if (isNotEmpty(employee.getCardId())) {
					VALUES("card_id", "#{cardId}");
				}
				if (employee.getCreateDate() != null) {
					VALUES("create_date", "#{createDate}");
				}
				if (employee.getDept() != null) {
					VALUES("dept_id", "#{dept.id}");
				}
				if (isNotEmpty(employee.getEducation())) {
					VALUES("education", "#{education}");
				}
				if (isNotEmpty(employee.getEmail())) {
					VALUES("email", "#{email}");
				}
				if (isNotEmpty(employee.getHobby())) {
					VALUES("hobby", "#{hobby}");
				}
				if (employee.getJob() != null) {
					VALUES("job_id", "#{job.id}");
				}
				if (isNotEmpty(employee.getName())) {
					VALUES("name", "#{name}");
				}
				if (isNotEmpty(employee.getPostCode())) {
					VALUES("post_code", "#{postCode}");
				}
				if (isNotEmpty(employee.getQq())) {
					VALUES("qq", "#{qq}");
				}
				if (isNotEmpty(employee.getRace())) {
					VALUES("race", "#{race}");
				}
				if (isNotEmpty(employee.getRemark())) {
					VALUES("remark", "#{remark}");
				}
				if (isNotEmpty(employee.getSex())) {
					VALUES("sex", "#{sex}");
				}
			}
		}.toString();
	}

	public String update(Employee employee) {
		return new SQL() {
			{
				UPDATE(EMPLOYEE_TABLE);
				if (isNotEmpty(employee.getAddress())) {
					SET("address = #{address}");
				}
				if (employee.getAge() != null) {
					SET("age = #{age}");
				}
				if (isNotEmpty(employee.getCardId())) {
					SET("card_id = #{cardId}");
				}
				if (employee.getCreateDate() != null) {
					SET("create_date = #{createDate}");
				}
				if (employee.getDept() != null) {
					SET("dept_id = #{dept.id}");
				}
				if (isNotEmpty(employee.getEducation())) {
					SET("education = #{education}");
				}
				if (isNotEmpty(employee.getEmail())) {
					SET("email = #{email}");
				}
				if (isNotEmpty(employee.getHobby())) {
					SET("hobby = #{hobby}");
				}
				if (employee.getJob() != null) {
					SET("job_id = #{job.id}");
				}
				if (isNotEmpty(employee.getName())) {
					SET("name = #{name}");
				}
				if (isNotEmpty(employee.getPostCode())) {
					SET("post_code = #{postCode}");
				}
				if (isNotEmpty(employee.getQq())) {
					SET("qq = #{qq}");
				}
				if (isNotEmpty(employee.getRace())) {
					SET("race = #{race}");
				}
				if (isNotEmpty(employee.getRemark())) {
					SET("remark = #{remark}");
				}
				if (isNotEmpty(employee.getSex())) {
					SET("sex = #{sex}");
				}
				WHERE("id = #{id}");
			}
		}.toString();
	}
}
