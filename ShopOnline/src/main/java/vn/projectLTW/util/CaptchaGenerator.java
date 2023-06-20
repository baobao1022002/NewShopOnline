package vn.projectLTW.util;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class CaptchaGenerator {
    private static final int CAPTCHA_WIDTH = 200;
    private static final int CAPTCHA_HEIGHT = 50;
    private static final int CAPTCHA_LENGTH = 6;
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
    private static String captchaText;
    public static BufferedImage generateCaptchaImage() {

        BufferedImage image = new BufferedImage(CAPTCHA_WIDTH, CAPTCHA_HEIGHT, BufferedImage.TYPE_INT_RGB);
        Graphics graphics = image.getGraphics();

        Random random = new Random();

        // Đổ nền màu trắng
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, CAPTCHA_WIDTH, CAPTCHA_HEIGHT);

        // Tạo ký tự ngẫu nhiên
//        String captchaText = generateRandomCaptcha();
        captchaText = generateRandomCaptcha(); // Cập nhật biến captchaText
        // Vẽ ký tự lên ảnh
        for (int i = 0; i < CAPTCHA_LENGTH; i++) {
            int x = 20 + (i * 30);
            int y = 30 + random.nextInt(10);
            graphics.setColor(new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256)));
            graphics.setFont(new Font("Arial", Font.BOLD, 30));
            graphics.drawString(String.valueOf(captchaText.charAt(i)), x, y);
        }

        graphics.dispose();

        return image;
    }

    public static String generateRandomCaptcha() {
        StringBuilder captchaText = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < CAPTCHA_LENGTH; i++) {
            int randomIndex = random.nextInt(CHARACTERS.length());
            char randomChar = CHARACTERS.charAt(randomIndex);
            captchaText.append(randomChar);
        }

        return captchaText.toString();
    }
    public static String getCaptchaText() {
        return captchaText;
    }

}
