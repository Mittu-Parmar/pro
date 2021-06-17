package in.mittu.datasource;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.mysql.jdbc.Connection;

public class DataSource {

	private static DataSource dataSource = null;
	private static Connection connection = null;

	private DataSource() {
	}

	public static DataSource getInstance() {
		if (dataSource == null) {
			dataSource = new DataSource();
		}
		return dataSource;
	}

	public Connection getConnection() throws ClassNotFoundException {
		
		if(connection!=null){
			return connection;
		}else {
			try {
				
//				String driver="com.mysql.jdbc.Driver";
//				String url = "jdbc:mysql://localhost:3306/importcsv";
//				String username = "root";
//				String password = "root";
				
				ResourceBundle bundle=ResourceBundle.getBundle("db");
				
				String driver=bundle.getString("driver");
				String url =bundle.getString("url"); 
				String username = bundle.getString("username");
				String password = bundle.getString("password");

				Class.forName(driver);
				connection = (Connection) DriverManager.getConnection(url, username, password);
				
				return connection;
				
			} catch (SQLException ex) {
				Logger.getLogger(DataSource.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		return null;
	}
	
	public void closeConnection() {
		try {
			connection.close();
		} catch (SQLException ex) {
			Logger.getLogger(DataSource.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
}
