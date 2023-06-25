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
import java.text.DecimalFormat;
import java.util.List;


@WebServlet(urlPatterns = {"/admin/home","/admin/home/seachOrder"})
public class HomeController extends HttpServlet{

	ICartService cartService=new CartServiceImpl();

	private static final long serialVersionUID = 1L;
	DecimalFormat decimalFormat = new DecimalFormat("#.##");

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURL().toString();
		if (url.contains("seachOrder")) {
			getSearchOrder(req, resp);
		}else {
			homePage(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		findAll(req, resp); // hiện danh sách User trong model

		// chuyển về Views
		RequestDispatcher dispacher = req.getRequestDispatcher("/views/admin/home.jsp");
		dispacher.forward(req, resp);
	}

	protected void homePage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Lấy dữ liệu và đẩy lên view

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


			List<Cart> allCartList=cartService.allOrder();
			req.setAttribute("allCartList",allCartList);

			int countToTalOrder=cartService.countToTalOrder();
			req.setAttribute("countToTalOrder", countToTalOrder);

			String totalRevenue=decimalFormat.format(cartService.totalRevenue()) ;

			req.setAttribute("totalRevenue",totalRevenue);




		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("error", "Error: " + e.getMessage());
		}
	}
	protected void getSearchOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
	private void postSearchOrder(HttpServletRequest req, HttpServletResponse resp) {
		try {
			req.setCharacterEncoding("UTF-8");
			resp.setCharacterEncoding("UTF-8");
			int month = Integer.parseInt(req.getParameter("month"));
			int year = Integer.parseInt(req.getParameter("year"));
			List<Cart> cartListByMonth =  cartService.orderByMonth(month,year);
			req.setAttribute("cartListByMonth", cartListByMonth);// đẩy ds lên Views

			double  revenueByMonth=cartService.revenueByMonth(month,year);
			req.setAttribute("revenueByMonth",revenueByMonth);
			req.getRequestDispatcher("/views/admin/home.jsp").forward(req, resp);



		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("error", "Error: " + e.getMessage());
		}
	}

}
