package databeans.gene;

public class Go {
	String go_id;
	String accession;
	String type;
	String name;
	String definition;
	
	public String getGo_id() {
		return go_id;
	}
	public void setGo_id(String go_id) {
		this.go_id = go_id;
	}
	public String getAccession() {
		return accession;
	}
	public void setAccession(String accession) {
		this.accession = accession;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDefinition() {
		return definition;
	}
	public void setDefinition(String definition) {
		this.definition = definition;
	}
	@Override
	public String toString() {
		return "Go [go_id=" + go_id + ", accession=" + accession + ", type="
				+ type + ", name=" + name + ", definition=" + definition + "]";
	}

	public String toInsertStat() {
		return "Insert into go(go_id, accession, type, name, definition) values('" +
				go_id + "', '" + accession + "', '" + type + "', '" + name + "', '" + definition + "');";
	}
	
	
}
