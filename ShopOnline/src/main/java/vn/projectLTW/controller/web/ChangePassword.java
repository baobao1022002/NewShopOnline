
package vn.projectLTW.controller.web;

import vn.projectLTW.model.Log;
import vn.projectLTW.service.ILogService;
import vn.projectLTW.service.IUserService;
import vn.projectLTW.service.Impl.LogServiceImpl;
import vn.projectLTW.service.Impl.UserServiceImpl;
import vn.projectLTW.util.PasswordEncryption;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.logging.Logger;

@WebServlet("/ChangePassword")
public class ChangePassword extends HttpServlet {
    IUserService userService = new UserServiceImpl();
    ILogService logService=new LogServiceImpl();
    Log log = new Log(Log.INFO,"","","",1);
    static final Logger LOGGER= Logger.getLogger(HomeController.class.getName());

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/views/web/changePassword.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        // Lấy thông tin từ form
        String oldPass = request.getParameter("oldPass");
        String newPass = request.getParameter("newPass");
        String confirmPass = request.getParameter("confirmPass");
        int Id = Integer.parseInt(request.getParameter("Id"));
        oldPass = PasswordEncryption.toSHA1(oldPass);
        newPass = PasswordEncryption.toSHA1(newPass);
        confirmPass = PasswordEncryption.toSHA1(confirmPass);

        if (oldPass == null || oldPass.isEmpty() ||
                newPass == null || newPass.isEmpty() ||
                confirmPass == null || confirmPass.isEmpty()) {
            // handle error
            request.setAttribute("error", "Chưa nhập mật khẩu");
            return;
        }

//         Kiểm tra tính hợp lệ của thông tin mật khẩu cũ
        boolean isOldPassCorrect = userService.checkOldPassword(Id, oldPass);
        if (!isOldPassCorrect) {
            // Nếu mật khẩu cũ không đúng, trả về thông báo lỗi
            request.setAttribute("error", "Mật khẩu cũ không đúng!");

            log.setLevel(Log.WARNING);
            log.setStatus(3);
            log.setSrc("entered wrong password");
            log.setContent("Account entered wrong password");
            logService.insert(log);
            LOGGER.warning("entered wrong password");
            request.getRequestDispatcher("/views/web/changePassword.jsp").forward(request, response);
            return;
        }

        // Kiểm tra tính hợp lệ của thông tin mật khẩu mới
        if (!newPass.equals(confirmPass)) {
            // Nếu mật khẩu mới không khớp, trả về thông báo lỗi
            request.setAttribute("error", "Mật khẩu mới không khớp!");
            request.getRequestDispatcher("/views/web/changePassword.jsp").forward(request, response);
            return;
        }


        // Thực hiện thay đổi mật khẩu
        userService.changePassword(Id, newPass);
        // Nếu thay đổi mật khẩu thành công, chuyển hướng về trang thông báo thành công
        request.setAttribute("success", "Thay đổi mật khẩu thành công");
        log.setLevel(Log.WARNING);
        log.setStatus(3);
        log.setSrc("change password successfully");
        log.setContent("Account has changed password successfully");
        logService.insert(log);
        LOGGER.warning("change password successfully");
        request.getRequestDispatcher("/views/web/changePassword.jsp").forward(request, response);
    }
    }




