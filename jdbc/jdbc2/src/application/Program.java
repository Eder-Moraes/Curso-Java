package application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;
import db.DbException;

public class Program {

	public static void main(String[] args) {

		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;

		try {
			conn = DB.getConnection();

			st = conn.createStatement();
			rs = st.executeQuery("select * from department");

			while(rs.next()) {
				System.out.println(rs.getInt("id") + ", " + rs.getString("name"));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} catch(DbException e){
			System.out.println(e.getMessage());
		} finally{
			DB.closeResultSet(rs);
			DB.closeStatement(st);
			DB.closeConnection();
		}



	}

}
