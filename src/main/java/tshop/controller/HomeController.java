package tshop.controller;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tshop.entity.Banner;
import tshop.entity.BannerC;
import tshop.entity.BannerM;
import tshop.entity.CategoryItem;
import tshop.entity.KeySearch;
import tshop.entity.Product;
import tshop.service.HomeService;

@WebServlet(urlPatterns = { "/home"})
public class HomeController extends HttpServlet {
	private HomeService homeService;

	@Override
	public void init() throws ServletException {
		this.homeService = new HomeService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Banner> listBannerL = homeService.getAllBannerL();
		req.setAttribute("listBannerL", listBannerL);

		int nBannerL = homeService.getNumberBannerL();
		req.setAttribute("nBannerL", nBannerL);

		List<BannerM> listBannerM = homeService.getAllBannerM();
		req.setAttribute("listBannerM", listBannerM);

		List<BannerC> listBannerC = homeService.getAllBannerC();
		req.setAttribute("listBannerC", listBannerC);

		List<Product> listProduct = homeService.getAllProduct();
		req.setAttribute("listProduct", listProduct);

		List<CategoryItem> listCategory = homeService.getAllCategoryItem();
		req.setAttribute("listCategory", listCategory);

		RequestDispatcher dispatcher = req.getRequestDispatcher("Home.jsp");
		dispatcher.forward(req, resp);
	}

}
