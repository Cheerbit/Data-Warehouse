package databeans.clinical;

public class Drug {
	String dr_id;
	String name;
	String type;
	String description;
	
	public String getDr_id() {
		return dr_id;
	}
	public void setDr_id(String dr_id) {
		this.dr_id = dr_id;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return "Drug [dr_id=" + dr_id + ", name=" + name + ", type=" + type
				+ ", description=" + description + "]";
	}
	
	public String toInsertStat() {
		return "Insert into drug(dr_id, name, type, description) values('" + dr_id + "', '" + name +"', '" + type + "', '" + description + "');";
	}
	
}	
