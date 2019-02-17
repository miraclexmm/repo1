package com.lqq.interceptor;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.lqq.entity.User;

public class AuthorizedInterceptor extends HandlerInterceptorAdapter {

	private static final String[] IGNORE_URI = { "/loginForm", "/login" };

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub

		boolean flag = false;

		String serverPath = request.getServletPath();
		System.out.println("ServerPath: " + serverPath);
		for (String s : IGNORE_URI) {

			if (serverPath.contains(s)) {
				flag = true;
				break;
			}

		}
		if (!flag) {

			User user = (User) request.getSession().getAttribute("user");
			if (user == null) {
				request.setAttribute("message", "您还未登录,请先登录!");
				ServletContext servletContext = request.getServletContext();
				servletContext.getRequestDispatcher("/loginForm").forward(request, response);
				return flag;
			} else {
				flag = true;
			}
		}
		return flag;
	}

}
