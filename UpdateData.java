import java.sql.*;


public class UpdateData
{
	//  Update statements

	/**
	 * Updates the release date of a game.
	 *
	 * @param title - key attribute, title of game release to be updated
	 * @param year - key attribute, year of game release to be updated
	 * @param platform - key attribute, platform of the game release to be updated
	 * @param date - new date for the game release.
	 */
	public static void updateUserWineDatabase(String wineName,
			String brand,
			String personalRating) 
	{

		try {
			//Query String
			String query = "UPDATE UserWineDatabase SET PersonalRating = ? WHERE WineName = ? "
					+ "AND Brand = ? ";

			//Prepared Statement
			PreparedStatement pstmt = WineDemo.sql.prepareStatement(query);
			pstmt.setString(1, personalRating); 
			pstmt.setString(2, wineName);
			pstmt.setString(3, brand);

			//Execute the update
			pstmt.executeUpdate();

		} catch(SQLException e) {
			System.out.println(e.getMessage()); //Handles exception
		}
	}

	//Update user password
	public static void updateUserPassword(String userName,
			String userPassword) 
	{

		try {
			//Query String
			String query = "UPDATE UserProfile SET UserPassword = ? WHERE UserName = ? ";

			//Prepared Statement
			PreparedStatement pstmt = WineDemo.sql.prepareStatement(query);
			pstmt.setString(1, userPassword); 
			pstmt.setString(2, userName);

			//Execute the update
			pstmt.executeUpdate();

		} catch(SQLException e) {
			System.out.println(e.getMessage()); //Handles exception
		}
	}

	//Update user password
	public void updateUserCountry(String userName,
			String countryName) 
	{

		try {
			//Query String
			String query = "UPDATE UserProfile SET CountryName = ? WHERE UserName = ? ";

			//Prepared Statement
			PreparedStatement pstmt = WineDemo.sql.prepareStatement(query);
			pstmt.setString(1, countryName); 
			pstmt.setString(2, userName);

			//Execute the update
			pstmt.executeUpdate();

		} catch(SQLException e) {
			System.out.println(e.getMessage()); //Handles exception
		}
	}
}