package vn.projectLTW.controller.web;

import vn.projectLTW.model.CartItem;
import vn.projectLTW.model.Log;
import vn.projectLTW.model.Product;
import vn.projectLTW.service.*;
import vn.projectLTW.service.Impl.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

@WebServlet(urlPatterns = { "/member/cart", "/member/cart/add", "/member/cart/remove","/member/cart/updateQuantity" })
public class CartController extends HttpServlet {
	static final Logger LOGGER= Logger.getLogger(HomeController.class.getName());
	String name= "AUTH";

	IUserService userService = new UserServiceImpl();
	IProductService productService=new ProductServiceImpl();
	ICategoryService categoryService=new CategoryServiceImpl();
	ISellerService sellerService=new SellerServiceImpl();
	ILogService logService=new LogServiceImpl();
	
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
		}else if(url.contains("cart/updateQuantity"))
			updateQuantity(req,resp);
		else {
			listCart(req,resp);

		}
	}

	protected void updateQuantity(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
		//Nhận tham số từ View
		String pId = req.getParameter("pId");
		String quantity=req.getParameter("quantity");
		//truy vấn product bằng pId
		Product product=productService.findOne(Integer.parseInt(pId));

		CartItem cartItem=new CartItem();
		cartItem.setQuantity(Integer.parseInt(quantity));
		cartItem.setUnitPrice(product.getPrice());
		cartItem.setProduct(product);

		//tạo session
		HttpSession session=req.getSession();
		Object obj=session.getAttribute("cart");
		if(obj==null){
			Map<Integer,CartItem> map=new HashMap<Integer,CartItem>();
			map.put(cartItem.getProduct().getProductId(),cartItem);
			session.setAttribute("cart",map);
		}else{
			Map<Integer,CartItem> map=extracted(obj);
			CartItem existCartItems=map.get(Integer.valueOf(pId));
			if(existCartItems==null){
				map.put(product.getProductId(),cartItem);
			}else{
				existCartItems.setQuantity(Integer.parseInt(quantity));
			}
			session.setAttribute("cart",map);
		}
		resp.sendRedirect(req.getContextPath()+"/member/cart");

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
		String userName = req.getParameter("userName");
		String pId=req.getParameter("pId");
		String quantity=req.getParameter("quantity");
		//truy vấn Product bằng pId
		Product product= productService.findOne(Integer.parseInt(pId));
		
		CartItem cartItem=new CartItem();
		cartItem.setQuantity(Integer.parseInt(quantity));
		cartItem.setUnitPrice(product.getPrice());
		cartItem.setProduct(product);

		Log log = new Log(Log.INFO,"",this.name,"",1);
//		log.setUserName(userService.findOne(userName).getUserName());
//		log.setStatus(userService.findOne(userName).getStatus());
		log.setLevel(Log.INFO);
		
		//Tạo session
		HttpSession session=req.getSession();
		Object obj=session.getAttribute("cart");
		if(obj==null) {
			Map<Integer, CartItem> map=new HashMap<Integer,CartItem>();
			map.put(cartItem.getProduct().getProductId(), cartItem);
			session.setAttribute("cart", map);
			log.setSrc("Create new empty cart");
			log.setContent("Don't have cart before, create new cart");
			logService.insert(log);

		}else {
			Map<Integer, CartItem> map= extracted(obj);
			CartItem existCartItem=map.get(Integer.valueOf(pId));
			if(existCartItem==null) {
				map.put(product.getProductId(), cartItem);
				log.setSrc("Add product to cart");
				log.setContent("Add new product to cart");
				logService.insert(log);
			}else {
				existCartItem.setQuantity(existCartItem.getQuantity()+Integer.parseInt(quantity));
				log.setSrc("Add already product to cart");
				log.setContent("Add product and update quantity product in cart");
				logService.insert(log);
			}
			session.setAttribute("cart", map);
			LOGGER.info("add cart");
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
		LOGGER.warning("loai hang khoi gio");
		
	}

	
}
