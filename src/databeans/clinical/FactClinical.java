package databeans.clinical;

import java.sql.Date;

public class FactClinical {
	String p_id;
	String ds_id;
	String sympton;
	Date ds_from_date;
	Date ds_to_date;
	String dr_id;
	String dosage;
	Date dr_from_date;
	Date dr_to_date;
	String tt_id;
	String result;
	Date tt_date;
	String s_id;
	
	public String getP_id() {
		return p_id;
	}
	public void setP_id(String p_id) {
		this.p_id = p_id;
	}
	public String getDs_id() {
		return ds_id;
	}
	public void setDs_id(String ds_id) {
		this.ds_id = ds_id;
	}
	public String getSympton() {
		return sympton;
	}
	public void setSympton(String sympton) {
		this.sympton = sympton;
	}
	public Date getDs_from_date() {
		return ds_from_date;
	}
	public void setDs_from_date(Date ds_from_date) {
		this.ds_from_date = ds_from_date;
	}
	public Date getDs_to_date() {
		return ds_to_date;
	}
	public void setDs_to_date(Date ds_to_date) {
		this.ds_to_date = ds_to_date;
	}
	public String getDr_id() {
		return dr_id;
	}
	public void setDr_id(String dr_id) {
		this.dr_id = dr_id;
	}
	public String getDosage() {
		return dosage;
	}
	public void setDosage(String dosage) {
		this.dosage = dosage;
	}
	public Date getDr_from_date() {
		return dr_from_date;
	}
	public void setDr_from_date(Date dr_from_date) {
		this.dr_from_date = dr_from_date;
	}
	public Date getDr_to_date() {
		return dr_to_date;
	}
	public void setDr_to_date(Date dr_to_date) {
		this.dr_to_date = dr_to_date;
	}
	public String getTt_id() {
		return tt_id;
	}
	public void setTt_id(String tt_id) {
		this.tt_id = tt_id;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public Date getTt_date() {
		return tt_date;
	}
	public void setTt_date(Date tt_date) {
		this.tt_date = tt_date;
	}
	public String getS_id() {
		return s_id;
	}
	public void setS_id(String s_id) {
		this.s_id = s_id;
	}
	@Override
	public String toString() {
		return "FactClinical [p_id=" + p_id + ", ds_id=" + ds_id + ", sympton="
				+ sympton + ", ds_from_date=" + ds_from_date + ", ds_to_date="
				+ ds_to_date + ", dr_id=" + dr_id + ", dosage=" + dosage
				+ ", dr_from_date=" + dr_from_date + ", dr_to_date="
				+ dr_to_date + ", tt_id=" + tt_id + ", result=" + result
				+ ", tt_date=" + tt_date + ", s_id=" + s_id + "]";
	}
	
	public String toInsertStat() {
		String insertStat =  "Insert into clinical_fact(p_id, ds_id, sympton, ds_from_date, " +
				"ds_to_date, dr_id, dosage, dr_from_date, dr_to_date, tt_id, " +
				"result, tt_date, s_id) values('" + p_id + "', '" + ds_id + "', '" + 
				sympton + "', '" + ds_from_date + "', '" + ds_to_date + "', '" + 
				dr_id + "', '" + dosage + "', '" + dr_from_date + "', '" + dr_to_date +
				"', '" + tt_id + "', '" + result + "', '" + tt_date + "', '" + s_id + "');";

		insertStat = insertStat.replaceAll("'null'", "null");
		return insertStat;
	}
}
