package vn.projectLTW.Dao.Impl;

import vn.projectLTW.Dao.DBConnection;
import vn.projectLTW.Dao.ICartDao;
import vn.projectLTW.model.Cart;
import vn.projectLTW.model.Users;
import vn.projectLTW.service.IUserService;
import vn.projectLTW.service.Impl.UserServiceImpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CartDaoImpl implements ICartDao{

	public Connection conn=null;
	public PreparedStatement ps=null;
	public ResultSet rs=null;
	IUserService userService=new UserServiceImpl();

	@Override
	public void insert(Cart cart) {
		String sql="INSERT INTO cart (cartId, userId, buyDate, status, buyerName, buyerEmail, buyerPhone, buyerAddress, buyerProvince, buyerDistrict, payment) values(?,?,?,?,?,?,?,?,?,?,?)";
		try {
			conn=new DBConnection().getConnection();
			ps=conn.prepareStatement(sql);
			ps.setString(1, cart.getCartId());
			ps.setInt(2, cart.getBuyer().getUserId());
			ps.setDate(3, new Date(cart.getBuyDate().getTime()));
			ps.setInt(4, cart.getStatus());
			ps.setString(5,cart.getBuyerName());
			ps.setString(6,cart.getBuyerEmail());
			ps.setString(7,cart.getBuyerPhone());
			ps.setString(8,cart.getBuyerAddress());
			ps.setString(9,cart.getBuyerProvince());
			ps.setString(10,cart.getBuyerDistrict());
			ps.setString(11,cart.getPayment());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	@Override
	public void update(Cart cart) {
		String sql="UPDATE cart set userId=?,buyDate=?,status=? where cartId=?";
		try {
			conn=new DBConnection().getConnection();
			ps=conn.prepareStatement(sql);
			ps.setInt(1, cart.getBuyer().getUserId());
			ps.setDate(2, new Date(cart.getBuyDate().getTime()));
			ps.setInt(3, cart.getStatus());
			ps.setString(4, cart.getCartId());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public void delete(String id) {
		String sql="Delete from cart  where cart.cartId=?";
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
	public void updateStatus(String id, int st) {
		String sql="UPDATE cart set status=? where cart.cartId=?";
		try {
			conn=new DBConnection().getConnection();
			ps=conn.prepareStatement(sql);
			ps.setInt(1, st);
			ps.setString(2, id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public Cart findOne(String id) {
		String sql="SELECT cart.cartId,cart.buyDate,cart.status,users.sellerId,users.email,users.userName,users.userId \r\n"
				+ "FROM cart INNER JOIN users ON cart.userId=users.userId\r\n"
				+ "WHERE cart.cartId=?";
		try {
			conn=new DBConnection().getConnection();
			ps=conn.prepareStatement(sql);
			ps.setString(1, id);
			rs=ps.executeQuery();
			while(rs.next()) {
				Users user=userService.findOne(rs.getInt("userId"));
				Cart cart=new Cart();
				cart.setCartId(rs.getString("cartId"));
				cart.setBuyDate(rs.getDate("buyDate"));
				cart.setStatus(rs.getInt("status"));
				cart.setBuyer(user);
				return cart;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public List<Cart> findAll() {
		List<Cart> cartList=new ArrayList<Cart>();
		String sql="SELECT cart.cartId,cart.buyDate,cart.status,users.sellerId,users.email,users.userName,users.userId \r\n"
				+ "FROM cart INNER JOIN users ON cart.userId=users.userId";
		try {
			conn=new DBConnection().getConnection();
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				Users user=userService.findOne(rs.getInt("userId"));
				Cart cart=new Cart();
				cart.setCartId(rs.getString("cartId"));
				cart.setBuyDate(rs.getDate("buyDate"));
				cart.setStatus(rs.getInt("status"));
				cart.setBuyer(user);
				cartList.add(cart);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cartList;
	}
	@Override
	public List<Cart> findAllByUser(int id) {
		List<Cart> cartList=new ArrayList<Cart>();
		String sql="\r\n"
				+ "SELECT cart.cartId,cart.buyDate,cart.status,users.sellerId,users.email,users.userName,users.userId \r\n"
				+ "FROM cart INNER JOIN users ON cart.userId=users.userId\r\n"
				+ "WHERE users.userId=? ORDER BY buyDate,status";
		try {
			conn=new DBConnection().getConnection();
			ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs=ps.executeQuery();
			while(rs.next()) {
				Users user=userService.findOne(rs.getInt("userId"));
				Cart cart=new Cart();
				cart.setCartId(rs.getString("cartId"));
				cart.setBuyDate(rs.getDate("buyDate"));
				cart.setStatus(rs.getInt("status"));
				cart.setBuyer(user);
				cartList.add(cart);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cartList;
	}
	@Override
	public int countByUser(int id) {
		String sql="SELECT count(*) FROM cart where cart.cartId=?";
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
	public int countByStatus(int id, int status) {
		String sql="SELECT count(*) FROM cart where cart.cartId=? and cart.status=?";
		try {
			conn=new DBConnection().getConnection();
			ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setInt(2, status);
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
	public List<Cart> allOrder() {
		List<Cart> cartList=new ArrayList<Cart>();
		String sql="SELECT cart.cartId,cart.buyDate,cart.status,cart.buyerName,cart.buyerPhone,cart.buyerEmail,cart.buyerAddress,cart.buyerProvince,cart.buyerDistrict,cart.payment\n" +
				"FROM cart";
		try {
			conn=new DBConnection().getConnection();
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				Cart cart=new Cart();
				cart.setCartId(rs.getString("cartId"));
				cart.setBuyDate(rs.getDate("buyDate"));
//				cart.setStatus(rs.getInt("status"));
				cart.setBuyerName(rs.getString("buyerName"));
				cart.setBuyerPhone(rs.getString("buyerPhone"));
				cart.setBuyerEmail(rs.getString("buyerEmail"));
				cart.setBuyerAddress(rs.getString("buyerAddress"));
				cart.setBuyerProvince(rs.getString("buyerProvince"));
				cart.setBuyerDistrict(rs.getString("buyerDistrict"));
				cart.setPayment(rs.getString("payment"));

				cartList.add(cart);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cartList;
	}

	@Override
	public List<Cart> orderByMonth(int month,int year) {
		List<Cart> cartList=new ArrayList<Cart>();
		String sql="SELECT cart.cartId,cart.buyDate,cart.status,cart.buyerName,cart.buyerPhone,cart.buyerEmail,cart.buyerAddress,cart.buyerProvince,cart.buyerDistrict,cart.payment\n" +
				"FROM cart  where month(buyDate)=? and year(buyDate)=?";
		try {
			conn=new DBConnection().getConnection();
			ps=conn.prepareStatement(sql);
			ps.setInt(1, month);
			ps.setInt(2, year);
			rs=ps.executeQuery();
			while(rs.next()) {
				Cart cart=new Cart();
				cart.setCartId(rs.getString("cartId"));
				cart.setBuyDate(rs.getDate("buyDate"));
//				cart.setStatus(rs.getInt("status"));
				cart.setBuyerName(rs.getString("buyerName"));
				cart.setBuyerPhone(rs.getString("buyerPhone"));
				cart.setBuyerEmail(rs.getString("buyerEmail"));
				cart.setBuyerAddress(rs.getString("buyerAddress"));
				cart.setBuyerProvince(rs.getString("buyerProvince"));
				cart.setBuyerDistrict(rs.getString("buyerDistrict"));
				cart.setPayment(rs.getString("payment"));

				cartList.add(cart);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cartList;
	}

	@Override
	public int countToTalOrder() {
		String sql="SELECT count(cartId) FROM cart;";
		try {
			conn=new DBConnection().getConnection();
			ps=conn.prepareStatement(sql);
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
	public double totalRevenue() {
		String sql="SELECT sum(payment) FROM cart";
		try {
			conn=new DBConnection().getConnection();
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				return rs.getDouble(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public double revenueByMonth(int month,int year) {
		String sql="SELECT sum(payment) FROM cart where month(buyDate)=? and year(buyDate)=?";
		try {
			conn=new DBConnection().getConnection();
			ps=conn.prepareStatement(sql);
			ps.setInt(1, month);
			ps.setInt(2, year);
			rs=ps.executeQuery();
			while(rs.next()) {
				return rs.getDouble(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	@Override
	public int countOrderByMonth(int month, int year) {
		String sql="SELECT count(cartId) FROM cart WHERE month(buyDate)=? and year(buyDate)=? ;";
		try {
			conn=new DBConnection().getConnection();
			ps=conn.prepareStatement(sql);
			ps.setInt(1, month);
			ps.setInt(2, year);
			rs=ps.executeQuery();
			while(rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
//	@Override
//	public String bestSeller(int month,int year) {
//		String sql="SELECT product.productName, SUM(cart_item.quantity) AS totalQuantity\n" +
//				"FROM cart_item\n" +
//				"JOIN cart ON cart_item.cartId = cart.cartId\n" +
//				"JOIN product ON cart_item.productId = product.productId\n" +
//				"WHERE month(cart.buyDate) = ? AND year(cart.buyDate) = ?\n" +
//				"GROUP BY product.productName\n" +
//				"ORDER BY totalQuantity DESC\n" +
//				"LIMIT 1;";
//		try {
//			conn=new DBConnection().getConnection();
//			ps=conn.prepareStatement(sql);
//			ps.setInt(1, month);
//			ps.setInt(2, year);
//			rs=ps.executeQuery();
//			while(rs.next()) {
//				return rs.getString(1);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return null ;
//	}

}