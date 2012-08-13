package partIII;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import th.database.SQLConnector;
import th.statistics.StatisticsCalculator;

public class Problem2 {

	/**
	 * @param args
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException {
		//Loading test_samples
		List<String> test_UID = new ArrayList<String>();
		List<Integer> test1 = new ArrayList<Integer>();
		List<Integer> test2 = new ArrayList<Integer>();
		List<Integer> test3 = new ArrayList<Integer>();
		List<Integer> test4 = new ArrayList<Integer>();
		List<Integer> test5 = new ArrayList<Integer>();
		
		List<Integer> info_test1_exp = new ArrayList<Integer>();
		List<Integer> info_test2_exp = new ArrayList<Integer>();
		List<Integer> info_test3_exp = new ArrayList<Integer>();
		List<Integer> info_test4_exp = new ArrayList<Integer>();
		List<Integer> info_test5_exp = new ArrayList<Integer>();
		List<List<Integer>> info_exp = new ArrayList<List<Integer>>();
		
		String sql = "select test_samples_id, test1, test2, test3, " +
				"test4, test5 from test_samples";
		SQLConnector sqlConnector = new SQLConnector();
		java.sql.Statement st = sqlConnector.conn.createStatement();
		
		st.executeQuery(sql);
		ResultSet rs = st.getResultSet();
		while(rs.next()) {
			test_UID.add(rs.getString("test_samples_id"));
			test1.add(rs.getInt("test1"));
			test2.add(rs.getInt("test2"));
			test3.add(rs.getInt("test3"));
			test4.add(rs.getInt("test4"));
			test5.add(rs.getInt("test5"));
		}
		
		//Loading patient list with or not ALL
//		List<String> patient_ALL = new ArrayList<String>();
//		List<String> patient_not_ALL = new ArrayList<String>();
//		sql = "select distinct p_id from clinical_fact where ds_id = '0002';";
//		st.executeQuery(sql);
//		rs = st.getResultSet();
//		while(rs.next()) {
//			patient_ALL.add(rs.getString("p_id"));
//		}
//		sql = "select distinct p_id from clinical_fact where ds_id <> '0002';";
//		st.executeQuery(sql);
//		rs = st.getResultSet();
//		while(rs.next()) {
//			patient_not_ALL.add(rs.getString("p_id"));
//		}
		
		//Loading s_id for each patient
		List<String> s_id_ALLList = new ArrayList<String>();
		List<String> s_id_not_ALLList = new ArrayList<String>();
		sql = "select s_id from s_id_ALL;";
		st.executeQuery(sql);
		rs = st.getResultSet();
		while(rs.next()) {
			s_id_ALLList.add(rs.getString("s_id"));
		}
		sql = "select s_id from s_id_not_ALL;";
		st.executeQuery(sql);
		rs = st.getResultSet();
		while(rs.next()) {
			s_id_not_ALLList.add(rs.getString("s_id"));
		}
		//System.out.println(s_id_ALLList.size());
		//System.out.println(s_id_not_ALLList.size());
		
		//Loading informativeList
		List<String> informativeList = new ArrayList<String>();
		sql = "select UID from informative_all_1";
		st.executeQuery(sql);
		rs = st.getResultSet();
		while(rs.next()) {
			informativeList.add(rs.getString("UID"));
		}
		
		//Generating informative gene exp for each patient
		for(String gene : informativeList) {
			int index = test_UID.indexOf(gene);
			info_test1_exp.add(test1.get(index));
			info_test2_exp.add(test2.get(index));
			info_test3_exp.add(test3.get(index));
			info_test4_exp.add(test4.get(index));
			info_test5_exp.add(test5.get(index));
		}
		info_exp.add(info_test1_exp);info_exp.add(info_test2_exp);
		info_exp.add(info_test3_exp);info_exp.add(info_test4_exp);info_exp.add(info_test5_exp);
		
		//Loading exp list
		List<List<Integer>> exp_list = new ArrayList<List<Integer>>();
		List<List<Integer>> exp_not_list = new ArrayList<List<Integer>>();
		
		for(int i = 0; i < s_id_ALLList.size(); i++) {
			sql = "select exp from microarray_fact mf, probe p where " +
					"mf.s_id = '" + s_id_ALLList.get(i) + "' and p.pb_id = mf.pb_id " +
							"and p.UID in (select UID from informative_all_1);";
			//System.out.println(sql);
			st.executeQuery(sql);
			rs = st.getResultSet();
			List<Integer> temp = new ArrayList<Integer>();
			while(rs.next()) {
				temp.add(rs.getInt("exp"));
			}
			exp_list.add(temp);
		}
		
		for(int i = 0; i < s_id_not_ALLList.size(); i++) {
			sql = "select exp from microarray_fact mf,  probe p where " +
					"mf.s_id = '" + s_id_not_ALLList.get(i) + "' and p.pb_id = mf.pb_id " +
							"and p.UID in (select UID from informative_all_1);";
			st.executeQuery(sql);
			rs = st.getResultSet();
			List<Integer> temp = new ArrayList<Integer>();
			while(rs.next()) {
				temp.add(rs.getInt("exp"));
			}
			exp_not_list.add(temp);
		}
		
		//Calculating rA rB
		List<List<Double>> rA = new ArrayList<List<Double>>();
		List<List<Double>> rB = new ArrayList<List<Double>>();
		for(int i = 0; i < info_exp.size(); i++) {
			List<Double> temp = new ArrayList<Double>();
			List<Double> temp2 = new ArrayList<Double>();
			for(int j = 0; j < exp_list.size(); j++) {
				temp.add(StatisticsCalculator.pearsonCorrelation(info_exp.get(i), exp_list.get(j)));
//				temp.add(Math.abs(StatisticsCalculator.pearsonCorrelation(exp_list.get(j), info_exp.get(i))));
			}
			rA.add(temp);
			for(int j = 0; j < exp_not_list.size(); j++) {
				temp2.add(StatisticsCalculator.pearsonCorrelation(info_exp.get(i), exp_not_list.get(j)));
//				temp2.add(Math.abs(StatisticsCalculator.pearsonCorrelation(exp_not_list.get(j), info_exp.get(i))));
			}
			rB.add(temp2);
		}
		
//		for(int i = 4; i < rA.size(); i++) {
//			System.out.println("===" + (i+1));
//			for(int j = 0; j < rA.get(i).size(); j++) {
//				System.out.println(rA.get(i).get(j));
//			}
//		}
//		
//		for(int i = 4; i < rB.size(); i++) {
//			System.out.println("===" + (i+1));
//			for(int j = 0; j < rB.get(i).size(); j++) {
//				System.out.println(rB.get(i).get(j));
//			}
//		}
		
		List<Double> tTestList = new ArrayList<Double>();
		List<Double> pvalue1List = new ArrayList<Double>();
		List<Double> pvalue2List = new ArrayList<Double>();
		
//		System.out.println(rA.size() + " " + rB.size());
		
		for(int i = 0; i < rA.size(); i++) {
			double ttest = Math.abs(StatisticsCalculator.tStatisticsD(rA.get(i), rB.get(i)));
			tTestList.add(ttest);
			int freedoms = rA.get(i).size() + rB.get(i).size() - 2;
//			int freedoms = 8;
//			System.out.println(freedoms);
			System.out.println(ttest);
			double pvalue1 = 1 - cern.jet.stat.Probability.studentT(freedoms, ttest*5);
			double pvalue2 = 2*(1 - cern.jet.stat.Probability.studentT(freedoms, ttest*2));
			pvalue1List.add(pvalue1);
			pvalue2List.add(pvalue2);
		}
		
		System.out.println("One tail");
		for(int i = 0; i < pvalue1List.size(); i++) {
			System.out.println("p-value for test " + (i+1) + " is: " + pvalue1List.get(i));
			if(pvalue1List.get(i) < 0.01){
				System.out.println("test " + (i+1) + " has ALL");
			}
		}

//		System.out.println("Two tail");
//		for(int i = 0; i < pvalue2List.size(); i++) {
//			System.out.println("p-value for test " + (i+1) + " is: " + pvalue2List.get(i));
//			if(pvalue2List.get(i) < 0.01){
//				System.out.println("test " + (i+1) + " has ALL");
//			}
//		}
	}

}
