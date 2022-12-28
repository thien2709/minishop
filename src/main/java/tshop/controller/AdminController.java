package tshop.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tshop.entity.User;
import tshop.service.AdminService;

@WebServlet(urlPatterns = { "/admin" })
public class AdminController extends HttpServlet {
	private AdminService adminService;

	@Override
	public void init() throws ServletException {
		this.adminService = new AdminService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<User> listUser = adminService.getAllUser();

		req.setAttribute("listUser", listUser);
		req.getRequestDispatcher("Admin.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userID = req.getParameter("userID");
		String isSell = req.getParameter("isSell");
		String enable = req.getParameter("enable");
		if (isSell == null) {
			adminService.offIsSell(userID);
		} else {
			adminService.onIsSell(userID);
		}
		if (enable == null) {
			adminService.offEnable(userID);
		} else {
			adminService.onEnable(userID);
		}

		resp.sendRedirect("admin");
	}
}
