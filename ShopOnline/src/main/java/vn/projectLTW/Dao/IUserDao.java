package vn.projectLTW.Dao;

import java.util.List;

import vn.projectLTW.model.Users;

public interface IUserDao {
	//Khai báo các hàm xử lí của Dao
	List<Users> findAll(); // hàm lấy toàn bộ User

	Users findOne(int id);
	Users findOne(String userName);// hàm lấy 1 đối tượng User theo ID

	void insert(Users user); // hàm này thêm dữ liệu mới cho User

	void insertRegister(Users user);// hàm này dùng cho Register
	
	void update(Users user); // hàm này cập nhật đối tượng User
	
	void updateStatus(Users user);// hàm này dùng active tài khoản
	
	void delete(int id);	//hàm này xóa 1 đối tượng User
	
	
	boolean checkExistEmail(String email);
	
	boolean checkExistUserName(String userName);

}
