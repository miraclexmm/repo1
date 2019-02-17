package com.lqq.dao.provider;

import static com.lqq.util.common.HbrConstants.MAP_NOTICE;
import static com.lqq.util.common.HbrConstants.NOTICE_TABLE;
import static com.lqq.util.common.HbrUtil.isNotEmpty;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

import com.lqq.entity.Notice;

public class NoticeDynaSqlProvider {

	public String selectByParams(Map<String, Object> params) {
		return new SQL() {
			{
				SELECT("*");
				FROM(NOTICE_TABLE);
				if (params != null) {

					if (params.get(MAP_NOTICE) != null) {
						Notice notice = (Notice) params.get(MAP_NOTICE);
						if (isNotEmpty(notice.getTitle())) {
							WHERE("title like concat('%',#{notice.title},'%')");
						}
						if (notice.getUser() != null && notice.getUser().getId() != null) {
							WHERE("user_id = #{notice.user.id}");
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
				FROM(NOTICE_TABLE);
				if (params.get(MAP_NOTICE) != null) {
					Notice notice = (Notice) params.get(MAP_NOTICE);
					if (isNotEmpty(notice.getTitle())) {
						WHERE("title like concat('%',#{notice.title},'%')");
					}
					if (notice.getUser() != null && notice.getUser().getId() != null) {
						WHERE("user_id = #{notice.user.id}");
					}
				}
			}
		}.toString();
	}

	public String insert(Notice notice) {
		return new SQL() {
			{
				INSERT_INTO(NOTICE_TABLE);
				if (isNotEmpty(notice.getContent())) {
					VALUES("content", "#{content}");
				}
				if (isNotEmpty(notice.getTitle())) {
					VALUES("title", "#{title}");
				}
				if (notice.getCreateDate() != null) {
					VALUES("create_date", "#{createDate}");
				}
				if (notice.getUser() != null && notice.getUser().getId() != null) {
					VALUES("user_id", "#{user.id}");
				}
			}
		}.toString();
	}

	public String update(Notice notice) {
		return new SQL() {
			{
				UPDATE(NOTICE_TABLE);
				if (isNotEmpty(notice.getContent())) {
					SET("content = #{content}");
				}
				if (isNotEmpty(notice.getTitle())) {
					SET("title = #{title}");
				}
				if (notice.getCreateDate() != null) {
					SET("create_date = #{createDate}");
				}
				if (notice.getUser() != null && notice.getUser().getId() != null) {
					SET("user_id = #{user.id}");
				}
				WHERE("id = #{id}");
			}
		}.toString();
	}

}
