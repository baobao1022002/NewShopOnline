package vn.projectLTW.controller.web;

import vn.projectLTW.model.*;
import vn.projectLTW.service.*;
import vn.projectLTW.service.Impl.*;
import vn.projectLTW.util.CaptchaGenerator;
import vn.projectLTW.util.Constant;
import vn.projectLTW.util.Email;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import vn.projectLTW.model.Log;
import vn.projectLTW.util.PasswordEncryption;

import java.util.logging.Logger;


@WebServlet(urlPatterns = {"/home", "/login", "/register", "/forgotPass", "/waiting", "/verifyCode", "/logout"})
public class HomeController extends HttpServlet {
    private static final long serialVersionUID = 5889168824989045500L;
    String name = "AUTH";
    IUserService userService = new UserServiceImpl();
    IProductService productService = new ProductServiceImpl();
    ICategoryService categoryService = new CategoryServiceImpl();
    ISellerService sellerService = new SellerServiceImpl();
    ILogService logService = new LogServiceImpl();
    Log log = new Log(Log.INFO, "", "", "", 1);
    static final Logger LOGGER = Logger.getLogger(HomeController.class.getName());

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
        } else {
            homePage(req, resp);
        }
    }


    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURL().toString();

        if (url.contains("register")) {
            postRegister(req, resp);
        } else if (url.contains("login")) {
            postLogin(req, resp);
        } else if (url.contains("forgotPass")) {
            postForgotPassword(req, resp);
        } else if (url.contains("verifyCode")) {
            postVerifyCode(req, resp);
        }
    }

    protected void homePage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Lấy dữ liệu và đẩy lên view

        List<Product> productListNew = productService.findAllNews();
        req.setAttribute("productListNew", productListNew);

        List<Category> categoryList = categoryService.findAll();
        req.setAttribute("categoryList", categoryList);

        List<Seller> sellerList = sellerService.findAll();
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

        // lấy tham số từ form
        String userName = req.getParameter("userName");
        String passWord = req.getParameter("passWord");
        passWord = PasswordEncryption.toSHA1(passWord);
        String email = req.getParameter("email");
        String fullName = req.getParameter("fullName");

        String alertMsg = "";
        if (userService.checkExistEmail(email)) {
            alertMsg = "Email đã tồn tại";
            req.setAttribute("error", alertMsg);
            req.getRequestDispatcher("/views/web/register.jsp").forward(req, resp);
        } else if (userService.checkExistUserName(userName)) {
            alertMsg = "Tài khoản đã tồn tại";
            req.setAttribute("error", alertMsg);
            req.getRequestDispatcher("/views/web/register.jsp").forward(req, resp);
        } else {
            String code = Email.getRandom();

            Users user = new Users(userName, email, fullName, code);

            boolean test = Email.getInstance().sendEmail(user.getEmail(), code);
            if (test) {

                // tạo session
                HttpSession session = req.getSession();
                session.setAttribute("account", user);
                boolean isSuccess = userService.register(email, passWord, userName, fullName, code);
                if (isSuccess) {
                    resp.sendRedirect(req.getContextPath() + "/verifyCode");
                } else {
                    alertMsg = "Lỗi hệ thống";
                    req.setAttribute("error", alertMsg);
                    req.getRequestDispatcher("/views/web/register.jsp").forward(req, resp);
                }
            } else {
                PrintWriter out = resp.getWriter();
                out.println("Lỗi khi gửi Email!!!!");

            }
        }
    }

    protected void getLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // check session

        HttpSession session = req.getSession(false);
        if (session != null && session.getAttribute("account") != null) {
            resp.sendRedirect(req.getContextPath() + "/waiting");

//			LOGGER.info("Login success new 1");
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
//					LOGGER.info("Login success new 2");
                    return;
                }
            }
        }
//		LOGGER.info("Login success new 3");
        log.setLevel(Log.ALERT);
        log.setStatus(2);
        log.setSrc("login successfull");
        log.setContent("Account has been successfully logged in");
        logService.insert(log);
        LOGGER.info("login successfull");
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
        log.setLevel(Log.ALERT);
        log.setStatus(2);
        log.setSrc("logout successfull");
        log.setContent("Account has been successfully logged out");
        logService.insert(log);
        LOGGER.info("logout successfull");
        resp.sendRedirect("./login");
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

    protected void      postForgotPassword(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");

        // lấy tham số từ form
        String userName = req.getParameter("userName");
        String email = req.getParameter("email");
        Users user = userService.findOne(userName);
        if (user.getEmail().equals(email) && user.getUserName().equals(userName)) {
            String pass = Email.getRandom();
            boolean test = Email.getInstance().sendEmail(user.getEmail(), pass);
            pass = PasswordEncryption.toSHA1(pass);
            user.setPassWord(pass);
            userService.update(user);

            if (test) {

                req.setAttribute("message", "Vui lòng kiểm tra email để nhận mật khẩu mới nhé!");
            } else {
                req.setAttribute("error", "Lỗi gửi email!");
            }
        } else {
            req.setAttribute("error", "User  Name hoặc Email không tồn tại trong hệ thống!");

            log.setLevel(Log.ALERT);
            log.setStatus(2);
            log.setSrc("forgot password false");
            log.setContent("userName or email does not exist in the system");
            logService.insert(log);
            LOGGER.info("forgot password false");

            req.getRequestDispatcher("/views/web/forgotPassword.jsp").forward(req, resp);
            return;
        }
        req.getRequestDispatcher("/views/web/forgotPassword.jsp").forward(req, resp);

    }


    private void saveRememberMe(HttpServletResponse response, String userName) {
        Cookie cookie = new Cookie(Constant.COOKIE_REMEMBER, userName);
        cookie.setMaxAge(30 * 60);
        response.addCookie(cookie);
    }

    protected void postLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");

        // lấy tham số từ form
        String userName = req.getParameter("userName");
        String passWord = req.getParameter("passWord");
        passWord = PasswordEncryption.toSHA1(passWord);
        String captcha = req.getParameter("captcha");
        boolean isRemeberMe = false;
        String remember = req.getParameter("remember");
        if ("on".equals(remember)) {
            isRemeberMe = true;
            log.setLevel(Log.ALERT);
            log.setStatus(2);
            log.setSrc("login successfull");
            log.setContent("Account has been successfully logged in");
            logService.insert(log);
            LOGGER.info("login successfull");
        }

        String alertMsg = "";
        // Lấy số ngẫu nhiên trên image
        String captchaText = CaptchaGenerator.getCaptchaText();
        // Thực hiện xác minh captcha
        if (!captcha.equals(captchaText)) {
            // Captcha không hợp lệ, hiển thị thông báo lỗi
            req.setAttribute("error", "Nhập sai captcha");
            req.getRequestDispatcher("/views/web/login.jsp").forward(req, resp);
        } else {
        Users user = userService.login(userName, passWord);

        if (user != null) {
            // Lấy thời gian khóa tài khoản
            Date lockedUntil = userService.getAccountLockedUntil(userName);

            if (lockedUntil != null && lockedUntil.after(new Date())) {
                // Tài khoản bị khóa và thời gian khóa còn hiệu lực

                req.setAttribute("error", "Tài khoản đã bị khóa đến " + lockedUntil);
                req.getRequestDispatcher("/views/web/login.jsp").forward(req, resp);
                return;
            }

            if (user.getStatus() == 1) {
                //tạo session
                HttpSession session = req.getSession(true);
                session.setAttribute("account", user);
                // Cập nhật số lần đăng nhập sai là 0
                userService.updateLoginAttempts(userName, 0);

                if (isRemeberMe) {
                    saveRememberMe(resp, userName);
                }
                resp.sendRedirect(req.getContextPath() + "/waiting");

            } else {
                alertMsg = "Tài khoản đã bị khóa, liên hệ Admin nhé";
                req.setAttribute("error", alertMsg);

                log.setLevel(Log.ALERT);
                log.setStatus(2);
                log.setSrc("login false");
                log.setContent("Account has been locked");
                logService.insert(log);
                LOGGER.info("login false");

                req.getRequestDispatcher("/views/web/login.jsp").forward(req, resp);
            }
        } else {
            alertMsg = "Tài khoản hoặc mật khẩu không đúng";
            req.setAttribute("error", alertMsg);
            log.setLevel(Log.ALERT);
            log.setStatus(2);
            log.setSrc("login false");
            log.setContent("Incorrect account or password");
            logService.insert(log);
            LOGGER.info("login false");

            // Lấy số lần đăng nhập sai từ database
            int loginAttempts = userService.getLoginAttempts(userName);


            if (loginAttempts >= 3) {
                long unlockTime = System.currentTimeMillis() + (24 * 60 * 60 * 1000); // 24 hours
                userService.setAccountLockedUntil(userName, new Date(unlockTime));
                req.setAttribute("error", "Tài khoản đã bị khóa do quá 3 lần đăng nhập sai");
                req.getRequestDispatcher("/views/web/login.jsp").forward(req, resp);
                return;
            }
            // Tăng số lần đăng nhập sai
            loginAttempts++;
            userService.updateLoginAttempts(userName, loginAttempts);
            req.setAttribute("error", "Bạn đã đăng nhập sai " + loginAttempts + " lần. Đăng nhập sai quá 3 lần sẽ bị khóa tài khoản");


            req.getRequestDispatcher("/views/web/login.jsp").forward(req, resp);

        }
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

                out.println( "    <br/>Kích hoạt tài khoản thành công!<br/>\r\n" + "    <br/>\r\n" + "    <br/></div>");

                log.setLevel(Log.ALERT);
                log.setStatus(2);
                log.setSrc("register successfull");
                log.setContent("Successfully activated new account");
                logService.insert(log);
                LOGGER.info("register successfull");
            } else {
                out.println( "    <br/>Sai mã kích hoạt, vui lòng kiểm tra lại!<br/>\r\n" + "    <br/>\r\n"
                        + "    <br/></div>");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
