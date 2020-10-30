package org.easybooks.bookstore.action;
import java.util.Map;

import org.easybooks.bookstore.service.IUserService;
import org.easybooks.bookstore.vo.User;
import org.easybooks.bookstore.service.impl.UserService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ActionContext;
public class UserAction extends ActionSupport {

	private User user;
	protected IUserService userService;
	private String message="";
	
	public String register() throws Exception{
		userService.saveUser(user);
		return SUCCESS;
	}
	public String execute() throws Exception{
		User u=userService.validateUser(user.getUsername(),user.getPassword());
		if(u!=null){
			Map session=ActionContext.getContext().getSession();
			session.put("user", u);
			return SUCCESS;
		}
		else{
			this.setMessage("用户名或密码错误，请重新登录");
		}
		return ERROR;
		}
	public String logout() throws Exception{
		Map session=ActionContext.getContext().getSession();
		session.remove("user");
		return SUCCESS;
	}
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}