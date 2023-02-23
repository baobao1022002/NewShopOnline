//package vn.projectLTW.controller.admin;
//
//import java.io.IOException;
//import java.util.List;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import vn.projectLTW.model.UserRoles;
//import vn.projectLTW.service.IUserRoleService;
//import vn.projectLTW.service.Impl.UserRoleServiceImpl;
//
//
//@WebServlet("/addRole")
//public class AddRoleController extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//	//truy xuất vào Interface  userRoleService để lấy  các hàm implement  Service userRole
//    IUserRoleService userRoleService= new UserRoleServiceImpl();
//
//
//
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//
//		//View sẽ nhận dữ liệu là View nào
//		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/admin/addRole.jsp");
//		dispatcher.forward(request, response);
//
//	}
//
//
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		//Xử lí tiếng việt khi thêm vào
//		response.setCharacterEncoding("UTF-8");
//		request.setCharacterEncoding("UTF-8");
//
//		UserRoles userRole = new UserRoles();
//		String rollName = request.getParameter("roleName");//lấy dữ liệu từ view jsp với thuộc tính name
//
//		userRole.setRoleName(rollName);//nạp dữ liệu vào trường roleName trong model
//
//		userRoleService.insert(userRole);// thêm dữ liệu vào database bằng hàm insert
//
//		response.sendRedirect(request.getContextPath()+"/UserRole");//trả về servlet controller
//	}
//
//}
