package vn.projectLTW.controller.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import  vn.projectLTW.accessgoogle.GooglePojo;
import  vn.projectLTW.accessgoogle.GoogleUtils;
import vn.projectLTW.model.UserGG;
import vn.projectLTW.model.Users;
import vn.projectLTW.service.ICategoryService;
import vn.projectLTW.service.IProductService;
import vn.projectLTW.service.ISellerService;
import vn.projectLTW.service.IUserService;
import vn.projectLTW.service.Impl.CategoryServiceImpl;
import vn.projectLTW.service.Impl.ProductServiceImpl;
import vn.projectLTW.service.Impl.SellerServiceImpl;
import vn.projectLTW.service.Impl.UserServiceImpl;
import vn.projectLTW.util.Email;

@WebServlet(urlPatterns={"/login-google","/loginGG","/registerGG","/waitingGG","/verifyCodeGG"})
public class LoginGoogleServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    static final Logger LOGGER= Logger.getLogger(HomeController.class.getName());

    IUserService userService = new UserServiceImpl();
    IProductService productService=new ProductServiceImpl();
    ICategoryService categoryService=new CategoryServiceImpl();
    ISellerService sellerService=new SellerServiceImpl();
    public LoginGoogleServlet() {
        super();
    }
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String url = req.getRequestURL().toString();
        if (url.contains("login-google")) {
            getRegisterFb(req, resp);
            getLoginFb(req, resp);
        } else if (url.contains("registerGG")) {
            getRegisterFb(req, resp);
        }else if (url.contains("waitingGG")) {
            getWaiting(req, resp);
        } else if (url.contains("verifyCodeGG")) {
            req.getRequestDispatcher("/views/web/verify.jsp").forward(req, resp);
        }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String url = req.getRequestURL().toString();
        if (url.contains("login-google")) {
            postRegisterFb(req, resp);
            postLoginFb(req, resp);
        } else if (url.contains("registerGG")) {
            postRegisterFb(req, resp);
        }else if (url.contains("verifyCodeGG")) {
            postVerifyCode(req, resp);
        }
    }

    protected void getLoginFb(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String code = request.getParameter("code");
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("account") != null) {
            response.sendRedirect(request.getContextPath() + "/waiting");
            return;
        }
        // check cookies
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("userName")) {
                    session = request.getSession(true);
                    session.setAttribute("userName", cookie.getValue());
                    response.sendRedirect(request.getContextPath() + "/waiting");
                    LOGGER.info("Login success");
                    return;
                }
            }
        }
        LOGGER.info("Login success3");


        if (code == null || code.isEmpty()) {
            RequestDispatcher dis = request.getRequestDispatcher("login.jsp");
            dis.forward(request, response);
        } else {
            String accessToken = GoogleUtils.getToken(code);
            GooglePojo googlePojo = GoogleUtils.getUserInfo(accessToken);
            request.setAttribute("id", googlePojo.getId());
            request.setAttribute("name", googlePojo.getName());
            request.setAttribute("email", googlePojo.getEmail());
            RequestDispatcher dis = request.getRequestDispatcher("index.jsp");
            dis.forward(request, response);
        }
    }

    protected void postLoginFb(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");

        // lấy tham số từ form
        String id = req.getParameter("id");
        String alertMsg = "";


        UserGG user=userService.loginGG(Integer.parseInt(id));

        if(user!=null) {
                //tạo session
                HttpSession session=req.getSession(true);
                session.setAttribute("account", user);

                resp.sendRedirect(req.getContextPath()+"/waiting");
            }else {
                alertMsg="Tài khoản đã bị khóa, liên hệ Admin nhé";
                LOGGER.warning("Tai khoan da bi khoa");
                req.setAttribute("error", alertMsg);
                req.getRequestDispatcher("/views/web/login.jsp").forward(req, resp);
            }

    }

    protected void getRegisterFb(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String code = request.getParameter("code");
//
//        if (code == null || code.isEmpty()) {
//            RequestDispatcher dis = request.getRequestDispatcher("login.jsp");
//            dis.forward(request, response);
//        } else {
//            String accessToken = GoogleUtils.getToken(code);
//            GooglePojo googlePojo = GoogleUtils.getUserInfo(accessToken);
//            request.setAttribute("id", googlePojo.getId());
//            request.setAttribute("name", googlePojo.getName());
//            request.setAttribute("email", googlePojo.getEmail());
//            RequestDispatcher dis = request.getRequestDispatcher("index.jsp");
//            dis.forward(request, response);
//        }
//        request.getRequestDispatcher("/views/web/register.jsp").forward(request, response);
    }

    protected void postRegisterFb(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");

        // lấy tham số từ form
        String code = req.getParameter("code");
        String accessToken = GoogleUtils.getToken(code);
        GooglePojo googlePojo = GoogleUtils.getUserInfo(accessToken);
        String id = googlePojo.getId();
        String userName = googlePojo.getName();
        String email = googlePojo.getEmail();

        String alertMsg = "";
        UserGG userGG = new UserGG(Integer.parseInt(id),userName,email);


//            boolean isSuccess = userService.registerGG(email, userName);
        boolean test = Email.getInstance().sendEmail(userGG.getEmail(), code);
        if (test) {

            // tạo session
            HttpSession session = req.getSession();
            session.setAttribute("account", userGG);
            boolean isSuccess = userService.registerGG(email,userName);
            if (isSuccess) {
                resp.sendRedirect(req.getContextPath() + "/verifyCode");
            } else {
                alertMsg = "Lỗi hệ thống";
                req.setAttribute("error", alertMsg);
//                req.getRequestDispatcher("/views/web/register.jsp").forward(req, resp);
            }
        } else {
            PrintWriter out = resp.getWriter();
            out.println("Lỗi khi gửi Email!!!!");
        }
//            req.getRequestDispatcher("/views/web/register.jsp").forward(req, resp);
        }


    protected void getWaiting(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //kiểm tra session
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
    protected void postVerifyCode(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = resp.getWriter()) {

            // truy cập session
            HttpSession session = req.getSession();
            Users user = (Users) session.getAttribute("account");

            String code = req.getParameter("authcode");

            if (code.equals(user.getCode())) {
                user.setEmail(user.getEmail());
                user.setStatus(1);

                userService.updateStatus(user);

                out.println("div class=\"container\"><br/>\r\n" + "    <br/>\r\n"
                        + "    <br/>Kích hoạt tài khoản thành công!<br/>\r\n" + "    <br/>\r\n" + "    <br/></div>");
            } else {
                out.println("div class=\"container\"><br/>\r\n" + "    <br/>\r\n"
                        + "    <br/>Sai mã kích hoạt, vui lòng kiểm tra lại!<br/>\r\n" + "    <br/>\r\n"
                        + "    <br/></div>");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}