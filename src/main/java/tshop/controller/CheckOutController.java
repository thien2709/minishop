package tshop.controller;

import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tshop.entity.Cart;
import tshop.entity.Shipping;
import tshop.entity.User;
import tshop.service.HomeService;
import tshop.service.OderService;

@WebServlet(urlPatterns = { "/checkout" })
public class CheckOutController extends HttpServlet {
	private HomeService homeService;

	@Override
	public void init() throws ServletException {
		this.homeService = new HomeService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		String sID = req.getParameter("sID");
		Shipping shipping = homeService.getShippingBySID(sID);
		double shipPrice = shipping.getPrice();
		HttpSession session = req.getSession();
		double sum = 0;
		if (Objects.nonNull(session.getAttribute("sum"))) {
			sum = (double) session.getAttribute("sum");
		}

		req.setAttribute("sum", sum);
		req.setAttribute("shipPrice", shipPrice);
		req.getRequestDispatcher("Checkout.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");
		Cart cart = (Cart) session.getAttribute("cart");
		OderService oderService = new OderService();
		if (Objects.nonNull(user) && Objects.nonNull(cart)) {
			cart.setUser(user);
			oderService.insertOder(cart);
		}
		// Login mail
		final String username = "learn.java.279@gmail.com";
		final String password = "gxanjnfmuaakufef";
		String firstname = req.getParameter("firstname");
		String emailTo = req.getParameter("email");
		String emailSubject = "Đây là Tshop! xin chào " + firstname;
		int numberOder = oderService.getNumberOder(user.getId());
		String emailContent = "Bạn đã đặt hàng thành công, mã đơn hàng của bạn là: " + numberOder;
		sendMail(username, password, emailTo, emailSubject, emailContent);

		resp.sendRedirect("success");
	}

	private void sendMail(String username, String password, String emailTo, String emailSubject, String emailContent) {
		Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", "587");
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.starttls.enable", "true");
		Session session2 = Session.getInstance(prop, new javax.mail.Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});
		try {
			Message message = new MimeMessage(session2);
			message.setFrom(new InternetAddress(username));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailTo));
			message.setSubject(emailSubject);
			message.setText(emailContent);
			Transport.send(message);
			
			System.out.println("Done");
		} catch (Exception e) {
			e.printStackTrace();
			String resultMessage = "There were an error: " + e.getMessage();
		}
	}
}
