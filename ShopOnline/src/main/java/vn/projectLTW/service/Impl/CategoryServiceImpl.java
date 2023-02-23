package vn.projectLTW.service.Impl;

import java.util.List;

import vn.projectLTW.Dao.ICategoryDao;
import vn.projectLTW.Dao.Impl.CategoryDaoImpl;
import vn.projectLTW.model.Category;
import vn.projectLTW.service.ICategoryService;

public class CategoryServiceImpl implements ICategoryService {

	ICategoryDao categoryDao=new CategoryDaoImpl();
	
	@Override
	public void insert(Category category) {
		categoryDao.insert(category);
	}

	@Override
	public void update(Category category) {
		Category oldCategory = categoryDao.findOne(category.getCategoryId());
		oldCategory.setCategoryName(category.getCategoryName());
		oldCategory.setStatus(category.getStatus());
		oldCategory.setImages(category.getImages());
		categoryDao.update(oldCategory);
	}

	@Override
	public void delete(int id) {
		categoryDao.delete(id);
	}

	@Override
	public Category findOne(int id) {
		return categoryDao.findOne(id);
	}

	@Override
	public List<Category> findAll() {
		return categoryDao.findAll();
	}

}
