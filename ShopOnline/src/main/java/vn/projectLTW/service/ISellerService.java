package vn.projectLTW.service;

import vn.projectLTW.model.Seller;

import java.util.List;

public interface ISellerService {
	void insert(Seller seller); // hàm này thêm dữ liệu mới cho Seller

	void update(Seller seller); // hàm này cập nhật đối tượng Seller
	
	void delete(int id);	//hàm này xóa 1 đối tượng Seller
	
	Seller findOne(int id);
	
	List<Seller> findAll();
}
