package vn.projectLTW.controller.web;

import vn.projectLTW.model.CartItem;
import vn.projectLTW.model.Seller;
import vn.projectLTW.model.Users;
import vn.projectLTW.service.*;
import vn.projectLTW.service.Impl.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = {"/member/orderbuy","/member/orderbuy/cancel","/member/orderbuy/recancel"})
public class OrderBuyerController extends HttpServlet {
    IUserService userService=new UserServiceImpl();
    ICategoryService cateService=new CategoryServiceImpl();
    IProductService productService=new ProductServiceImpl();
    ICartService cartService=new CartServiceImpl();
    ICartItemService cartItemService=new CartItemServiceImpl();
    ISellerService sellerService =new SellerServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");

        //kiểm tra session
        HttpSession session=req.getSession();
        Object obj= session.getAttribute("account");

        Users user=(Users) obj;
        int uid=user.getUserId();
        int sellerId=user.getSellerId();


        Seller seller=sellerService.findOne(sellerId);
        req.setAttribute("seller",seller);
        String indexPage=req.getParameter("index");
        if(indexPage==null){
            indexPage="1";
        }
        int index=Integer.parseInt(indexPage);
        int count=cartItemService.countByUser(uid);

        //chia trang cho count
        int endPage=count/3;
        if(count%3!=0){
            endPage++;
        }
        List<CartItem> listCartItem=cartItemService.findAllByUserPaging(uid,index);
        List<CartItem> listCartItem1=cartItemService.findAllByUser(uid);
        req.setAttribute("listCartItem1",listCartItem1);
        req.setAttribute("listCartItem",listCartItem);
        req.setAttribute("endP",endPage);
        req.setAttribute("tag",index);

        req.setAttribute("all",cartService.countByUser(uid));
        System.out.println("all: "+cartService.countByUser(uid));
        req.setAttribute("choxacnhan",cartService.countByStatus(uid,0));
        req.setAttribute("cholayhang",cartService.countByStatus(uid,1));
        req.setAttribute("choxacnhanhuy",cartService.countByStatus(uid,5));
        req.setAttribute("danggiao",cartService.countByStatus(uid,2));
        req.setAttribute("dagiao",cartService.countByStatus(uid,3));
        req.setAttribute("huy",cartService.countByStatus(uid,4));

        String id=req.getParameter("id");
        String st=req.getParameter("st");//st
        String url=req.getRequestURL().toString();

        if(url.contains("/member/orderbuy/cancel")){
            cartService.updateStatus(id,Integer.parseInt(st));
            req.getRequestDispatcher("/views/web/orderbuy-list.jsp").forward(req, resp);

//            RequestDispatcher dispatcher=req.getRequestDispatcher("member/orderbuy");
//            dispatcher.forward(req,resp);
        }else if(url.contains("recancel")){
            cartService.updateStatus(id,Integer.parseInt(st));
            req.getRequestDispatcher("/views/web/orderbuy-list.jsp").forward(req, resp);

//            RequestDispatcher dispatcher=req.getRequestDispatcher("member/orderbuy");
//            dispatcher.forward(req,resp);
        }else{
            req.getRequestDispatcher("/views/web/orderbuy-list.jsp").forward(req, resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
