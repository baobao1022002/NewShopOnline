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
import vn.projectLTW.model.Seller;
import vn.projectLTW.model.UserRoles;
import vn.projectLTW.model.Users;

import vn.projectLTW.service.ISellerService;
import vn.projectLTW.service.IUserRoleService;
import vn.projectLTW.service.IUserService;
import vn.projectLTW.service.Impl.SellerServiceImpl;
import vn.projectLTW.service.Impl.UserRoleServiceImpl;
import vn.projectLTW.service.Impl.UserServiceImpl;
import vn.projectLTW.util.Constant;
import vn.projectLTW.util.UploadUtils;

@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 10, // 10MB
		maxFileSize = 1024 * 1024 * 50, // 50MB
		maxRequestSize = 1024 * 1024 * 50) // 50MB

@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/admin/seller", "/admin/seller/create", "/admin/seller/update",
		"/admin/seller/edit", "/admin/seller/delete", "/admin/seller/reset" })
public class SellerController extends HttpServlet {
	ISellerService sellerService = new SellerServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");

		String url = req.getRequestURL().toString();
		Seller seller = null;

		if (url.contains("delete")) {
			delete(req, resp);
			seller = new Seller();
			req.setAttribute("seller", seller);// đẩy dữ liệu lên Views

		} else if (url.contains("edit")) {
			edit(req, resp);
		} else if (url.contains("reset")) {
			seller = new Seller();
			req.setAttribute("seller", seller);// đẩy dữ liệu lên Views

		}
		req.setAttribute("tag", "sell");

		findAll(req, resp); // hiện danh sách User trong model

		// chuyển về Views
		RequestDispatcher dispacher = req.getRequestDispatcher("/views/admin/list-seller.jsp");
		dispacher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");

		String url = req.getRequestURL().toString();
		Seller seller = null;

		if (url.contains("create")) {
			create(req, resp);

		} else if (url.contains("update")) {
			update(req, resp);
		} else if (url.contains("delete")) {
			delete(req, resp);
		}

		else if (url.contains("reset")) {
			seller = new Seller();
			req.setAttribute("seller", seller);

		}
		findAll(req, resp); // hiện danh sách User trong model

		// chuyển về Views
		RequestDispatcher dispacher = req.getRequestDispatcher("/views/admin/list-seller.jsp");
		dispacher.forward(req, resp);
	}

	private void findAll(HttpServletRequest req, HttpServletResponse resp) {
		try {
			List<Seller> sellerList = sellerService.findAll();// gọi hàm findAll trong service trả về đối tượng
																	// List<Users>
			req.setAttribute("sellerList", sellerList);// đẩy ds lên Views

		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("error", "Error: " + e.getMessage());
		}
	}

	protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String id = req.getParameter("sellerId");// lấy tham số từ Views có name = sellerId

			// Xóa ảnh cũ đi
			Seller oldSeller = sellerService.findOne(Integer.parseInt(id));
			if (oldSeller.getImages() != null) {
				String fileName = oldSeller.getImages();
				UploadUtils.deleteFile(fileName, "\\seller\\");
			}
			sellerService.delete(Integer.parseInt(id)); // gọi hàm delete trong service để xóa seller thông qua id
			req.setAttribute("message", "Đã xóa thành công");
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("error", "Error: " + e.getMessage());
		}
	}

	protected void edit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String id = req.getParameter("sellerId");// lấy tham số từ Views có name = id
			Seller seller = sellerService.findOne(Integer.parseInt(id)); // gọi hàm findOne trong service để lấy 1
																				// seller thông
			// qua id
			req.setAttribute("seller", seller);

		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("error", "Error: " + e.getMessage());
		}
	}

	protected void create(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Seller seller = new Seller();
		DiskFileItemFactory disFileItemFactory = new DiskFileItemFactory();
		ServletFileUpload servletFileUpload = new ServletFileUpload(disFileItemFactory);
		try {

		
				List<FileItem> items = servletFileUpload.parseRequest(req);
				for (FileItem item : items) {
					if (item.getFieldName().equals("sellerName")) {
						seller.setSellerName(item.getString());
					} else if (item.getFieldName().equals("images")) {
						if (item.getSize() > 0) {// nếu có file
							String orFileName = item.getName();
							int index = orFileName.lastIndexOf(".");
							String ext = orFileName.substring(index + 1);
							String fileName = System.currentTimeMillis() + "." + ext;
							File file = new File(Constant.DIR + "/seller/" + fileName);
							item.write(file);
							seller.setImages(fileName);
						} else {
							seller.setImages("avatar.png");
						}
					}
				}
			
			// gọi phương thức update trong Service
			sellerService.insert(seller);

			// thông báo
			req.setAttribute("seller", seller);
			req.setAttribute("message", "Cập nhật thành công");
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("error", "Error" + e.getMessage());
		}
	}


	protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			req.setCharacterEncoding("UTF-8");
			resp.setCharacterEncoding("UTF-8");

			// Lấy dữ liệu từ JSP bằng BeanUtils
			Seller seller = new Seller();
			BeanUtils.populate(seller, req.getParameterMap());

			// Xử lí hình ảnh
			// Khởi tạo DAO
			Seller oldseller = sellerService.findOne(seller.getSellerId());
//			System.out.println(oldUser.getImages());
			if (req.getPart("images").getSize() == 0) {
				seller.setImages(oldseller.getImages());
			} else {
				if (oldseller.getImages() != null) {
					// xóa ảnh cũ đi
					String fileName = oldseller.getImages();
					UploadUtils.deleteFile(fileName, "\\seller\\");
					// xử lí hình ảnh
					fileName = "" + System.currentTimeMillis();
					seller.setImages(
							UploadUtils.processUpload("images", req, Constant.DIR + "\\seller\\", fileName));
				}
			}

			// gọi phương thức update trong Service
			sellerService.update(seller);

			// thông báo
			req.setAttribute("seller", seller);
			req.setAttribute("message", "Cập nhật thành công!");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			req.setAttribute("error", "Error: " + e.getMessage());
		}
	}
}
