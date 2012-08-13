package databeans.gene;

public class Promoter {
	String pm_id;
	String type;
	String sequence;
	int length;
	String description;
	public String getPm_id() {
		return pm_id;
	}
	public void setPm_id(String pm_id) {
		this.pm_id = pm_id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSequence() {
		return sequence;
	}
	public void setSequence(String sequence) {
		this.sequence = sequence;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return "Promoter [pm_id=" + pm_id + ", type=" + type + ", sequence="
				+ sequence + ", length=" + length + ", description="
				+ description + "]";
	}
	
	public String toInsertStat() {
		return "Insert into promoter(pm_id, type, sequence, length, description) values('" +
				 pm_id + "', '" + type + "', '" + sequence + "', " + length + ", '" + description + "');";
	}
	
}
