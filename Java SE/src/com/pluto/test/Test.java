package com.pluto.test;

import java.text.SimpleDateFormat;
import java.util.Date;


class Test {

	@org.junit.jupiter.api.Test
	void test() {
		System.out.println(222);
	}
	
	@org.junit.jupiter.api.Test
	void test2() {
		Date now=new Date();
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(now));
	}

}
