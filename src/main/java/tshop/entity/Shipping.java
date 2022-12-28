package tshop.entity;

public class Shipping {
	private int sID;
	private String name;
	private double price;

	public Shipping() {
		// TODO Auto-generated constructor stub
	}

	public Shipping(int sID, String name, double price) {
		this.sID = sID;
		this.name = name;
		this.price = price;
	}

	public int getsID() {
		return sID;
	}

	public void setsID(int sID) {
		this.sID = sID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Shipping [sID=" + sID + ", name=" + name + ", price=" + price + "]";
	}

}
