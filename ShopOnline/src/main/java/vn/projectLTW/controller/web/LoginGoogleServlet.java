package vn.projectLTW.controller.web;

import vn.projectLTW.accessgoogle.GooglePojo;
import vn.projectLTW.accessgoogle.GoogleUtils;
import vn.projectLTW.model.Log;
import vn.projectLTW.model.UserGG;
import vn.projectLTW.model.Users;
import vn.projectLTW.service.*;
import vn.projectLTW.service.Impl.*;
import vn.projectLTW.util.Email;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;

import vn.projectLTW.model.Log;
import java.util.logging.Logger;
@WebServlet(urlPatterns={"/login-google","/loginGG","/registerGG","/waitingGG","/verifyCodeGG"})
//@WebServlet("/login-google")
public class LoginGoogleServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    IUserService userService = new UserServiceImpl();
    IProductService productService=new ProductServiceImpl();
    ICategoryService categoryService=new CategoryServiceImpl();
    ISellerService sellerService=new SellerServiceImpl();
    ILogService logService=new LogServiceImpl();
    Log log = new Log(Log.INFO,"","","",1);
    static final Logger LOGGER= Logger.getLogger(HomeController.class.getName());
    public LoginGoogleServlet() {
        super();
    }
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String url = req.getRequestURL().toString();
        if (url.contains("login-google")) {
            doGetGG(req, resp);
        } else if (url.contains("waitingGG")) {
            getWaiting(req, resp);
        } else if (url.contains("verifyCodeGG")) {
            req.getRequestDispatcher("/views/web/verify.jsp").forward(req, resp);
        }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String url = req.getRequestURL().toString();
        if (url.contains("login-google")) {
            doPostGG(req, resp);
//            postLoginFb(req, resp);
        }
    }

    protected void doGetGG(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String code = req.getParameter("code");
        String accessToken = GoogleUtils.getToken(code);
        GooglePojo googlePojo = GoogleUtils.getUserInfo(accessToken);
        String id=googlePojo.getId();
        String name= googlePojo.getName();
        String email=googlePojo.getEmail();

        System.out.println(googlePojo.getId());
        System.out.println(googlePojo.getName());
        System.out.println(googlePojo.getEmail());
        if (code == null || code.isEmpty()) {
            RequestDispatcher dis = req.getRequestDispatcher("login.jsp");
            dis.forward(req, resp);
        } else {
                UserGG userGG=new UserGG(id,email);
                // tạo session
                HttpSession session = req.getSession();
                session.setAttribute("account", userGG);
                boolean isSuccess = userService.registerGG(id,email);

                if (isSuccess) {
                    userGG.setEmail(userGG.getEmail());
                    userGG.setStatus(1);
                    userService.updateStatusGG(userGG);
                    System.out.println("Dang ky thanh cong");
                } else {
                    req.getRequestDispatcher("/views/web/login.jsp").forward(req, resp);
                }
            log.setLevel(Log.INFO);
            log.setStatus(1);
            log.setSrc("login with google account successfull");
            log.setContent("login with google account successfully");
            logService.insert(log);
            LOGGER.info("login with google account successfull");
                RequestDispatcher dis = req.getRequestDispatcher("index.jsp");
                dis.forward(req, resp);
        }
    }
    protected void doPostGG(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
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
                log.setLevel(Log.ALERT);
                log.setStatus(2);
                log.setSrc("Đăng kí thành công");
                log.setContent("Kích hoạt thành công tài khoản mới");
                logService.insert(log);
                LOGGER.info("Đăng kí thành công");
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