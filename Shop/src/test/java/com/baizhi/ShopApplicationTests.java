package com.baizhi;

import java.io.File;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.baizhi.dao.ProductDao;
import com.baizhi.dao.UserDao;
import com.baizhi.entity.Product;
import com.baizhi.entity.User;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;

@SpringBootTest
@MapperScan("com.baizhi.dao")
class ShopApplicationTests {

	@Autowired
	private ProductDao productDao;
	@Autowired
	private UserDao userDao;

	@Test
	void contextLoads() {
	}

	@Test
	public void test1() {

		// 测试输出所有商品信息
		List<Product> products = productDao.selectAll();
		for (Product product : products) {
			System.out.println(product);
		}

		// 测试输出所有用户信息
		List<User> users = userDao.selectAll();
		for (User user : users) {
			System.out.println(user);
		}
	}

	// 测试通过商品ID删除商品信息
	@Test
	public void test2() {
		Product product = productDao.selectById(1);
		System.out.println(product);
	}

	// 测试添加商品
	@Test
	public void test3() {
		Product product = productDao.selectById(1);
		System.out.println(product);
		productDao.insert(product);
	}

	// 测试删除商品
	@Test
	public void test4() {
		productDao.delete(30);
	}

	@Test
	public void test5() {
		// 导出数据
		// 1.得到数据
		List<Product> products = productDao.selectAll();
		// 2.使用Hutool工具封装数据
		// 1.获得写数据工具--Writer
		ExcelWriter writer = ExcelUtil.getWriter(true);
		writer.merge(8, "商品信息表");
		writer.setColumnWidth(1, 20);
		writer.setColumnWidth(2, 20);
		writer.setColumnWidth(4, 20);
		writer.setColumnWidth(6, 20);
		writer.setColumnWidth(7, 20);
		// 2.将数据通过writer写出去
		writer.write(products);
		// 3.将数据输出到文件中
		writer.flush(new File("D:/test.xlsx"));
		// 4.释放资源，关闭流
		writer.close();

	}

	@Test
	public void test6() {
		// 1.生成验证码
		LineCaptcha captcha = CaptchaUtil.createLineCaptcha(200, 40, 4, 4);
		// 2.将验证码保存到硬盘
		captcha.write(new File("D:/test,png"));
	}
}
