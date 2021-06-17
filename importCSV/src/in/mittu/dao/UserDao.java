package in.mittu.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import in.mittu.datasource.DataSource;
import in.mittu.models.User;

public class UserDao {

	public static int ERROR = 0;
	public static int AlERADY_EXIST = 1;
	public static int INSERTED = 2;
	public static int NOT_EXIST = 3;

	public int save(User user) {

		try {

			Connection connection = DataSource.getInstance().getConnection();
			String createTableQuery = "CREATE TABLE IF NOT EXISTS users(userid int(10) unsigned NOT NULL, password varchar(10) NOT NULL)";
			Statement statement = (Statement) connection.createStatement();
			statement.execute(createTableQuery);


			if (checkUserAvailable(user)==NOT_EXIST) {				
				String insertQuery = "INSERT INTO users (userid,password) VALUES(?,?)";
				PreparedStatement preparedStatement =(PreparedStatement) connection.prepareStatement(insertQuery);
				preparedStatement.setInt(1, user.getId());
				preparedStatement.setString(2, user.getPassword());
				int i = preparedStatement.executeUpdate();
				if(i>0){
					return INSERTED;
				}else{
					return ERROR;
				}
			}else if(checkUserAvailable(user)==AlERADY_EXIST){
				return AlERADY_EXIST;
			}else{
				return ERROR;
			}
		} catch (SQLException | ClassNotFoundException ex) {
			return ERROR;

		}
	}

	public int checkUserAvailable(User user) {
		
		try {
			Connection connection= DataSource.getInstance().getConnection();
			String selectUserQuery = "select * from users where userid=?";
			PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(selectUserQuery);
			preparedStatement.setInt(1, user.getId());
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				return AlERADY_EXIST;
			}else{
				return NOT_EXIST;
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			return ERROR;
		}
			
	}

}
