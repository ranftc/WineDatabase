import java.sql.*;

public class InsertData {

	/**
	 * Adds a tuple to game releases.
	 *
	 * @param title - title of game to be added
	 * @param year - year of initial release of game to be added
	 * @param platform - platform for this version of the game.
	 * @param date - date of release of this version of game
	 */
	public static void addUserProfile(String userName,
			String userPassword,
			String firstName,
			String lastName,
			String dob,
			String countryName) 
	{
		try {

			//Create insert query string
			String insertString = "INSERT INTO UserProfile VALUES (?, ?, ?, ?, ?, ?)";

			//Create prepared statement for insert and assign it the values.
			PreparedStatement insertStatement = WineDemo.sql.prepareStatement(insertString);
			insertStatement.setString(1, userName);
			insertStatement.setString(2, userPassword);
			insertStatement.setString(3, firstName);
			insertStatement.setString(4, lastName);
			insertStatement.setString(5, dob);
			insertStatement.setString(6, countryName);

			//Perform the insert and confirm success.
			int rows = insertStatement.executeUpdate();
			if (rows != 1) {
				System.out.println("ALERT: Insertion failed.");
			}

		} catch(SQLException e) {
			System.out.println(e.getMessage()); //Handles exceptons.
		}
	}

	public static void addUserWineDatabase (String wineName,
			String brand,
			String userName,
			String personalRating) 
	{
		try {

			//Create insert query string
			String insertString = "INSERT INTO UserWineDatabase VALUES (?, ?, ?, ?)";

			//Create prepared statement for insert and assign it the values.
			PreparedStatement insertStatement = WineDemo.sql.prepareStatement(insertString);
			insertStatement.setString(1, wineName);
			insertStatement.setString(2, brand);
			insertStatement.setString(3, userName);
			insertStatement.setString(4, personalRating);


			//Perform the insert and confirm success.
			int rows = insertStatement.executeUpdate();
			if (rows != 1) {
				System.out.println("ALERT: Insertion failed.");
			}

		} catch(SQLException e) {
			System.out.println(e.getMessage()); //Handles exceptons.
		}
	}
	
	public static void addOriginalWine(String wineName,
			String brand,
			String varietal,
			String classType,
			String subClass,
			String region,
			String compatibleFoods,
			String priceRange,
			String globalRating) 
	{
		try {

			//Create insert query string
			String insertString = "INSERT INTO OriginalWineDatabase VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

			//Create prepared statement for insert and assign it the values.
			PreparedStatement insertStatement = WineDemo.sql.prepareStatement(insertString);
			insertStatement.setString(1, wineName);
			insertStatement.setString(2, brand);
			insertStatement.setString(3, varietal);
			insertStatement.setString(4, classType);
			insertStatement.setString(5, subClass);
			insertStatement.setString(6, region);
			insertStatement.setString(7, compatibleFoods);
			insertStatement.setString(8, priceRange);
			insertStatement.setString(9, globalRating);



			//Perform the insert and confirm success.
			int rows = insertStatement.executeUpdate();
			if (rows != 1) {
				System.out.println("ALERT: Insertion failed.");
			}

		} catch(SQLException e) {
			System.out.println(e.getMessage()); //Handles exceptons.
		}
	}
}