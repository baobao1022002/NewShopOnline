package vn.projectLTW.controller.web;

import vn.projectLTW.model.*;
import vn.projectLTW.service.*;
import vn.projectLTW.service.Impl.*;
import vn.projectLTW.util.RandomUUID;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;


@WebServlet (urlPatterns = {"/checkout-cart","/checkout"})
public class CheckoutController extends HttpServlet {
        IUserService userService=new UserServiceImpl();
        ICartService cartService=new CartServiceImpl();
        ICartItemService cartItemService=new CartItemServiceImpl();

        long time=System.currentTimeMillis();



        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

            req.getRequestDispatcher("/views/web/checkout.jsp").forward(req, resp);
        }
    @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //kiểm tra session
        resp.setContentType("text/html; charset=UTF-8");
        req.setCharacterEncoding("UTF-8");
        HttpSession session=req.getSession();
        Object obj= session.getAttribute("account");
        Users buyer=(Users) obj;

        // lưu dữ liệu vào cart
        Cart cart=new Cart();
        String buyerName = req.getParameter("buyerName");
        String buyerEmail = req.getParameter("buyerEmail");
        String buyerPhone = req.getParameter("buyerPhone");
        String address = req.getParameter("address");
        String province = req.getParameter("province");
        String district = req.getParameter("district");
        String payment = req.getParameter("payment");

        cart.setBuyer(buyer);
        cart.setBuyDate(new java.sql.Date(time));
        cart.setCartId(RandomUUID.getRandomID());
        cart.setStatus(0);
        cart.setBuyerName(buyerName);
        cart.setBuyerEmail(buyerEmail);
        cart.setBuyerPhone(buyerPhone);
        cart.setAddress(address);
        cart.setProvince(province);
        cart.setDistrict(district);
        cart.setPayment(payment);

        cartService.insert( cart);

        //thiết lập session cho cart
        Object objCart=session.getAttribute("cart");
        if(obj!=null){
            //ep ve dung kieu cua no khi them vao o phan them vao gio hang controller
            @SuppressWarnings("unchecked")
            Map<Integer, CartItem> map=(Map<Integer, CartItem>) objCart;
            //lưu dữ liệu vào cartItem
            for(CartItem cartItem:map.values()){
                cartItem.setCart(cart);
                cartItem.setCartItemId(RandomUUID.getRandomID());
                //SendMail sm=new SendMail();
                //sm.sendMail(cart.getBuyer().getEmail(),"Shopping.iotstar","Nội dung!");
                cartItemService.insert(cartItem);
            }
        }
        //bỏ session cart
        session.removeAttribute("cart");
            resp.sendRedirect(req.getContextPath() + "/home");
    }
        }


