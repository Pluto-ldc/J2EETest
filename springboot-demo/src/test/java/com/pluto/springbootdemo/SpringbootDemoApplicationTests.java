package com.pluto.springbootdemo;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.pluto.springbootdemo.entity.User;

@SpringBootTest
class SpringbootDemoApplicationTests {

	@Test
	void contextLoads() {
		User user = new User(null, "1", "1");
		Date date = new Date();
		System.out.println(date + "," + user);
	}

}