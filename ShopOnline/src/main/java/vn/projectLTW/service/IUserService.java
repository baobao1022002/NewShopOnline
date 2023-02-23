package vn.projectLTW.service;

import java.util.List;

import vn.projectLTW.model.Users;

public interface IUserService {
	//Khai báo các hàm xử lí
	List<Users> findAll(); // hàm lấy toàn bộ User

	Users findOne(int id); // hàm lấy 1 đối tượng User
	Users findOne(String userName); // hàm lấy 1 đối tượng User theo userName

	void insert(Users user); // hàm này thêm dữ liệu mới cho User

	void updateStatus(Users user);// hàm này dùng active tài khoản

	void update(Users user); // hàm này cập nhật đối tượng User
	
	void delete(int id);	//hàm này xóa 1 đối tượng User
	
	boolean register(String email,String passWord,String userName,String fullName,String code);
	
	Users login(String userName,String passWord);
	
	boolean checkExistEmail(String email);
	
	boolean checkExistUserName(String userName);
	
	
	

}
