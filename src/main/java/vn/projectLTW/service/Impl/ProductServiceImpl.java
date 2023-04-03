package vn.projectLTW.service.Impl;

import java.sql.Date;
import java.util.List;

import vn.projectLTW.Dao.IProductDao;
import vn.projectLTW.Dao.Impl.ProductDaoImpl;
import vn.projectLTW.model.Product;
import vn.projectLTW.service.IProductService;

public class ProductServiceImpl implements IProductService {
	IProductDao productDao=new ProductDaoImpl();
	
	@Override
	public void insert(Product product) {
//		product.setCreateDate(new Date(System.currentTimeMillis()));
		productDao.insert(product);		
	}

	@Override
	public void update(Product product) {
		Product oldProduct=productDao.findOne(product.getProductId());

		oldProduct.setProductCode(product.getProductCode());
		oldProduct.setProductName(product.getProductName());
		oldProduct.setDescription(product.getDescription());
		oldProduct.setImages(product.getImages());
		oldProduct.setPrice(product.getPrice());
		oldProduct.setStoke(product.getStoke());
		oldProduct.setStatus(product.getStatus());
		oldProduct.setCategory(product.getCategory());
		oldProduct.setSeller(product.getSeller());
		
		productDao.update(oldProduct);		
	}

	@Override
	public void delete(int id) {
		productDao.delete(id);		
	}

	@Override
	public Product findOne(int id) {
		return productDao.findOne(id);
	}

	@Override
	public List<Product> findAll() {
		return productDao.findAll();
	}

	@Override
	public List<Product> findAllNews() {
		// TODO Auto-generated method stub
		return productDao.findAllNews();
	}
	public List<Product> findAllTopAmount(){
		return productDao.findAllTopAmount();
	}



	@Override
	public List<Product> findAllByPage(int id) {
		// TODO Auto-generated method stub
		return productDao.findAllByPage(id);
	}

	@Override
	public int countAll() {
		// TODO Auto-generated method stub
		return productDao.countAll();
	}

	@Override
	public List<Product> findAllByCID(int id, int index) {
		// TODO Auto-generated method stub
		return productDao.findAllByCID(id, index);
	}

	@Override
	public List<Product> findAllBySeller(int id, int index) {
		// TODO Auto-generated method stub
		return productDao.findAllBySeller(id, index);
	}

	@Override
	public int countCID(int id) {
		// TODO Auto-generated method stub
		return productDao.countCID(id);
	}

	@Override
	public int countSell(int id) {
		// TODO Auto-generated method stub
		return productDao.countSell(id);
	}



}
