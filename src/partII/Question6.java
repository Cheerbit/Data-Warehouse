package partII;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import th.database.SQLConnector;
import th.statistics.StatisticsCalculator;

public class Question6 {

	/**
	 * @param args
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException {
		List<List<Integer>> ALLexp = new ArrayList<List<Integer>>();
		List<List<Integer>> AMLexp = new ArrayList<List<Integer>>();
		
		List<Double> ALLcorrList = new ArrayList<Double>();
		List<Double> AMLcorrList = new ArrayList<Double>();
		
		List<String> patient_ALL_List = new ArrayList<String>();
		List<String> patient_AML_List = new ArrayList<String>();
		
		SQLConnector sqlConnector = new SQLConnector();
		java.sql.Statement st = sqlConnector.conn.createStatement();
		String sql = "select distinct cf.p_id from clinical_fact cf, disease d where cf.ds_id = d.ds_id and d.name = \"ALL\";";
		st.executeQuery(sql);
		ResultSet rs = st.getResultSet();
		while(rs.next()) {
			String id = rs.getString("p_id");
			patient_ALL_List.add(id);
		}
		
		for(int i = 0; i < patient_ALL_List.size(); i++){
			sql = "select cf.exp from microarray_fact cf, s_id_all s, pb_id_0007154 p where cf.s_id = s.s_id and cf.pb_id = p.pb_id and s.s_id in "
				+ "(select cf.s_id from s_id_all s, clinical_fact cf where s.s_id = cf.s_id and cf.p_id = '"
				+ patient_ALL_List.get(i) + "');";
			st.executeQuery(sql);
			rs = st.getResultSet();
			List<Integer> temp = new ArrayList<Integer>();
			while (rs.next()) {
				temp.add(rs.getInt("exp"));
			}
			ALLexp.add(temp);
		}

		for(int i = 0; i < ALLexp.size(); i++) {
			for(int j = i + 1; j < ALLexp.size(); j++) {
				double result = StatisticsCalculator.pearsonCorrelation(ALLexp.get(i), ALLexp.get(j));
				ALLcorrList.add(result);
			}
		}
		double temp = 0;
		for(int i = 0; i < ALLcorrList.size(); i++) {
			temp += ALLcorrList.get(i);
		}
		System.out.println("Between ALL:" + temp/ALLcorrList.size());
		
		sql = "select distinct cf.p_id from clinical_fact cf, disease d where cf.ds_id = d.ds_id and d.name = \"AML\";";
		st.executeQuery(sql);
		rs = st.getResultSet();
		while(rs.next()) {
			String id = rs.getString("p_id");
			patient_AML_List.add(id);
		}
		
		for(int i = 0; i < patient_AML_List.size(); i++) {
			sql = "select cf.exp from microarray_fact cf, s_id_aml s, pb_id_0007154 p where cf.s_id = s.s_id and cf.pb_id = p.pb_id and s.s_id in "
				+ "(select cf.s_id from s_id_aml s, clinical_fact cf where s.s_id = cf.s_id and cf.p_id = '"
				+ patient_AML_List.get(i) + "');";
			st.executeQuery(sql);
			rs = st.getResultSet();
			List<Integer> tmp = new ArrayList<Integer>();
			while(rs.next()) {
				tmp.add(rs.getInt("exp"));
			}
			AMLexp.add(tmp);
		}
		
		for(int i = 0; i < ALLexp.size(); i++) {
			for(int j = 0; j < AMLexp.size(); j++) {
				double result = StatisticsCalculator.pearsonCorrelation(ALLexp.get(i), AMLexp.get(j));
				AMLcorrList.add(result);
			}
		}
		temp = 0; 
		for(int i = 0; i < AMLcorrList.size(); i++){
			temp += AMLcorrList.get(i);
		}
		System.out.println("Between ALL and AML" + temp/AMLcorrList.size());
		//System.out.println(ALLcorrList.size() + "-" + AMLcorrList.size());
		
//		List<Integer> input1 = new ArrayList<Integer>();
//		List<Integer> input2 = new ArrayList<Integer>();
//		String sql = "select cf.exp from microarray_fact cf, s_id_all s, pb_id_0007154 p where cf.s_id = s.s_id and cf.pb_id = p.pb_id and s.s_id in "
//			+ "(select cf.s_id from s_id_all s, clinical_fact cf where s.s_id = cf.s_id and cf.p_id = '00047880');";
//		st.executeQuery(sql);
//		ResultSet rs = st.getResultSet();
//		while (rs.next()) {
//			input1.add(rs.getInt("exp"));
//		}
//		
//		sql = "select cf.exp from microarray_fact cf, s_id_all s, pb_id_0007154 p where cf.s_id = s.s_id and cf.pb_id = p.pb_id and s.s_id in "
//			+ "(select cf.s_id from s_id_all s, clinical_fact cf where s.s_id = cf.s_id and cf.p_id = '00013258');";
//		st.executeQuery(sql);
//		rs = st.getResultSet();
//		while (rs.next()) {
//			input2.add(rs.getInt("exp"));
//		}
//		
//		for(int i = 0; i < input1.size(); i++) {
//			System.out.println(input1.get(i));
//		}
//		System.out.println("---");
//		for(int i = 0; i < input2.size(); i++) {
//			System.out.println(input2.get(i));
//		}
//		System.out.println(StatisticsCalculator.pearsonCorrelation(input1, input2));
	}

}
