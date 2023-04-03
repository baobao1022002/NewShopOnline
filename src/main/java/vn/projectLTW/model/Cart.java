package vn.projectLTW.model;

import java.util.Date;

public class Cart {
	private String cartId;
	private Users buyer;
	private Date buyDate;
	private int status;
	public Cart(String cartId, Users buyer, Date buyDate, int status) {
		super();
		this.cartId = cartId;
		this.buyer = buyer;
		this.buyDate = buyDate;
		this.status = status;
	}
	public Cart() {
		super();
	}
	public String getCartId() {
		return cartId;
	}
	public void setCartId(String cartId) {
		this.cartId = cartId;
	}
	public Users getBuyer() {
		return buyer;
	}
	public void setBuyer(Users buyer) {
		this.buyer = buyer;
	}
	public Date getBuyDate() {
		return buyDate;
	}
	public void setBuyDate(Date buyDate) {
		this.buyDate = buyDate;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	

}
