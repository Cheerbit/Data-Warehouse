package partII;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import th.database.SQLConnector;
import th.statistics.StatisticsCalculator;

public class Question5 {

	/**
	 * @param args
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException {
		List<Integer> ALL = new ArrayList<Integer>();
		List<Integer> AML = new ArrayList<Integer>();
		List<Integer> Colon_tumor = new ArrayList<Integer>();
		List<Integer> breast_tumor = new ArrayList<Integer>();
		List<List<Integer>> input = new ArrayList<List<Integer>>();
		
		SQLConnector sqlConnector = new SQLConnector();
		java.sql.Statement st = sqlConnector.conn.createStatement();
		String sql1 = "select exp from microarray_fact cf, s_id_all, pb_id_0007154 p where cf.s_id = s_id_all.s_id and cf.pb_id = p.pb_id order by exp;";
		st.executeQuery(sql1);
		ResultSet rs = st.getResultSet();
		while(rs.next()) {
			int tmp = rs.getInt("exp");
			ALL.add(tmp);
		}
		
		String sql2 = "select exp from microarray_fact cf, s_id_aml, pb_id_0007154 p where cf.s_id = s_id_aml.s_id and cf.pb_id = p.pb_id order by exp;";
		st.executeQuery(sql2);
		rs = st.getResultSet();
		while(rs.next()) {
			int tmp = rs.getInt("exp");
			AML.add(tmp);
		}
		
		String sql3 = "select exp from microarray_fact cf, s_id_colon, pb_id_0007154 p where cf.s_id = s_id_colon.s_id and cf.pb_id = p.pb_id order by exp;";
		st.executeQuery(sql3);
		rs = st.getResultSet();
		while(rs.next()) {
			int tmp = rs.getInt("exp");
			Colon_tumor.add(tmp);
		}
		
		String sql4 = "select exp from microarray_fact cf, s_id_breast, pb_id_0007154 p where cf.s_id = s_id_breast.s_id and cf.pb_id = p.pb_id order by exp;";
		st.executeQuery(sql4);
		rs = st.getResultSet();
		while(rs.next()) {
			int tmp = rs.getInt("exp");
			breast_tumor.add(tmp);
		}
		
		input.add(ALL);input.add(AML);input.add(Colon_tumor);input.add(breast_tumor);
		double fTest = StatisticsCalculator.fStatistics(input);
		System.out.println("F-Test: " + fTest);
	}

}
