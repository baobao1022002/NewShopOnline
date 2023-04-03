package vn.projectLTW.controller.admin;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import vn.projectLTW.model.UserRoles;
import vn.projectLTW.model.Users;
import vn.projectLTW.service.IUserRoleService;
import vn.projectLTW.service.IUserService;
import vn.projectLTW.service.Impl.UserRoleServiceImpl;
import vn.projectLTW.service.Impl.UserServiceImpl;
import vn.projectLTW.util.Constant;
import vn.projectLTW.util.UploadUtils;

@MultipartConfig(fileSizeThreshold = 1024*1024*10,//10MB
					maxFileSize = 1024*1024*50,//50MB
					maxRequestSize = 1024*1024*50 ) //50MB

@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/admin/user", "/admin/user/create", "/admin/user/update", "/admin/user/edit",
		"/admin/user/delete", "/admin/user/reset" })
public class UserController extends HttpServlet {
	IUserRoleService userRoleService = new UserRoleServiceImpl();
	IUserService userService = new UserServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");

		String url = req.getRequestURL().toString();
		Users user = null;

		if (url.contains("delete")) {
			delete(req, resp);
			user = new Users();
			req.setAttribute("user", user);// đẩy dữ liệu lên Views

		} else if (url.contains("edit")) {
			edit(req, resp);
		} else if (url.contains("reset")) {
			user = new Users();
			req.setAttribute("user", user);// đẩy dữ liệu lên Views

		}
		req.setAttribute("tag", "use");

		findAll(req, resp); // hiện danh sách User trong model

		// chuyển về Views
		RequestDispatcher dispacher = req.getRequestDispatcher("/views/admin/list-user.jsp");
		dispacher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");

		String url = req.getRequestURL().toString();
		Users user = null;

		if (url.contains("create")) {
			create(req, resp);

		} else if (url.contains("update")) {
			update(req, resp);
		} else if (url.contains("reset")) {
			user = new Users();
			req.setAttribute("user", user);

		}
		findAll(req, resp); // hiện danh sách User trong model

		// chuyển về Views
		RequestDispatcher dispacher = req.getRequestDispatcher("/views/admin/list-user.jsp");
		dispacher.forward(req, resp);
	}

	private void findAll(HttpServletRequest req, HttpServletResponse resp) {
		try {
			List<Users> userList = userService.findAll();// gọi hàm findAll trong service trả về đối tượng List<Users>
			req.setAttribute("userList", userList);// đẩy ds lên Views

			List<UserRoles> roles = userRoleService.findAll();// lấy tất cả roles trong bảng roles , đẩy ds roles lên
																// views
			req.setAttribute("roles", roles);

		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("error", "Error: " + e.getMessage());
		}
	}

	protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String id = req.getParameter("userId");// lấy tham số từ Views có name = id

			// Xóa ảnh cũ đi
			Users oldUsers = userService.findOne(Integer.parseInt(id));
			if (oldUsers.getImages() != null) {
				String fileName = oldUsers.getImages();
				UploadUtils.deleteFile(fileName, "\\users\\");
			}
			userService.delete(Integer.parseInt(id)); // gọi hàm delete trong service để xóa User thông qua id
			req.setAttribute("message", "Đã xóa thành công");
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("error", "Error: " + e.getMessage());
		}
	}

	protected void edit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String id = req.getParameter("userId");// lấy tham số từ Views có name = id
			Users user = userService.findOne(Integer.parseInt(id)); // gọi hàm findOne trong service để lấy 1 User thông
																	// qua id
			req.setAttribute("user", user); // đẩy đối tượng user lên views

			List<UserRoles> roles = userRoleService.findAll();
			req.setAttribute("roles", roles);

		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("error", "Error: " + e.getMessage());
		}
	}

	protected void create(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Users user = new Users();
		DiskFileItemFactory disFileItemFactory = new DiskFileItemFactory();
		ServletFileUpload servletFileUpload = new ServletFileUpload(disFileItemFactory);
		try {
			List<FileItem> items = servletFileUpload.parseRequest(req);
			for (FileItem item : items) {
				if (item.getFieldName().equals("email")) {
					if (userService.checkExistEmail(item.getString())) {
						req.setAttribute("error", "Email đã tồn tại");
						return;
					} else {
						user.setEmail(item.getString());
					}
				} else if (item.getFieldName().equals("userName")) {
					if (userService.checkExistUserName(item.getString())) {
						req.setAttribute("error", "UserName đã tồn tại");
						return;
					} else {
						user.setUserName(item.getString());
					}
				} else if (item.getFieldName().equals("fullName")) {
					user.setFullName(item.getString("UTF-8"));
				} else if (item.getFieldName().equals("passWord")) {
					user.setPassWord(item.getString("UTF-8"));
				} else if (item.getFieldName().equals("roleId")) {
					user.setRoles(userRoleService.findOne(Integer.parseInt(item.getString())));
				} else if (item.getFieldName().equals("status")) {
					user.setStatus(Integer.parseInt(item.getString("UTF-8")));
				} else if (item.getFieldName().equals("phone")) {
					user.setPhone(item.getString("UTF-8"));
				} else if (item.getFieldName().equals("images")) {
					if (item.getSize() > 0) {// nếu có file
						String orFileName = item.getName();
						int index = orFileName.lastIndexOf(".");
						String ext = orFileName.substring(index + 1);
						String fileName = System.currentTimeMillis() + "." + ext;
						File file = new File(Constant.DIR + "/users/" + fileName);
						item.write(file);
						user.setImages(fileName);
					} else {
						user.setImages("avatar.png");
					}
				}
			}
			userService.insert(user);
			req.setAttribute("user", user);
			req.setAttribute("message", "Đã thêm thành công");
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("error", "Error: " + e.getMessage());
		}
	}

	protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			req.setCharacterEncoding("UTF-8");
			resp.setCharacterEncoding("UTF-8");
			
			// Lấy dữ liệu từ JSP bằng BeanUtils
			Users user=new Users();
			BeanUtils.populate(user, req.getParameterMap());
//			System.out.println("full name: "+user.getUserName());
			// Xử lí hình ảnh
			//Khởi tạo DAO
			Users oldUser=userService.findOne(user.getUserId());
//			System.out.println(oldUser.getImages());
			if(req.getPart("images").getSize()==0) { 
				user.setImages(oldUser.getImages());
			}else {
				if(oldUser.getImages()!=null) {
					//xóa ảnh cũ đi
					String fileName=oldUser.getImages();
					UploadUtils.deleteFile(fileName, "\\users\\");
					//xử lí hình ảnh
					fileName=""+System.currentTimeMillis();
					user.setImages(UploadUtils.processUpload("images", req, Constant.DIR+"\\users\\", fileName));
				
				}
			}
			//Lấy dữ liệu roles từ bản UserRoles
			user.setRoles(userRoleService.findOne(user.getRoleId()));
			//gọi phương thức update trong Service
			userService.update(user);
			
			//thông báo 
			req.setAttribute("user", user);
			req.setAttribute("message", "Cập nhật thành công!");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();	
			req.setAttribute("error", "Error: "+e.getMessage());
		}
	}
}





