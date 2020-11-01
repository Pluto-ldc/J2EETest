package com.baizhi.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.baizhi.entity.Admin;
import com.baizhi.service.AdminService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	AdminService adminService;

	@PostMapping("/login.do")
	public String login(@RequestParam("userName") String userName, @RequestParam("passWord") String passWord,
			@RequestParam("safeCode") String safeCode, HttpServletRequest req) {
		if (!req.getSession().getAttribute("code").equals(safeCode)) {
			req.setAttribute("msg", "验证码输入错误！");
			return "forward:/Login.jsp";
		}
		Admin admin = adminService.login(userName);
		if (admin == null) {
			req.setAttribute("msg", "用户名不存在！");
			return "forward:/Login.jsp";
		}
		if (!admin.getPwd().equals(passWord)) {
			req.setAttribute("msg", "密码错误！");
			return "forward:/Login.jsp";
		}
		req.getSession().setAttribute("admin", admin);
		return "redirect:/product/list.do";

	}

	@PostMapping("/register.do")
	public String register(@RequestParam("name") String name, @RequestParam("pwd") String pwd,
			@RequestParam("mobile") String mobile, @RequestParam("email") String email, HttpServletRequest req) {
		Admin admin = new Admin(null, name, pwd, mobile, email);
		if (adminService.login(name) != null) {
			req.setAttribute("msg", "该用户名已被使用，请重新输入！");
			return "forward:/Register.jsp";
		}
		adminService.register(admin);
		req.setAttribute("msg", "注册成功！");
		return "forward:/Login.jsp";

	}

	@RequestMapping("/layout.do")
	public String layout(HttpServletRequest req) {
		req.getSession().invalidate();
		return "redirect:/Login.jsp";
	}
}
