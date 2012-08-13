package databeans.experiment;

public class FactExperiment {
	String e_id;
	String nm_id;
	String pj_id;
	String pn_id;
	String pf_id;
	String pt_id;
	String pu_id;
	public String getE_id() {
		return e_id;
	}
	public void setE_id(String e_id) {
		this.e_id = e_id;
	}
	public String getNm_id() {
		return nm_id;
	}
	public void setNm_id(String nm_id) {
		this.nm_id = nm_id;
	}
	public String getPj_id() {
		return pj_id;
	}
	public void setPj_id(String pj_id) {
		this.pj_id = pj_id;
	}
	public String getPn_id() {
		return pn_id;
	}
	public void setPn_id(String pn_id) {
		this.pn_id = pn_id;
	}
	public String getPf_id() {
		return pf_id;
	}
	public void setPf_id(String pf_id) {
		this.pf_id = pf_id;
	}
	public String getPt_id() {
		return pt_id;
	}
	public void setPt_id(String pt_id) {
		this.pt_id = pt_id;
	}
	public String getPu_id() {
		return pu_id;
	}
	public void setPu_id(String pu_id) {
		this.pu_id = pu_id;
	}
	
	@Override
	public String toString() {
		return "FactExperiment [e_id=" + e_id + ", nm_id=" + nm_id + ", pj_id="
				+ pj_id + ", pn_id=" + pn_id + ", pf_id=" + pf_id + ", pt_id="
				+ pt_id + ", pu_id=" + pu_id + "]";
	}
	
	public String toInsertStat() {
		String insertStat = "Insert into experiment_fact(e_id, nm_id, pj_id, pn_id," +
				"pf_id, pt_id, pu_id) values('" + e_id + "', '" + nm_id + "', '" + 
				pj_id + "', '" + pn_id + "', '" + pf_id + "', '" + pt_id + "', '" + 
				pu_id + "');";
		insertStat = insertStat.replaceAll("'null'", "null");
		return insertStat;
	}
}
