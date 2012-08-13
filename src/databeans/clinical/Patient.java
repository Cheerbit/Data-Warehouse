package databeans.clinical;

import java.sql.Date;

public class Patient {
	String p_id;
	String ssn;
	String name;
	String gender;
	Date dob;
	
	public String getP_id() {
		return p_id;
	}
	public void setP_id(String p_id) {
		this.p_id = p_id;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	
	@Override
	public String toString() {
		return "Patient [p_id=" + p_id + ", ssn=" + ssn + ", name=" + name
				+ ", gender=" + gender + ", dob=" + dob + "]";
	}
	
	public String toInsertStat() {
		return "Insert into patient(p_id, ssn, name, gender, dob) values('" + p_id + "', '" + ssn + "', '" + name + "', '" + gender + "', '" + dob + "');";
	}
	
	
}
