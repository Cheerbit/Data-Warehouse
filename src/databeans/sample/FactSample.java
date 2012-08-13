package databeans.sample;

import java.sql.Date;

public class FactSample {
	String s_id;
	String mk_id;
	String mk_result;
	Date mk_date;
	String as_id;
	String as_result;
	Date as_date;
	String tm_id;
	String tm_description;
	public String getS_id() {
		return s_id;
	}
	public void setS_id(String s_id) {
		this.s_id = s_id;
	}
	public String getMk_id() {
		return mk_id;
	}
	public void setMk_id(String mk_id) {
		this.mk_id = mk_id;
	}
	public String getMk_result() {
		return mk_result;
	}
	public void setMk_result(String mk_result) {
		this.mk_result = mk_result;
	}
	public Date getMk_date() {
		return mk_date;
	}
	public void setMk_date(Date mk_date) {
		this.mk_date = mk_date;
	}
	public String getAs_id() {
		return as_id;
	}
	public void setAs_id(String as_id) {
		this.as_id = as_id;
	}
	public String getAs_result() {
		return as_result;
	}
	public void setAs_result(String as_result) {
		this.as_result = as_result;
	}
	public Date getAs_date() {
		return as_date;
	}
	public void setAs_date(Date as_date) {
		this.as_date = as_date;
	}
	public String getTm_id() {
		return tm_id;
	}
	public void setTm_id(String tm_id) {
		this.tm_id = tm_id;
	}
	public String getTm_description() {
		return tm_description;
	}
	public void setTm_description(String tm_description) {
		this.tm_description = tm_description;
	}
	
	@Override
	public String toString() {
		return "FactSample [s_id=" + s_id + ", mk_id=" + mk_id + ", mk_result="
				+ mk_result + ", mk_date=" + mk_date + ", as_id=" + as_id
				+ ", as_result=" + as_result + ", as_date=" + as_date
				+ ", tm_id=" + tm_id + ", tm_description=" + tm_description
				+ "]";
	}
	
	public String toInsertStat() {
		String insertStat = "Insert into sample_fact(s_id, mk_id, mk_result, " +
				"mk_date, as_id, as_result, as_date, tm_id, tm_description) values('" +
				s_id + "', '" + mk_id + "', '" + mk_result + "', '" + mk_date + "', '" +
				as_id + "', '" + as_result + "', '" + as_date + "', '" + tm_id + "', '" +
				tm_description + "');";
		insertStat = insertStat.replaceAll("'null'", "null");
		return insertStat;
	}
}
