package com.baizhi.controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.baizhi.dao.UserDao;
import com.baizhi.entity.User;

import cn.hutool.core.io.IORuntimeException;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserDao userDao;

	@RequestMapping("/list.do")
	public String getAll(Model model) {
		// 获得所有商品信息
		List<User> users = userDao.selectAll();
		// 将list数据存入model
		model.addAttribute("users", users);

		// 页面跳转
		return "forward:/user/UserList.jsp";
	}

	@GetMapping("/delete.do")
	public String deleteUser(@RequestParam("id") int id) {
		userDao.delete(id);
		return "redirect:/user/list.do";
	}

	@PostMapping("/addUser.do")
	public String addUser(@RequestParam("userName") String userName, @RequestParam("age") int age,
			@RequestParam("mobile") String mobile, @RequestParam("email") String email,
			@RequestParam("address") String address) {
		User user = new User(null, userName, "123456", age, mobile, email, address, null, null);
		userDao.insert(user);
		return "redirect:/user/list.do";
	}

	@GetMapping("/editUser.do")
	public String editUser(@RequestParam("id") int id, Model model) {
		User user = userDao.selectById(id);
		model.addAttribute("user", user);
		return "forward:/user/EditUser.jsp";
	}

	@PostMapping("updateUser.do")
	public String updateUser(@RequestParam("id") int id, @RequestParam("userName") String userName,
			@RequestParam("mobile") String mobile, @RequestParam("age") int age, @RequestParam("email") String email,
			@RequestParam("address") String address) {
		User user = new User(id, userName, null, age, mobile, email, address, "0", null);
		userDao.updateUser(user);
		return "redirect:/user/list.do";
	}

	@RequestMapping("/export.do")
	public void exportUsers(HttpServletResponse response) throws IORuntimeException, IOException {
		// 设置本次文件导出的文件名
		response.setHeader("content-disposition", "attachment;fileName=" + URLEncoder.encode("用户导出表.xlsx", "UTF-8"));
		List<User> users = userDao.selectAll();
		ExcelWriter writer = ExcelUtil.getWriter();
		writer.merge(8, "用户信息表");
		writer.setColumnWidth(1, 20);
		writer.setColumnWidth(4, 20);
		writer.setColumnWidth(5, 20);
		writer.setColumnWidth(6, 20);
		writer.write(users);
		writer.flush(response.getOutputStream());
		writer.close();

	}
}
