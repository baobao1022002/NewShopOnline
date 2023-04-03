package vn.projectLTW.service;

import java.util.List;

import vn.projectLTW.model.UserRoles;


public interface IUserRoleService {
	//Khai báo các hàm xử lí service
		List<UserRoles> findAll(); // hàm lấy toàn bộ UserRoles

		UserRoles findOne(int id); // hàm lấy 1 đối tượng UserRoles

		void insert(UserRoles role); // hàm này thêm dữ liệu mới cho UserRoles

		void update(UserRoles role); // hàm này cập nhật đối tượng UserRoles
		
		void delete(int id);	//hàm này xóa 1 đối tượng UserRoles
		
	
}
