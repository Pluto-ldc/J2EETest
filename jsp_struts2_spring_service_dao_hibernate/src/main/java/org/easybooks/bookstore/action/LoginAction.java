package org.easybooks.bookstore.action;

import org.easybooks.bookstore.service.IUserService;
import org.easybooks.bookstore.vo.User;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

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
		User user = userService.validateUser(this.user);
		if (user == null) {
			ActionContext.getContext().getValueStack().set("msg", "用户名或密码错误！");
			return ERROR;
		}
		return SUCCESS;
	}

	public String register() {
		User user = userService.registerUser(this.user);
		String msg = null;
		ValueStack valueStack = ActionContext.getContext().getValueStack();
		if (user != null) {
			msg = "注册成功，请登陆！";
		} else {
			msg = "注册失败，该用户名已被占用，请重新填写表单！";
		}
		valueStack.set("msg", msg);
		return user != null ? SUCCESS : ERROR;
	}
}
