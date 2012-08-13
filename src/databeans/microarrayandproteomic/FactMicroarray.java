package databeans.microarrayandproteomic;

public class FactMicroarray {
	String s_id;
	String e_id;
	String pb_id;
	String mu_id;
	int exp;
	
	public String getS_id() {
		return s_id;
	}
	public void setS_id(String s_id) {
		this.s_id = s_id;
	}
	public String getE_id() {
		return e_id;
	}
	public void setE_id(String e_id) {
		this.e_id = e_id;
	}
	public String getPb_id() {
		return pb_id;
	}
	public void setPb_id(String pb_id) {
		this.pb_id = pb_id;
	}
	public String getMu_id() {
		return mu_id;
	}
	public void setMu_id(String mu_id) {
		this.mu_id = mu_id;
	}
	public int getExp() {
		return exp;
	}
	public void setExp(int exp) {
		this.exp = exp;
	}
	
	@Override
	public String toString() {
		return "FactMicroarray [s_id=" + s_id + ", e_id=" + e_id + ", pb_id="
				+ pb_id + ", mu_id=" + mu_id + ", exp=" + exp + "]";
	}
	
	public String toInsertStat() {
		return "Insert into microarray_fact(s_id, e_id, pb_id, mu_id, exp) values('" +
				s_id + "', '"+ e_id + "', '"+ pb_id + "', '"+ mu_id + "', "+ exp + ");";
	}
}
