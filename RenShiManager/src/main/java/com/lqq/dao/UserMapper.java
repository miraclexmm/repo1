package com.lqq.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import com.lqq.util.common.HbrConstants;
import com.lqq.dao.provider.UserDynaSqlProvider;
import com.lqq.entity.User;

public interface UserMapper {

	// 根据登录名和密码查询员工
	@Select("select * from " + HbrConstants.USER_TABLE + " where login_name=#{loginName} and " + "password=#{password}")
	User selectUserByLoginNameAndPassword(@Param("loginName") String loginName, @Param("password") String password);

	// 根据Id查询用户
	@Select("select * from " + HbrConstants.USER_TABLE + " where id=#{id}")
	User selectUserById(@Param("id") Integer id);

	// 根据id删除用户
	@Delete("delete from " + HbrConstants.USER_TABLE + " where id=#{id}")
	boolean deleteUserById(Integer id);

	// 动态修改用户
	@UpdateProvider(type = UserDynaSqlProvider.class, method = "updateUser")
	boolean updateUser(User user);

	// 动态查询
	@SelectProvider(type = UserDynaSqlProvider.class, method = "selectWithParm")
	List<User> selectUserByParam(Map<String, Object> params);

	// 动态查询总数
	@SelectProvider(type = UserDynaSqlProvider.class, method = "count")
	Integer count(Map<String, Object> params);

	// 动态插入用户
	@InsertProvider(type = UserDynaSqlProvider.class, method = "insertUser")
	boolean insertUser(User user);

}