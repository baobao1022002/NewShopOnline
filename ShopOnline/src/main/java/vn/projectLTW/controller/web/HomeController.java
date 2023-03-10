package vn.projectLTW.controller.web;

import vn.projectLTW.model.Category;
import vn.projectLTW.model.Product;
import vn.projectLTW.model.Seller;
import vn.projectLTW.model.Users;
import vn.projectLTW.service.ICategoryService;
import vn.projectLTW.service.IProductService;
import vn.projectLTW.service.ISellerService;
import vn.projectLTW.service.IUserService;
import vn.projectLTW.service.Impl.CategoryServiceImpl;
import vn.projectLTW.service.Impl.ProductServiceImpl;
import vn.projectLTW.service.Impl.SellerServiceImpl;
import vn.projectLTW.service.Impl.UserServiceImpl;
import vn.projectLTW.util.Constant;
import vn.projectLTW.util.Email;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


@WebServlet(urlPatterns = { "/home", "/login", "/register", "/forgotPass", "/waiting", "/verifyCode","/logout" })
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 5889168824989045500L;

	IUserService userService = new UserServiceImpl();
	IProductService productService=new ProductServiceImpl();
	ICategoryService categoryService=new CategoryServiceImpl();
	ISellerService sellerService=new SellerServiceImpl();

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURL().toString();

		if (url.contains("register")) {
			getRegister(req, resp);
		} else if (url.contains("login")) {
			getLogin(req, resp);
		} else if (url.contains("forgotPass")) {
			req.getRequestDispatcher("/views/web/forgotPassword.jsp").forward(req, resp);
		} else if (url.contains("waiting")) {
			getWaiting(req, resp);
		} else if (url.contains("verifyCode")) {
			req.getRequestDispatcher("/views/web/verify.jsp").forward(req, resp);
		} else if (url.contains("logout")) {
			getLogout(req, resp);
		}
		else {
			homePage(req, resp);
		}
	}


	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURL().toString();

		if (url.contains("register")) {
//			postRegister(req, resp);
		} else if (url.contains("login")) {
			postLogin(req, resp);
		} else if (url.contains("forgotPass")) {
			postForgotPassword(req, resp);
		} else if (url.contains("verifyCode")) {
			postVerifyCode(req, resp);
		}
	}

	protected void homePage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//L???y d??? li???u v?? ?????y l??n view

		List<Product> productListNew=productService.findAllNews();
		req.setAttribute("productListNew", productListNew);

		List<Category> categoryList=categoryService.findAll();
		req.setAttribute("categoryList", categoryList);

		List<Seller> sellerList=sellerService.findAll();
		req.setAttribute("sellerList", sellerList);

		req.getRequestDispatcher("/views/web/home.jsp").forward(req, resp);
	}

	protected void getRegister(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/views/web/register.jsp").forward(req, resp);
	}

	protected void postRegister(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");

		// l???y tham s??? t??? form
		String userName = req.getParameter("userName");
		String passWord = req.getParameter("passWord");
		String email = req.getParameter("email");
		String fullName = req.getParameter("fullName");

		String alertMsg = "";
		if (userService.checkExistEmail(email)) {
			alertMsg = "Email ???? t???n t???i";
			req.setAttribute("error", alertMsg);
			req.getRequestDispatcher("/views/web/register.jsp").forward(req, resp);
		} else if (userService.checkExistUserName(userName)) {
			alertMsg = "T??i kho???n ???? t???n t???i";
			req.setAttribute("error", alertMsg);
			req.getRequestDispatcher("/views/web/register.jsp").forward(req, resp);
		} else {
			String code = Email.getRandom();

			Users user = new Users(userName, email, fullName, code);

			boolean test = Email.getInstance().sendEmail(user.getEmail(), code);
			if (test) {

				// t???o session
				HttpSession session = req.getSession();
				session.setAttribute("account", user);
				boolean isSuccess = userService.register(email, passWord, userName, fullName, code);
				if (isSuccess) {
					resp.sendRedirect(req.getContextPath() + "/verifyCode");
				} else {
					alertMsg = "L???i h??? th???ng";
					req.setAttribute("error", alertMsg);
					req.getRequestDispatcher("/views/web/register.jsp").forward(req, resp);
				}
			} else {
				PrintWriter out = resp.getWriter();
				out.println("L???i khi g???i Email!!!!");
			}
		}
	}

	protected void getLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// check session
		HttpSession session = req.getSession(false);
		if (session != null && session.getAttribute("account") != null) {
			resp.sendRedirect(req.getContextPath() + "/waiting");
			return;
		}

		// check cookies
		Cookie[] cookies = req.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("userName")) {
					session = req.getSession(true);
					session.setAttribute("userName", cookie.getValue());
					resp.sendRedirect(req.getContextPath() + "/waiting");
					return;
				}
			}
		}
		req.getRequestDispatcher("/views/web/login.jsp").forward(req, resp);
	}

	protected void getLogout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// check session
		HttpSession session = req.getSession();
		session.removeAttribute("account");
		// check cookies
		Cookie[] cookies = req.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals(Constant.COOKIE_REMEMBER)) {
					cookie.setMaxAge(0);
					resp.addCookie(cookie);
					break;
				}
			}
		}
		resp.sendRedirect("./login");
	}

	protected void getWaiting(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//ki???m tra session
		HttpSession session = req.getSession();

		if (session != null && session.getAttribute("account") != null) {
			Users u = (Users) session.getAttribute("account");
			req.setAttribute("userName", u.getUserName());
			if (u.getRoleId() == 2) {
				resp.sendRedirect(req.getContextPath() + "/admin/home");
			} else if (u.getRoleId() == 10) {
				resp.sendRedirect(req.getContextPath() + "/manager/home");
			} else if (u.getRoleId() == 8) {
				resp.sendRedirect(req.getContextPath() + "/seller/home");
			} else {
				resp.sendRedirect(req.getContextPath() + "/home");
			}
		} else {
			resp.sendRedirect(req.getContextPath() + "/login");
		}
	}

	protected void postForgotPassword(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");

		// l???y tham s??? t??? form
		String userName = req.getParameter("userName");
		String email = req.getParameter("email");
		Users user= userService.findOne(userName);
		if (user.getEmail().equals(email)&& user.getUserName().equals(userName)) {
			String pass = 	Email.getRandom();
			user.setPassWord(pass);
			userService.update(user);
			boolean test = Email.getInstance().sendEmail(user.getEmail(), pass);
			if (test) {

				req.setAttribute("message", "Vui l??ng ki???m tra email ????? nh???n m???t kh???u m???i nh??!");
			}else {
				req.setAttribute("error", "L???i g???i email!");
			}
		}else {
			req.setAttribute("error", "User  Name ho???c Email kh??ng t???n t???i trong h??? th???ng!");
			req.getRequestDispatcher("/views/web/forgotPassword.jsp").forward(req, resp);
			return;
		}
		req.getRequestDispatcher("/views/web/forgotPassword.jsp").forward(req, resp);

	}


	private void saveRememberMe(HttpServletResponse response, String userName) {
		Cookie cookie=new Cookie(Constant.COOKIE_REMEMBER, userName);
		cookie.setMaxAge(30*60);
		response.addCookie(cookie);
	}

	protected void postLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");

		// l???y tham s??? t??? form
		String userName = req.getParameter("userName");
		String passWord = req.getParameter("passWord");
		boolean isRemeberMe = false;
		String remember = req.getParameter("remember");
		if ("on".equals(remember)) {
			isRemeberMe = true;
		}

		String alertMsg = "";

		if (userName.isEmpty() || passWord.isEmpty()) {
			alertMsg = "T??i kho???n ho???c m???t kh???u kh??ng ????ng";
			req.setAttribute("error", alertMsg);
			req.getRequestDispatcher("/views/web/login.jsp").forward(req, resp);
			return;
		}

		Users user=userService.login(userName, passWord);

		if(user!=null) {
			if(user.getStatus()==1) {
				//t???o session
				HttpSession session=req.getSession(true);
				session.setAttribute("account", user);

				if(isRemeberMe) {
					saveRememberMe(resp, userName);
				}
				resp.sendRedirect(req.getContextPath()+"/waiting");
			}else {
				alertMsg="T??i kho???n ???? b??? kh??a, li??n h??? Admin nh??";
				req.setAttribute("error", alertMsg);
				req.getRequestDispatcher("/views/web/login.jsp").forward(req, resp);
			}
		}else {
			alertMsg="T??i kho???n ho???c m???t kh???u kh??ng ????ng";
			req.setAttribute("error", alertMsg);
			req.getRequestDispatcher("/views/web/login.jsp").forward(req, resp);
		}
	}

	protected void postVerifyCode(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		try (PrintWriter out = resp.getWriter()) {

			// truy c???p session
			HttpSession session = req.getSession();
			Users user = (Users) session.getAttribute("account");

			String code = req.getParameter("authcode");

			if (code.equals(user.getCode())) {
				user.setEmail(user.getEmail());
				user.setStatus(1);

				userService.updateStatus(user);

				out.println("div class=\"container\"><br/>\r\n" + "    <br/>\r\n"
						+ "    <br/>K??ch ho???t t??i kho???n th??nh c??ng!<br/>\r\n" + "    <br/>\r\n" + "    <br/></div>");
			} else {
				out.println("div class=\"container\"><br/>\r\n" + "    <br/>\r\n"
						+ "    <br/>Sai m?? k??ch ho???t, vui l??ng ki???m tra l???i!<br/>\r\n" + "    <br/>\r\n"
						+ "    <br/></div>");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
