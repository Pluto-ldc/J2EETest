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
 * 用户注册，数据格式已由js校验过，直接插入
 * 
 * @author pluto
 *
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String userName = request.getParameter("userName");
		String passWord = request.getParameter("passWord");
		String name = request.getParameter("name");
		String sex = request.getParameter("sex");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");

		User user = new User();
		user.setUserName(userName);
		user.setPassWord(passWord);
		user.setName(name);
		user.setSex(sex);
		user.setEmail(email);
		user.setMobile(mobile);

		UserModel userModel = new UserModel();
		try {
			boolean isRegisterSusess = userModel.register(user);
			if (isRegisterSusess) {
				request.setAttribute("msg", "注册成功，请登录！");
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			} else {
				request.setAttribute("msg", "注册失败，请联系管理员处理！");
				request.getRequestDispatcher("/register.jsp").forward(request, response);
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
