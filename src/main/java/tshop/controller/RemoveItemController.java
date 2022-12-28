package tshop.controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tshop.entity.Cart;
import tshop.entity.CartItem;
import tshop.entity.Product;
import tshop.entity.Shipping;
import tshop.service.HomeService;

@WebServlet(urlPatterns = { "/remove-item" })
public class RemoveItemController extends HttpServlet {
	private HomeService homeService;

	@Override
	public void init() throws ServletException {
		this.homeService = new HomeService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		Cart cart = (Cart) session.getAttribute("cart");
		List<CartItem> list = cart.getItems();
		String pID = req.getParameter("pid");
		Product product = homeService.getProductByID(pID);
		int total = (int) session.getAttribute("total");

		Iterator<CartItem> litr = list.listIterator();
		while (litr.hasNext()) {
			CartItem cartItem = litr.next();
			if (cartItem.getProduct().getpID() == product.getpID()) {
				litr.remove();
				total = total - cartItem.getQuantity();
			}
		}
		if (total == 0) {
			session.removeAttribute("total");
		} else {
			session.setAttribute("total", total);
		}
		cart.setItems(list);
		double sum = 0;
		for (CartItem cartItem : list) {
			sum += cartItem.getProduct().getPrice() * cartItem.getQuantity();
		}

		session.setAttribute("sum", sum);
		session.setAttribute("cart", cart);
		
		List<Shipping> listShipping = homeService.getAllShipping();
		req.setAttribute("listShipping", listShipping);

		req.getRequestDispatcher("Cart.jsp").forward(req, resp);
	}
}
