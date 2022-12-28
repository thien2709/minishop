package tshop.entity;

public class CartItem {
	private int cIID;
	private Product product;
	private double price;
	private int quantity;

	public CartItem() {
		// TODO Auto-generated constructor stub
	}

	public CartItem(int cIID, Product product, double price, int quantity) {
		this.cIID = cIID;
		this.product = product;
		this.price = price;
		this.quantity = quantity;
	}

	public int getcIID() {
		return cIID;
	}

	public void setcIID(int cIID) {
		this.cIID = cIID;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "CartItem [cIID=" + cIID + ", product=" + product + ", price=" + price + ", quantity=" + quantity + "]";
	}

}
