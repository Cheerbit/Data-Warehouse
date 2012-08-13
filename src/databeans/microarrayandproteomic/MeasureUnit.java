package databeans.microarrayandproteomic;

public class MeasureUnit {
	String mu_id;
	String name;
	String type;
	String description;
	
	public String getMu_id() {
		return mu_id;
	}
	public void setMu_id(String mu_id) {
		this.mu_id = mu_id;
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
		return "MeasureUnit [mu_id=" + mu_id + ", name=" + name + ", type="
				+ type + ", description=" + description + "]";
	}
	
	public String toInsertStat() {
		return "Insert into measureunit(mu_id, name, type, description) values('" +
				mu_id + "', '" + name + "', '" + type + "', '" + description + "');";
	}
	
}
