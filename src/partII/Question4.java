package partII;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import th.database.SQLConnector;
import th.statistics.StatisticsCalculator;

public class Question4 {

	/**
	 * @param args
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException {
		List<Integer> patientWithALL = new ArrayList<Integer>();
		List<Integer> patientWithoutAll = new ArrayList<Integer>();
		
		SQLConnector sqlConnector = new SQLConnector();
		java.sql.Statement st = sqlConnector.conn.createStatement();
		String sql1 = "select exp from microarray_fact cf, s_id_all, pb_id_0012502 p where cf.s_id = s_id_all.s_id and cf.pb_id = p.pb_id order by exp;";
		st.executeQuery(sql1);
		ResultSet rs = st.getResultSet();
		while(rs.next()) {
			int tmp = rs.getInt("exp");
			patientWithALL.add(tmp);
		}
		
		String sql2 = "select exp from microarray_fact cf, s_id_not_all, pb_id_0012502 p where cf.s_id = s_id_not_all.s_id and cf.pb_id = p.pb_id order by exp;";
		st.executeQuery(sql2);
		rs = st.getResultSet();
		while(rs.next()) {
			int tmp = rs.getInt("exp");
			patientWithoutAll.add(tmp);
		}
		
		double tTest = StatisticsCalculator.tStatistics(patientWithALL, patientWithoutAll);
		System.out.println("T-Test: " + tTest);
	}

}
