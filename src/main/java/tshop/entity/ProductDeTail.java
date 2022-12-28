package tshop.entity;

public class ProductDeTail extends Product {
	private String image2;
	private String image3;
	private String image4;
	private String image5;
	private int sold;
	private int available;

	public ProductDeTail() {
		// TODO Auto-generated constructor stub
	}

	public ProductDeTail(String image2, String image3, String image4, String image5, int sold, int available) {
		this.image2 = image2;
		this.image3 = image3;
		this.image4 = image4;
		this.image5 = image5;
		this.sold = sold;
		this.available = available;
	}

	public String getImage2() {
		return image2;
	}

	public void setImage2(String image2) {
		this.image2 = image2;
	}

	public String getImage3() {
		return image3;
	}

	public void setImage3(String image3) {
		this.image3 = image3;
	}

	public String getImage4() {
		return image4;
	}

	public void setImage4(String image4) {
		this.image4 = image4;
	}

	public String getImage5() {
		return image5;
	}

	public void setImage5(String image5) {
		this.image5 = image5;
	}

	public int getSold() {
		return sold;
	}

	public void setSold(int sold) {
		this.sold = sold;
	}

	public int getAvailable() {
		return available;
	}

	public void setAvailable(int available) {
		this.available = available;
	}

	@Override
	public String toString() {
		return "ProductDeTail [image2=" + image2 + ", image3=" + image3 + ", image4=" + image4 + ", image5=" + image5
				+ ", sold=" + sold + ", available=" + available + "]";
	}

	@Override
	public int getpID() {
		return super.getpID();
	}

	@Override
	public String getImage() {
		return super.getImage();
	}

	@Override
	public String getDescribe() {
		return super.getDescribe();
	}

	@Override
	public double getPrice() {
		return super.getPrice();
	}

	@Override
	public int getcID() {
		return super.getcID();
	}

	@Override
	public int getSellID() {
		return super.getSellID();
	}

}
