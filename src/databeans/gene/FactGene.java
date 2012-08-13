package databeans.gene;

public class FactGene {
	String UID;
	String go_id;
	String cl_id;
	String dm_id;
	String pm_id;
	String UID2;
	public String getUID() {
		return UID;
	}
	public void setUID(String uID) {
		UID = uID;
	}
	public String getGo_id() {
		return go_id;
	}
	public void setGo_id(String go_id) {
		this.go_id = go_id;
	}
	public String getCl_id() {
		return cl_id;
	}
	public void setCl_id(String cl_id) {
		this.cl_id = cl_id;
	}
	public String getDm_id() {
		return dm_id;
	}
	public void setDm_id(String dm_id) {
		this.dm_id = dm_id;
	}
	public String getPm_id() {
		return pm_id;
	}
	public void setPm_id(String pm_id) {
		this.pm_id = pm_id;
	}
	public String getUID2() {
		return UID2;
	}
	public void setUID2(String uID2) {
		UID2 = uID2;
	}
	
	@Override
	public String toString() {
		return "FactGene [UID=" + UID + ", go_id=" + go_id + ", cl_id=" + cl_id
				+ ", dm_id=" + dm_id + ", pm_id=" + pm_id + ", UID2=" + UID2
				+ "]";
	}
	
	public String toInsertStat() {
		String insertStat = "Insert into gene_fact(UID, go_id, cl_id, dm_id, pm_id, UID2) values('" +
				UID + "', '" + go_id + "', '" + cl_id + "', '" + dm_id + "', '" + pm_id + "', '" + UID2 + "');";
		insertStat = insertStat.replaceAll("'null'", "null");
		return insertStat;
	}
	
}
