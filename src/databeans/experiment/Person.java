package databeans.experiment;

public class Person {
	String pn_id;
	String name;
	String labName;
	String contact;
	
	public String getPn_id() {
		return pn_id;
	}
	public void setPn_id(String pn_id) {
		this.pn_id = pn_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLabName() {
		return labName;
	}
	public void setLabName(String labName) {
		this.labName = labName;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	
	@Override
	public String toString() {
		return "Person [pn_id=" + pn_id + ", name=" + name + ", labName="
				+ labName + ", contact=" + contact + "]";
	}
	
	public String toInsertStat() {
		return "Insert into person(pn_id, name, labName, contact) values('" +
				pn_id + "', '" + name + "', '" + labName + "', '" + contact + "');";
	}
}
