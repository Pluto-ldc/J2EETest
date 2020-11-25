package org.easybooks.bookstore.model;

import java.util.HashMap;
import java.util.Map;

import org.easybooks.bookstore.vo.OrderItem;

/**
 * 图书商城购物车类
 * 
 * 
 * @author pluto
 *
 */
public class Cart {

	/**
	 * 购物车对象
	 */
	private Map<Integer, OrderItem> cartMap;

	public Map<Integer, OrderItem> getCartMap() {
		return cartMap;
	}

	public void setCartMap(Map<Integer, OrderItem> cartMap) {
		this.cartMap = cartMap;
	}

	/**
	 * 重载无参构造器，若购物车为null，则初始化
	 */
	public Cart() {
		if (cartMap == null) {
			cartMap = new HashMap<>();
		}
	}

	/**
	 * 增加图书到购物车
	 * 
	 * @param bookId    要增加的图书Id
	 * @param orderItem 要增加的图书详细信息
	 */
	public void addBook(Integer bookId, OrderItem orderItem) {
		if (cartMap.containsKey(bookId)) {
			OrderItem orderItemExsit = cartMap.get(bookId);
			orderItem.setQuantity(orderItem.getQuantity() + orderItemExsit.getQuantity());
		}
		cartMap.put(bookId, orderItem);
	}

	/**
	 * 修改购物车中某图书的数量
	 * 
	 * @param bookId   要修改的图书Id
	 * @param quantity 要增加的图书的数量
	 */
	public void updateCart(Integer bookId, int quantity) {
		if (quantity < 1) {
			cartMap.remove(bookId);
		} else {
			OrderItem orderItem = cartMap.get(bookId);
			orderItem.setQuantity(quantity);
			cartMap.put(bookId, orderItem);
		}
	}

	/**
	 * 获取购物车对象中所有图书的总价
	 * 
	 * @return 购物车中所有图书总价
	 */
	public int getTotalPrice() {
		int totalPrice = 0;
		for (OrderItem orderItem : cartMap.values()) {
			totalPrice += orderItem.getBook().getPrice() * orderItem.getQuantity();
		}
		return totalPrice;
	}

}
