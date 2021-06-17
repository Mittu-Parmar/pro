package in.mittu.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import in.mittu.datasource.DataSource;
import in.mittu.models.MenuItemModel;
import in.mittu.util.StaticResource;

public class MenuItemsDao {

	public boolean saveItems(List<MenuItemModel> menuItemModels,int userId) {

		Connection connection;
		try {
			connection = DataSource.getInstance().getConnection();
			String createTableQuery = "CREATE TABLE IF NOT EXISTS ird_menuitems (menuitem_id int(10) AUTO_INCREMENT,menuitem_code varchar(254) NOT NULL UNIQUE ,name varchar(254) NOT NULL,description varchar(254) DEFAULT NULL,available_time varchar(500) DEFAULT NULL,delivery_time int(11) DEFAULT NULL,keywords varchar(2000) DEFAULT NULL,image varchar(2000) DEFAULT NULL,position mediumint(9) NOT NULL,price double(8,2) NOT NULL DEFAULT 0.00,hotel_id int(10) NOT NULL, created_by int(10) NOT NULL,created_on timestamp NOT NULL DEFAULT 0, modified_by int(10) unsigned DEFAULT NULL, modified_on timestamp NULL DEFAULT NULL ON UPDATE current_timestamp(),PRIMARY KEY (menuitem_id))";
			Statement statement = (Statement) connection.createStatement();
			statement.execute(createTableQuery);

			/////
			connection.setAutoCommit(false);
			String insertQuery = "INSERT INTO ird_menuitems (menuitem_code,name,description,available_time,delivery_time,keywords,image,position,price,hotel_id,created_by,created_on,modified_on) values (?,?,?,?,?,?,?,?,?,?,?,?,?)on duplicate key update name=?, description=?, available_time=?,delivery_time =?,keywords=? ,image=?,position=?, price=?, hotel_id=?,modified_by=?,modified_on=(SELECT CURRENT_TIMESTAMP())";
			PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(insertQuery);

			for (int i = 0; i < menuItemModels.size(); i++) {

				preparedStatement.setString(1, menuItemModels.get(i).getMenuItemCode());
				preparedStatement.setString(2, menuItemModels.get(i).getName());
				preparedStatement.setString(3, menuItemModels.get(i).getDescription());
				preparedStatement.setString(4, menuItemModels.get(i).getAvailableTime());
				preparedStatement.setInt(5, menuItemModels.get(i).getDeliveryTime());
				preparedStatement.setString(6, menuItemModels.get(i).getKeywords());
				preparedStatement.setString(7, menuItemModels.get(i).getImage());
				preparedStatement.setInt(8, menuItemModels.get(i).getPosition());
				preparedStatement.setDouble(9, menuItemModels.get(i).getPrice());
				preparedStatement.setInt(10, menuItemModels.get(i).getHotelId());
				preparedStatement.setInt(11, userId);
				preparedStatement.setTimestamp(12, null);
				preparedStatement.setTimestamp(13, null);

				preparedStatement.setString(14, menuItemModels.get(i).getName());
				preparedStatement.setString(15, menuItemModels.get(i).getDescription());
				preparedStatement.setString(16, menuItemModels.get(i).getAvailableTime());
				preparedStatement.setInt(17, menuItemModels.get(i).getDeliveryTime());
				preparedStatement.setString(18, menuItemModels.get(i).getKeywords());
				preparedStatement.setString(19, menuItemModels.get(i).getImage());
				preparedStatement.setInt(20, menuItemModels.get(i).getPosition());
				preparedStatement.setDouble(21, menuItemModels.get(i).getPrice());
				preparedStatement.setInt(22, menuItemModels.get(i).getHotelId());
				preparedStatement.setInt(23, userId);

				preparedStatement.addBatch();

			}

			int[] updateCounts = preparedStatement.executeBatch();

			// since there were no errors, commit

			connection.commit();
			connection.setAutoCommit(true);
			////

			if (updateCounts.length > 0) {

				StaticResource.indexList.clear();
				StaticResource.optionList.clear();
				StaticResource.mainList.clear();

				StaticResource.indexList = null;
				StaticResource.optionList = null;
				StaticResource.mainList = null;

				return true;
			} else {
				return true;
			}

		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();

			return false;
		}

	}

	public void loadMenuItems() {

		try {
			Connection connection = DataSource.getInstance().getConnection();

			if (tableExist(connection, "ird_menuitems")) {
				String selectQuery = "SELECT * FROM ird_menuitems";
				Statement statement = (Statement) connection.createStatement();
				ResultSet set = statement.executeQuery(selectQuery);

				StaticResource.menuItemModelList = new ArrayList<MenuItemModel>();

				while (set.next()) {

					MenuItemModel model = new MenuItemModel();

					model.setMenuItemId(set.getInt("menuitem_id"));
					model.setMenuItemCode(set.getString("menuitem_code"));
					model.setName(set.getString("name"));

					model.setDescription(set.getString("description"));
					model.setAvailableTime(set.getString("available_time"));
					model.setDeliveryTime(set.getInt("delivery_time"));
					model.setKeywords(set.getString("keywords"));
					model.setImage(set.getString("image"));

					model.setPosition(set.getInt("position"));
					model.setPrice(set.getDouble("price"));
					model.setHotelId(set.getInt("hotel_id"));
					model.setCreatedBy(set.getInt("created_by"));
					model.setCreatedOn(set.getTimestamp("created_on"));

					model.setModifiedBy(set.getInt("modified_by"));
					model.setModifiedOn(set.getTimestamp("modified_on"));

					StaticResource.menuItemModelList.add(model);
				}

			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

	public static boolean tableExist(Connection conn, String tableName) throws SQLException {
		boolean tExists = false;
		try (ResultSet rs = conn.getMetaData().getTables(null, null, tableName, null)) {
			while (rs.next()) {
				String tName = rs.getString("TABLE_NAME");
				if (tName != null && tName.equals(tableName)) {
					tExists = true;
					break;
				}
			}
		}
		return tExists;
	}

	public boolean delete(int menuItemId) {

		try {
			Connection connection = DataSource.getInstance().getConnection();
			String sql = "DELETE FROM ird_menuitems WHERE menuitem_id = ?";
			PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
			preparedStatement.setInt(1, menuItemId);

			if (preparedStatement.executeUpdate() > 0) {
				return true;
			} else {
				return true;
			}

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			return false;
		}

	}

	public boolean update(MenuItemModel model,int userId) {

		
		Connection connection;
		try {
			connection = DataSource.getInstance().getConnection();
			connection.setAutoCommit(true);
			String updateQuary="UPDATE ird_menuitems SET menuitem_code=?,name=?,description=?,available_time=?,delivery_time=?,keywords=?,image=?,position=?,price=?,hotel_id=?,modified_by=?,modified_on=(SELECT CURRENT_TIMESTAMP()) WHERE menuitem_id=?";
			PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(updateQuary);
			
			preparedStatement.setString(1, model.getMenuItemCode());
			preparedStatement.setString(2, model.getName());

			preparedStatement.setString(3, model.getDescription());
			preparedStatement.setString(4, model.getAvailableTime());
			preparedStatement.setInt(5, model.getDeliveryTime());
			preparedStatement.setString(6, model.getKeywords());
			preparedStatement.setString(7, model.getImage());

			preparedStatement.setInt(8, model.getPosition());
			preparedStatement.setDouble(9, model.getPrice());
			preparedStatement.setInt(10, model.getHotelId());
			preparedStatement.setInt(11, userId);
			preparedStatement.setInt(12, model.getMenuItemId());
			
			if(preparedStatement.executeUpdate()>0){
				return true;
			}else{
				return false;
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return false;
		}
		
	}

}
