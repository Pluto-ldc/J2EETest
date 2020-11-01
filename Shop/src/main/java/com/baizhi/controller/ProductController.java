package com.baizhi.controller;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.baizhi.dao.ProductDao;
import com.baizhi.entity.Product;

import cn.hutool.core.io.IORuntimeException;
import cn.hutool.core.lang.UUID;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;

@Controller
@RequestMapping("/product")
public class ProductController {
	@Autowired
	private ProductDao productDao;

	@RequestMapping("/list.do")
	public String getAll(Model model) {
		// 获得所有商品信息
		List<Product> products = productDao.selectAll();
		// 将list数据存入model
		model.addAttribute("products", products);

//		for (Product product : products) {
//			System.out.println(product);
//		}

		// 页面跳转
		return "forward:/product/ProductList.jsp";

	}

	@RequestMapping("/analysis.do")
	public String getNeedAddAndTop(Model model) {
		// 获得所有商品信息
		List<Product> needProducts = productDao.needAdd();
		List<Product> topProducts = productDao.saleTop();
		model.addAttribute("needProducts", needProducts);
		model.addAttribute("topProducts", topProducts);
		return "forward:/product/ProductAnalysis.jsp";
	}

	@GetMapping("changeStatus.do")
	public String changeStatus(@RequestParam("id") int id, @RequestParam("status") String status) {
		productDao.changeStatus(id, status);
		return "redirect:/product/list.do";

	}

	@GetMapping("deleteProduct.do")
	public String deleteProduct(@RequestParam("id") int id) {
		productDao.delete(id);
		return "redirect:/product/list.do";

	}

	@GetMapping("infoProduct.do")
	public String infoProduct(@RequestParam("id") int id, Model model) {
		Product product = productDao.selectById(id);
		model.addAttribute("product", product);
		return "forward:/product/ProductDetail.jsp";

	}

	@PostMapping("addProduct.do")
	public String addProduct(@RequestParam("productPic") MultipartFile productPic, @RequestParam("name") String name,
			@RequestParam("price") Double price, @RequestParam("sum") Integer sum,
			@RequestParam("description") String description) throws Exception {
		String path = ResourceUtils.getFile("classpath:static").getPath();
		String uuid = UUID.randomUUID().toString();
		String realName = productPic.getOriginalFilename();
		String suffix = realName.substring(realName.lastIndexOf("."));
		String saveName = uuid + suffix;
		String savePath = path + "\\" + saveName;
		productPic.transferTo(new File(savePath));
		Product product = new Product(null, name, price, sum, 0L, "1", new Date(), description, saveName);
		productDao.insert(product);
		return "redirect:/product/list.do";

	}

	@GetMapping("editProduct.do")
	public String editProduct(@RequestParam("id") int id, Model model) {
		Product product = productDao.selectById(id);
		model.addAttribute("product", product);
		return "forward:/product/EditProduct.jsp";
	}

	@PostMapping("updateProduct.do")
	public String updateProduct(@RequestParam("id") int id, @RequestParam("name") String name,
			@RequestParam("price") Double price, @RequestParam("sum") int sum,
			@RequestParam("description") String description) {
		Product product = new Product(id, name, price, sum, null, null, null, description, null);
		productDao.updateProduct(product);
		return "redirect:/product/list.do";
	}

	@PostMapping("removeBatch.do")
	public String removeBatch(@RequestParam("ids") int[] ids) {
		productDao.deleteBatch(ids);
		return "redirect:/product/list.do";
	}

	@RequestMapping("/export.do")
	public void exportProducts(HttpServletResponse response) throws IORuntimeException, IOException {
		// 设置本次文件导出的文件名
		response.setHeader("content-disposition", "attachment;fileName=" + URLEncoder.encode("商品导出表.xlsx", "UTF-8"));
		List<Product> products = productDao.selectAll();
		ExcelWriter writer = ExcelUtil.getWriter();
		writer.merge(8, "商品信息表");
		writer.setColumnWidth(1, 20);
		writer.setColumnWidth(2, 20);
		writer.setColumnWidth(4, 20);
		writer.setColumnWidth(6, 20);
		writer.setColumnWidth(7, 20);
		writer.write(products);
		writer.flush(response.getOutputStream());
		writer.close();

	}
}
