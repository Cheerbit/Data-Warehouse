package databeans.sample;

public class Assay {
	String as_id;
	String name;
	String type;
	String setting;
	String description;
	
	public String getAs_id() {
		return as_id;
	}
	public void setAs_id(String as_id) {
		this.as_id = as_id;
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
	public String getSetting() {
		return setting;
	}
	public void setSetting(String setting) {
		this.setting = setting;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return "Assay [as_id=" + as_id + ", name=" + name + ", type=" + type
				+ ", setting=" + setting + ", description=" + description + "]";
	}
	
	public String toInsertStat() {
		return "Insert into assay(as_id, name, type, setting, description) values('"
		+ as_id + "', '" + name + "', '" + type + "', '" + setting + "', '" + description + "');";
	}
}
