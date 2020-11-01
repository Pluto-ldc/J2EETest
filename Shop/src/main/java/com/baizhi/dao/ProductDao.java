package com.baizhi.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baizhi.entity.Product;

/**
 * @author Administrator
 * 
 *         Ctrl+Shift+O 快速导包
 */
public interface ProductDao {

	// 查询所有商品
	public List<Product> selectAll();

	// 根据ID查询商品
	public Product selectById(int id);

	// 更改商品状态
	public void changeStatus(@Param("id") int id, @Param("status") String status);

	// 添加商品
	public void insert(Product product);

	// 删除商品
	public void delete(int id);

	// 急需补货商品前5条
	public List<Product> needAdd();

	// 销量前五商品
	public List<Product> saleTop();

	// 修改商品信息
	public void updateProduct(Product product);

	// 批量删除商品
	public void deleteBatch(@Param("ids") int[] ids);
}
