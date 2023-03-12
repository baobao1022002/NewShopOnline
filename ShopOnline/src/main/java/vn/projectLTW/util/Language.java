package vn.projectLTW.util;

import java.util.HashMap;
import java.util.Map;

public class Language {
    public Map<String,String> englishLanguage(){
        Map<String,String> map = new HashMap<>();
        map.put("home","Home");
        map.put("products","Products");
        map.put("login","Login");
        map.put("register","Register");
        map.put("search","Search");
        map.put("english","English");
        map.put("vietnamese","Vietnamese");
        map.put("viewcart","View cart");
        map.put("checkout","Check out");
        map.put("items","Items");
        map.put("logout","Logout");
        map.put("account","My Account");

        map.put("username","User name");
        map.put("password","Password");
        map.put("email","Email");
        map.put("fullname","Full name");
        map.put("confirmpassword","Confirm password");
        map.put("remember","Remember me");
        map.put("forgotpassword","Forgot password");

        map.put("newproducts","New Products");
        map.put("zoom","Zoom");
        map.put("view","View");
        map.put("addtocart","Add to cart");
        map.put("category","Category");
        map.put("shop","Shop");
        map.put("passwordretrieval","Password retrieval");
        map.put("inventory","Quantity in stock");
        map.put("size","Size");
        map.put("color","Color");
        map.put("seedetails","See details");


        return map;

    }

    public Map<String,String> vietnameseLanguage(){
        Map<String,String> map = new HashMap<>();
        map.put("home","Trang chủ");
        map.put("products","Sản phẩm");
        map.put("login","Đăng nhập");
        map.put("register","Đăng kí");
        map.put("search","Tìm kiếm");
        map.put("english","Tiếng Anh");
        map.put("vietnamese","Việt Nam");
        map.put("viewcart","Xem giỏ hàng");
        map.put("checkout","Thanh toán");
        map.put("items","Sản phẩm");
        map.put("logout","Đăng xuất");
        map.put("account","Tài khoản");

        map.put("username","Tên đăng nhập");
        map.put("password","Mật khẩu");
        map.put("remember","Lưu đăng nhập");
        map.put("forgotpassword", "Quên mật khẩu");
        map.put("fullname","Họ và tên");
        map.put("confirmpassword","Nhập lại mật khẩu");
        map.put("remember","Lưu đăng nhập");

        map.put("newproducts","Sản phẩm mới");
        map.put("zoom","Phóng to");
        map.put("view","Xem");
        map.put("addtocart","Thêm vào giỏ hàng");
        map.put("category","Loại");
        map.put("shop","Cửa hàng");
        map.put("passwordretrieval","Lấy lại mật khẩu");
        map.put("inventory","Số lượng tồn");
        map.put("size","Kích cỡ");
        map.put("color","Màu sắc");
        map.put("seedetails","Xem chi tiết");


        return map;

    }

}
