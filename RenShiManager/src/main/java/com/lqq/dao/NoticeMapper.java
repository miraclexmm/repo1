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

import static com.lqq.util.common.HbrConstants.NOTICE_TABLE;

import com.lqq.dao.provider.NoticeDynaSqlProvider;
import com.lqq.entity.Notice;

public interface NoticeMapper {

	// 根据条件查询notice
	@SelectProvider(type = NoticeDynaSqlProvider.class, method = "selectByParams")
	@Results({
			@Result(column = "user_id", property = "user", one = @One(select = "com.lqq.dao.UserMapper.selectUserById", fetchType = FetchType.EAGER)) })
	List<Notice> selectByParams(Map<String, Object> params);

	// 根据条件查询数量
	@SelectProvider(type = NoticeDynaSqlProvider.class, method = "count")
	@Results({
			@Result(column = "user_id", property = "user", one = @One(select = "com.lqq.dao.UserMapper.selectUserById", fetchType = FetchType.EAGER)) })
	Integer count(Map<String, Object> params);

	// 根据Id查询
	@Select("select * from " + NOTICE_TABLE + " where id = #{id}")
	@Results({
			@Result(column = "user_id", property = "user", one = @One(select = "com.lqq.dao.UserMapper.selectUserById", fetchType = FetchType.EAGER)) })
	Notice selectById(Integer id);

	// 删除
	@Delete("delete from " + NOTICE_TABLE + " where id = #{id}")
	boolean deleteById(Integer id);

	// 动态更新
	@UpdateProvider(type = NoticeDynaSqlProvider.class, method = "update")
	boolean update(Notice notice);

	// 动态插入
	@InsertProvider(type = NoticeDynaSqlProvider.class, method = "insert")
	boolean insert(Notice notice);

}