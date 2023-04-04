package vn.projectLTW.util;

import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.internet.MimeMessage;
import java.util.Properties;
import java.util.Random;


public class Email {
	private static Email sendEmail;
	private JavaMailSenderImpl mailSender;
	private static final String  fromEmail ="20130474@st.hcmuaf.edu.vn";
	private static final String password="Xuyen28082002";

	private Email(){
		mailSender = new JavaMailSenderImpl();
		mailSender.setHost("smtp.gmail.com");
		mailSender.setPort(587);
		mailSender.setDefaultEncoding("utf-8");
		mailSender.setUsername(fromEmail);
		mailSender.setPassword(password);
		Properties props = mailSender.getJavaMailProperties();
		props.setProperty("mail.mime.charset", "utf-8");
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.debug", "true");
		props.put("session.setDebug", "true");
	}

	public static Email getInstance(){
		if(sendEmail == null)
			return new Email();
		return sendEmail;
	}
	//Hàm mã code ngẫu nhiên
	public static String getRandom() {

		Random rnd=new Random();
		int number=rnd.nextInt(999999);
		return String.format("%06d", number);
	}

	//send email to the user email
	public boolean sendEmail(String toEmail, String text) {
		try {
			MimeMessage mimeMessage = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, false, "utf-8");
			mimeMessage.setSubject("Shop Online");
			mimeMessage.setContent(text, "text/html; charset=utf-8");

			helper.setFrom(fromEmail);
			helper.setTo(toEmail);

			mailSender.send(mimeMessage);
			return true;
		} catch (Exception e) {
			return false;
		}
	}


	public static void main(String[] args) {

		Email.getInstance().sendEmail("ngohuyk80169@gmail.com",Email.getRandom());
	}
}
