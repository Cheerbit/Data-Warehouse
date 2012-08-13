package databeans.experiment;

public class Experiment {
	String e_id;
	String name;
	String type;
	
	public String getE_id() {
		return e_id;
	}
	public void setE_id(String e_id) {
		this.e_id = e_id;
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
	
	@Override
	public String toString() {
		return "Experiment [e_id=" + e_id + ", name=" + name + ", type=" + type
				+ "]";
	}
	
	public String toInsertStat() {
		return "Insert into experiment(e_id, name, type) values('" +
				e_id + "', '" + name + "', '" + type + "');";
	}
	
}
