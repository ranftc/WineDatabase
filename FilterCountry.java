import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class FilterCountry {

	public static ResultSet results;

	//Create Query for country
	public static ResultSet drinkingAges(String condition, String value) 
	{


		try {

			String query = "";
			//SQL Select Query

			if( condition.equals("Ascending")) //ASC for ascend
			{
				query = "SELECT * FROM Country ORDER BY wineDrinkingAge ASC";
			}
			else if( condition.equals("Descending")) //DESC for descend
			{
				query = "SELECT * FROM Country ORDER BY wineDrinkingAge DESC";
			}
			else if( condition.equals("Total Ban") || condition.equals("Unknown")) // for bans and unknown searchs
			{
				query = "SELECT * FROM Country WHERE wineDrinkingAge LIKE \"%" + condition + "%\"";
			}
			else if( condition.equals(">="))
			{
				query = "SELECT * FROM Country WHERE wineDrinkingAge >= " + "'" + value + "'";
			}
			else if( condition.equals("<="))
			{
				query = "SELECT * FROM Country WHERE wineDrinkingAge <= " + "'" + value + "'";
			}
			else if (condition.equals("="))
			{
				query = "SELECT * FROM Country WHERE wineDrinkingAge = " + "'" + value + "'";
			}
			else  //Search for specific country
			{
				query = "SELECT * FROM Country WHERE countryName LIKE \"%" + value + "%\"";
				
			}

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
}