package databeans.experiment;

public class Norm {
	String nm_id;
	String type;
	String software;
	String parameters;
	String description;
	
	public String getNm_id() {
		return nm_id;
	}
	public void setNm_id(String nm_id) {
		this.nm_id = nm_id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSoftware() {
		return software;
	}
	public void setSoftware(String software) {
		this.software = software;
	}
	public String getParameters() {
		return parameters;
	}
	public void setParameters(String parameters) {
		this.parameters = parameters;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return "Norm [nm_id=" + nm_id + ", type=" + type + ", software="
				+ software + ", parameters=" + parameters + ", description="
				+ description + "]";
	}
	
	public String toInsertStat() {
		return "Insert into norm(nm_id, type, software, parameters, description) values('" +
				nm_id + "', '" + type + "', '" + software + "', '" + parameters + "', '" + description + "');";
	}
}
