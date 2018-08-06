package com.imooc.sm.global;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 编码过滤器
 */
public class EncodingFilter implements Filter {

	// 编码方式
	private String encoding = "UTF-8";	
	
	/*
	 * 销毁方法
	 */
	public void destroy() {
		encoding = null;
	}

	/*
	 * 过滤
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		// 改变编码方式
		request.setCharacterEncoding(encoding);
		response.setCharacterEncoding(encoding);
		// 过滤
		chain.doFilter(request, response);
	}

	/*
	 * 初始化方法
	 */
	public void init(FilterConfig fIlterConfig) throws ServletException {
		
		if(fIlterConfig.getInitParameter("ENCODING") != null) {
			// 获取配置的编码		
			encoding =  fIlterConfig.getInitParameter("ENCODING");
		}
	}

}