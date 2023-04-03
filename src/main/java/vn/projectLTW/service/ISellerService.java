package vn.projectLTW.service;

import java.util.List;

import vn.projectLTW.model.Seller;

public interface ISellerService {
	void insert(Seller seller); // hàm này thêm dữ liệu mới cho Seller

	void update(Seller seller); // hàm này cập nhật đối tượng Seller
	
	void delete(int id);	//hàm này xóa 1 đối tượng Seller
	
	Seller findOne(int id);
	
	List<Seller> findAll();
}
