package shop.controller.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import shop.domain.User;
import shop.model.UserModel;

/**
 * 用户修改信息
 * 
 * @author pluto
 *
 */
@WebServlet("/EditUserInfo")
public class EditUserInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userName = request.getParameter("userName");
		String name = request.getParameter("name");
		String sex = request.getParameter("sex");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		Integer id = Integer.valueOf(request.getParameter("userId"));

		User user = new User();
		user.setUserName(userName);
		user.setName(name);
		user.setSex(sex);
		user.setEmail(email);
		user.setMobile(mobile);
		user.setId(id);

		UserModel userModel = new UserModel();
		boolean isEditSusess = userModel.editUserInfo(user);
		if (isEditSusess) {
			request.setAttribute("msg", "资料修改成功！");
		} else {
			request.setAttribute("msg", "资料修改失败，请联系管理员处理！");
		}
		request.getRequestDispatcher("/LayoutServlet").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
