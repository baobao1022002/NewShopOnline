package vn.projectLTW.controller.web;


import vn.projectLTW.model.Cart;
import vn.projectLTW.model.CartItem;
import vn.projectLTW.model.Users;
import vn.projectLTW.service.ICartItemService;
import vn.projectLTW.service.ICartService;
import vn.projectLTW.service.IUserService;
import vn.projectLTW.service.Impl.CartItemServiceImpl;
import vn.projectLTW.service.Impl.CartServiceImpl;
import vn.projectLTW.service.Impl.UserServiceImpl;
import vn.projectLTW.util.RandomUUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = {"/member/order"})
public class OrderController extends HttpServlet {
    IUserService userService=new UserServiceImpl();
    ICartService cartService=new CartServiceImpl();
    ICartItemService cartItemService=new CartItemServiceImpl();

    long time=System.currentTimeMillis();



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");

        //kiểm tra session
        HttpSession session=req.getSession();
        Object obj= session.getAttribute("account");
        Users buyer=(Users) obj;
        // lưu dữ liệu vào cart
        Cart cart=new Cart();
        cart.setBuyer(buyer);
        cart.setBuyDate(new java.sql.Date(time));
        cart.setCartId(RandomUUID.getRandomID());
        cart.setStatus(0);

        cartService.insert(cart);

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
        resp.sendRedirect(req.getContextPath()+"/home");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
