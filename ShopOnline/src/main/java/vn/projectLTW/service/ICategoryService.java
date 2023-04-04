package vn.projectLTW.service;

import vn.projectLTW.model.Category;

import java.util.List;

public interface ICategoryService {
	void insert(Category category); // hàm này thêm dữ liệu mới cho User

	void update(Category category); // hàm này cập nhật đối tượng User
	
	void delete(int id);	//hàm này xóa 1 đối tượng User
	
	Category findOne(int id);
	
	List<Category> findAll();
}
