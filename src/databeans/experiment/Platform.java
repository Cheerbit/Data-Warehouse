package databeans.experiment;

public class Platform {
	String pf_id;
	String hardware;
	String software;
	String settings;
	String description;
	
	public String getPf_id() {
		return pf_id;
	}
	public void setPf_id(String pf_id) {
		this.pf_id = pf_id;
	}
	public String getHardware() {
		return hardware;
	}
	public void setHardware(String hardware) {
		this.hardware = hardware;
	}
	public String getSoftware() {
		return software;
	}
	public void setSoftware(String software) {
		this.software = software;
	}
	public String getSettings() {
		return settings;
	}
	public void setSettings(String settings) {
		this.settings = settings;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return "Platform [pf_id=" + pf_id + ", hardware=" + hardware
				+ ", software=" + software + ", settings=" + settings
				+ ", description=" + description + "]";
	}
	
	public String toInsertStat() {
		return "Insert into platform(pf_id, hardware, software, settings, description) values('" +
				pf_id + "', '" + hardware + "', '" + software + "', '" + settings + "', '" + description + "');";
	}
}
