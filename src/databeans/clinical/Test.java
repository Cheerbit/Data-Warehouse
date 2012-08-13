package databeans.clinical;

public class Test {
	String tt_id;
	String name;
	String type;
	String setting;
	
	public String getTt_id() {
		return tt_id;
	}
	public void setTt_id(String tt_id) {
		this.tt_id = tt_id;
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
		return "Test [tt_id=" + tt_id + ", name=" + name + ", type=" + type
				+ ", setting=" + setting + "]";
	}
	
	public String toInsertStat() {
		return "Insert into test(tt_id, name, type, setting) values('" + tt_id + "', '" + name + "', '" + type + "', '" + setting + "');";
	}
}
