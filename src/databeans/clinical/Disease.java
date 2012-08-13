package databeans.clinical;

public class Disease {
	String ds_id;
	String name;
	String type;
	String description;
	
	public String getDs_id() {
		return ds_id;
	}
	public void setDs_id(String ds_id) {
		this.ds_id = ds_id;
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
		return "Disease [ds_id=" + ds_id + ", name=" + name + ", type=" + type
				+ ", description=" + description + "]";
	}
	
	public String toInsertStat() {
		return "Insert into disease(ds_id, name, type, description) values('" + ds_id + "', '" + name + "', '" + type + "', '" + description + "');";
	}
	
}
