package tshop.controller;

import java.io.IOException;
import java.util.Objects;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tshop.entity.Cart;
import tshop.entity.User;
import tshop.service.HomeService;

@WebServlet(urlPatterns = { "/login" })
public class LoginController extends HttpServlet {
	private HomeService homeService;

	@Override
	public void init() throws ServletException {
		homeService = new HomeService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.sendRedirect(req.getContextPath() + "/Login.jsp");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userName = req.getParameter("username");
		String passWord = req.getParameter("password");
		User user = homeService.checkLogin(userName, passWord);

		if (Objects.nonNull(user)) {
			if (user.getEnable() == 0) {
				
				resp.sendRedirect("Login.jsp");
			} else {
				HttpSession httpSession = req.getSession();
				httpSession.setAttribute("user", user);
				resp.sendRedirect(req.getContextPath() + "/home");
			}
		} else {
			resp.sendRedirect("login");
		}
	}
}
