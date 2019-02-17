package com.lqq.dao;

import java.util.List;
import java.util.Map;
import static com.lqq.util.common.HbrConstants.*;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import com.lqq.dao.provider.JobDynaSqlProvider;
import com.lqq.entity.Job;

public interface JobMapper {

	// 根据条件查询Job
	@SelectProvider(type = JobDynaSqlProvider.class, method = "selectByParams")
	List<Job> selectJobByParams(Map<String, Object> params);

	// 根据id查询job
	@Select("select * from " + JOB_TABLE + " where id = #{id}")
	Job selectById(Integer id);

	// 动态查询总数
	@SelectProvider(type = JobDynaSqlProvider.class, method = "count")
	Integer count(Map<String, Object> params);

	// 删除job
	@Delete("delete from " + JOB_TABLE + " where id = #{id}")
	boolean delete(Integer id);

	// 动态插入
	@InsertProvider(type = JobDynaSqlProvider.class, method = "insert")
	boolean insert(Job job);

	// 动态修改
	@InsertProvider(type = JobDynaSqlProvider.class, method = "update")
	boolean update(Job job);
}