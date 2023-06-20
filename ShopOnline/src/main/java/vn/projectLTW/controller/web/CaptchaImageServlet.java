package vn.projectLTW.controller.web;

import vn.projectLTW.util.CaptchaGenerator;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

@WebServlet("/captchaImage")
public class CaptchaImageServlet extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("image/png");

        BufferedImage captchaImage = CaptchaGenerator.generateCaptchaImage();
        OutputStream outputStream = response.getOutputStream();
        ImageIO.write(captchaImage, "png", outputStream);

        outputStream.close();
    }


}
