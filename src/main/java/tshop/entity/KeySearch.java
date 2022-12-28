package tshop.entity;

public class KeySearch {
	private String keyWord;

	public KeySearch(String keyWord) {
		this.keyWord = keyWord;
	}

	public String getKeyWord() {
		return keyWord;
	}

	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}

	@Override
	public String toString() {
		return "KeySearch [keyWord=" + keyWord + "]";
	}

}
