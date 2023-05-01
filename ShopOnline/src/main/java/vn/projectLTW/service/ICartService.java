package vn.projectLTW.service;

import vn.projectLTW.model.Cart;

import java.util.List;

public interface ICartService {
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
