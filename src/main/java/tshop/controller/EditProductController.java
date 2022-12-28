package tshop.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import tshop.entity.CategoryItem;
import tshop.entity.Product;
import tshop.entity.User;
import tshop.service.HomeService;

@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 5, maxFileSize = 1024 * 1024 * 10, maxRequestSize = 1024 * 1024 * 50)
@WebServlet(urlPatterns = { "/edit-product" })
public class EditProductController extends HttpServlet {
	private HomeService homeService;

	@Override
	public void init() throws ServletException {
		this.homeService = new HomeService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		Product product = homeService.getProductByID(id);
		String cID = req.getParameter("cID");
		CategoryItem categoryItem = homeService.getCategoryByCID(cID);

		List<CategoryItem> listCategory = homeService.getAllCategoryItem();

		req.setAttribute("categoryItem", categoryItem);
		req.setAttribute("product", product);
		req.setAttribute("listCategory", listCategory);

		req.getRequestDispatcher("LoadProduct.jsp").forward(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");
		int sellID = user.getId();

		try {
			String id = req.getParameter("id");
			String describe = req.getParameter("describe");
			String pricee = req.getParameter("price");
			String cidd = req.getParameter("cID");
			double price = Double.parseDouble(pricee);
			int cid = Integer.parseInt(cidd);
			Part part = req.getPart("image");
			System.out.println(part.toString());

			String realPath = req.getServletContext().getRealPath("/client/img/product");
			String fileName = Paths.get(part.getSubmittedFileName()).getFileName().toString();
			if (!fileName.isBlank()) {
				part.write(realPath + "/" + fileName);
			}
			System.out.println(fileName);

			homeService.updateProduct(id, fileName, describe, price, cid, sellID);

		} catch (Exception e) {
			// TODO: handle exception
		}
		resp.sendRedirect("manager");
	}

}
