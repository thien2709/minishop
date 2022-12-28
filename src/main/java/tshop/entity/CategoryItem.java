package tshop.entity;

public class CategoryItem {
	private int cID;
	private String image;
	private String type;

	public CategoryItem() {
		// TODO Auto-generated constructor stub
	}

	public CategoryItem(int cID, String image, String type) {
		this.cID = cID;
		this.image = image;
		this.type = type;
	}

	public int getcID() {
		return cID;
	}

	public void setcID(int cID) {
		this.cID = cID;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "CategoryItem [cID=" + cID + ", image=" + image + ", type=" + type + "]";
	}

}
