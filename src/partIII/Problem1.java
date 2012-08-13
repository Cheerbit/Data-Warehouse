package partIII;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import th.database.SQLConnector;
import th.statistics.StatisticsCalculator;

public class Problem1 {

	/**
	 * @param args
	 * @throws IOException
	 * @throws SQLException
	 */
	public static void main(String[] args) throws IOException, SQLException {
		// System.out.println("Please enter the disease.");
		String disease = "";

		List<String> UIDList = new ArrayList<String>();
		List<String> pbidList = new ArrayList<String>();

		List<List<Integer>> exp_list = new ArrayList<List<Integer>>();
		List<List<Integer>> exp_not_list = new ArrayList<List<Integer>>();

		List<String> informativeList = new ArrayList<String>();
		List<Double> pvalueList = new ArrayList<Double>();
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));
		// disease = reader.readLine();

		String sql = "select distinct UID from gene";
		String sql2 = "";
		SQLConnector sqlConnector = new SQLConnector();
		java.sql.Statement st = sqlConnector.conn.createStatement();
		st.executeQuery(sql);
		ResultSet rs;
		rs = st.getResultSet();
		while (rs.next()) {
			UIDList.add(rs.getString("UID"));
		}

		sql = "select distinct pb_id from probe where probe.UID in (select distinct UID from gene);";
		st.executeQuery(sql);
		rs = st.getResultSet();
		while (rs.next()) {
			pbidList.add(rs.getString("pb_id"));
		}

		long startTime = System.currentTimeMillis();

		for (int i = 0; i < pbidList.size(); i++) {
			sql = "select exp from microarray_fact mf, s_id_ALL a "
					+ "where mf.s_id = a.s_id and mf.pb_id = '"
					+ pbidList.get(i) + "'";
			sql2 = "select exp from microarray_fact mf, s_id_not_ALL a "
					+ "where mf.s_id = a.s_id and mf.pb_id = '"
					+ pbidList.get(i) + "'";
			st.executeQuery(sql);
			rs = st.getResultSet();
			List<Integer> temp = new ArrayList<Integer>();
			while (rs.next()) {
				temp.add(rs.getInt("exp"));
			}
			exp_list.add(temp);

			st.executeQuery(sql2);
			rs = st.getResultSet();
			List<Integer> temp2 = new ArrayList<Integer>();
			while (rs.next()) {
				temp2.add(rs.getInt("exp"));
			}
			exp_not_list.add(temp2);
		}
		List<Double> tTestList = new ArrayList<Double>();
		for (int i = 0; i < exp_list.size(); i++) {
			double ttest = Math.abs(StatisticsCalculator.tStatistics(exp_list.get(i),
					exp_not_list.get(i)));
			tTestList.add(ttest);
			//System.out.println(UIDList.get(i) + " = " + ttest);
			int freedoms = exp_list.get(i).size() + exp_not_list.get(i).size()
					- 2;
			double pvalue = 2*(1 - cern.jet.stat.Probability.studentT(freedoms,
					ttest));
			pvalueList.add(pvalue);
			if(pvalue <= 0.01) {
				informativeList.add(UIDList.get(i));
			}
			//System.out.println(pvalue);
			
		}
//		double temp = 0;
//		for(int i = 0; i < tTestList.size(); i++) {
//			temp += tTestList.get(i);
//		}
//		System.out.println("tTestList size:" + tTestList.size() + " Total: " + temp);
		//System.out.println(informativeList.size());
//		st.executeUpdate("delete from informative_all");
//		for(int i = 0; i < informativeList.size(); i++) {
//			//System.out.println("insert into informative_all(UID) values('" + informativeList.get(i) + "');");
//			st.executeUpdate("insert into informative_all(UID) values('" + informativeList.get(i) + "');");
//			//System.out.println(informativeList.get(i));
//		}
//		st.executeUpdate("delete from informative_all_2");
//		for(int i = 0; i < informativeList.size(); i++) {
//			//System.out.println("insert into informative_all(UID) values('" + informativeList.get(i) + "');");
//			st.executeUpdate("insert into informative_all_2(UID) values('" + informativeList.get(i) + "');");
//			//System.out.println(informativeList.get(i));
//		}
		System.out
				.println((double) (System.currentTimeMillis() - startTime) / 1000);
	}

}
