package databeans.experiment;

import java.sql.Date;

public class Publication {
	String pu_id;
	String pub_med_id;
	String title;
	String authors;
	String abstractString;
	Date pubDate;
	
	public String getPu_id() {
		return pu_id;
	}
	public void setPu_id(String pu_id) {
		this.pu_id = pu_id;
	}
	public String getPub_med_id() {
		return pub_med_id;
	}
	public void setPub_med_id(String pub_med_id) {
		this.pub_med_id = pub_med_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthors() {
		return authors;
	}
	public void setAuthors(String authors) {
		this.authors = authors;
	}
	public String getAbstractString() {
		return abstractString;
	}
	public void setAbstractString(String abstractString) {
		this.abstractString = abstractString;
	}
	public Date getPubDate() {
		return pubDate;
	}
	public void setPubDate(Date pubDate) {
		this.pubDate = pubDate;
	}
	
	@Override
	public String toString() {
		return "Publication [pu_id=" + pu_id + ", pub_med_id=" + pub_med_id
				+ ", title=" + title + ", authors=" + authors
				+ ", abstractString=" + abstractString + ", pubDate=" + pubDate
				+ "]";
	}
	
	public String toInsertStat() {
		return "Insert into publication(pu_id, pub_med_id, title, authors, abstract, pubDate) values('" +
				pu_id + "', '" + pub_med_id + "', '" + title + "', '" + authors + "', '" + abstractString + "', '" + pubDate + "');";
	}
}
