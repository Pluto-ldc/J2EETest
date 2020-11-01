package com.baizhi;

import java.io.File;

import org.junit.jupiter.api.Test;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;

public class TestCaptcha {
	@Test
	public void test1() {
		// 1.生成验证码
		LineCaptcha captcha = CaptchaUtil.createLineCaptcha(200, 40, 4, 4);
		// 2.将验证码保存到硬盘
		captcha.write(new File("D:/test,png"));
	}

}
