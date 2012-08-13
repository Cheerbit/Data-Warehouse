package databeans.sample;

import java.sql.Date;

public class Sample {
	String s_id;
	String source;
	int amount;
	Date sp_date;
	
	public String getS_id() {
		return s_id;
	}
	public void setS_id(String s_id) {
		this.s_id = s_id;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public Date getSp_date() {
		return sp_date;
	}
	public void setSp_date(Date sp_date) {
		this.sp_date = sp_date;
	}
	
	@Override
	public String toString() {
		return "Sample [s_id=" + s_id + ", source=" + source + ", amount="
				+ amount + ", sp_date=" + sp_date + "]";
	}

	public String toInsertStat() {
		return "Insert into sample(s_id, source, amount, sp_date) values(" +
				"'" + s_id + "', '" + source + "', " + amount + ", '" + sp_date + "');";
	}
}
