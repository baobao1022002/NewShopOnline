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
//@WebServlet("/editRole")
//public class EditRoleController extends HttpServlet {
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
//		UserRoles userRole=userRoleService.findOne(roleId);// lấy 1 đối tượng  UserRole từ RoleId bằng hàm findOne
//		request.setAttribute("userRole", userRole);
//
//		//View sẽ nhận dữ liệu là View nào
//		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/admin/editRole.jsp");
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
//
//		String id=request.getParameter("roleId");//lấy dữ liệu từ view jsp với thuộc tính id
//		int roleId=Integer.parseInt(id);
//
//		String rollName = request.getParameter("roleName");//lấy dữ liệu từ view jsp với thuộc tính name
//
//
//		userRole.setRoleId(roleId);//nạp dữ liệu vào trường roleId trong model
//		userRole.setRoleName(rollName);//nạp dữ liệu vào trường roleName trong model
//
//
//
//		userRoleService.update(userRole);// cập nhật dữ liệu vào database  bằng hàm update
//
//
//		response.sendRedirect(request.getContextPath()+"/UserRole");//trả về servlet controller
//	}
//
//}
