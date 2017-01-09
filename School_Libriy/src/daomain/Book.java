package daomain;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class Book implements Serializable {
	
	private String isbn;
	
	private int publishId;
	
	private String publishName;
	
	private String title;
	
	private int editionNumber;
	
	private String copyright;
	
	private String imageFile;

	private double price;
	
	private int[] authorIds;

	public int getPublishId() {
		return publishId;
	}

	public void setPublishId(int publishId) {
		this.publishId = publishId;
	}

	public String getPublishName() {
		return publishName;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public void setPublishName(String publishName) {
		this.publishName = publishName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getEditionNumber() {
		return editionNumber;
	}

	public void setEditionNumber(int editionNumber) {
		this.editionNumber = editionNumber;
	}

	public String getCopyright() {
		return copyright;
	}

	public void setCopyright(String copyright) {
		this.copyright = copyright;
	}

	public String getImageFile() {
		return imageFile;
	}

	public void setImageFile(String imageFile) {
		this.imageFile = imageFile;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int[] getAuthorIds() {
		return authorIds;
	}

	public void setAuthorIds(int[] authorIds) {
		this.authorIds = authorIds;
	}
	
	

}
