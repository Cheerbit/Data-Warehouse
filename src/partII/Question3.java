package partII;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import th.database.SQLConnector;

public class Question3 {

	/**
	 * @param args
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException {
		SQLConnector sqlConnector = new SQLConnector();
		java.sql.Statement st = sqlConnector.conn.createStatement();
//		String sql = "select exp from microarray_fact mf, s_id_all s where mu_id = '001' and s.s_id = mf.s_id and pb_id in" +
//		" ( select distinct p.pb_id from probe p, gene_fact gf where gf.UID = p.UID and gf.cl_id = '00002');";
		String sql = "select mf.exp from microarray_fact mf, s_id_all s, probe p, gene_fact gf" +
				" where mf.mu_id = '001' and s.s_id = mf.s_id and p.pb_id = mf.pb_id and gf.cl_id = '00002' and gf.UID = p.UID;";
		st.executeQuery(sql);
		ResultSet rs = st.getResultSet();
		System.out.println("Ans = ");
		List<Integer> resultList = new ArrayList<Integer>();
		while(rs.next()) {
			resultList.add(rs.getInt("exp"));
			//System.out.println(result);
		}
		
		System.out.println(resultList.size());
	}

}
