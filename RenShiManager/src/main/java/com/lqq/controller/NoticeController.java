package com.lqq.controller;

import static com.lqq.util.common.HbrConstants.MAP_NOTICE;
import static com.lqq.util.common.HbrConstants.PAGE_DEFAULT_SIZE;
import static com.lqq.util.common.HbrUtil.isNotEmpty;

import java.util.Date;
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
import com.lqq.entity.Notice;
import com.lqq.entity.User;
import com.lqq.service.HbrService;

@Controller
public class NoticeController {

	@Autowired
	@Qualifier("hbrService")
	private HbrService hbrService;

	@RequestMapping("/notice/noticeSearchIndex")
	public String searchIndex() {

		return "manager/notice/notice_search";
	}

	@RequestMapping("/notice/noticeSearch")
	public String search(String name, Integer curPage, HttpServletRequest request) {

		Map<String, Object> params = new HashMap<String, Object>();
		if (curPage == null) {
			curPage = 1;
		}
		if (isNotEmpty(name)) {
			Notice notice = new Notice();
			notice.setTitle(name);
			params.put(MAP_NOTICE, notice);
		}
		PageHelper.startPage(curPage, PAGE_DEFAULT_SIZE);
		List<Notice> list = hbrService.selectNoticeByParams(params);
		PageInfo<Notice> pageInfo = new PageInfo<>(list);
		request.setAttribute("notice_list", list);
		request.setAttribute("name", name);
		request.setAttribute("pageInfo", pageInfo);
		return "manager/notice/notice_search";
	}

	@RequestMapping("/notice/noticeAddIndex")
	public String addIndex(Model model){
		Notice notice = new Notice();
		model.addAttribute("notice", notice);
		return "manager/notice/notice_add";
	}

	@RequestMapping("/notice/noticeAdd")
	public String add(@Valid @ModelAttribute Notice notice,Errors errors, HttpServletRequest request) throws Exception {
		if(errors.hasErrors()){
			return "manager/notice/notice_add";
		}
		User user = (User) request.getSession().getAttribute("user");
		notice.setUser(user);
		notice.setCreateDate(new Date());
		request.setAttribute("title", "添加状态");
		if (hbrService.addNotice(notice)) {
			request.setAttribute("message", "添加公告成功!");
			return "manager/notice/notice_add_result";
		} else {
			request.setAttribute("message", "添加公告失败!");
			return "manager/notice/notice_add_result";
		}
	}
	
	@RequestMapping("/notice/noticeDelete")
	public void delete(Integer id,HttpServletResponse response) throws Exception{
		if(hbrService.deleteNotice(id)){
			response.getWriter().write("OK");
		}else{
			response.getWriter().write("删除出错!");
		}
	}
	
	@RequestMapping("notice/noticeModifyIndex")
	public String modifyIndex(Integer id,Model model){
		Notice notice = hbrService.selecNoticetById(id);
		model.addAttribute("notice", notice);
		return "manager/notice/notice_modify";
	}
	@RequestMapping("/notice/noticeModify")
	public String modify(@Valid @ModelAttribute Notice notice,Errors errors,HttpServletRequest request){
		if(errors.hasErrors()){
			return "manager/notice/notice_modify";
		}
		request.setAttribute("title", "修改状态");
		if(hbrService.updateNotice(notice)){
			request.setAttribute("message", "修改公告信息成功");
			return "manager/notice/notice_add_result";
		}else{
			request.setAttribute("message", "修改公告信息出错");
			return "manager/notice/notice_add_result";
		}
	}
}
