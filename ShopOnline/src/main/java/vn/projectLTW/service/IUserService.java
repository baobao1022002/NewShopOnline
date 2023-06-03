package vn.projectLTW.service;

import vn.projectLTW.model.UserGG;
import vn.projectLTW.model.Users;

import java.util.Date;
import java.util.List;


public interface IUserService {
	//Khai báo các hàm xử lí
	List<Users> findAll(); // hàm lấy toàn bộ User

	Users findOne(int id); // hàm lấy 1 đối tượng User
		UserGG findOneGG(String id); // hàm lấy 1 đối tượng User


	Users findOne(String userName); // hàm lấy 1 đối tượng User theo userName

	void insert(Users user); // hàm này thêm dữ liệu mới cho User


	void updateStatus(Users user);// hàm này dùng active tài khoản

	void updateStatusGG(UserGG user);// hàm này dùng active tài khoản

	void update(Users user); // hàm này cập nhật đối tượng User
	
	void delete(int id);	//hàm này xóa 1 đối tượng User
	
	boolean register(String email,String passWord,String userName,String fullName,String code);

	boolean registerGG(String userGGId,String email);


	Users login(String userName,String passWord);
	UserGG loginGG(String userGG_Id);
	
	boolean checkExistEmail(String email);
	
	boolean checkExistUserName(String userName);

	void changePassword(int Id, String newPass);

    boolean checkOldPassword(int Id, String oldPass);

    int getLoginAttempts(String userName);

	void updateLoginAttempts(String userName, int loginAttempts);

	Date getAccountLockedUntil(String userName);

	void setAccountLockedUntil(String userName, Date unlockTime);

//    void changeProfile(int id, String fullname, String email, String phone, String province, String district, String address);

	void changeProfile(int Id, String fullname, String email, String phone);
}
