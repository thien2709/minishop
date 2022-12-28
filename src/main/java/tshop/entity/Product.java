package tshop.entity;

public class Product {
	private int pID;
	private String image;
	private String describe;
	private double price;
	private int cID;
	private int sellID;

	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Product(int pID, String image, String describe, double price, int cID, int sellID) {
		super();
		this.pID = pID;
		this.image = image;
		this.describe = describe;
		this.price = price;
		this.cID = cID;
		this.sellID = sellID;
	}

	public int getpID() {
		return pID;
	}

	public void setpID(int pID) {
		this.pID = pID;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getDescribe() {
		return describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getcID() {
		return cID;
	}

	public void setcID(int cID) {
		this.cID = cID;
	}

	public int getSellID() {
		return sellID;
	}

	public void setSellID(int sellID) {
		this.sellID = sellID;
	}

	@Override
	public String toString() {
		return "Product [pID=" + pID + ", image=" + image + ", describe=" + describe + ", price=" + price + ", cID="
				+ cID + ", sellID=" + sellID + "]";
	}

}
