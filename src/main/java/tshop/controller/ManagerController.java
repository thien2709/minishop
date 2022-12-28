package tshop.controller;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tshop.entity.CategoryItem;
import tshop.entity.Product;
import tshop.entity.User;
import tshop.service.HomeService;

@WebServlet(urlPatterns = { "/manager" })
public class ManagerController extends HttpServlet {
	private HomeService homeService;

	@Override
	public void init() throws ServletException {
		this.homeService = new HomeService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");
		int sellID = user.getId();

		String indexPage = req.getParameter("index");
		if (Objects.isNull(indexPage)) {
			indexPage = "1";
		}
		int index = Integer.parseInt(indexPage);
		int paging = homeService.getPaging(sellID);
		if (user.getIsAdmin() != 1) {
			List<Product> listProducts = homeService.getProductByIndex(sellID, index);
			req.setAttribute("listProducts", listProducts);
		} else {
			List<Product> listProducts = homeService.getAllProductByAdmin(index);
			req.setAttribute("listProducts", listProducts);
			paging = homeService.getNumberProductByAdmin();
		}

		int endPage = paging / 5;
		if (endPage % 5 != 0) {
			endPage++;
		}

		List<CategoryItem> listCategory = homeService.getAllCategoryItem();

		req.setAttribute("index", index);
		req.setAttribute("listCategory", listCategory);
		req.setAttribute("paging", paging);
		req.setAttribute("endPage", endPage);
		req.getRequestDispatcher("Manager.jsp").forward(req, resp);
	}

}
