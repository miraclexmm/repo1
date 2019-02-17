package com.lqq.dao.provider;

import static com.lqq.util.common.HbrConstants.*;
import static com.lqq.util.common.HbrUtil.*;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

import com.lqq.entity.Dept;

public class DeptDynaSqlProvider {

	public String selectByParams(Map<String, Object> params) {
		return new SQL() {
			{
				SELECT("*");
				FROM(DEPT_TABLE);
				if (params != null) {
					if (params.get(MAP_DEPT) != null) {
						Dept dept = (Dept) params.get(MAP_DEPT);
						if (isNotEmpty(dept.getName())) {
							WHERE("name like concat('%',#{dept.name},'%')");
						}
					}
				}
			}
		}.toString();
	}

	public String count(Map<String, Object> params) {
		return new SQL() {
			{
				SELECT("count(*)");
				FROM(DEPT_TABLE);
				if (params.get(MAP_DEPT) != null) {
					Dept dept = (Dept) params.get(MAP_DEPT);
					if (isNotEmpty(dept.getName())) {
						WHERE("name like concat('%',#{dept.name},'%')");
					}
				}
			}
		}.toString();
	}

	public String insert(Dept dept) {
		return new SQL() {
			{
				INSERT_INTO(DEPT_TABLE);
				if (isNotEmpty(dept.getName())) {
					VALUES("name", "#{name}");
				}
				if (isNotEmpty(dept.getRemark())) {
					VALUES("remark", "#{remark}");
				}
			}
		}.toString();
	}

	public String update(Dept dept) {
		return new SQL() {
			{
				UPDATE(DEPT_TABLE);
				if (isNotEmpty(dept.getName())) {
					SET("name = #{name}");
				}
				if (isNotEmpty(dept.getRemark())) {
					SET("remark = #{remark}");
				}
				WHERE("id = #{id}");
			}
		}.toString();
	}

}
