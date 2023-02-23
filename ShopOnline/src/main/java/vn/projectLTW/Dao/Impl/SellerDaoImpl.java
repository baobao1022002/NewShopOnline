package vn.projectLTW.Dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.projectLTW.Dao.DBConnection;
import vn.projectLTW.Dao.ISellerDao;
import vn.projectLTW.model.Seller;


public class SellerDaoImpl implements ISellerDao {

	public Connection conn=null;
	public PreparedStatement ps=null;
	public ResultSet rs=null;
	
	
	@Override
	public void insert(Seller seller) {
		String sql="Insert into seller(sellerName,images,status) values(?,?,?)";
		try {
			conn=new DBConnection().getConnection();
			ps=conn.prepareStatement(sql);
			ps.setString(1, seller.getSellerName());
			ps.setString(2, seller.getImages());
			ps.setInt(3, seller.getStatus());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	@Override
	public void update(Seller seller) {
		String sql="UPDATE seller SET  sellerName=?,images=?,status=? WHERE sellerId=?";
		try {
			conn=new DBConnection().getConnection();
			ps=conn.prepareStatement(sql);
			ps.setString(1, seller.getSellerName());
			ps.setString(2, seller.getImages());
			ps.setInt(3, seller.getStatus());
			ps.setInt(4, seller.getSellerId());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	@Override
	public void delete(int id) {
		String sql="DELETE FROM seller WHERE sellerId=?";
		try {
			conn=new DBConnection().getConnection();
			ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	@Override
	public Seller findOne(int id) {
		// TODO Auto-generated method stub
		String sql = "Select * From seller where sellerId=?";

		try {
			conn = new DBConnection().getConnection(); // Kết nối CSDL
			ps = conn.prepareStatement(sql); // Ném câu lệnh SQL bằng phát biểu prepareStatement
			ps.setInt(1, id);		// đưa tham số vào ?
			rs = ps.executeQuery(); // Thực thi câu query và trả về ResultSet

			while (rs.next()) { // Duyệt từng dòng trong ResultSet và trả về ds đối tượng
				Seller seller = new Seller();
				seller.setSellerId(rs.getInt("sellerId"));
				seller.setSellerName(rs.getString("sellerName"));
				seller.setImages(rs.getString("images"));
				seller.setStatus(rs.getInt("status"));
				
				return seller;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return null;
	}
	@Override
	public List<Seller> findAll() {

		List<Seller> sellerList = new ArrayList<Seller>();
		String sql = "Select * From seller";

		try {
			conn = new DBConnection().getConnection(); // Kết nối CSDL
			ps = conn.prepareStatement(sql); // Ném câu lệnh SQL bằng phát biểu prepareStatement
			rs = ps.executeQuery(); // Thực thi câu query và trả về ResultSet

			while (rs.next()) { // Duyệt từng dòng trong ResultSet và trả về ds đối tượng
				Seller seller = new Seller();
				seller.setSellerId(rs.getInt("sellerId"));
				seller.setSellerName(rs.getString("sellerName"));
				seller.setImages(rs.getString("images"));
				seller.setStatus(rs.getInt("status"));
				sellerList.add(seller);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return sellerList;

	}

}
