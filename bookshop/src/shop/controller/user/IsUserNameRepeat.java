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
 * 接收用户名判断是否重复
 * @author pluto
 *
 */
@WebServlet("/IsUserNameRepeat")
public class IsUserNameRepeat extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String userName=request.getParameter("userName");
		User user=new User();
		user.setUserName(userName);
		UserModel userModel=new UserModel();
		try {
			boolean isUserNameRepeat=userModel.checkUserNameRepeat(user);
			response.getWriter().print(isUserNameRepeat);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
