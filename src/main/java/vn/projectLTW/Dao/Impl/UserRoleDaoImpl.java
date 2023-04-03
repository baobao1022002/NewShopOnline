package vn.projectLTW.Dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.projectLTW.Dao.DBConnection;
import vn.projectLTW.Dao.IUserRoleDao;
import vn.projectLTW.model.UserRoles;

public class UserRoleDaoImpl implements IUserRoleDao {
	public Connection conn = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;

	@Override
	public List<UserRoles> findAll() {
		// TODO Auto-generated method stub
		List<UserRoles> roleList = new ArrayList<UserRoles>();
		String sql = "Select * From user_roles";

		try {
			conn = new DBConnection().getConnection(); // Kết nối CSDL
			ps = conn.prepareStatement(sql); // Ném câu lệnh SQL bằng phát biểu prepareStatement
			rs = ps.executeQuery(); // Thực thi câu query và trả về ResultSet

			while (rs.next()) { // Duyệt từng dòng trong ResultSet và trả về ds đối tượng
				UserRoles userRole = new UserRoles();
				userRole.setRoleId(rs.getInt("roleId"));
				userRole.setRoleName(rs.getString("roleName"));
				roleList.add(userRole);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return roleList;
	}

	@Override
	public UserRoles findOne(int id) {
		// TODO Auto-generated method stub
		String sql = "select * from user_roles Where roleId=?";

		try {
			conn = new DBConnection().getConnection(); // Kết nối CSDL
			ps = conn.prepareStatement(sql); // Ném câu lệnh SQL bằng phát biểu prepareStatement
			ps.setInt(1, id);	//đưa tham số  vào dấu ?
			rs = ps.executeQuery(); // Thực thi câu query và trả về ResultSet

			while (rs.next()) { // Duyệt từng dòng trong ResultSet và trả về ds đối tượng
				UserRoles userRole = new UserRoles();
				userRole.setRoleId(rs.getInt("roleId"));
				userRole.setRoleName(rs.getString("roleName"));
				return userRole;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public void insert(UserRoles role) {
		// TODO Auto-generated method stub
		String sql="INSERT INTO user_roles(roleName) VALUES (?)";
		try {
			conn = new DBConnection().getConnection();
			ps=conn.prepareStatement(sql);
			ps.setString(1, role.getRoleName());
			ps.executeUpdate();
						
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	@Override
	public void update(UserRoles role) {
		// TODO Auto-generated method stub
		String sql="UPDATE user_roles SET roleName=? WHERE roleId=?";
		
		try {
			conn = new DBConnection().getConnection();
			ps=conn.prepareStatement(sql);
			ps.setString(1, role.getRoleName());
			ps.setInt(2, role.getRoleId());
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		

	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub

String sql="DELETE user_roles WHERE roleId=?";
		
		try {
			conn = new DBConnection().getConnection();
			ps=conn.prepareStatement(sql);
			ps.setInt(1,id);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
