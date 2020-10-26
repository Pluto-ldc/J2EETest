package shop.domain;

import java.util.ArrayList;
import java.util.List;

public class Transaction {
	
	private String dateString;
	
	private List<Cart> cartList=new ArrayList<Cart>();
	
	private boolean status = false;

	public String getDateString() {
		return dateString;
	}

	public void setDateString(String dateString) {
		this.dateString = dateString;
	}

	public List<Cart> getCartList() {
		return cartList;
	}

	public void setCartList(List<Cart> cartList) {
		this.cartList = cartList;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
}
