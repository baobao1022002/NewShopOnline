package vn.projectLTW.Dao;

import vn.projectLTW.model.Cart;

import java.util.List;

public interface ICartDao {
//	void insert(Cart cart, String buyerName,String buyerEmail, String buyerPhone, String address, String province, String district, String payment);

	void insert(Cart cart);

	void update(Cart cart);
	void delete(String id);
	void updateStatus(String id,int st);
	Cart findOne(String id);
	List<Cart> findAll();
	List<Cart> findAllByUser(int id);
	int countByUser(int id);
	int countByStatus(int id, int status); 
	
}
