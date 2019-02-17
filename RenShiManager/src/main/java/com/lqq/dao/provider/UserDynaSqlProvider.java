package com.lqq.dao.provider;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

import com.lqq.entity.User;
import static com.lqq.util.common.HbrConstants.*;
import static com.lqq.util.common.HbrUtil.*;

public class UserDynaSqlProvider {

	// 动态查询
	public String selectWithParm(Map<String, Object> params) {

		return new SQL() {
			{
				SELECT("*");
				FROM(USER_TABLE);
				if (params != null) {

					if (params.get(MAP_USER) != null) {
						User user = (User) params.get(MAP_USER);
						if (user.getLoginName() != null && !user.getLoginName().equals("")) {
							WHERE("login_name like concat('%',#{user.loginName},'%')");
						}
						if (user.getRealName() != null && !user.getRealName().equals("")) {
							WHERE("real_name like concat('%',#{user.realName},'%')");
						}
						if (user.getStatus() != null) {
							WHERE("status like concat('%',#{user.getStatus},'%')");
						}
					}
				}
				ORDER_BY("create_date desc ");
			}
		}.toString();
	}

	// 动态查询总数量
	public String count(Map<String, Object> params) {
		return new SQL() {
			{
				SELECT("count(*)");
				FROM(USER_TABLE);
				if (params.get(MAP_USER) != null) {
					User user = (User) params.get(MAP_USER);
					if (user.getLoginName() != null && !user.getLoginName().equals("")) {
						WHERE("login_name like concat('%',#{user.loginName},'%')");
					}
					if (user.getRealName() != null && !user.getRealName().equals("")) {
						WHERE("real_name like concat('%',#{user.realName},'%')");
					}
					if (user.getStatus() != null) {
						WHERE("status like concat('%',#{user.getStatus},'%')");
					}
				}

			}
		}.toString();
	}

	// 动态插入
	public String insertUser(User user) {
		return new SQL() {
			{
				INSERT_INTO(USER_TABLE);
				if (isNotEmpty(user.getLoginName())) {
					VALUES("login_name", "#{loginName}");
				}
				if (isNotEmpty(user.getPassword())) {
					VALUES("password", "#{password}");
				}
				if (isNotEmpty(user.getRealName())) {
					VALUES("real_name", "#{realName}");
				}
				VALUES("create_date", "#{createDate}");
				VALUES("status", "#{status}");
			}
		}.toString();
	}

	// 动态更新
	public String updateUser(User user) {
		return new SQL() {
			{
				UPDATE(USER_TABLE);
				if (isNotEmpty(user.getLoginName())) {
					SET("login_name = #{loginName}");
				}
				if (isNotEmpty(user.getPassword())) {
					SET("password = #{password}");
				}
				if (isNotEmpty(user.getRealName())) {
					SET("real_name = #{realName}");
				}
				if (user.getStatus() != null) {
					SET("status = #{status}");
				}
				WHERE("id = #{id}");
			}
		}.toString();
	}

}
