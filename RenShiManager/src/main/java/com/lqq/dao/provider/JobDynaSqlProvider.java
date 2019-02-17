package com.lqq.dao.provider;

import static com.lqq.util.common.HbrConstants.JOB_TABLE;
import static com.lqq.util.common.HbrConstants.MAP_JOB;
import static com.lqq.util.common.HbrUtil.isNotEmpty;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

import com.lqq.entity.Job;

public class JobDynaSqlProvider {

	public String selectByParams(Map<String, Object> params) {

		return new SQL() {
			{
				SELECT("*");
				FROM(JOB_TABLE);
				if (params != null) {
					if (params.get(MAP_JOB) != null) {
						Job job = (Job) params.get(MAP_JOB);
						if (isNotEmpty(job.getName())) {
							WHERE("name like concat('%',#{job.name},'%') ");
						}
						if (isNotEmpty(job.getRemark())) {
							WHERE("remark like concat('%',#{job.remark},'%') ");
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
				FROM(JOB_TABLE);
				if (params.get(MAP_JOB) != null) {
					Job job = (Job) params.get(MAP_JOB);
					if (isNotEmpty(job.getName())) {
						WHERE("name like concat('%',#{job.name},'%') ");
					}
					if (isNotEmpty(job.getRemark())) {
						WHERE("remark like concat('%',#{job.remark},'%') ");
					}
				}
			}
		}.toString();
	}

	public String insert(Job job) {
		return new SQL() {
			{
				INSERT_INTO(JOB_TABLE);
				if (isNotEmpty(job.getName())) {
					VALUES("name", "#{name}");
				}
				if (isNotEmpty(job.getRemark())) {
					VALUES("remark", "#{remark}");
				}
			}
		}.toString();
	}

	public String update(Job job) {
		return new SQL() {
			{
				UPDATE(JOB_TABLE);
				if (isNotEmpty(job.getName())) {
					SET("name = #{name}");
				}
				if (isNotEmpty(job.getRemark())) {
					SET("remark = #{remark}");
				}
				WHERE("id = #{id}");
			}
		}.toString();
	}
}
