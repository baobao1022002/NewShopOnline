package vn.projectLTW.model;

import java.util.Date;

public class Cart {
	private String cartId;
	private Users buyer;
	private Date buyDate;
	private int status;
	private String buyerName;
	private String buyerEmail;
	private String buyerPhone;
	private String buyerAddress;
	private String buyerProvince;
	private String buyerDistrict;
	private String payment;
	public Cart(String cartId, Users buyer, Date buyDate, int status,String buyerName, String buyerEmail, String buyerPhone, String buyerAddress, String buyerProvince, String buyerDistrict, String payment) {
		super();
		this.cartId = cartId;
		this.buyer = buyer;
		this.buyDate = buyDate;
		this.status = status;
		this.buyerName = buyerName;
		this.buyerEmail = buyerEmail;
		this.buyerPhone = buyerPhone;
		this.buyerAddress = buyerAddress;
		this.buyerProvince =buyerProvince ;
		this.buyerDistrict = buyerDistrict;
		this.payment = payment;
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

	public String getBuyerName() {
		return buyerName;
	}

	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}

	public String getBuyerEmail() {
		return buyerEmail;
	}

	public void setBuyerEmail(String buyerEmail) {
		this.buyerEmail = buyerEmail;
	}

	public String getBuyerPhone() {
		return buyerPhone;
	}

	public void setBuyerPhone(String buyerPhone) {
		this.buyerPhone = buyerPhone;
	}


	public String getBuyerAddress() {
		return buyerAddress;
	}

	public void setBuyerAddress(String buyerAddress) {
		this.buyerAddress = buyerAddress;
	}

	public String getBuyerProvince() {
		return buyerProvince;
	}

	public void setBuyerProvince(String buyerProvince) {
		this.buyerProvince = buyerProvince;
	}

	public String getBuyerDistrict() {
		return buyerDistrict;
	}

	public void setBuyerDistrict(String buyerDistrict) {
		this.buyerDistrict = buyerDistrict;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}
}