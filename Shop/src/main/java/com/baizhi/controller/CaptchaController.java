package com.baizhi.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;

@Controller
@RequestMapping("/util")
public class CaptchaController {
	@RequestMapping("/captcha.do")
	public void getCode(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 1.生成验证码
		LineCaptcha captcha = CaptchaUtil.createLineCaptcha(200, 40, 4, 4);
		// 2.将验证码保存到硬盘
		captcha.write(response.getOutputStream());
		String code = captcha.getCode();
		request.getSession().setAttribute("code", code);
	}
}
