package org.easybooks.bookstore.action;

import org.easybooks.bookstore.dao.IUserDAO;
import org.easybooks.bookstore.dao.impl.UserDAO;
import org.easybooks.bookstore.vo.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
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
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext( new String[] { "applicationContext.xml" });
		IUserDAO userDAO = (UserDAO) applicationContext.getBean("UserDAO");
		User user = userDAO.validate(this.user);
		((ConfigurableApplicationContext)applicationContext).close();
		if (user != null) {
			return SUCCESS;
		}else {
			return ERROR;
		}
	}
}
