package com.lqq.controller;

import static com.lqq.util.common.HbrConstants.MAP_EMPLOYEE;
import static com.lqq.util.common.HbrConstants.PAGE_DEFAULT_SIZE;

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
import com.lqq.entity.Dept;
import com.lqq.entity.Employee;
import com.lqq.entity.Job;
import com.lqq.service.HbrService;

@Controller
public class EmployeeController {

	@Autowired
	@Qualifier("hbrService")
	private HbrService hbrService;

	@RequestMapping("/employee/employeeSearchIndex")
	public String searchIndex(HttpServletRequest request) {

		getAllDeptAndJob(request);
		return "manager/employee/employee_search";
	}

	@RequestMapping("/employee/employeeSearch")
	public String search(Employee employee, Integer dept_id, Integer job_id, HttpServletRequest request,
			Integer curPage) {
		Dept dept = null;
		Job job = null;
		if (dept_id != null) {
			dept = hbrService.selectDeptById(dept_id);
		}
		if (job_id != null) {
			job = hbrService.selectJobById(job_id);
		}
		if (curPage == null) {
			curPage = 1;
		}
		System.out.println(employee);
		employee.setDept(dept);
		employee.setJob(job);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put(MAP_EMPLOYEE, employee);
		PageHelper.startPage(curPage, PAGE_DEFAULT_SIZE);
		List<Employee> list = hbrService.selectEmployeeByParams(params);
		PageInfo<Employee> pageInfo = new PageInfo<>(list);
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("employee_list", list);
		request.setAttribute("employee", employee);
		getAllDeptAndJob(request);
		return "manager/employee/employee_search";
	}

	@RequestMapping("/employee/employeeAddIndex")
	public String addIndex(HttpServletRequest request) {
		getAllDeptAndJob(request);
		Employee employee = new Employee();
		request.setAttribute("employee", employee);
		return "manager/employee/employee_add";
	}

	@RequestMapping("/employee/emloyeeAdd")
	public String add(@Valid @ModelAttribute Employee employee, Errors errors, HttpServletRequest request) {
		if (errors.hasErrors()) {
			getAllDeptAndJob(request);
			System.out.println(errors);
			return "manager/employee/employee_add";
		}
		Dept dept = hbrService.selectDeptById(employee.getDeptId());
		Job job = hbrService.selectJobById(employee.getJobId());
		employee.setDept(dept);
		employee.setJob(job);
		employee.setCreateDate(new Date());
		request.setAttribute("title", "添加状态");
		if (hbrService.addEmployee(employee)) {
			request.setAttribute("message", "添加成功!");
			return "manager/employee/employee_add_result";
		} else {
			request.setAttribute("message", "添加员工失败!");
			return "manager/employee/employee_add";
		}
	}

	public void getAllDeptAndJob(HttpServletRequest request) {
		List<Dept> depts = hbrService.selectDeptByParams(null);
		List<Job> jobs = hbrService.selectJobByParams(null);
		request.setAttribute("dept_list", depts);
		request.setAttribute("job_list", jobs);
	}

	@RequestMapping("employee/employeeModifyIndex")
	public String modifyIndex(Integer id,Model model){
		Employee employee = hbrService.selectEmployeeById(id);
		model.addAttribute("employee", employee);
		return "manager/employee/employee_modify";
	}
	@RequestMapping("/employee/employeeModify")
	public String modify(@Valid @ModelAttribute Employee employee,Errors errors,HttpServletRequest request) {
		if(errors.hasErrors()){
			return "manager/employee/employee_modify";
		}
		request.setAttribute("title", "修改状态");
		if (hbrService.updateEmployee(employee)) {
			request.setAttribute("message", "修改员工信息成功!");
			return "manager/employee/employee_add_result";
		} else {
			request.setAttribute("message", "修改员工信息出错!");
			return "manager/employee/employee_add_result";
		}
	}

	@RequestMapping("/employee/employeeDelete")
	public void delete(Integer id, HttpServletResponse response) throws Exception {
		if (hbrService.deleteEmployee(id)) {
			response.getWriter().write("OK");
		} else {
			response.getWriter().write("FALSE");
		}
	}

}
