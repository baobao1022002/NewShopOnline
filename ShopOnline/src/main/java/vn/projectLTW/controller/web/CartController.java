package vn.projectLTW.controller.web;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

//import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vn.projectLTW.model.CartItem;
import vn.projectLTW.model.Product;
import vn.projectLTW.service.ICategoryService;
import vn.projectLTW.service.IProductService;
import vn.projectLTW.service.ISellerService;
import vn.projectLTW.service.IUserService;
import vn.projectLTW.service.Impl.CategoryServiceImpl;
import vn.projectLTW.service.Impl.ProductServiceImpl;
import vn.projectLTW.service.Impl.SellerServiceImpl;
import vn.projectLTW.service.Impl.UserServiceImpl;

@WebServlet(urlPatterns = { "/member/cart", "/member/cart/add", "/member/cart/remove" })
public class CartController extends HttpServlet {

	IUserService userService = new UserServiceImpl();
	IProductService productService=new ProductServiceImpl();
	ICategoryService categoryService=new CategoryServiceImpl();
	ISellerService sellerService=new SellerServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		String url=req.getRequestURI().toString();
		if(url.contains("cart/add")) {
			addCart(req,resp);
		}else if(url.contains("cart/remove")) {
			removeItem(req,resp);
		}else {
			listCart(req,resp);

		}
	}
	protected void listCart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher=req.getRequestDispatcher("/views/web/cart-list.jsp");	
		dispatcher.forward(req, resp); 
	}
	protected void addCart(HttpServletRequest req, HttpServletResponse resp) throws IOException ,ServletException{
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		//nhận tham số từ view
		String pId=req.getParameter("pId");
		String quantity=req.getParameter("quantity");
		//truy vấn Product bằng pId
		Product product= productService.findOne(Integer.parseInt(pId));
		
		CartItem cartItem=new CartItem();
		cartItem.setQuantity(Integer.parseInt(quantity));
		cartItem.setUnitPrice(product.getPrice());
		cartItem.setProduct(product);	
		
		//Tạo session
		HttpSession session=req.getSession();
		Object obj=session.getAttribute("cart");
		if(obj==null) {
			Map<Integer, CartItem> map=new HashMap<Integer,CartItem>();
			map.put(cartItem.getProduct().getProductId(), cartItem);
			session.setAttribute("cart", map);
		}else {
			Map<Integer, CartItem> map= extracted(obj);
			CartItem existCartItem=map.get(Integer.valueOf(pId));
			if(existCartItem==null) {
				map.put(product.getProductId(), cartItem);
			}else {
				existCartItem.setQuantity(existCartItem.getQuantity()+Integer.parseInt(quantity));
			}
			session.setAttribute("cart", map);
		}
		resp.sendRedirect(req.getContextPath()+"/member/cart");
	}

	@SuppressWarnings("unchecked")
	private Map<Integer, CartItem> extracted(Object obj) {
		// TODO Auto-generated method stub
		return (Map<Integer, CartItem>) obj;
	}
	protected void removeItem(HttpServletRequest req, HttpServletResponse resp)  throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		//nhận tham số từ view
		String pId=req.getParameter("pId");
		
		HttpSession session=req.getSession();
		Object obj=session.getAttribute("cart");
		if(obj!=null) {
			@SuppressWarnings("unchecked")
			Map<Integer,CartItem> map=extracted(obj);
			map.remove(Integer.parseInt(pId));
			session.setAttribute("cart", map);
		}
			
		resp.sendRedirect(req.getContextPath()+"/member/cart");
		
		
	}

	
}
