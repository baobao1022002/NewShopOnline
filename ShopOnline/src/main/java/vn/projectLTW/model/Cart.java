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
	private String address;
	private String province;
	private String district;
	private String payment;
	public Cart(String cartId, Users buyer, Date buyDate, int status,String buyerName, String buyerEmail, String buyerPhone, String address, String province, String district, String payment) {
		super();
		this.cartId = cartId;
		this.buyer = buyer;
		this.buyDate = buyDate;
		this.status = status;
		this.buyerName = buyerName;
		this.buyerEmail = buyerEmail;
		this.buyerPhone = buyerPhone;
		this.address = address;
		this.province = province;
		this.district = district;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}
}