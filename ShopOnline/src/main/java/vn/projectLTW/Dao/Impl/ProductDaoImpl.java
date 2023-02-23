package vn.projectLTW.Dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import vn.projectLTW.Dao.DBConnection;
import vn.projectLTW.Dao.IProductDao;
import vn.projectLTW.model.Category;
import vn.projectLTW.model.Product;
import vn.projectLTW.model.Seller;
import vn.projectLTW.service.ICategoryService;
import vn.projectLTW.service.ISellerService;
import vn.projectLTW.service.Impl.CategoryServiceImpl;
import vn.projectLTW.service.Impl.SellerServiceImpl;

public class ProductDaoImpl implements IProductDao {
	public Connection conn = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;
	ISellerService sellerService=new SellerServiceImpl();
	ICategoryService categoryService= new CategoryServiceImpl();
	@Override
	public void insert(Product product) {
		String sql = "INSERT INTO product(productName,productCode,categoryId,description,price,stoke,images,status,createDate,sellerId)\r\n"
				+ "VALUES(?,?,?,?,?,?,?,?,?,?)";
		try {
			conn = new DBConnection().getConnection(); // Kết nối CSDL
			ps = conn.prepareStatement(sql); // Ném câu lệnh SQL bằng phát biểu prepareStatement
			ps.setString(1, product.getProductName());
			ps.setLong(2, product.getProductCode());
			ps.setInt(3, product.getCategory().getCategoryId());
			ps.setString(4, product.getDescription());
			ps.setDouble(5, product.getPrice());
			ps.setInt(6, product.getStoke());
			ps.setString(7, product.getImages());
			ps.setInt(8, product.getStatus());
			ps.setDate(9, product.getCreateDate());
			ps.setInt(10, product.getSeller().getSellerId());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	@Override
	public void update(Product product) {
		String sql = "UPDATE product SET productName=?,productCode=?,categoryId=?,description=?,price=?,stoke=?,images=?,status=?,createDate=?,sellerId=? WHERE productId=?";
		try {
			conn = new DBConnection().getConnection(); // Kết nối CSDL
			ps = conn.prepareStatement(sql); // Ném câu lệnh SQL bằng phát biểu prepareStatement
			ps.setString(1, product.getProductName());
			ps.setLong(2, product.getProductCode());
			ps.setInt(3, product.getCategory().getCategoryId());
			ps.setString(4, product.getDescription());
			ps.setDouble(5, product.getPrice());
			ps.setInt(6, product.getStoke());
			ps.setString(7, product.getImages());
			ps.setInt(8, product.getStatus());
			ps.setDate(9, product.getCreateDate());
			ps.setInt(10, product.getSeller().getSellerId());
			ps.setInt(11, product.getProductId());
			ps.executeUpdate();

		} catch (Exception e) {
			
		}
		
	}
	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM product where productId=?";
		try {
			conn = new DBConnection().getConnection(); // Kết nối CSDL
			ps = conn.prepareStatement(sql); // Ném câu lệnh SQL bằng phát biểu prepareStatement
			ps.setInt(1, id);
			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	@Override
	public Product findOne(int id) {
		String sql="  SELECT product.productId,product.productName,product.productCode,product.description,product.amount,\r\n"
				+ "		product.price,product.images,product.createDate,product.stoke,product.wishList,product.status,\r\n"
				+ "		category.categoryId,category.categoryName,seller.sellerId,seller.images AS sellerAvatar,seller.sellerName\r\n"
				+ "	FROM product INNER JOIN category ON product.categoryId=category.categoryId\r\n"
				+ "				 INNER JOIN seller ON product.sellerId=seller.sellerId\r\n"
				+ "	WHERE productId=?";
		try {
			conn = new DBConnection().getConnection(); // Kết nối CSDL
			ps = conn.prepareStatement(sql); // Ném câu lệnh SQL bằng phát biểu prepareStatement
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while(rs.next()) {
				Category category=categoryService.findOne(rs.getInt("categoryId"));
				Seller seller=sellerService.findOne(rs.getInt("sellerId"));
				Product product=new Product();
				product.setProductId(rs.getInt("productId"));
				product.setProductCode(rs.getLong("productCode"));
				product.setProductName(rs.getString("productName"));
				product.setAmount(rs.getInt("amount"));
				product.setDescription(rs.getString("description"));
				product.setImages(rs.getString("images"));
				product.setPrice(rs.getDouble("price"));
				product.setStoke(rs.getInt("stoke"));
				product.setWishList(rs.getInt("wishList"));
				product.setStatus(rs.getInt("status"));
				product.setCreateDate(rs.getDate("createDate"));
				product.setCategory(category);
				product.setSeller(seller);
				return product;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public List<Product> findAll() {
		List<Product> productList=new ArrayList<Product>();
		String sql="SELECT Product.productId,Product.productName,Product.productCode,Product.description,Product.amount,\r\n"
				+ "		Product.price,Product.images,Product.createDate,Product.stoke,Product.wishList,Product.status,\r\n"
				+ "		category.categoryId,category.categoryName,seller.sellerId,seller.images AS sellerAvatar,seller.sellerName\r\n"
				+ "	FROM Product INNER JOIN category ON Product.categoryId=category.categoryId\r\n"
				+ "				 INNER JOIN seller ON Product.sellerId=seller.sellerId";
		try {
			conn = new DBConnection().getConnection(); // Kết nối CSDL
			ps = conn.prepareStatement(sql); // Ném câu lệnh SQL bằng phát biểu prepareStatement
			rs = ps.executeQuery();
			while(rs.next()) {
				Category category=categoryService.findOne(rs.getInt("categoryId"));
				Seller seller=sellerService.findOne(rs.getInt("sellerId"));
				Product product=new Product();
				product.setProductId(rs.getInt("productId"));
				product.setProductCode(rs.getLong("productCode"));
				product.setProductName(rs.getString("productName"));
				product.setAmount(rs.getInt("amount"));
				product.setDescription(rs.getString("description"));
				product.setImages(rs.getString("images"));
				product.setPrice(rs.getDouble("price"));
				product.setStoke(rs.getInt("stoke"));
				product.setWishList(rs.getInt("wishList"));
				product.setStatus(rs.getInt("status"));
				product.setCreateDate(rs.getDate("createDate"));
				product.setCategory(category);
				product.setSeller(seller);
				productList.add(product);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return productList;
	}


	@Override
	public List<Product> findAllNews() {
		List<Product> productList=new ArrayList<Product>();
		String sql="SELECT product.productId,product.productName,product.productCode,product.description,product.amount,\r\n"
				+ "		product.price,product.images,product.createDate,product.stoke,product.wishList,product.status,\r\n"
				+ "		category.categoryId,category.categoryName,seller.sellerId,seller.images AS sellerAvatar,seller.sellerName\r\n"
				+ "FROM product INNER JOIN category ON product.categoryId=category.categoryId\r\n"
				+ "			INNER JOIN seller ON product.sellerId=seller.sellerId\r\n"
				+ "ORDER BY productId DESC";
		try {
			conn = new DBConnection().getConnection(); // Kết nối CSDL
			ps = conn.prepareStatement(sql); // Ném câu lệnh SQL bằng phát biểu prepareStatement
			rs = ps.executeQuery();
			while(rs.next()) {
				Category category=categoryService.findOne(rs.getInt("categoryId"));
				Seller seller=sellerService.findOne(rs.getInt("sellerId"));
				Product product=new Product();
				product.setProductId(rs.getInt("productId"));
				product.setProductCode(rs.getLong("productCode"));
				product.setProductName(rs.getString("productName"));
				product.setAmount(rs.getInt("amount"));
				product.setDescription(rs.getString("description"));
				product.setImages(rs.getString("images"));
				product.setPrice(rs.getDouble("price"));
				product.setStoke(rs.getInt("stoke"));
				product.setWishList(rs.getInt("wishList"));
				product.setStatus(rs.getInt("status"));
				product.setCreateDate(rs.getDate("createDate"));
				product.setCategory(category);
				product.setSeller(seller);
				productList.add(product);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return productList;
	}


	@Override
	public List<Product> findAllTopAmount() {
		// TODO Auto-generated method stub
		List<Product> productList=new ArrayList<Product>();
		String sql="SELECT product.productId,product.productName,product.productCode,product.description,product.amount,\r\n"
				+ "		product.price,product.images,product.createDate,product.stoke,product.wishList,product.status,\r\n"
				+ "		category.categoryId,category.categoryName,seller.sellerId,seller.images AS sellerAvatar,seller.sellerName\r\n"
				+ "FROM product INNER JOIN category ON product.categoryId=category.categoryId\r\n"
				+ "			INNER JOIN seller ON product.sellerId=seller.sellerId\r\n"
				+ "ORDER BY amount DESC";
		try {
			conn = new DBConnection().getConnection(); // Kết nối CSDL
			ps = conn.prepareStatement(sql); // Ném câu lệnh SQL bằng phát biểu prepareStatement
			rs = ps.executeQuery();
			while(rs.next()) {
				Category category=categoryService.findOne(rs.getInt("categoryId"));
				Seller seller=sellerService.findOne(rs.getInt("sellerId"));
				Product product=new Product();
				product.setProductId(rs.getInt("productId"));
				product.setProductCode(rs.getLong("productCode"));
				product.setProductName(rs.getString("productName"));
				product.setAmount(rs.getInt("amount"));
				product.setDescription(rs.getString("description"));
				product.setImages(rs.getString("images"));
				product.setPrice(rs.getDouble("price"));
				product.setStoke(rs.getInt("stoke"));
				product.setWishList(rs.getInt("wishList"));
				product.setStatus(rs.getInt("status"));
				product.setCreateDate(rs.getDate("createDate"));
				product.setCategory(category);
				product.setSeller(seller);
				productList.add(product);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return productList;
	}


	@Override
	public List<Product> findAllByCID(int id,int index) {
		List<Product> productList=new ArrayList<Product>();
		String sql="SELECT product.productId,product.productName,product.productCode,product.description,product.amount,\r\n"
				+ "		product.price,product.images,product.createDate,product.stoke,product.wishList,product.status,\r\n"
				+ "		category.categoryId,category.categoryName,seller.sellerId,seller.images AS sellerAvatar,seller.sellerName\r\n"
				+ "FROM product INNER JOIN category ON product.categoryId=category.categoryId\r\n"
				+ "			INNER JOIN seller ON product.sellerId=seller.sellerId\r\n"
				+ "WHERE Category.categoryId=? ORDER BY productId DESC OFFSET ? ROWS FETCH NEXT 3 ROWS ONLY";
		try {
			conn = new DBConnection().getConnection(); // Kết nối CSDL
			ps = conn.prepareStatement(sql); // Ném câu lệnh SQL bằng phát biểu prepareStatement
			ps.setInt(1, id);
			ps.setInt(2, index);
			rs = ps.executeQuery();
			while(rs.next()) {
				Category category=categoryService.findOne(rs.getInt("categoryId"));
				Seller seller=sellerService.findOne(rs.getInt("sellerId"));
				Product product=new Product();
				product.setProductId(rs.getInt("productId"));
				product.setProductCode(rs.getLong("productCode"));
				product.setProductName(rs.getString("productName"));
				product.setAmount(rs.getInt("amount"));
				product.setDescription(rs.getString("description"));
				product.setImages(rs.getString("images"));
				product.setPrice(rs.getDouble("price"));
				product.setStoke(rs.getInt("stoke"));
				product.setWishList(rs.getInt("wishList"));
				product.setStatus(rs.getInt("status"));
				product.setCreateDate(rs.getDate("createDate"));
				product.setCategory(category);
				product.setSeller(seller);
				productList.add(product);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return productList;
	}


	@Override
	public List<Product> findAllBySeller(int id,int index) {
		// TODO Auto-generated method stub
		List<Product> productList=new ArrayList<Product>();
		String sql="SELECT product.productId,product.productName,product.productCode,product.description,product.amount,\r\n"
				+ "		product.price,product.images,product.createDate,product.stoke,product.wishList,product.status,\r\n"
				+ "		category.categoryId,category.categoryName,seller.sellerId,seller.images AS sellerAvatar,seller.sellerName\r\n"
				+ "FROM product INNER JOIN category ON product.categoryId=category.categoryId\r\n"
				+ "			INNER JOIN seller ON product.sellerId=seller.sellerId\r\n"
				+ "WHERE Seller.sellerId=? ORDER BY productId DESC OFFSET ? ROWS FETCH NEXT 3 ROWS ONLY";
		try {
			conn = new DBConnection().getConnection(); // Kết nối CSDL
			ps = conn.prepareStatement(sql); // Ném câu lệnh SQL bằng phát biểu prepareStatement
			ps.setInt(1, id);
			ps.setInt(2, index);
			rs = ps.executeQuery();
			while(rs.next()) {
				Category category=categoryService.findOne(rs.getInt("categoryId"));
				Seller seller=sellerService.findOne(rs.getInt("sellerId"));
				Product product=new Product();
				product.setProductId(rs.getInt("productId"));
				product.setProductCode(rs.getLong("productCode"));
				product.setProductName(rs.getString("productName"));
				product.setAmount(rs.getInt("amount"));
				product.setDescription(rs.getString("description"));
				product.setImages(rs.getString("images"));
				product.setPrice(rs.getDouble("price"));
				product.setStoke(rs.getInt("stoke"));
				product.setWishList(rs.getInt("wishList"));
				product.setStatus(rs.getInt("status"));
				product.setCreateDate(rs.getDate("createDate"));
				product.setCategory(category);
				product.setSeller(seller);
				productList.add(product);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return productList;
	}


	@Override
	public List<Product> findAllByPage(int id) {
		// TODO Auto-generated method stub
		List<Product> productList=new ArrayList<Product>();
		String sql="SELECT product.productId,product.productName,product.productCode,product.description,product.amount,\r\n"
				+ "		product.price,product.images,product.createDate,product.stoke,product.wishList,product.status,\r\n"
				+ "		category.categoryId,category.categoryName,seller.sellerId,seller.images AS sellerAvatar,seller.sellerName\r\n"
				+ "FROM product INNER JOIN category ON product.categoryId=category.categoryId\r\n"
				+ "			INNER JOIN seller ON product.sellerId=seller.sellerId\r\n"
				+ "ORDER BY product.productId DESC OFFSET ? ROWS FETCH NEXT 3 ROWS ONLY";
		try {
			conn = new DBConnection().getConnection(); // Kết nối CSDL
			ps = conn.prepareStatement(sql); // Ném câu lệnh SQL bằng phát biểu prepareStatement
			ps.setInt(1, id);
			
			rs = ps.executeQuery();
			while(rs.next()) {
				Category category=categoryService.findOne(rs.getInt("categoryId"));
				Seller seller=sellerService.findOne(rs.getInt("sellerId"));
				Product product=new Product();
				product.setProductId(rs.getInt("productId"));
				product.setProductCode(rs.getLong("productCode"));
				product.setProductName(rs.getString("productName"));
				product.setAmount(rs.getInt("amount"));
				product.setDescription(rs.getString("description"));
				product.setImages(rs.getString("images"));
				product.setPrice(rs.getDouble("price"));
				product.setStoke(rs.getInt("stoke"));
				product.setWishList(rs.getInt("wishList"));
				product.setStatus(rs.getInt("status"));
				product.setCreateDate(rs.getDate("createDate"));
				product.setCategory(category);
				product.setSeller(seller);
				productList.add(product);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return productList;
	}



	@Override
	public int countAll() {
		String sql="select count(*) from product";
		try {
			conn = new DBConnection().getConnection(); // Kết nối CSDL
			ps = conn.prepareStatement(sql); // Ném câu lệnh SQL bằng phát biểu prepareStatement
			rs = ps.executeQuery();
			while(rs.next()) {
				return rs.getInt(1);
			}
		}catch(Exception e) {
			
		}
		return 0;
	}


	@Override
	public int countCID(int id) {
		String sql="select count(*) from product where categoryId=?";
		try {
			conn = new DBConnection().getConnection(); // Kết nối CSDL
			ps = conn.prepareStatement(sql); // Ném câu lệnh SQL bằng phát biểu prepareStatement
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while(rs.next()) {
				return rs.getInt(1);
			}
		}catch(Exception e) {
			
		}
		return 0;
	}


	@Override
	public int countSell(int id) {
		String sql="select count(*) from product where sellerId=?";
		try {
			conn = new DBConnection().getConnection(); // Kết nối CSDL
			ps = conn.prepareStatement(sql); // Ném câu lệnh SQL bằng phát biểu prepareStatement
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while(rs.next()) {
				return rs.getInt(1);
			}
		}catch(Exception e) {
			
		}
		return 0;		
	}


	
}
