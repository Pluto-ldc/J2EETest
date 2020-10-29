package org.easybooks.bookstore.action;

import org.easybooks.bookstore.service.IUserService;
import org.easybooks.bookstore.vo.User;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class LoginAction extends ActionSupport {

	private User user;
	
	protected IUserService userService;

	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String execute() {
		User user=userService.validateUser(this.user);
		if (user != null) {
			return SUCCESS;
		} else {
			return ERROR;
		}
	}
	
	public String register() {
		User user=userService.registerUser(this.user);
		if (user != null) {
			return SUCCESS;
		}else {
			return ERROR;
		}
	}
}
