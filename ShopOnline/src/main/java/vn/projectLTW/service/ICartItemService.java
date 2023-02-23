package vn.projectLTW.service;

import java.util.List;

import vn.projectLTW.model.CartItem;

public interface ICartItemService {
	void insert(CartItem cartItem);
	void update(CartItem cartItem);
	void delete(String id);
	CartItem findOne(String id);
	List<CartItem> findAll();
	List<CartItem> findAllByUser(int id);
	List<CartItem> findAllByUserId(int id);
	List<CartItem> findAllByUserPaging(int id,int index);

	
	int countByUser(int id);
	List<CartItem> findAllSeller(int id);
}
