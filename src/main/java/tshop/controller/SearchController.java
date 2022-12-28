package tshop.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tshop.entity.KeySearch;
import tshop.entity.Product;
import tshop.entity.User;
import tshop.service.HomeService;

@WebServlet(urlPatterns = { "/search" })
public class SearchController extends HttpServlet {
	private HomeService homeService;

	@Override
	public void init() throws ServletException {
		this.homeService = new HomeService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");
		String keyword = req.getParameter("keyword");

		if (Objects.nonNull(keyword)) {
			if (Objects.nonNull(user)) {
				int uID = homeService.getUID(user.getUser());
				List<KeySearch> listkKeySearchs = homeService.getKeySearchByUID(uID);
				int check = homeService.checkKeySearch(keyword, uID);
				if (check == 0) {
					homeService.insertKeySearch(uID, keyword);
					KeySearch keySearch = new KeySearch(keyword);
					listkKeySearchs.add(keySearch);
					session.setAttribute("listKeySearch", listkKeySearchs);
				} else {
					session.setAttribute("listKeySearch", listkKeySearchs);
				}
			}

			List<Product> listP = homeService.getAllProductByName(keyword);
			req.setAttribute("listP", listP);
		}
		
		if(Objects.nonNull(req.getParameter("cID"))) {
			List<Product> listP = homeService.searchProductByCID(req.getParameter("cID"));
			req.setAttribute("listP", listP);
		}

		req.getRequestDispatcher("Search.jsp").forward(req, resp);
	}

}
