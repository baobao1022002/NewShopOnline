package vn.projectLTW.controller.admin;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import vn.projectLTW.model.Product;
import vn.projectLTW.model.Seller;
import vn.projectLTW.model.UserRoles;
import vn.projectLTW.model.Users;
import vn.projectLTW.service.IUserRoleService;
import vn.projectLTW.service.Impl.UserRoleServiceImpl;
import vn.projectLTW.util.Constant;
import vn.projectLTW.util.UploadUtils;

@WebServlet(urlPatterns = { "/admin/userRole", "/admin/userRole/create", "/admin/userRole/update", "/admin/userRole/edit",
		"/admin/userRole/delete", "/admin/userRole/reset" })

public class UserRoleController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//truy xuất vào Interface  userRoleService để lấy  các hàm implement  Service userRole
    IUserRoleService userRoleService= new UserRoleServiceImpl();

//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//
//
//
//		request.setAttribute("tag", "userole");
//
//		List<UserRoles> roleList = userRoleService.findAll();//lấy toàn bộ dữ liệu  bản UserRole đưa vào List
//		request.setAttribute("roleList", roleList);// đẩy dữ liệu  từ List lên View JSP
//
//		//View sẽ nhận dữ liệu là View nào
//		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/admin/userRole-List.jsp");
//		dispatcher.forward(request, response);
//
//	}
//
//
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(req, resp);
//
//	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		String url = request.getRequestURL().toString();
		UserRoles role = null;

		if (url.contains("delete")) {
			delete(request, response);
			role = new UserRoles();
			request.setAttribute("role", role);// đẩy dữ liệu lên Views

		} else if (url.contains("edit")) {
			edit(request, response);
		} else if (url.contains("reset")) {
			role = new UserRoles();
			request.setAttribute("role", role);// đẩy dữ liệu lên Views

		}
		request.setAttribute("tag", "rol");

		findAll(request, response); // hiện danh sách User trong model

		// chuyển về Views
		RequestDispatcher dispacher = request.getRequestDispatcher("/views/admin/userRole-List.jsp");
		dispacher.forward(request, response);



//		request.setAttribute("tag", "userole");
//
//		List<UserRoles> roleList = userRoleService.findAll();//lấy toàn bộ dữ liệu  bản UserRole đưa vào List
//		request.setAttribute("roleList", roleList);// đẩy dữ liệu  từ List lên View JSP
//
//		//View sẽ nhận dữ liệu là View nào
//		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/admin/userRole-List.jsp");
//		dispatcher.forward(request, response);

	}


	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(req, resp);
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");

		String url = req.getRequestURL().toString();
		UserRoles role = null;

		if (url.contains("create")) {
			create(req, resp);

		} else if (url.contains("update")) {
			update(req, resp);
		} else if (url.contains("reset")) {
			role = new UserRoles();
			req.setAttribute("role", role);

		}
		findAll(req, resp); // hiện danh sách User trong model

		// chuyển về Views
		RequestDispatcher dispacher = req.getRequestDispatcher("/views/admin/userRole-List.jsp");
		dispacher.forward(req, resp);
	}

	private void findAll(HttpServletRequest req, HttpServletResponse resp) {
		try {
			List<UserRoles> userRoleList = userRoleService.findAll();// gọi hàm findAll trong service trả về đối tượng List<Users>
			req.setAttribute("userRoleList", userRoleList);// đẩy ds lên Views



		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("error", "Error: " + e.getMessage());
		}
	}

	protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String id = req.getParameter("roleId");// lấy tham số từ Views có name = id


			userRoleService.delete(Integer.parseInt(id)); // gọi hàm delete trong service để xóa User thông qua id
			req.setAttribute("message", "Đã xóa thành công");
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("error", "Error: " + e.getMessage());
		}
	}



	protected void edit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String id = req.getParameter("userId");// lấy tham số từ Views có name = id
			UserRoles role = userRoleService.findOne(Integer.parseInt(id)); // gọi hàm findOne trong service để lấy 1 User thông													// qua id
																// seller thông
			// qua id
			req.setAttribute("role", role);

		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("error", "Error: " + e.getMessage());
		}

//		try {
//			String id = req.getParameter("userId");// lấy tham số từ Views có name = id
//			UserRoles role = userRoleService.findOne(Integer.parseInt(id)); // gọi hàm findOne trong service để lấy 1 User thông													// qua id
//			req.setAttribute("role", role); // đẩy đối tượng user lên views
//		} catch (Exception e) {
//			e.printStackTrace();
//			req.setAttribute("error", "Error: " + e.getMessage());
//		}
	}

	protected void create(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {

			req.setCharacterEncoding("UTF-8");
			resp.setCharacterEncoding("UTF-8");

			UserRoles role=new UserRoles();
			BeanUtils.populate(role, req.getParameterMap());

			userRoleService.insert(role);
			System.out.println("role id: "+role.getRoleId()+" roleName: "+role.getRoleName());

			req.setAttribute("role", role);
			req.setAttribute("message", "Đã thêm thành công");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			req.setAttribute("error", "Error"+e.getMessage());
		}
	}

	protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			req.setCharacterEncoding("UTF-8");
			resp.setCharacterEncoding("UTF-8");

			// Lấy dữ liệu từ JSP bằng BeanUtils
			UserRoles role=new UserRoles();
			BeanUtils.populate(role, req.getParameterMap());


			userRoleService.update(role);

			//thông báo
			req.setAttribute("role", role);
			req.setAttribute("message", "Cập nhật thành công!");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			req.setAttribute("error", "Error: "+e.getMessage());
		}
	}

}
