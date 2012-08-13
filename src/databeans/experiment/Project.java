package databeans.experiment;

public class Project {
	String pj_id;
	String name;
	String investigator;
	String description;
	
	public String getPj_id() {
		return pj_id;
	}
	public void setPj_id(String pj_id) {
		this.pj_id = pj_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getInvestigator() {
		return investigator;
	}
	public void setInvestigator(String investigator) {
		this.investigator = investigator;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return "Project [pj_id=" + pj_id + ", name=" + name + ", investigator="
				+ investigator + ", description=" + description + "]";
	}
	
	public String toInsertStat() {
		return "Insert into project(pj_id, name, investigator, description) values('" +
				pj_id + "', '" + name + "', '" + investigator + "', '" + description + "');";
	}
}
