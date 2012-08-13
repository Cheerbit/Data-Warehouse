package databeans.experiment;

public class Protocal {
	String pt_id;
	String name;
	String text;
	String createdby;
	public String getPt_id() {
		return pt_id;
	}
	public void setPt_id(String pt_id) {
		this.pt_id = pt_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getCreatedby() {
		return createdby;
	}
	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}
	
	@Override
	public String toString() {
		return "Protocal [pt_id=" + pt_id + ", name=" + name + ", text=" + text
				+ ", createdby=" + createdby + "]";
	}
	
	public String toInsertStat() {
		return "Insert into protocal(pt_id, name, text, createdby) values('" +
				pt_id + "', '" + name + "', '" + text + "', '" + createdby + "');";
	}
}
