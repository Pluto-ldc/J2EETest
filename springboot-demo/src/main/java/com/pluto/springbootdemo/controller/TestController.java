package com.pluto.springbootdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@GetMapping("/hello/{name}")
	public String sayHello(@PathVariable("name") String name) {
		return name + "你好！";
	}

}
