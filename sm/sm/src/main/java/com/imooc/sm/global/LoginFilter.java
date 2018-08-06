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
 * ��¼����
 */
public class LoginFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		// ��ȡ���ʵ�servlet·��
		String path = req.getServletPath();
		
		if(path.toLowerCase().indexOf("login") != -1) {
			// ��¼���˳�
			chain.doFilter(request, response);
		} else {
			HttpSession session = req.getSession();
			Object obj = session.getAttribute("USER");
			if(obj != null) {
				// �Ѿ���¼ 				
				chain.doFilter(request, response);
			} else {
				// δ��¼,�ض�������¼����
				res.sendRedirect(req.getContextPath() + "/toLogin.do");
			}
		}
	}
	
	
	public void init(FilterConfig fIlterConfig) throws ServletException {}
	
}
