import java.sql.*;

public class FilterOriginalWineDatabase {

	public static ResultSet results;

	//Create Query by wineName
	public static ResultSet wineName(String condition) 
	{

		try {

			//SQL Select Query
			String query = "SELECT * FROM OriginalWineDatabase WHERE WineName LIKE \"%" + condition + "%\"";
			//Create a SQL Statement object
			Statement stmt = WineDemo.sql.createStatement();

			//Execute the query on the statement object
			//  Returns a ResultSet.
			results = stmt.executeQuery(query);



		} catch(SQLException e) { //Handle exceptions
			System.out.println(e.getMessage());
		}
		return results;
	}

	//Create Query for brand
	public static ResultSet brand(String condition) 
	{

		try {

			//SQL Select Query
			String query = "SELECT * FROM OriginalWineDatabase WHERE Brand LIKE \"%" + condition + "%\"";
			//Create a SQL Statement object
			Statement stmt = WineDemo.sql.createStatement();

			//Execute the query on the statement object
			//  Returns a ResultSet.
			results = stmt.executeQuery(query);



		} catch(SQLException e) { //Handle exceptions
			System.out.println(e.getMessage());
		}
		return results;
	}

	//Create Query for Varietal
	public static ResultSet varietal(String condition) 
	{

		try {

			//SQL Select Query
			String query = "SELECT * FROM OriginalWineDatabase WHERE Varietal = " + "'"+condition+"'";

			//Create a SQL Statement object
			Statement stmt = WineDemo.sql.createStatement();

			//Execute the query on the statement object
			//  Returns a ResultSet.
			results = stmt.executeQuery(query);



		} catch(SQLException e) { //Handle exceptions
			System.out.println(e.getMessage());
		}
		return results;
	}

	//Create Query for Class (sweetness)
	public static ResultSet classType(String condition, String value) 
	{

		try {
			String query;

			//SQL Select Query
			if(condition.equals("Ascending"))
			{
				query = "SELECT * FROM originalwinedatabase ORDER BY Class ASC"; 
			}
			else if(condition.equals("Descending"))
			{
				query = "SELECT * FROM originalwinedatabase ORDER BY Class DESC"; 
			}
			else if( condition.equals(">="))
			{
				query = "SELECT * FROM OriginalWineDatabase WHERE Class >= " + "'" + value + "'" +  "ORDER BY Class";
			}
			else if (condition.equals("<="))
			{
				query = "SELECT * FROM OriginalWineDatabase WHERE Class <= " + "'" + value + "'" +  "ORDER BY Class";
			}
			else //equal to
			{
				query = "SELECT * FROM OriginalWineDatabase WHERE Class = " + "'" + value + "'";
			}

			//Create a SQL Statement object
			Statement stmt = WineDemo.sql.createStatement();

			//Execute the query on the statement object
			//  Returns a ResultSet.
			results = stmt.executeQuery(query);

		} catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}

		return results;
	}

	//Create Query for subClass
	public static ResultSet subClass(String condition) 
	{

		try {
			String query;

			//SQL Select Query
			//Requires user to enter subClass ex- Moscato
			query = "SELECT * FROM OriginalWineDatabase WHERE subClass LIKE \"%" + condition + "%\"";


			//Create a SQL Statement object
			Statement stmt = WineDemo.sql.createStatement();

			//Execute the query on the statement object
			//  Returns a ResultSet.
			results = stmt.executeQuery(query);

		} catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}

		return results;
	}

	//Create Query for Region
	public static ResultSet region(String condition) 
	{

		try {
			String query;

			//SQL Select Query
			query = "SELECT * FROM OriginalWineDatabase WHERE Region = " + "'"+condition+"'";


			//Create a SQL Statement object
			Statement stmt = WineDemo.sql.createStatement();

			//Execute the query on the statement object
			//  Returns a ResultSet.
			results = stmt.executeQuery(query);

		} catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}

		return results;
	}

	//Create Query for compatibleFoods
	public static ResultSet compatibleFoods(String condition) 
	{

		try {
			String query;

			//SQL Select Query
			query = "SELECT * FROM OriginalWineDatabase WHERE CompatibleFoods LIKE \"%" + condition + "%\"";

			//Create a SQL Statement object
			Statement stmt = WineDemo.sql.createStatement();

			//Execute the query on the statement object
			//  Returns a ResultSet.
			results = stmt.executeQuery(query);

		} catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}

		return results;
	}

	//Create Query for priceRange
	public static ResultSet priceRange(String condition, String value) 
	{

		try {
			String query;

			//SQL Select Query
			if(condition.equals("Ascending"))
			{
				query = "SELECT * FROM originalwinedatabase ORDER BY PriceRange ASC"; 
			}
			else if(condition.equals("Descending"))
			{
				query = "SELECT * FROM originalwinedatabase ORDER BY PriceRange DESC"; 
			}
			else if( condition.equals(">="))
			{
				query = "SELECT * FROM OriginalWineDatabase WHERE PriceRange >= " + "'" + value + "'" +  "ORDER BY PriceRange";
			}
			else if (condition.equals("<="))
			{
				query = "SELECT * FROM OriginalWineDatabase WHERE PriceRange <= " + "'" + value + "'" +  "ORDER BY PriceRange";
			}
			else //equal to
			{
				query = "SELECT * FROM OriginalWineDatabase WHERE PriceRange = " + "'" + value + "'";
			}
			
			//Create a SQL Statement object
			Statement stmt = WineDemo.sql.createStatement();

			//Execute the query on the statement object
			//  Returns a ResultSet.
			results = stmt.executeQuery(query);

		} catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}

		return results;
	}

	//Create Query for priceRange
	public static ResultSet globalRating(String condition, String value) 
	{

		try {
			String query;

			//SQL Select Query
			if(condition.equals("Ascending"))
			{
				query = "SELECT * FROM originalwinedatabase ORDER BY GlobalRating ASC"; 
			}
			else if(condition.equals("Descending"))
			{
				query = "SELECT * FROM originalwinedatabase ORDER BY GlobalRating DESC"; 
			}
			else if( condition.equals(">="))
			{
				query = "SELECT * FROM OriginalWineDatabase WHERE GlobalRating >= " + "'" + value + "'" +  "ORDER BY GlobalRating";
			}
			else if (condition.equals("<="))
			{
				query = "SELECT * FROM OriginalWineDatabase WHERE GlobalRating <= " + "'" + value + "'" +  "ORDER BY GlobalRating";
			}
			else //equal to
			{
				query = "SELECT * FROM OriginalWineDatabase WHERE GlobalRating = " + "'" + value + "'";
			}

			//Create a SQL Statement object
			Statement stmt = WineDemo.sql.createStatement();

			//Execute the query on the statement object
			//  Returns a ResultSet.
			results = stmt.executeQuery(query);

		} catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}

		return results;
	}
}