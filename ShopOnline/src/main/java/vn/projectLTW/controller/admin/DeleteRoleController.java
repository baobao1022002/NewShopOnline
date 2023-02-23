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
//@WebServlet("/deleteRole")
//public class DeleteRoleController extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//	//truy xuất vào Interface  userRoleService để lấy  các hàm implement  Service userRole
//    IUserRoleService userRoleService= new UserRoleServiceImpl();
//
//
//
//
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//		String id= request.getParameter("id");//lấy dữ liệu tham số  từ URL trên view JSP
//		int roleId=Integer.parseInt(id);
//
//		userRoleService.delete(roleId);// gọi hàm  delete để xóa 1 đối tượng theo tham số truyền vào roleId
//
//		//View sẽ nhận dữ liệu là View nào
//		RequestDispatcher dispatcher = request.getRequestDispatcher("/UserRole");
//		dispatcher.forward(request, response);
//
//	}
//
//
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//	}
//
//}
