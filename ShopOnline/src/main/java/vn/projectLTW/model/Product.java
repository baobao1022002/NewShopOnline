package vn.projectLTW.model;

import java.io.Serializable;
import java.sql.Date;

public class Product implements Serializable{
	private int productId;
	private String productName;
	private long productCode;
	private int categoryId;
	private String  description;
	private Double price;
	private int amount;
	private int  stoke;
	private String images;
	private String image2;
	private String image3;
	private String image4;
	private String image5;

	private int  wishList;
	private int  status;
	private Date createDate;
	private int  sellerId;
	private Category category;
	private Seller seller;
	
	public Product() {
		super();
	}

	public Product(int productId, String productName, long productCode, int categoryId, String description,
			Double price, int amount, int stoke, String images, int wishList, int status, Date createDate, int sellerId,String image2,String image3,String image4,String image5,
			Category category, Seller seller) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productCode = productCode;
		this.categoryId = categoryId;
		this.description = description;
		this.price = price;
		this.amount = amount;
		this.stoke = stoke;
		this.images = images;

		this.wishList = wishList;
		this.status = status;
		this.createDate = createDate;
		this.sellerId = sellerId;
		this.image2=image2;
		this.image3=image3;
		this.image4=image4;
		this.image5=image5;
		this.category = category;
		this.seller = seller;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public long getProductCode() {
		return productCode;
	}

	public void setProductCode(long productCode) {
		this.productCode = productCode;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getStoke() {
		return stoke;
	}

	public void setStoke(int stoke) {
		this.stoke = stoke;
	}

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}

	public int getWishList() {
		return wishList;
	}

	public void setWishList(int wishList) {
		this.wishList = wishList;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public int getSellerId() {
		return sellerId;
	}

	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Seller getSeller() {
		return seller;
	}

	public void setSeller(Seller seller) {
		this.seller = seller;
	}

	public String getImage2() {
		return image2;
	}

	public void setImage2(String image2) {
		this.image2 = image2;
	}

	public String getImage3() {
		return image3;
	}

	public void setImage3(String image3) {
		this.image3 = image3;
	}

	public String getImage4() {
		return image4;
	}

	public void setImage4(String image4) {
		this.image4 = image4;
	}

	public String getImage5() {
		return image5;
	}

	public void setImage5(String image5) {
		this.image5 = image5;
	}
}
