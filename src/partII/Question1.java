package partII;

import java.sql.ResultSet;
import java.sql.SQLException;

import th.database.SQLConnector;

public class Question1 {

	/**
	 * @param args
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException {
		SQLConnector sqlConnector = new SQLConnector();
		java.sql.Statement st = sqlConnector.conn.createStatement();
		String sql = "select count(p_id) as p_id_count from disease d, clinical_fact c where d.ds_id = c.ds_id and d.description='tumor';";
		st.executeQuery(sql);
		ResultSet rs = st.getResultSet();
		rs.next();

		int result = rs.getInt("p_id_count");
		System.out.println("Tumor: " + result);
		
		sql = "select count(p_id) as p_id_count from disease d, clinical_fact c where d.ds_id = c.ds_id and d.type='leukemia';";
		st.executeQuery(sql);
		rs = st.getResultSet();
		rs.next();
		result = rs.getInt("p_id_count");
		System.out.println("leukemia: " + result);
		
		sql = "select count(p_id) as p_id_count from disease d, clinical_fact c where d.ds_id = c.ds_id and d.name='ALL';";
		st.executeQuery(sql);
		rs = st.getResultSet();
		rs.next();
		result = rs.getInt("p_id_count");
		System.out.println("ALL: " + result);
	}

}
