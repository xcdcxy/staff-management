package com.imooc.sm.global;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 登录过滤
 */
public class LoginFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		// 获取访问的servlet路径
		String path = req.getServletPath();
		
		if(path.toLowerCase().indexOf("login") != -1) {
			// 登录、退出
			chain.doFilter(request, response);
		} else {
			HttpSession session = req.getSession();
			Object obj = session.getAttribute("USER");
			if(obj != null) {
				// 已经登录 				
				chain.doFilter(request, response);
			} else {
				// 未登录,重定向至登录界面
				res.sendRedirect(req.getContextPath() + "/toLogin.do");
			}
		}
	}
	
	
	public void init(FilterConfig fIlterConfig) throws ServletException {}
	
}
