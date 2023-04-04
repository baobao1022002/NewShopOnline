package vn.projectLTW.Dao;

import vn.projectLTW.model.Seller;

import java.util.List;

public interface ISellerDao {
	void insert(Seller seller); // hàm này thêm dữ liệu mới cho User

	void update(Seller seller); // hàm này cập nhật đối tượng User
	
	void delete(int id);	//hàm này xóa 1 đối tượng User
	
	Seller findOne(int id);
	
	List<Seller> findAll();
}
