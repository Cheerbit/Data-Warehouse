package partII;

import java.sql.ResultSet;
import java.sql.SQLException;

import th.database.SQLConnector;

public class Question2 {

	/**
	 * @param args
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException {
		SQLConnector sqlConnector = new SQLConnector();
		java.sql.Statement st = sqlConnector.conn.createStatement();
		String sql = "select distinct d.type from drug d, clinical_fact c, disease di where c.dr_id = d.dr_id and c.ds_id = di.ds_id and di.description = 'tumor';";
		st.executeQuery(sql);
		ResultSet rs = st.getResultSet();
		System.out.println("Ans = ");
		while(rs.next()) {
			String result = rs.getString("type");
			System.out.println(result);
		}
	}

}
