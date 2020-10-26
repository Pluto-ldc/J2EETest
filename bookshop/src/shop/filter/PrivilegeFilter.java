package shop.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import shop.domain.User;

/**
 * 权限验证的过滤器
 * @author pluto
 *
 */
@WebFilter("/pages/*")
public class PrivilegeFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//判断用户是否登陆,如果登陆,放行,没有登陆回到登陆界面
		HttpServletRequest req=(HttpServletRequest) request;
		User exsitUser=(User) req.getSession().getAttribute("user");
		//判断
		if(exsitUser==null) {
			//未登陆
			req.setAttribute("msg", "您还没有登陆!没有权限访问!");
			req.getRequestDispatcher("/login.jsp").forward(req, response);
		}else {
			//已经登陆,放行
			chain.doFilter(req, response);
		}
	}

}
