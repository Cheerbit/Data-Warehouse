package databeans.sample;

public class Term {
	String tm_id;
	String name;
	String type;
	String setting;
	
	public String getTm_id() {
		return tm_id;
	}

	public void setTm_id(String tm_id) {
		this.tm_id = tm_id;
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
	
	@Override
	public String toString() {
		return "Term [tm_id=" + tm_id + ", name=" + name + ", type=" + type
				+ ", setting=" + setting + "]";
	}

	public String toInsertStat() {
		return "Insert into term(tm_id, name, type, setting) values('" 
		+ tm_id + "', '" + name + "', '" + type + "', '" + setting + "');";
		
	}
}
