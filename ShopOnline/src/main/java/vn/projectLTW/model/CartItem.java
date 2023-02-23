package vn.projectLTW.model;

public class CartItem {
	private String cartItemId;
	private int quantity;
	private double unitPrice;
	private String cartId;
	private int productId;
	private Product product;
	private Cart cart;
	public CartItem() {
		super();
	}
	public CartItem(String cartItemId, int quantity, double unitPrice, String cartId, int productId, Product product,
			Cart cart) {
		super();
		this.cartItemId = cartItemId;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
		this.cartId = cartId;
		this.productId = productId;
		this.product = product;
		this.cart = cart;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public String getCartId() {
		return cartId;
	}
	public void setCartId(String cartId) {
		this.cartId = cartId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	public String getCartItemId() {
		return cartItemId;
	}
	public void setCartItemId(String cartItemId) {
		this.cartItemId = cartItemId;
	}
	
	
	
}


