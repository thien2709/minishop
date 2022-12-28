package tshop.entity;

import java.util.List;

public class Cart {
	private int cartID;
	private User user;
	private List<CartItem> items;
	private int status;

	public Cart() {
		// TODO Auto-generated constructor stub
	}

	public Cart(int cartID, User user, List<CartItem> items, int status) {
		this.cartID = cartID;
		this.user = user;
		this.items = items;
		this.status = status;
	}

	public int getCartID() {
		return cartID;
	}

	public void setCartID(int cartID) {
		this.cartID = cartID;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<CartItem> getItems() {
		return items;
	}

	public void setItems(List<CartItem> items) {
		this.items = items;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Cart [cartID=" + cartID + ", user=" + user + ", items=" + items + ", status=" + status + "]";
	}

}
