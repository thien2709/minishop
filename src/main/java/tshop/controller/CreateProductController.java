package tshop.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import tshop.entity.User;
import tshop.service.HomeService;

@MultipartConfig(
        fileSizeThreshold   = 1024 * 1024 * 5,
        maxFileSize         = 1024 * 1024 * 10,
        maxRequestSize      = 1024 * 1024 * 50
)
@WebServlet(urlPatterns = { "/create-product" })

public class CreateProductController extends HttpServlet {
	private HomeService homeService;

	@Override
	public void init() throws ServletException {
		this.homeService = new HomeService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.sendRedirect(req.getContextPath() + "/Manager.jsp");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");
		int sellID = user.getId();
		
		try {
			String describe = req.getParameter("describe");
			String pricee = req.getParameter("price");
			String cidd = req.getParameter("cID");
			double price = Double.parseDouble(pricee);
			int cid = Integer.parseInt(cidd);
			Part part = req.getPart("image");

			String realPath = req.getServletContext().getRealPath("/client/img/product");
			String fileName = Paths.get(part.getSubmittedFileName()).getFileName().toString();
			if(!fileName.isBlank()) {
				part.write(realPath + "/" + fileName);
			}
			System.out.println(describe);
			System.out.println(price);
			System.out.println(cid);
			
			homeService.insertProduct(fileName, describe, price, cid, sellID);

		} catch (Exception e) {
			// TODO: handle exception
		}

		resp.sendRedirect("manager");
	}
}
