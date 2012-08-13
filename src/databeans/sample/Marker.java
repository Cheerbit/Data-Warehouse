package databeans.sample;

public class Marker {
	String mk_id;
	String name;
	String type;
	String locus;
	String description;
	
	public String getMk_id() {
		return mk_id;
	}
	public void setMk_id(String mk_id) {
		this.mk_id = mk_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getLocus() {
		return locus;
	}
	public void setLocus(String locus) {
		this.locus = locus;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return "Marker [mk_id=" + mk_id + ", name=" + name + ", type=" + type
				+ ", locus=" + locus + ", description=" + description + "]";
	}
	
	public String toInsertStat() {
		return "Insert into marker(mk_id, name, type, locus, description) values('"
				 + mk_id + "', '" + name + "', '" + type + "', '" + locus + "', '" + description + "');";
	}
	
}
