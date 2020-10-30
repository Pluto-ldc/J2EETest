package org.easybooks.bookstore.model;

import java.util.*;
import org.easybooks.bookstore.vo.*;

public class Cart {
	//���Գ�Ա:bookid->OrderItem
	protected Map<Integer,OrderItem> items;
	
	public Cart(){
		if(items==null)
			items=new HashMap<Integer,OrderItem>();
	}
	
	//���ͼ�鵽���ﳵ
	public void addBook(Integer bookid,OrderItem OrderItem){
		//�����ӵ�ͼ�鵽���ﳵ�в����ڣ������ͼ�鵽���ﳵ
		//����Ѿ����ڣ������ͼ�������
		if(items.containsKey(bookid)){
			OrderItem _OrderItem=items.get(bookid);//�õ����ﳵ�и�ͼ���OrderItem
			//���º󶩵�������=ԭ����������+��������������
			_OrderItem.setQuantity(OrderItem.getQuantity()+_OrderItem.getQuantity());
			items.put(bookid,_OrderItem);
		}
		else{
			items.put(bookid,OrderItem);
		}
	}
	
	public void updateCart(Integer bookid, int quantity) {
		OrderItem OrderItem=items.get(bookid);
		OrderItem.setQuantity(quantity);
		items.put(bookid,OrderItem);
			
	}
	//���㹺�ﳵ��ͼ����ܼ۸�
	public int getTotalPrice(){
//		int total=0;
////		Collection coll=items.values();//��ȡMap�����е�value
////		Iterator ita=coll.iterator();
//		while(items.values().iterator().hasNext()){
//			OrderItem OrderItem=(OrderItem)items.values().iterator().next();
//			int price=OrderItem.getBook().getPrice();
//			total+=OrderItem.getQuantity()*price;
//		}
//		return total;
//	}
	
	
		int totalPrice=0;
		for(Iterator<OrderItem> it=items.values().iterator();it.hasNext();){
			OrderItem OrderItem=(OrderItem)it.next();
			Book book=OrderItem.getBook();
			int quantity=OrderItem.getQuantity();
			totalPrice+=book.getPrice()*quantity;
		}
		return totalPrice;
	}
	
	
	public Map<Integer, OrderItem> getItems() {
		return items;
	}
	public void setItems(Map<Integer, OrderItem> items) {
		this.items = items;
	}

	
}