package tshop.entity;

public class BannerC {
	private String image;
	private String title;

	public BannerC() {
	}

	public BannerC(String image, String title) {
		this.image = image;
		this.title = title;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "BannerItem [image=" + image + ", title=" + title + "]";
	}

}
