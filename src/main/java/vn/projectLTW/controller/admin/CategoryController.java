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

import vn.projectLTW.Dao.ICategoryDao;
import vn.projectLTW.model.Category;
import vn.projectLTW.model.UserRoles;
import vn.projectLTW.model.Users;
import vn.projectLTW.service.ICategoryService;
import vn.projectLTW.service.IUserRoleService;
import vn.projectLTW.service.IUserService;
import vn.projectLTW.service.Impl.CategoryServiceImpl;
import vn.projectLTW.service.Impl.UserRoleServiceImpl;
import vn.projectLTW.service.Impl.UserServiceImpl;
import vn.projectLTW.util.Constant;
import vn.projectLTW.util.UploadUtils;

@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 10, // 10MB
		maxFileSize = 1024 * 1024 * 50, // 50MB
		maxRequestSize = 1024 * 1024 * 50) // 50MB

@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/admin/category", "/admin/category/create", "/admin/category/update",
		"/admin/category/edit", "/admin/category/delete", "/admin/category/reset" })
public class CategoryController extends HttpServlet {
	ICategoryService categoryService = new CategoryServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");

		String url = req.getRequestURL().toString();
		Category category = null;

		if (url.contains("delete")) {
			delete(req, resp);
			category = new Category();
			req.setAttribute("category", category);// đẩy dữ liệu lên Views

		} else if (url.contains("edit")) {
			edit(req, resp);
		} else if (url.contains("reset")) {
			category = new Category();
			req.setAttribute("category", category);// đẩy dữ liệu lên Views

		}
		req.setAttribute("tag", "cate");
		findAll(req, resp); // hiện danh sách User trong model

		// chuyển về Views
		RequestDispatcher dispacher = req.getRequestDispatcher("/views/admin/list-category.jsp");
		dispacher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");

		String url = req.getRequestURL().toString();
		Category category = null;

		if (url.contains("create")) {
			create(req, resp);

		} else if (url.contains("update")) {
			update(req, resp);
		} else if (url.contains("delete")) {
			delete(req, resp);
		}

		else if (url.contains("reset")) {
			category = new Category();
			req.setAttribute("category", category);

		}
		findAll(req, resp); // hiện danh sách User trong model

		// chuyển về Views
		RequestDispatcher dispacher = req.getRequestDispatcher("/views/admin/list-category.jsp");
		dispacher.forward(req, resp);
	}

	private void findAll(HttpServletRequest req, HttpServletResponse resp) {
		try {
			List<Category> categoryList = categoryService.findAll();// gọi hàm findAll trong service trả về đối tượng
																	// List<Users>
			req.setAttribute("categoryList", categoryList);// đẩy ds lên Views

		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("error", "Error: " + e.getMessage());
		}
	}

	protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String id = req.getParameter("categoryId");// lấy tham số từ Views có name = categoryId

			// Xóa ảnh cũ đi
			Category oldCategory = categoryService.findOne(Integer.parseInt(id));
			if (oldCategory.getImages() != null) {
				String fileName = oldCategory.getImages();
				UploadUtils.deleteFile(fileName, "\\category\\");
			}
			categoryService.delete(Integer.parseInt(id)); // gọi hàm delete trong service để xóa Category thông qua id
			req.setAttribute("message", "Đã xóa thành công");
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("error", "Error: " + e.getMessage());
		}
	}

	protected void edit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String id = req.getParameter("categoryId");// lấy tham số từ Views có name = id
			Category category = categoryService.findOne(Integer.parseInt(id)); // gọi hàm findOne trong service để lấy 1
																				// category thông
			// qua id
			req.setAttribute("category", category);

		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("error", "Error: " + e.getMessage());
		}
	}

	protected void create(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			req.setCharacterEncoding("UTF-8");
			resp.setCharacterEncoding("UTF-8");
			//Lấy dữ liệu từ jsp bằng BeanUtils
			Category category=new Category();
			BeanUtils.populate(category, req.getParameterMap());
			// xử lí hình ảnh
			if(req.getPart("images").getSize()!=0) {
				//xử lí hình ảnh
				String fileName=""+System.currentTimeMillis();
				category.setImages(
						UploadUtils.processUpload("images", req, Constant.DIR + "\\category\\", fileName));
			}
			//gọi pt update  trong service
			categoryService.insert(category);
			req.setAttribute("category", category);
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
			Category category = new Category();
			BeanUtils.populate(category, req.getParameterMap());

			// Xử lí hình ảnh
			// Khởi tạo DAO
			Category oldCategory = categoryService.findOne(category.getCategoryId());
//			System.out.println(oldUser.getImages());
			if (req.getPart("images").getSize() == 0) {
				category.setImages(oldCategory.getImages());
			} else {
				if (oldCategory.getImages() != null) {
					// xóa ảnh cũ đi
					String fileName = oldCategory.getImages();
					UploadUtils.deleteFile(fileName, "\\category\\");
					// xử lí hình ảnh
					fileName = "" + System.currentTimeMillis();
					category.setImages(
							UploadUtils.processUpload("images", req, Constant.DIR + "\\category\\", fileName));

				}
			}

			// gọi phương thức update trong Service
			categoryService.update(category);

			// thông báo
			req.setAttribute("category", category);
			req.setAttribute("message", "Cập nhật thành công!");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			req.setAttribute("error", "Error: " + e.getMessage());
		}
	}
}
