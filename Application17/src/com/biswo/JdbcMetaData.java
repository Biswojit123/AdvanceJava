package com.biswo;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
public class JdbcMetaData {

	public static void main(String[] args) {
		Connection con = null;
		DatabaseMetaData db = null;
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","bishnu");
			db = con.getMetaData();
			System.out.println(db.getDatabaseProductName());
			System.out.println(db.getDatabaseProductVersion());
			System.out.println(db.getDatabaseMajorVersion());
			System.out.println(db.getDatabaseMinorVersion());
			System.out.println(db.getDriverName());
			System.out.println(db.getDriverVersion());
			System.out.println(db.getDriverMajorVersion());
			System.out.println(db.getDriverMinorVersion());
			System.out.println(db.getSQLKeywords());
			System.out.println(db.getStringFunctions());
			System.out.println(db.getNumericFunctions());
			System.out.println(db.supportsBatchUpdates());
			System.out.println(db.supportsStoredProcedures());
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}

}
