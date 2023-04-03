package vn.projectLTW.service.Impl;

import java.util.List;

import vn.projectLTW.Dao.ICartItemDao;
import vn.projectLTW.Dao.Impl.CartItemDaoImpl;
import vn.projectLTW.model.CartItem;
import vn.projectLTW.service.ICartItemService;

public class CartItemServiceImpl implements ICartItemService {
	ICartItemDao cartItemDao=new CartItemDaoImpl();
	@Override
	public void insert(CartItem cartItem) {
		cartItemDao.insert(cartItem);		
	}

	@Override
	public void update(CartItem cartItem) {
		CartItem oldCartItem=cartItemDao.findOne(cartItem.getCartItemId());
		oldCartItem.setCart(cartItem.getCart());
		oldCartItem.setProduct(cartItem.getProduct());
		oldCartItem.setQuantity(cartItem.getQuantity());
		oldCartItem.setUnitPrice(cartItem.getUnitPrice());
		cartItemDao.update(oldCartItem);
	}

	@Override
	public void delete(String id) {
		cartItemDao.delete(id);		
	}

	@Override
	public CartItem findOne(String id) {
		// TODO Auto-generated method stub
		return cartItemDao.findOne(id);
	}

	@Override
	public List<CartItem> findAll() {
		// TODO Auto-generated method stub
		return cartItemDao.findAll();
	}

	@Override
	public List<CartItem> findAllByUser(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CartItem> findAllByUserId(int id) {
		// TODO Auto-generated method stub
		return cartItemDao.findAllByUserId(id);
	}

	@Override
	public List<CartItem> findAllByUserPaging(int id, int index) {
		// TODO Auto-generated method stub
		return cartItemDao.findAllByUserPaging(id, index);
	}

	@Override
	public int countByUser(int id) {
		// TODO Auto-generated method stub
		return cartItemDao.countByUser(id);
	}

	@Override
	public List<CartItem> findAllSeller(int id) {
		// TODO Auto-generated method stub
		return cartItemDao.findAllSeller(id);
	}

}
