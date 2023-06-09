package vn.projectLTW.controller.web;

import vn.projectLTW.model.Category;
import vn.projectLTW.model.Product;
import vn.projectLTW.model.Seller;
import vn.projectLTW.service.ICategoryService;
import vn.projectLTW.service.IProductService;
import vn.projectLTW.service.ISellerService;
import vn.projectLTW.service.Impl.CategoryServiceImpl;
import vn.projectLTW.service.Impl.ProductServiceImpl;
import vn.projectLTW.service.Impl.SellerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

//"product/detail"
@WebServlet(urlPatterns = { "/product/list","/product/loadAjax","/product/detail"	})
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 5889168824989045500L;
	static final Logger LOGGER= Logger.getLogger(HomeController.class.getName());
	String name= "AUTH";

	IProductService productService = new ProductServiceImpl();
	ICategoryService categoryService = new CategoryServiceImpl();
	ISellerService sellerService=new SellerServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI().toString();
		if (url.contains("product/list")) {
			productPage(req, resp);
		} else if (url.contains("product/detail")) {
			productDetail(req, resp);
		}

	}



	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

	protected void productDetail(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String productId = req.getParameter("productId");

		Product product = productService.findOne(Integer.parseInt(productId));
		req.setAttribute("product", product);

		List<Category> categoryList = categoryService.findAll();
		req.setAttribute("categoryList", categoryList);
		req.getRequestDispatcher("/views/web/product-detail.jsp").forward(req, resp);

	}

	protected void productPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String categoryId=req.getParameter("categoryId");
		String sellerId=req.getParameter("sellerId");
		
		String indexPage=req.getParameter("index");
		
		//phân trang
		if(indexPage==null) {
			indexPage="1";
		}

		int indexp=Integer.parseInt(indexPage);
		
		//Get Data từ DAO
		int countP=productService.countAll();
		int countCid=productService.countCID(Integer.parseInt(categoryId));
		int countSid=productService.countSell(Integer.parseInt(sellerId));
		
		//chia trang cho count
		int endPage=countP/3;
		if(countP%3!=0) {
			endPage++;
		}
		
		if(Integer.parseInt(categoryId)==0&&Integer.parseInt(sellerId)==0) {
			List<Product> productList =productService.findAllByPage(indexp-1);
			req.setAttribute("productList", productList);
			req.setAttribute("countproductAll", countP);
			
		}else if(Integer.parseInt(categoryId)!=0&&Integer.parseInt(sellerId)==0){
			List<Product> productList=productService.findAllByCID(Integer.parseInt(categoryId),indexp-1);
			req.setAttribute("productList", productList);
			req.setAttribute("countproductAll", countCid);
		}else if(Integer.parseInt(categoryId)==0&&Integer.parseInt(sellerId)!=0){
			List<Product> productList=productService.findAllBySeller(Integer.parseInt(sellerId),indexp-1);
			req.setAttribute("productList", productList);
			req.setAttribute("countproductAll", countSid);

		}
		
		
		//Lấy dữ liệu và đẩy lên view
		List<Category> categoryList=categoryService.findAll();
		req.setAttribute("categoryList", categoryList);
		
		List<Seller> sellerList=sellerService.findAll();
		req.setAttribute("sellerList", sellerList);
		
		//truyền lên JSP
		req.setAttribute("endP", endPage);
		req.setAttribute("tag", indexp);
		req.setAttribute("categoryId", categoryId);
		req.setAttribute("sellerId", sellerId);
		
		
		req.getRequestDispatcher("/views/web/product-list.jsp").forward(req, resp);
		
	}


}
