package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DB {
	
	private static Connection conn = null;
	
	//metodo carrega as propriedades que estão definidas no arquivo db.properties
	private static Properties loadProperties() {
		try(FileInputStream fs = new FileInputStream("db.properties")) {
			Properties props = new Properties();
			props.load(fs);
			return props;
		}catch(IOException e) {
			throw new DbException(e.getMessage());
		}
	}
	
	public static Connection getConnection() {
		if(conn == null) {
			try {
			Properties props = loadProperties();
			String url = props.getProperty("dburl");
			conn = DriverManager.getConnection(url, props);
			
			}catch(SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
		return conn;
	}
	
	public static void closeConnection() {
		if(conn != null) {
			try {
				conn.close();
			}catch(SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}
	
	public static void closePrepareStatement(Statement st) {
		try {
			st.close();
		}catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		
	}
}
