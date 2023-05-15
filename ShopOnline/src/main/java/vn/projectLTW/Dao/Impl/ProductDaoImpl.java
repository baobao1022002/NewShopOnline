package vn.projectLTW.Dao.Impl;

import vn.projectLTW.Dao.DBConnection;
import vn.projectLTW.Dao.IProductDao;
import vn.projectLTW.model.Category;
import vn.projectLTW.model.Product;
import vn.projectLTW.model.Seller;
import vn.projectLTW.service.ICategoryService;
import vn.projectLTW.service.ISellerService;
import vn.projectLTW.service.Impl.CategoryServiceImpl;
import vn.projectLTW.service.Impl.SellerServiceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements IProductDao {
	public Connection conn = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;
	ISellerService sellerService=new SellerServiceImpl();
	ICategoryService categoryService= new CategoryServiceImpl();
	@Override
	public void insert(Product product) {
		String sql = "INSERT INTO product(productName,productCode,categoryId,description,price,stoke,images,image2,image3,image4,image5,status,createDate,sellerId)\r\n"
				+ "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
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
			ps.setString(8, product.getImage2());
			ps.setString(9, product.getImage3());
			ps.setString(10, product.getImage4());
			ps.setString(11, product.getImage5());
			ps.setInt(12, product.getStatus());
			ps.setDate(13, product.getCreateDate());
			ps.setInt(14, product.getSeller().getSellerId());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	@Override
	public void update(Product product) {
		String sql = "UPDATE product SET productName=?,productCode=?,categoryId=?,description=?,price=?,stoke=?,images=?,image2=?,image3=?,image4=?,image5=?,status=?,createDate=?,sellerId=? WHERE productId=?";
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
			ps.setString(8, product.getImage2());
			ps.setString(9, product.getImage3());
			ps.setString(10, product.getImage4());
			ps.setString(11, product.getImage5());
			ps.setInt(12, product.getStatus());
			ps.setDate(13, product.getCreateDate());
			ps.setInt(14, product.getSeller().getSellerId());
			ps.setInt(15, product.getProductId());
			ps.executeUpdate();

		} catch (Exception e) {

		}

	}
	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM Product where productId=?";
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
		String sql="SELECT product.productId,product.productName,product.productCode,product.description,product.amount,\r\n"
				+ "		product.price,product.images,product.image2,product.image3,product.image4,product.image5,product.createDate,product.stoke,product.wishList,product.status,\r\n"
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
				product.setImage2(rs.getString("image2"));
				product.setImage3(rs.getString("image3"));
				product.setImage4(rs.getString("image4"));
				product.setImage5(rs.getString("image5"));
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
		String sql="SELECT product.productId,product.productName,product.productCode,product.description,product.amount,\n" +
				"\t\t\t\tproduct.price,product.images,product.image2,product.image3,product.image4,product.image5,product.createDate,product.stoke,product.wishList,product.status,\n" +
				"\t\t\t\tcategory.categoryId,category.categoryName,seller.sellerId,seller.images AS sellerAvatar,seller.sellerName\n" +
				"\t\t\t\tFROM product INNER JOIN category ON product.categoryId=category.categoryId\n" +
				"\t\t\t\tINNER JOIN seller ON product.sellerId=seller.sellerId";
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
				product.setImage2(rs.getString("image2"));
				product.setImage3(rs.getString("image3"));
				product.setImage4(rs.getString("image4"));
				product.setImage5(rs.getString("image5"));
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
				+ "		product.price,product.images,product.image2,product.image3,product.image4,product.image5,product.createDate,product.stoke,product.wishList,product.status,\r\n"
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
				product.setImage2(rs.getString("image2"));
				product.setImage3(rs.getString("image3"));
				product.setImage4(rs.getString("image4"));
				product.setImage5(rs.getString("image5"));
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
				+ "		product.price,product.images,product.image2,product.image3,product.image4,product.image5,product.createDate,product.stoke,product.wishList,product.status,\r\n"
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
				product.setImage2(rs.getString("image2"));
				product.setImage3(rs.getString("image3"));
				product.setImage4(rs.getString("image4"));
				product.setImage5(rs.getString("image5"));
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
				+ "		product.price,product.images,product.image2,product.image3,product.image4,product.image5,product.createDate,product.stoke,product.wishList,product.status,\r\n"
				+ "		category.categoryId,category.categoryName,seller.sellerId,seller.images AS sellerAvatar,seller.sellerName\r\n"
				+ "FROM product INNER JOIN category ON product.categoryId=category.categoryId\r\n"
				+ "			INNER JOIN seller ON product.sellerId=seller.sellerId\r\n"
				+ "WHERE category.categoryId=? ORDER BY productId DESC LIMIT 3 OFFSET ? ";
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
				product.setImage2(rs.getString("image2"));
				product.setImage3(rs.getString("image3"));
				product.setImage4(rs.getString("image4"));
				product.setImage5(rs.getString("image5"));
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
				+ "		product.price,product.images,product.image2,product.image3,product.image4,product.image5,product.createDate,product.stoke,product.wishList,product.status,\r\n"
				+ "		category.categoryId,category.categoryName,seller.sellerId,seller.images AS sellerAvatar,seller.sellerName\r\n"
				+ "FROM product INNER JOIN category ON product.categoryId=category.categoryId\r\n"
				+ "			INNER JOIN seller ON product.sellerId=seller.sellerId\r\n"
				+ "WHERE seller.sellerId=? ORDER BY productId DESC LIMIT 3 OFFSET ?";
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
				product.setImage2(rs.getString("image2"));
				product.setImage3(rs.getString("image3"));
				product.setImage4(rs.getString("image4"));
				product.setImage5(rs.getString("image5"));
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
				+ "		product.price,product.images,product.image2,product.image3,product.image4,product.image5,product.createDate,product.stoke,product.wishList,product.status,\r\n"
				+ "		category.categoryId,category.categoryName,seller.sellerId,seller.images AS sellerAvatar,seller.sellerName\r\n"
				+ "FROM product INNER JOIN category ON product.categoryId=category.categoryId\r\n"
				+ "			INNER JOIN seller ON product.sellerId=seller.sellerId\r\n"
				+ "ORDER BY product.productId DESC LIMIT 3 OFFSET ?";
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
				product.setImage2(rs.getString("image2"));
				product.setImage3(rs.getString("image3"));
				product.setImage4(rs.getString("image4"));
				product.setImage5(rs.getString("image5"));
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


	@Override
	public List<Product> SearchByName(String txtSearch) {

		List<Product> productList = new ArrayList<Product>();
		String sql = "SELECT * FROM product WHERE productName LIKE ?";
		try {

			conn = new DBConnection().getConnection(); // Kết nối CSDL
			ps = conn.prepareStatement(sql); // Ném câu lệnh SQL bằng phát biểu prepareStatement
			ps.setString(1,  '%'+ txtSearch +'%');		// đưa tham số vào ?
			rs = ps.executeQuery(); // Thực thi câu query và trả về ResultSet

			while (rs.next()) {
//
				Product product = new Product();
				product.setProductId(rs.getInt("productId"));
				product.setProductCode(rs.getLong("productCode"));
				product.setProductName(rs.getString("productName"));
				product.setAmount(rs.getInt("amount"));
				product.setDescription(rs.getString("description"));
				product.setImages(rs.getString("images"));
				product.setImage2(rs.getString("image2"));
				product.setImage3(rs.getString("image3"));
				product.setImage4(rs.getString("image4"));
				product.setImage5(rs.getString("image5"));
				product.setPrice(rs.getDouble("price"));
				product.setStoke(rs.getInt("stoke"));
				product.setWishList(rs.getInt("wishList"));
				product.setStatus(rs.getInt("status"));
				product.setCreateDate(rs.getDate("createDate"));

				productList.add(product);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return productList;

	}

}
