package com.softfz.security;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SystemFilter implements Filter{
	private SystemCenter center;
	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse) res;
		
		if(center.getCurrentLoginUser(request)==null){
			//没有登录
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print("{\"statusCode\":301,\"message\":\"会话超时，请重新登录!\"}");
			out.flush();
			out.close();
		}else{
			if(center.hasPermission(request)){
				chain.doFilter(req, res);
			}else{
				//没有权限
				//没有登录
				response.setCharacterEncoding("UTF-8");
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.print("{\"statusCode\":300,\"message\":\"您没有权限访问这个请求!\"}");
				out.flush();
				out.close();
			}
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		center = SystemCenter.getInstance();
	}

}
