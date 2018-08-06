package com.imooc.sm.global;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * ���������
 */
public class EncodingFilter implements Filter {

	// ���뷽ʽ
	private String encoding = "UTF-8";	
	
	/*
	 * ���ٷ���
	 */
	public void destroy() {
		encoding = null;
	}

	/*
	 * ����
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		// �ı���뷽ʽ
		request.setCharacterEncoding(encoding);
		response.setCharacterEncoding(encoding);
		// ����
		chain.doFilter(request, response);
	}

	/*
	 * ��ʼ������
	 */
	public void init(FilterConfig fIlterConfig) throws ServletException {
		
		if(fIlterConfig.getInitParameter("ENCODING") != null) {
			// ��ȡ���õı���		
			encoding =  fIlterConfig.getInitParameter("ENCODING");
		}
	}

}