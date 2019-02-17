package com.lqq.validator;

import org.springframework.stereotype.Repository;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.lqq.entity.Document;

@Repository("myFileValidator")
public class MyFileValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Document.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		ValidationUtils.rejectIfEmpty(errors, "title",null, "文档标题不能为空!");
		Document document = (Document) target;
		if (document.getFile().getOriginalFilename() == null
				|| document.getFile().getOriginalFilename().trim().equals("")) {
			errors.rejectValue("file",null, "无文件上传!");
		}
	}

}
