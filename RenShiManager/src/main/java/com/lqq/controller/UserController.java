package com.lqq.controller;

import static com.lqq.util.common.HbrConstants.MAP_USER;
import static com.lqq.util.common.HbrConstants.PAGE_DEFAULT_SIZE;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lqq.entity.User;
import com.lqq.service.HbrService;

@Controller
public class UserController {

	@Autowired
	@Qualifier("hbrService")
	private HbrService hbrService;
	
	@RequestMapping("/{index}")
	public String index(@PathVariable("index") String index) {

		return index;
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(String loginName,String password, HttpSession httpSession,HttpServletRequest request) {

		User user = hbrService.login(loginName, password);
		if(user != null){
			httpSession.setAttribute("user", user);
			return "redirect:/main";
		}else{
			request.setAttribute("message", "用户名或密码错误!");
			return "loginForm";
		}
	}
	
	@RequestMapping("/main")
	public String main(){
		return "main";
	}
	
	@RequestMapping("/userSearchIndex")
	public String userSearchIndex(){
		return "manager/user/user_search";
	}
	
	@RequestMapping("/user/userSearch")
	public String userSearch(String realName,HttpServletRequest request,Integer curPage) throws UnsupportedEncodingException{
		Map<String, Object> params = new HashMap<>();
		if(curPage == null){
			curPage = 1;
		}
		if(realName != null && !realName.equals("")){
			System.out.println("转换前:"+realName);
			if(!(java.nio.charset.Charset.forName("GBK").newEncoder().canEncode(realName))){
				realName = new String(realName.getBytes("ISO-8859-1"),"UTF-8");
				System.out.println("转换后:"+realName);
			}
			User user = new User();
			user.setRealName(realName);
			params.put(MAP_USER, user);
		}
		PageHelper.startPage(curPage, PAGE_DEFAULT_SIZE);
		List<User> list = hbrService.findUserByParam(params);
		PageInfo<User> pageInfo = new PageInfo<>(list);
		request.setAttribute("user_list", list);
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("realName", realName);
		return "manager/user/user_search";
	}

	/**
	 * 添加用户
	 * @param model
	 * @return
	 */
	@RequestMapping("/user/userAddIndex")
	public String userAddIndex(Model model){
		User user = new User();
		model.addAttribute("user", user);
		return "manager/user/user_add";
	}


	@RequestMapping("/user/userAdd")
	public String userAdd(@Valid @ModelAttribute User user,Errors errors,Model model){
		if(errors.hasErrors()){
			return "manager/user/user_add";
		}
		user.setCreateDate(new Date());
		user.setStatus(1);
		model.addAttribute("title", "添加状态");
		if(hbrService.addUser(user)){
			model.addAttribute("message", "添加成功!");
			return "manager/user/user_add_result";
		}else{
			model.addAttribute("message","添加用户失败!" );
			return "manager/user/user_add";
		}
	}
	
	@RequestMapping("user/userLogout")
	public String logout(HttpSession session){
		session.removeAttribute("user");
		return "loginForm";
	}
	
	@RequestMapping("/user/userModifyIndex")
	public String modifyIndex(Integer id,Model model){
		User user = hbrService.findUserById(id);
		model.addAttribute("user", user);
		return "manager/user/user_modify";
	}
	
	@RequestMapping("/user/userModify")
	public String modify(@Valid @ModelAttribute User user,Errors errors,HttpServletRequest request){
		if(errors.hasErrors()){
			return "manager/user/user_modify";
		}
		request.setAttribute("title", "修改状态");
		if(hbrService.updateUser(user)){
			request.setAttribute("message", "修改用户信息成功!");
			return "manager/user/user_add_result";
		}else{
			request.setAttribute("message", "修改用户信息出错!");
			return "manager/user/user_add_result";
		}
	}
	
	@RequestMapping("/user/userDelete")
	public void delete(Integer id,HttpServletResponse response) throws Exception{
		if(hbrService.deleteUser(id)){
			response.getWriter().write("OK");
		}else{
			response.getWriter().write("FALSE");
		}
	}
	

}
