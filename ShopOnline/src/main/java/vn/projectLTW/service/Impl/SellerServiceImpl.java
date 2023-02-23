package vn.projectLTW.service.Impl;

import java.util.List;
import vn.projectLTW.Dao.ISellerDao;
import vn.projectLTW.Dao.Impl.SellerDaoImpl;
import vn.projectLTW.model.Seller;
import vn.projectLTW.service.ISellerService;

public class SellerServiceImpl implements ISellerService {
	ISellerDao sellerDao=new SellerDaoImpl();
	
	@Override
	public void insert(Seller seller) {
		sellerDao.insert(seller);
		
	}

	@Override
	public void update(Seller seller) {
		Seller oldSeller = sellerDao.findOne(seller.getSellerId());
		oldSeller.setSellerName(seller.getSellerName());
		oldSeller.setStatus(seller.getStatus());
		oldSeller.setImages(seller.getImages());
		sellerDao.update(oldSeller);
		
	}

	@Override
	public void delete(int id) {
		sellerDao.delete(id);
		
	}

	@Override
	public Seller findOne(int id) {
		return sellerDao.findOne(id);
	}

	@Override
	public List<Seller> findAll() {
		return sellerDao.findAll();
	}

}
