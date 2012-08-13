package databeans.microarrayandproteomic;

public class Probe {
	String pb_id;
	String UID;
	String name;
	String description;
	boolean isQC;
	
	public String getPb_id() {
		return pb_id;
	}
	public void setPb_id(String pb_id) {
		this.pb_id = pb_id;
	}
	public String getUID() {
		return UID;
	}
	public void setUID(String uID) {
		UID = uID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isQC() {
		return isQC;
	}
	public void setQC(boolean isQC) {
		this.isQC = isQC;
	}
	
	@Override
	public String toString() {
		return "Probe [pb_id=" + pb_id + ", UID=" + UID + ", name=" + name
				+ ", description=" + description + ", isQC=" + isQC + "]";
	}
	
	public String toInsertStat() {
		return "Insert into probe(pb_id, UID, name, description, isQC) values('" 
		+ pb_id + "', '" + UID + "', '" + name + "', '" + description + "'," + isQC + ");";
	}
}
