package vn.projectLTW.Dao.Impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

//import org.apache.catalina.storeconfig.StoreContextAppender;

import vn.projectLTW.Dao.DBConnection;
import vn.projectLTW.Dao.ICartItemDao;
import vn.projectLTW.model.Cart;
import vn.projectLTW.model.CartItem;
import vn.projectLTW.model.Product;
import vn.projectLTW.model.Seller;
import vn.projectLTW.model.Users;
import vn.projectLTW.service.ICartService;
import vn.projectLTW.service.IProductService;
import vn.projectLTW.service.ISellerService;
import vn.projectLTW.service.IUserService;
import vn.projectLTW.service.Impl.CartServiceImpl;
import vn.projectLTW.service.Impl.ProductServiceImpl;
import vn.projectLTW.service.Impl.SellerServiceImpl;
import vn.projectLTW.service.Impl.UserServiceImpl;

public class CartItemDaoImpl implements ICartItemDao{

	public Connection conn=null;
	public PreparedStatement ps=null;
	public ResultSet rs=null;
	
	ICartService cartService=new CartServiceImpl();
	IProductService productService=new ProductServiceImpl();
	IUserService userService=new UserServiceImpl();
	ISellerService sellerService=new SellerServiceImpl();
	
	@Override
	public void insert(CartItem cartItem) {
		String sql="Insert into cart_item(cartItemId,cartId,productId,quantity,unitPrice) values(?,?,?,?,?)";
		try {
			conn=new DBConnection().getConnection();
			ps=conn.prepareStatement(sql);
			ps.setString(1, cartItem.getCartItemId());
			ps.setString(2, cartItem.getCart().getCartId());
			ps.setInt(3, cartItem.getProduct().getProductId());
			ps.setInt(4, cartItem.getQuantity());
			ps.setDouble(5, cartItem.getUnitPrice());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void update(CartItem cartItem) {
		String sql="UPDATE cart_item set cartId=?, productId=?,quantity=?,unitPrice=?,  where cartItemId=?";
		try {
			conn=new DBConnection().getConnection();
			ps=conn.prepareStatement(sql);
			ps.setString(1, cartItem.getCart().getCartId());
			ps.setInt(2, cartItem.getProduct().getProductId());
			ps.setInt(3, cartItem.getQuantity());
			ps.setDouble(4, cartItem.getUnitPrice());
			ps.setString(5, cartItem.getCartItemId());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}		
		
	}

	@Override
	public void delete(String id) {
		String sql="Delete from cart_item   where cartItemId=?";
		try {
			conn=new DBConnection().getConnection();
			ps=conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}				
	}

	@Override
	public CartItem findOne(String id) {
		String sql="SELECT cart_item.cartItemId,cart_item.quantity,cart_item.unitPrice,cart.userId,cart.buyDate,cart.status,cart.cartId,product.productName,product.price\r\n"
				+ "				 FROM cart_item INNER JOIN cart ON cart.cartId=cart_item.cartId INNER JOIN product ON cart_item.productId=product.productId\r\n"
				+ "				WHERE cart_item.cartItemId=?";
		try {
			conn=new DBConnection().getConnection();
			ps=conn.prepareStatement(sql);
			ps.setString(1, id);
			rs=ps.executeQuery();
			while(rs.next()) {
				Users user=userService.findOne(rs.getInt("userId"));
				
				Cart cart=new Cart();
				cart.setBuyer(user);
				cart.setBuyDate(rs.getDate("buyDate"));
				cart.setStatus(rs.getInt("status"));
				cart.setCartId(rs.getString("cartId"));
				
				Product product=new Product();
				product.setProductName(rs.getString("productName"));
				product.setPrice(rs.getDouble("price"));
				
				CartItem cartItem=new CartItem();
				cartItem.setCart(cart);
				cartItem.setProduct(product);
				cartItem.setQuantity(rs.getInt("quantity"));
				cartItem.setUnitPrice(rs.getDouble("unitPrice"));
				
				return cartItem;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return null;
	}

	@Override
	public List<CartItem> findAll() {
		List<CartItem> cartListItem=new ArrayList<CartItem>();
		String sql="SELECT cart_item.cartItemId,cart_item.quantity,cart_item.unitPrice,cart.userId,cart.buyDate,cart.status,cart.cartId,product.productName,product.price\r\n"
				+ "				 FROM cart_item INNER JOIN cart ON cart.cartId=cart_item.cartId INNER JOIN product ON cart_item.productId=product.productId";
		try {
			conn=new DBConnection().getConnection();
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				Users user=userService.findOne(rs.getInt("userId"));
				
				Cart cart=new Cart();
				cart.setBuyer(user);
				cart.setBuyDate(rs.getDate("buyDate"));
				cart.setStatus(rs.getInt("status"));
				cart.setCartId(rs.getString("cartId"));
				
				Product product=new Product();
				product.setProductName(rs.getString("productName"));
				product.setPrice(rs.getDouble("price"));
				
				CartItem cartItem=new CartItem();
				cartItem.setCart(cart);
				cartItem.setProduct(product);
				cartItem.setQuantity(rs.getInt("quantity"));
				cartItem.setUnitPrice(rs.getDouble("unitPrice"));
				
				 cartListItem.add(cartItem);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return cartListItem;
	}

	@Override
	public List<CartItem> findAllByUser(int id) {
		List<CartItem> cartListItem=new ArrayList<CartItem>();

		String sql="SELECT cart_item.cartItemId,cart_item.quantity,cart_item.unitPrice,cart_item.cartId,cart_item.productId,cart.userId,cart.buyDate,cart.status,cart.cartId AS cart_id,product.productName,product.price,product.images,seller.sellerName,seller.sellerId AS s_id,seller.images AS avatar\r\n"
				+ "				 FROM cart_item INNER JOIN cart ON cart.cartId=cart_item.cartId\r\n"
				+ "								INNER JOIN product ON cart_item.productId=product.productId \r\n"
				+ "								INNER JOIN seller ON product.sellerId=seller.sellerId\r\n"
				+ "			WHERE cart.userId=? ORDER BY cart.status ASC";
			
		try {
			conn=new DBConnection().getConnection();
			ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs=ps.executeQuery();
			while(rs.next()) {
				Users user=userService.findOne(rs.getInt("userId"));
				Seller seller=sellerService.findOne(rs.getInt("s_id"));
				
				Cart cart=new Cart();
				cart.setBuyer(user);
				cart.setBuyDate(rs.getDate("buyDate"));
				cart.setStatus(rs.getInt("status"));
				cart.setCartId(rs.getString("cart_id"));
				
				Product product=new Product();
				product.setProductName(rs.getString("productName"));
				product.setPrice(rs.getDouble("price"));
				product.setImages(rs.getString("images"));
				product.setSellerId(rs.getInt("s_id"));
				product.setSeller(seller);
				
				CartItem cartItem=new CartItem();
				cartItem.setCartItemId(rs.getString("cartItemId"));
				cartItem.setCartId(rs.getString("cart_id"));
				cartItem.setProductId(rs.getInt("productId"));;
				cartItem.setCart(cart);
				cartItem.setProduct(product);
				cartItem.setQuantity(rs.getInt("quantity"));
				cartItem.setUnitPrice(rs.getDouble("unitPrice"));
				
				cartListItem.add(cartItem);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return null;
	}

	@Override
	public List<CartItem> findAllByUserId(int id) {
		List<CartItem> cartListItem=new ArrayList<CartItem>();

		String sql="SELECT cart_item.cartItemId,cart_item.quantity,cart_item.unitPrice,cart_item.cartId,cart_item.productId,cart.userId,cart.buyDate,cart.status,cart.cartId AS cart_id,product.productName,product.price,product.images,seller.sellerName,seller.sellerId AS s_id,seller.images AS avatar\r\n"
				+ "				 FROM cart_item INNER JOIN cart ON cart.cartId=cart_item.cartId\r\n"
				+ "								INNER JOIN product ON cart_item.productId=product.productId \r\n"
				+ "								INNER JOIN seller ON product.sellerId=seller.sellerId\r\n"
				+ "			WHERE cart.userId=? ";
			
		try {
			conn=new DBConnection().getConnection();
			ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs=ps.executeQuery();
			while(rs.next()) {
				Users user=userService.findOne(rs.getInt("userId"));
				Seller seller=sellerService.findOne(rs.getInt("s_id"));
				
				Cart cart=new Cart();
				cart.setBuyer(user);
				cart.setBuyDate(rs.getDate("buyDate"));
				cart.setStatus(rs.getInt("status"));
				cart.setCartId(rs.getString("cart_id"));
				
				Product product=new Product();
				product.setProductName(rs.getString("productName"));
				product.setPrice(rs.getDouble("price"));
				product.setImages(rs.getString("images"));
				product.setSellerId(rs.getInt("s_id"));
				product.setSeller(seller);
				
				CartItem cartItem=new CartItem();
				cartItem.setCartItemId(rs.getString("cartItemId"));
				cartItem.setCartId(rs.getString("cart_id"));
				cartItem.setProductId(rs.getInt("productId"));;
				cartItem.setCart(cart);
				cartItem.setProduct(product);
				cartItem.setQuantity(rs.getInt("quantity"));
				cartItem.setUnitPrice(rs.getDouble("unitPrice"));
				
				cartListItem.add(cartItem);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return null;
	}

	@Override
	public List<CartItem> findAllByUserPaging(int id, int index) {
		List<CartItem> cartListItem=new ArrayList<CartItem>();

		String sql="SELECT cart_item.cartItemId,cart_item.quantity,cart_item.unitPrice,cart_item.cartId,cart_item.productId,cart.userId,cart.buyDate,cart.status,cart.cartId AS cart_id,product.productName,product.price,product.images,seller.sellerName,seller.sellerId AS s_id,seller.images AS avatar\r\n"
				+ "				 FROM cart_item INNER JOIN cart ON cart.cartId=cart_item.cartId\r\n"
				+ "								INNER JOIN product ON cart_item.productId=product.productId \r\n"
				+ "								INNER JOIN seller ON product.sellerId=seller.sellerId\r\n"
				+ "			WHERE cart.userId=? ORDER BY cart.status ASC\r\n"
				+"OFFSET ? ROWS FETCH NEXT 3 ROWS ONLY";
		try {
			conn=new DBConnection().getConnection();
			ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setInt(2, (index-1)*3);
			rs=ps.executeQuery();
			while(rs.next()) {
				Users user=userService.findOne(rs.getInt("userId"));
				Seller seller=sellerService.findOne(rs.getInt("s_id"));
				
				Cart cart=new Cart();
				cart.setBuyer(user);
				cart.setBuyDate(rs.getDate("buyDate"));
				cart.setStatus(rs.getInt("status"));
				cart.setCartId(rs.getString("cart_id"));
				
				Product product=new Product();
				product.setProductName(rs.getString("productName"));
				product.setPrice(rs.getDouble("price"));
				product.setImages(rs.getString("images"));
				product.setSellerId(rs.getInt("s_id"));
				product.setSeller(seller);
				
				CartItem cartItem=new CartItem();
				cartItem.setCartItemId(rs.getString("cartItemId"));
				cartItem.setCartId(rs.getString("cart_id"));
				cartItem.setProductId(rs.getInt("productId"));;
				cartItem.setCart(cart);
				cartItem.setProduct(product);
				cartItem.setQuantity(rs.getInt("quantity"));
				cartItem.setUnitPrice(rs.getDouble("unitPrice"));
				
				cartListItem.add(cartItem);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return null;
	}

	@Override
	public int countByUser(int id) {
		String sql="SELECT count(*) FROM cart_item INNER JOIN cart ON cart_item.cartId=cart.cartId where cart.userId=?";
		try {
			conn=new DBConnection().getConnection();
			ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs=ps.executeQuery();
			while(rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return 0;
	}

	@Override
	public List<CartItem> findAllSeller(int id) {
		// TODO Auto-generated method stub
		List<CartItem> cartListItem=new ArrayList<CartItem>();

		String sql="SELECT cart_item.cartItemId,cart_item.quantity,cart_item.unitPrice,cart_item.cartId,cart_item.productId,cart.userId,cart.buyDate,cart.status,cart.cartId AS cart_id,product.productName,product.price,product.images,seller.sellerName,seller.sellerId AS s_id,seller.images AS avatar\r\n"
				+ "				 FROM cart_item INNER JOIN cart ON cart.cartId=cart_item.cartId\r\n"
				+ "								INNER JOIN product ON cart_item.productId=product.productId \r\n"
				+ "								INNER JOIN seller ON product.sellerId=seller.sellerId\r\n"
				+ "			WHERE seller.sellerId=? ORDER BY cart.status ASC";
		
		try {
			conn=new DBConnection().getConnection();
			ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs=ps.executeQuery();
			while(rs.next()) {
				Users user=userService.findOne(rs.getInt("userId"));
				Seller seller=sellerService.findOne(rs.getInt("s_id"));
				
				Cart cart=new Cart();
				cart.setBuyer(user);
				cart.setBuyDate(rs.getDate("buyDate"));
				cart.setStatus(rs.getInt("status"));
				cart.setCartId(rs.getString("cart_id"));
				
				Product product=new Product();
				product.setProductName(rs.getString("productName"));
				product.setPrice(rs.getDouble("price"));
				product.setImages(rs.getString("images"));
				product.setSellerId(rs.getInt("s_id"));
				product.setSeller(seller);
				
				CartItem cartItem=new CartItem();
				cartItem.setCartItemId(rs.getString("cartItemId"));
				cartItem.setCartId(rs.getString("cart_id"));
				cartItem.setProductId(rs.getInt("productId"));;
				cartItem.setCart(cart);
				cartItem.setProduct(product);
				cartItem.setQuantity(rs.getInt("quantity"));
				cartItem.setUnitPrice(rs.getDouble("unitPrice"));
				
				cartListItem.add(cartItem);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return null;
	}

}
