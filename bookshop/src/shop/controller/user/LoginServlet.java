package shop.controller.user;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.domain.User;
import shop.model.UserModel;

/**
 * 处理登陆的Servlet
 * 
 * @author pluto
 *
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 接受数据
		String userName = request.getParameter("userName");
		String passWord = request.getParameter("passWord");
		String verifyCode = request.getParameter("verifyCode");
		String verifyCode0 = (String) request.getSession().getAttribute("verifyCode");
		request.getSession().removeAttribute("verifyCode");
		if (!verifyCode0.equalsIgnoreCase(verifyCode)) {
			request.setAttribute("msg", "验证码输入错误！");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;
		}
		// 封装数据
		User user = new User();
		user.setUserName(userName);
		user.setPassWord(passWord);
		// 处理数据
		UserModel userModel = new UserModel();
		try {
			User exsitUser = userModel.login(user);
			if (exsitUser == null) {
				request.setAttribute("msg", "用户名或密码错误！");
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			} else {
				request.getSession().setAttribute("user", exsitUser);
				response.sendRedirect(request.getContextPath() + "/pages/main.jsp");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
