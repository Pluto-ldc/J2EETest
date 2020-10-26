package com.pluto.action;

import java.util.HashMap;
import java.util.Map;
import com.opensymphony.xwork2.ActionSupport;
import com.pluto.domain.User;
import com.pluto.model.UserModel;

public class UserAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	Map<String, Object> rep_Json;

	public Map<String, Object> getRep_Json() {
		return rep_Json;
	}

	public void setRep_Json(Map<String, Object> rep_Json) {
		this.rep_Json = rep_Json;
	}

	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String login() throws Exception {
		UserModel userModel = new UserModel();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Integer code = -1;
		String msg = "未知错误!";
		User exsitUser = null;
		if (user != null) {
			if (user.getUserName() == null || "".equals(user.getUserName())) {
				msg = "用户名不能为空!";
			} else if (user.getPassWord() == null || "".equals(user.getPassWord())) {
				msg = "密码不能为空!";
			} else {
				exsitUser = userModel.login(this.user);
				if (exsitUser != null) {
					code = 1;
					exsitUser.setPassWord(null);
					msg = "登录成功!";
				} else {
					code = 0;
					msg = "用户名或密码错误!";
				}
			}
		} else {
			msg = "必须的参数未被提供!";
		}
		dataMap.put("code", code);
		dataMap.put("data", exsitUser);
		dataMap.put("msg", msg);
		this.setRep_Json(dataMap);
		return SUCCESS;
	}

	public String register() throws Exception {
		UserModel userModel = new UserModel();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Integer code = -1;
		String msg = "未知错误!";
		if (user != null) {
			if (user.getUserName() == null || "".equals(user.getUserName())) {
				msg = "用户名不能为空!";
			} else if (user.getPassWord() == null || "".equals(user.getPassWord())) {
				msg = "密码不能为空!";
			} else {
				if (this.user != null) {
					Long exsitUserCount = userModel.selectUserByUserName(user.getUserName());
					if (exsitUserCount < 1) {
						Integer num = userModel.register(this.user);
						if (num == 1) {
							code = 1;
							msg = "注册成功!";
						} else {
							code = 0;
							msg = "注册失败!";
						}
					} else {
						msg = "该用户名已存在!";
					}
				}
			}
		} else {
			msg = "必须的参数未被提供!";
		}
		dataMap.put("code", code);
		dataMap.put("msg", msg);
		this.setRep_Json(dataMap);
		return SUCCESS;
	}
}
