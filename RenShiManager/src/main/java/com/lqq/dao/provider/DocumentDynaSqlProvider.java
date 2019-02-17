package com.lqq.dao.provider;

import java.util.Map;
import static com.lqq.util.common.HbrConstants.DOCUMENT_TABLE;
import static com.lqq.util.common.HbrConstants.MAP_DOCUMENT;
import static com.lqq.util.common.HbrUtil.isNotEmpty;

import org.apache.ibatis.jdbc.SQL;

import com.lqq.entity.Document;

public class DocumentDynaSqlProvider {

	public String selectByParams(Map<String, Object> params) {

		return new SQL() {
			{
				SELECT("*");
				FROM(DOCUMENT_TABLE);
				if (params != null) {
					if (params.get(MAP_DOCUMENT) != null) {
						Document document = (Document) params.get(MAP_DOCUMENT);
						if (isNotEmpty(document.getFileName())) {
							WHERE("file_name like concat('%',#{document.fileName},'%')");
						}
						if (isNotEmpty(document.getTitle())) {
							WHERE("title like concat('%',#{document.title},'%')");
						}
						if (document.getUser() != null && document.getUser().getId() != null) {
							WHERE("user_id = #{document.user.id}");
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
				FROM(DOCUMENT_TABLE);
				if (params.get(MAP_DOCUMENT) != null) {
					Document document = (Document) params.get(MAP_DOCUMENT);
					if (isNotEmpty(document.getFileName())) {
						WHERE("file_name like concat('%',#{document.fileName},'%')");
					}
					if (isNotEmpty(document.getTitle())) {
						WHERE("title like concat('%',#{document.title},'%')");
					}
					if (document.getUser() != null && document.getUser().getId() != null) {
						WHERE("user_id = #{document.user.id}");
					}

				}
			}
		}.toString();
	}

	public String insert(Document document) {
		return new SQL() {
			{
				INSERT_INTO(DOCUMENT_TABLE);
				if (document.getCreateDate() != null) {
					VALUES("create_date", "#{createDate}");
				}
				if (isNotEmpty(document.getFileName())) {
					VALUES("file_name", "#{fileName}");
				}
				if (isNotEmpty(document.getRemark())) {
					VALUES("remark", "#{remark}");
				}
				if (isNotEmpty(document.getTitle())) {
					VALUES("title", "#{title}");
				}
				if (document.getUser() != null && document.getUser().getId() != null) {
					VALUES("user_id", "#{user.id}");
				}
			}
		}.toString();
	}

	public String update(Document document) {
		return new SQL() {
			{
				UPDATE(DOCUMENT_TABLE);
				if (document.getCreateDate() != null) {
					SET("create_date = #{createDate}");
				}
				if (isNotEmpty(document.getFileName())) {
					SET("file_name = #{fileName}");
				}
				if (isNotEmpty(document.getRemark())) {
					SET("remark = #{remark}");
				}
				if (isNotEmpty(document.getTitle())) {
					SET("title = #{title}");
				}
				if (document.getUser() != null && document.getUser().getId() != null) {
					SET("user_id = #{user.id}");
				}
				WHERE("id = #{id}");
			}
		}.toString();
	}

}
