package vn.projectLTW.controller.web;

import vn.projectLTW.model.Log;
import vn.projectLTW.service.ILogService;
import vn.projectLTW.service.IUserService;
import vn.projectLTW.service.Impl.LogServiceImpl;
import vn.projectLTW.service.Impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.logging.Logger;

@WebServlet(name = "ChangeProfile", value = "/ChangeProfile")
public class ChangeProfile extends HttpServlet {
    IUserService userService = new UserServiceImpl();
    ILogService logService=new LogServiceImpl();
    Log log = new Log(Log.INFO,"","","",1);
    static final Logger LOGGER= Logger.getLogger(HomeController.class.getName());

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/views/web/myaccount.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String fullname = request.getParameter("fullname");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
//        String province = request.getParameter("province");
//        String district = request.getParameter("district");
//        String address = request.getParameter("address");
        int Id = Integer.parseInt(request.getParameter("Id"));
        userService.changeProfile(Id,fullname,email,phone);
//        userService.changeProfile(Id,fullname,email,phone,province,district,address);
        request.setAttribute("success", "Thay đổi thành công");
        request.getRequestDispatcher("/views/web/myaccount.jsp").forward(request, response);
    }
}
