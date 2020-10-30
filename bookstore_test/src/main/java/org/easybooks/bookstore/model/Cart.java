package org.easybooks.bookstore.model;

import java.util.*;
import org.easybooks.bookstore.vo.*;

public class Cart {
	//属性成员:bookid->orderitem
	protected Map<Integer,Orderitem> items;
	
	public Cart(){
		if(items==null)
			items=new HashMap<Integer,Orderitem>();
	}
	
	//添加图书到购物车
	public void addBook(Integer bookid,Orderitem orderitem){
		//如果添加的图书到购物车中不存在，则添加图书到购物车
		//如果已经存在，则更新图书的数量
		if(items.containsKey(bookid)){
			Orderitem _orderitem=items.get(bookid);//得到购物车中该图书的orderitem
			//更新后订单的数量=原订单的数量+新增订单的数量
			_orderitem.setQuantity(orderitem.getQuantity()+_orderitem.getQuantity());
			items.put(bookid,_orderitem);
		}
		else{
			items.put(bookid,orderitem);
		}
	}
	
	public void updateCart(Integer bookid, int quantity) {
		Orderitem orderitem=items.get(bookid);
		orderitem.setQuantity(quantity);
		items.put(bookid,orderitem);
			
	}
	//计算购物车中图书的总价格
	public int getTotalPrice(){
//		int total=0;
////		Collection coll=items.values();//获取Map中所有的value
////		Iterator ita=coll.iterator();
//		while(items.values().iterator().hasNext()){
//			Orderitem orderitem=(Orderitem)items.values().iterator().next();
//			int price=orderitem.getBook().getPrice();
//			total+=orderitem.getQuantity()*price;
//		}
//		return total;
//	}
	
	
		int totalPrice=0;
		for(Iterator it=items.values().iterator();it.hasNext();){
			Orderitem orderitem=(Orderitem)it.next();
			Book book=orderitem.getBook();
			int quantity=orderitem.getQuantity();
			totalPrice+=book.getPrice()*quantity;
		}
		return totalPrice;
	}
	
	
	public Map<Integer, Orderitem> getItems() {
		return items;
	}
	public void setItems(Map<Integer, Orderitem> items) {
		this.items = items;
	}

	
}