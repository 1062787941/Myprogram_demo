package daomain;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Publish implements Serializable{
	
	private int publisherID;
	private String publisherNam;
	
	
	public Publish(int publisherID, String publisherNam) {
		super();
		this.publisherID = publisherID;
		this.publisherNam = publisherNam;
	}
	
	public Publish() {
		super();
	}

	public int getPublisherID() {
		return publisherID;
	}
	public void setPublisherID(int publisherID) {
		this.publisherID = publisherID;
	}
	public String getPublisherNam() {
		return publisherNam;
	}
	public void setPublisherNam(String publisherNam) {
		this.publisherNam = publisherNam;
	}
	
	
	
	
}
