package vn.projectLTW.controller.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.projectLTW.model.Category;
import vn.projectLTW.model.Product;
import vn.projectLTW.model.Seller;
import vn.projectLTW.service.ICategoryService;
import vn.projectLTW.service.IProductService;
import vn.projectLTW.service.ISellerService;
import vn.projectLTW.service.IUserService;
import vn.projectLTW.service.Impl.CategoryServiceImpl;
import vn.projectLTW.service.Impl.ProductServiceImpl;
import vn.projectLTW.service.Impl.SellerServiceImpl;
import vn.projectLTW.service.Impl.UserServiceImpl;

//"product/detail"
@WebServlet(urlPatterns = { "/product/list","/product/loadAjax","/product/detail"	})
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 5889168824989045500L;

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
//		else if (url.contains("product/loadAjax")) {
//			productLoadAjax(req, resp);
//		}
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
//		if(categoryId==null) {
//			categoryId="0";
//		}
//		if(sellerId==null) {
//			sellerId= "0";
//		}
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
			List<Product> productListNew=productService.findAllByPage(indexp-1);
			req.setAttribute("productListNew", productListNew);
			req.setAttribute("countproductAll", countP);
			
		}else if(Integer.parseInt(categoryId)!=0&&Integer.parseInt(sellerId)==0){
			List<Product> productListNew=productService.findAllByCID(Integer.parseInt(categoryId),indexp-1);
			req.setAttribute("productListNew", productListNew);
			req.setAttribute("countproductAll", countCid);
		}else if(Integer.parseInt(categoryId)==0&&Integer.parseInt(sellerId)!=0){
			List<Product> productListNew=productService.findAllBySeller(Integer.parseInt(sellerId),indexp-1);
			req.setAttribute("productListNew", productListNew);
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
	
//	protected void productLoadAjax(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//		String amount=req.getParameter("exits");
//		int imount = Integer.parseInt(amount);
//		List<Product> productListNew = productService.findAllByPage(imount);
//		
//		PrintWriter out=resp.getWriter();
//		for (Product p : productListNew) {
//			out.println("	<!-- PRODUCT ITEM START -->\r\n"
//					+ "				 <div class=\"product col-md-4 col-sm-6 col-xs-12\">\r\n"
//					+ "					<div class=\"product-item\">\r\n"
//					+ "						<div class=\"pi-img-wrapper\">\r\n"
//					+ "							<img src=\"/ShopOnline/image?fname=products/"+p.getImages()+"\"></c:url>\"\r\n"
//					+ "								class=\"img-responsive\" alt=\"${proList.productName}\">\r\n"
//					+ "							<div>\r\n"
//					+ "								<a href=\"<c:url value=\"/image?fname=products/${proList.images}\"></c:url>\"\r\n"
//					+ "									class=\"btn btn-default fancybox-button\">Zoom</a> \r\n"
//					+ "								<a href=\"#product-pop-up${proList.productId}\" class=\"btn btn-default fancybox-fast-view\">View</a>\r\n"
//					+ "							</div>\r\n"
//					+ "						</div>\r\n"
//					+ "						<h3>\r\n"
//					+ "							<a href=\"<c:url value=\"/product/detail?productId=${proList.productId}\"></c:url>\">${proList.productName}\"</a>\r\n"
//					+ "						</h3>\r\n"
//					+ "						<div class=\"pi-price\">$ ${proList.price}\"</div>\r\n"
//					+ "						<a href=\"#\" class=\"btn btn-default add2cart\">Add to cart</a>\r\n"
//					+ "					</div>\r\n"
//					+ "				</div> \r\n"
//					+ "				<!-- PRODUCT ITEM END -->\r\n"
//					+ "				\r\n"
//					+ "				   	<!-- BEGIN fast view of a product -->\r\n"
//					+ "						<div id=\"product-pop-up${proList.productId}\" style=\"display: none; width: 700px;\">\r\n"
//					+ "							<div class=\"product-page product-pop-up${proList.productId}\">\r\n"
//					+ "								<div class=\"row\">\r\n"
//					+ "									<div class=\"col-md-6 col-sm-6 col-xs-3\">\r\n"
//					+ "										<div class=\"product-main-image\">\r\n"
//					+ "											<img src=\"<c:url value=\"/image?fname=products/${proList.images }\"></c:url>\"\r\n"
//					+ "												alt=\"Cool green dress with red bell 45\" class=\"img-responsive\">\r\n"
//					+ "										</div>\r\n"
//					+ "										<div class=\"product-other-images\">\r\n"
//					+ "											<a href=\"<c:url value=\"/image?fname=products/${proList.images }\"></c:url>\" class=\"active\"><img alt=\"Berry Lace Dress\"\r\n"
//					+ "												src=\"<c:url value=\"/image?fname=products/${proList.images }\"></c:url>\"></a>\r\n"
//					+ "											<a href=\"<c:url value=\"/image?fname=products/${proList.images }\"></c:url>\"\r\n"
//					+ "												src=\"<c:url value=\"/image?fname=products/${proList.images }\"></c:url>\"></a>\r\n"
//					+ "											<a href=\"<c:url value=\"/image?fname=products/${proList.images }\"></c:url>\"><img alt=\"Berry Lace Dress\"\r\n"
//					+ "												src=\"<c:url value=\"/image?fname=products/${proList.images }\"></c:url>\"></a>\r\n"
//					+ "										</div>\r\n"
//					+ "									</div>\r\n"
//					+ "									<div class=\"col-md-6 col-sm-6 col-xs-9\">\r\n"
//					+ "										<h2>${proList.productName}</h2>\r\n"
//					+ "										<div class=\"price-availability-block clearfix\">\r\n"
//					+ "											<div class=\"price\">\r\n"
//					+ "												<strong><span>$</span>${proList.price }</strong> <em>$<span>${proList.price/0.8 }</span></em>\r\n"
//					+ "											</div>\r\n"
//					+ "												<div class=\"availability\">\r\n"
//					+ "												Số lượng tồn: <strong>${proList.stoke}</strong>\r\n"
//					+ "											</div>\r\n"
//					+ "										</div>\r\n"
//					+ "										<div class=\"description\">\r\n"
//					+ "											<p>${proList.description }</p>\r\n"
//					+ "										</div>\r\n"
//					+ "										<div class=\"product-page-options\">\r\n"
//					+ "											<div class=\"pull-left\">\r\n"
//					+ "												<label class=\"control-label\">Size:</label> <select\r\n"
//					+ "													class=\"form-control input-sm\">\r\n"
//					+ "													<option>L</option>\r\n"
//					+ "													<option>M</option>\r\n"
//					+ "													<option>XL</option>\r\n"
//					+ "												</select>\r\n"
//					+ "											</div>\r\n"
//					+ "											<div class=\"pull-left\">\r\n"
//					+ "												<label class=\"control-label\">Color:</label> <select\r\n"
//					+ "													class=\"form-control input-sm\">\r\n"
//					+ "													<option>Red</option>\r\n"
//					+ "													<option>Blue</option>\r\n"
//					+ "													<option>Black</option>\r\n"
//					+ "												</select>\r\n"
//					+ "											</div>\r\n"
//					+ "										</div>\r\n"
//					+ "										<div class=\"product-page-cart\">\r\n"
//					+ "											<div class=\"product-quantity\">\r\n"
//					+ "												<input id=\"product-quantity\" type=\"text\" value=\"1\" readonly\r\n"
//					+ "													name=\"product-quantity\" class=\"form-control input-sm\">\r\n"
//					+ "											</div>\r\n"
//					+ "											<button class=\"btn btn-primary\" type=\"submit\">Cho vào giỏ hàng</button>\r\n"
//					+ "											<a href=\"<c:url value=\"/product/detail?productId=${proList.productId }\"></c:url>\" class=\"btn btn-default\">Xem chi tiết</a>\r\n"
//					+ "										</div>\r\n"
//					+ "									</div>\r\n"
//					+ "\r\n"
//					+ "									<div class=\"sticker sticker-sale\"></div>\r\n"
//					+ "								</div>\r\n"
//					+ "							</div>\r\n"
//					+ "						</div>\r\n"
//					+ "						<!-- END fast view of a product -->");
//		}
//	}

}
