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

import tshop.entity.Cart;
import tshop.entity.CartItem;
import tshop.entity.Product;
import tshop.service.HomeService;

@WebServlet(urlPatterns = { "/pay" })
public class PayController extends HttpServlet {
	private HomeService homeService;

	@Override
	public void init() throws ServletException {
		this.homeService = new HomeService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int quantity = 1;
		double sum = 0;
		int total = 0;
		String pID = req.getParameter("pid");
		Product product = homeService.getProductByID(pID);
		if (Objects.nonNull(product)) {
			HttpSession session = req.getSession();
			if (Objects.isNull(session.getAttribute("cart"))) {
				Cart cart = new Cart();
				List<CartItem> list = new ArrayList<>();
				CartItem cartItem = new CartItem();
				cartItem.setProduct(product);
				cartItem.setPrice(product.getPrice());
				cartItem.setQuantity(quantity);
				list.add(cartItem);
				cart.setItems(list);
				session.setAttribute("cart", cart);
				for (CartItem o : cart.getItems()) {
					total += o.getQuantity();
				}
				session.setAttribute("total", total);
				for (CartItem o : list) {
					sum += o.getProduct().getPrice() * o.getQuantity();
				}
				session.setAttribute("sum", sum);
			} else {
				Cart cart = (Cart) session.getAttribute("cart");
				List<CartItem> list = cart.getItems();
				boolean check = false;
				for (CartItem cartItem : list) {
					if (cartItem.getProduct().getpID() == product.getpID()) {
						cartItem.setQuantity(cartItem.getQuantity() + 1);
						check = true;
					}
				}
				if (check == false) {
					CartItem cartItem = new CartItem();
					cartItem.setProduct(product);
					cartItem.setPrice(product.getPrice());
					cartItem.setQuantity(quantity);
					list.add(cartItem);
					cart.setItems(list);
				}
				session.setAttribute("cart", cart);
				for (CartItem o : cart.getItems()) {
					total += o.getQuantity();
					session.setAttribute("total", total);
				}
				for (CartItem o : list) {
					sum += o.getProduct().getPrice() * o.getQuantity();
				}
				session.setAttribute("sum", sum);
			}
			resp.sendRedirect("cart");
		} else {
			resp.sendRedirect("cart");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
