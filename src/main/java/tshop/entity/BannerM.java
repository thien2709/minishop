package tshop.entity;

public class BannerM {
	String image;

	public BannerM(String image) {
		this.image = image;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "BannerM [image=" + image + "]";
	}

}
