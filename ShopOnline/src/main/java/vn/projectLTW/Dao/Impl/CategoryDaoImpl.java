package vn.projectLTW.Dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;




import vn.projectLTW.Dao.DBConnection;
import vn.projectLTW.Dao.ICategoryDao;
import vn.projectLTW.model.Category;
import vn.projectLTW.model.UserRoles;

public class CategoryDaoImpl implements ICategoryDao{

	public Connection conn=null;
	public PreparedStatement ps=null;
	public ResultSet rs=null;
	
	
	@Override
	public void insert(Category category) {
		String sql="Insert into category(categoryName,images,status) values(?,?,?)";
		try {
			conn=new DBConnection().getConnection();
			ps=conn.prepareStatement(sql);
			ps.setString(1, category.getCategoryName());
			ps.setString(2, category.getImages());
			ps.setInt(3, category.getStatus());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	@Override
	public void update(Category category) {
		String sql="UPDATE category SET  categoryName=?,images=?,status=? WHERE categoryId=?";
		try {
			conn=new DBConnection().getConnection();
			ps=conn.prepareStatement(sql);
			ps.setString(1, category.getCategoryName());
			ps.setString(2, category.getImages());
			ps.setInt(3, category.getStatus());
			ps.setInt(4, category.getCategoryId());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	@Override
	public void delete(int id) {
		String sql="DELETE FROM category WHERE categoryId=?";
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
	public Category findOne(int id) {
		// TODO Auto-generated method stub
		String sql = "Select * From category where categoryId=?";

		try {
			conn = new DBConnection().getConnection(); // Kết nối CSDL
			ps = conn.prepareStatement(sql); // Ném câu lệnh SQL bằng phát biểu prepareStatement
			ps.setInt(1, id);		// đưa tham số vào ?
			rs = ps.executeQuery(); // Thực thi câu query và trả về ResultSet

			while (rs.next()) { // Duyệt từng dòng trong ResultSet và trả về ds đối tượng
				Category category = new Category();
				category.setCategoryId(rs.getInt("categoryId"));
				category.setCategoryName(rs.getString("categoryName"));
				category.setImages(rs.getString("images"));
				category.setStatus(rs.getInt("status"));
				
				return category;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return null;
	}
	@Override
	public List<Category> findAll() {

		List<Category> categoryList = new ArrayList<Category>();
		String sql = "Select * From category";

		try {
			conn = new DBConnection().getConnection(); // Kết nối CSDL
			ps = conn.prepareStatement(sql); // Ném câu lệnh SQL bằng phát biểu prepareStatement
			rs = ps.executeQuery(); // Thực thi câu query và trả về ResultSet

			while (rs.next()) { // Duyệt từng dòng trong ResultSet và trả về ds đối tượng
				Category category = new Category();
				category.setCategoryId(rs.getInt("categoryId"));
				category.setCategoryName(rs.getString("categoryName"));
				category.setImages(rs.getString("images"));
				category.setStatus(rs.getInt("status"));
				categoryList.add(category);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return categoryList;

	}
	
}