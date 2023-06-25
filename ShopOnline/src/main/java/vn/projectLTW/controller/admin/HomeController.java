package vn.projectLTW.controller.admin;

import vn.projectLTW.model.Cart;
import vn.projectLTW.model.Category;
import vn.projectLTW.model.Product;
import vn.projectLTW.model.Seller;
import vn.projectLTW.service.ICartService;
import vn.projectLTW.service.Impl.CartServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@MultipartConfig(fileSizeThreshold = 1024*1024*10,//10MB
		maxFileSize = 1024*1024*50,//50MB
		maxRequestSize = 1024*1024*50 ) //50MB
@WebServlet(urlPatterns = {"/admin/home"})
public class HomeController extends HttpServlet{

	ICartService cartService=new CartServiceImpl();

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		req.setAttribute("tag", "adminhome");
		findAll(req, resp); // hiện danh sách product trong model

		// chuyển về Views
		RequestDispatcher dispacher = req.getRequestDispatcher("/views/admin/home.jsp");
		dispacher.forward(req, resp);
	}
	private void findAll(HttpServletRequest req, HttpServletResponse resp) {
		try {
			int month = Integer.parseInt(req.getParameter("month"));
			List<Cart> cartListByMonth =  cartService.orderByMonth(month);
			req.setAttribute("cartListByMonth", cartListByMonth);// đẩy ds lên Views

			List<Cart> allCartList=cartService.allOrder();
			req.setAttribute("allCartList",allCartList);

			int countToTalOrder=cartService.countToTalOrder();
			req.setAttribute("countToTalOrder", countToTalOrder);

			double totalRevenue=cartService.totalRevenue();
			req.setAttribute("totalRevenue",totalRevenue);

			double  revenueByMonth=cartService.revenueByMonth(month);
			req.setAttribute("revenueByMonth",revenueByMonth);


		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("error", "Error: " + e.getMessage());
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}
