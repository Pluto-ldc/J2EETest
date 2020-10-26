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
 * 用户修改密码
 * @author pluto
 *
 */
@WebServlet("/UpdateUserPwd")
public class UpdateUserPwd extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer id=Integer.valueOf(request.getParameter("userId"));
		String passWord=request.getParameter("passWord");
		User user=new User();
		user.setId(id);
		user.setPassWord(passWord);
		UserModel userModel=new UserModel();
		boolean isUpdateUserPwdSuccess=userModel.updateUserPwd(user);
		if (isUpdateUserPwdSuccess) {
			request.setAttribute("msg", "密码修改成功！");
		} else {
			request.setAttribute("msg", "密码修改失败，请联系管理员处理！");
		}
		request.getRequestDispatcher("/LayoutServlet").forward(request, response);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
