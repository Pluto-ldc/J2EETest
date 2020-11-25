package org.easybooks.bookstore.action;

import java.io.IOException;

import org.apache.struts2.ServletActionContext;
import org.easybooks.bookstore.service.IUserService;
import org.easybooks.bookstore.vo.User;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private User user;

	private IUserService userService;

	private String message = "";

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public String execute() {
		User user = userService.validateUser(this.user.getUserName(), this.user.getPassWord());
		if (user != null) {
			ActionContext.getContext().getSession().put("user", user);
			return SUCCESS;
		}
		this.setMessage("用户名或密码错误！");
		return ERROR;

	}

	public String register() {
		if (userService.saveUser(this.user) == null) {
			this.setMessage("注册失败，该用户名已被占用，请重新填写表单！");
			return ERROR;
		}
		this.setMessage("注册成功，请登录！");
		return SUCCESS;
	}

	public void checkUser() throws IOException {
		ServletActionContext.getResponse().getWriter().print(userService.checkUser(this.user.getUserName()));
	}

	public String logout() {
		ActionContext.getContext().getSession().remove("user");
		this.setMessage("注销成功！");
		return SUCCESS;
	}

}