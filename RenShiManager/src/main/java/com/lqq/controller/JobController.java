package com.lqq.controller;

import static com.lqq.util.common.HbrConstants.MAP_JOB;
import static com.lqq.util.common.HbrConstants.PAGE_DEFAULT_SIZE;
import static com.lqq.util.common.HbrUtil.isNormalString;
import static com.lqq.util.common.HbrUtil.notNormalStringParse;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lqq.entity.Job;
import com.lqq.service.HbrService;

@Controller
public class JobController {

	@Autowired
	@Qualifier("hbrService")
	private HbrService hbrService;

	@RequestMapping("/job/jobSearchIndex")
	public String searchIndex() {
		return "manager/job/job_search";
	}

	@RequestMapping("/job/jobSearch")
	public String search(String name, HttpServletRequest request, Integer curPage) {

		Map<String, Object> params = new HashMap<String, Object>();
		if (name != null && !name.trim().equals("")) {
			if (!isNormalString(name)) {
				name = notNormalStringParse(name);
			}
			Job job = new Job();
			job.setName(name);
			params.put(MAP_JOB, job);

		}
		if (curPage == null) {
			curPage = 1;
		}
		PageHelper.startPage(curPage, PAGE_DEFAULT_SIZE);
		List<Job> list = hbrService.selectJobByParams(params);
		PageInfo<Job> pageInfo = new PageInfo<>(list);
		request.setAttribute("job_list", list);
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("name", name);
		return "manager/job/job_search";
	}

	@RequestMapping("/job/jobAddIndex")
	public String addIndex(Model model) {
		Job job = new Job();
		model.addAttribute("job", job);
		return "manager/job/job_add";
	}

	@RequestMapping("/job/jobAdd")
	public String add(@Valid @ModelAttribute Job job,Errors errors, HttpServletRequest request) {
		if(errors.hasErrors()){
			return "manager/job/job_add";
		}
		request.setAttribute("title", "添加状态");
		if (hbrService.addJob(job)) {
			request.setAttribute("message", "添加成功!");
			return "manager/job/job_add_result";
		} else {
			request.setAttribute("message", "添加失败!");
			return "manager/job/job_add";
		}
	}

	@RequestMapping("/job/jobModifyIndex")
	public String modifyIndex(Integer id,Model model){
		Job job = hbrService.selectJobById(id);
		model.addAttribute("job", job);
		return "manager/job/job_modify";
	}
	@RequestMapping("/job/jobModify")
	public String modify(@Valid @ModelAttribute Job job,Errors errors, HttpServletRequest request) {
		if(errors.hasErrors()){
			return "manager/job/job_modify";
		}
		request.setAttribute("title", "修改状态");
		if (hbrService.updateJob(job)) {
			request.setAttribute("message", "修改职位信息成功!");
			return "manager/job/job_add_result";
		} else {
			request.setAttribute("message", "修改职位信息出错!");
			return "manager/job/job_add_result";
		}
	}

	@RequestMapping("/job/jobDelete")
	public void delete(Integer id, HttpServletResponse response) throws Exception {
		if (hbrService.deleteJob(id)) {
			response.getWriter().write("OK");
		} else {
			response.getWriter().write("FALSE");
		}
	}
}
