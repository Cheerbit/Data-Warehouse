package databeans.gene;

public class Domain {
	
	String dm_id;
	String type;
	String db;
	String accession;
	String title;
	int length;
	String description;
	
	public String getDm_id() {
		return dm_id;
	}
	public void setDm_id(String dm_id) {
		this.dm_id = dm_id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDb() {
		return db;
	}
	public void setDb(String db) {
		this.db = db;
	}
	public String getAccession() {
		return accession;
	}
	public void setAccession(String accession) {
		this.accession = accession;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return "Domain [dm_id=" + dm_id + ", type=" + type + ", db=" + db
				+ ", accession=" + accession + ", title=" + title + ", length="
				+ length + ", description=" + description + "]";
	}
	
	public String toInsertStat() {
		return "Insert into domain(dm_id, type, db, accession, title, length, description) values('" +
				dm_id + "', '" + type + "', '" + db + "', '" + accession + "', '" + title + "', " + length + ", '" + description + "');";
	}
	
}
