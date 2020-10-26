package org.easybooks.bookstore.action;

import org.easybooks.bookstore.dao.IUserDAO;
import org.easybooks.bookstore.dao.impl.UserDAO;
import org.easybooks.bookstore.vo.User;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class LoginAction extends ActionSupport {

	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String execute() throws Exception {
		boolean validated = false;
		IUserDAO userDAO = new UserDAO();
		User user = userDAO.validate(new User(this.user.getUserName(), this.user.getPassWord()));
		if (user != null) {
			validated = true;
		}
		if (validated) {
			return SUCCESS;
		} else {
			return ERROR;
		}
	}
}
