package org.easybooks.bookstore.model;

import java.util.*;
import org.easybooks.bookstore.vo.*;

public class Cart {
	//���Գ�Ա:bookid->orderitem
	protected Map<Integer,Orderitem> items;
	
	public Cart(){
		if(items==null)
			items=new HashMap<Integer,Orderitem>();
	}
	
	//���ͼ�鵽���ﳵ
	public void addBook(Integer bookid,Orderitem orderitem){
		//�����ӵ�ͼ�鵽���ﳵ�в����ڣ������ͼ�鵽���ﳵ
		//����Ѿ����ڣ������ͼ�������
		if(items.containsKey(bookid)){
			Orderitem _orderitem=items.get(bookid);//�õ����ﳵ�и�ͼ���orderitem
			//���º󶩵�������=ԭ����������+��������������
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
	//���㹺�ﳵ��ͼ����ܼ۸�
	public int getTotalPrice(){
//		int total=0;
////		Collection coll=items.values();//��ȡMap�����е�value
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