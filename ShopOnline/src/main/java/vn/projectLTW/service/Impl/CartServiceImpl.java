package vn.projectLTW.service.Impl;

import vn.projectLTW.Dao.ICartDao;
import vn.projectLTW.Dao.Impl.CartDaoImpl;
import vn.projectLTW.model.Cart;
import vn.projectLTW.service.ICartService;

import java.util.List;

public class CartServiceImpl implements ICartService{
	ICartDao cartDao=new CartDaoImpl();

	@Override
	public void insert(Cart cart) {
		cartDao.insert(cart);
		
	}

	@Override
	public void update(Cart cart) {
		Cart oldCart=cartDao.findOne(cart.getCartId());
		oldCart.setBuyDate(cart.getBuyDate());
		oldCart.setBuyer(cart.getBuyer());
		cartDao.update(oldCart);
	}

	@Override
	public void delete(String id) {
		cartDao.delete(id);		
	}

	@Override
	public void updateStatus(String id, int st) {
		cartDao.updateStatus(id, st);		
	}

	@Override
	public Cart findOne(String id) {
		// TODO Auto-generated method stub
		return cartDao.findOne(id);
	}

	@Override
	public List<Cart> findAll() {
		// TODO Auto-generated method stub
		return cartDao.findAll();
	}

	@Override
	public List<Cart> findAllByUser(int id) {
		// TODO Auto-generated method stub
		return cartDao.findAllByUser(id);
	}

	@Override
	public int countByUser(int id) {
		// TODO Auto-generated method stub
		return cartDao.countByUser(id);
	}

	@Override
	public int countByStatus(int id, int status) {
		// TODO Auto-generated method stub
		return cartDao.countByStatus(id, status);
	}

	@Override
	public List<Cart> allOrder() {
		return cartDao.allOrder();
	}

	@Override
	public List<Cart> orderByMonth(int month,int year) {
		return cartDao.orderByMonth(month,year);
	}

	@Override
	public int countToTalOrder() {
		return cartDao.countToTalOrder();
	}

	@Override
	public double totalRevenue() {
		return cartDao.totalRevenue();
	}

	@Override
	public double revenueByMonth(int month,int year) {
		return cartDao.revenueByMonth(month,year);
	}
  	@Override
	public int countOrderByMonth(int month, int year) {
		return  cartDao.countOrderByMonth(month,year);
	}
//	@Override
//	public String bestSeller(int month,int year) {
//		return  cartDao.bestSeller(month,year);
//	}
}
