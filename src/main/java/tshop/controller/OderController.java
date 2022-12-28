package tshop.controller;

import java.io.IOException;
import java.util.Objects;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tshop.entity.Cart;
import tshop.entity.CartItem;
import tshop.entity.Product;
import tshop.entity.ProductDeTail;
import tshop.entity.User;
import tshop.service.HomeService;
import tshop.service.OderService;

@WebServlet(urlPatterns = "/success")
public class OderController extends HttpServlet {
	private OderService oderService;

	@Override
	public void init() throws ServletException {
		this.oderService = new OderService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");
		Cart cart = (Cart) session.getAttribute("cart");
		for (CartItem cartItem : cart.getItems()) {
			oderService.updateProductDetail(cartItem.getQuantity(), cartItem.getProduct().getpID());
		}
		session.removeAttribute("total");
		session.removeAttribute("sum");
		session.removeAttribute("cart");
		
		int numberOder = oderService.getNumberOder(user.getId());
		req.setAttribute("numberOder", numberOder);
		req.getRequestDispatcher("Success.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
}
