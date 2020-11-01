package com.baizhi.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import org.springframework.core.annotation.Order;

@Order(1)
@WebFilter(filterName = "piceaFilter", urlPatterns = { "/user/*", "/product/*" })
public class LoginFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request2 = (HttpServletRequest) request;
		// TODO Auto-generated method stub
		if (request2.getSession().getAttribute("admin") == null) {
			request2.setAttribute("msg", "登录已失效，请重新登录！");
			request2.getRequestDispatcher("/Login.jsp").forward(request2, response);
		} else {
			chain.doFilter(request2, response);
		}
	}

}
