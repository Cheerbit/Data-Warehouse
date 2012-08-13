package databeans.gene;

public class Cluster {

	String cl_id;
	String num;
	String pattern;
	String tool;
	String tSetting;
	String description;
	
	public String getCl_id() {
		return cl_id;
	}
	public void setCl_id(String cl_id) {
		this.cl_id = cl_id;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getPattern() {
		return pattern;
	}
	public void setPattern(String pattern) {
		this.pattern = pattern;
	}
	public String getTool() {
		return tool;
	}
	public void setTool(String tool) {
		this.tool = tool;
	}
	public String gettSetting() {
		return tSetting;
	}
	public void settSetting(String tSetting) {
		this.tSetting = tSetting;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return "Cluster [cl_id=" + cl_id + ", num=" + num + ", pattern="
				+ pattern + ", tool=" + tool + ", tSetting=" + tSetting
				+ ", description=" + description + "]";
	}
	
	public String toInsertStat() {
		return "Insert into cluster(cl_id, num, pattern, tool, tSetting, description) values('" +
				cl_id + "', '" + num + "', '" + pattern + "', '" + tool + "', '" + tSetting + "', '" + description + "');";
	}
	
	
}
