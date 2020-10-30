import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class WineDemo{


	public static String url = "jdbc:mysql://localhost:3306/TEST?useSSL=false";
	public static String user = "root";
	public static String pswd = "12345";

	public static String table = "";

	public static String wineNameCondition = "Cook's";
	public static String brandCondition = "Block";
	public static String varietalCondition = "Rose";
	public static String classTypeCondition = "6";
	public static String subClassCondition = "Pinot";
	public static String regionCondition = "Italy";
	public static String foodCondition = "Crab";
	public static String condition = "";
	public static String priceCondition = "-7";
	public static String globalRatingCondition = "3";

	//public static String countryCondition = "Total"; //condition = "Total ban";
	//public static String countryCondition = "21"; //condition = "Equal";
	public static String countryCondition = "Vietnam"; //condition = "";

	public static ResultSet resultFullTable;
	public static ResultSet resultWineName;
	public static ResultSet resultBrand;
	public static ResultSet resultVarietal;
	public static ResultSet resultClassType;
	public static ResultSet resultSubClass;
	public static ResultSet resultRegion;
	public static ResultSet resultCompatibleFoods;
	public static ResultSet resultPriceRange;
	public static ResultSet resultGlobalRating;
	public static ResultSet resultFilteredCountry;

	public static ResultSet resultUserProfileDatabase;
	public static ResultSet resultOriginalWineDatabase;
	public static ResultSet resultUserWineDatabase;
	public static ResultSet resultCountryDatabase;


	public static String userName; 
	public static String userPassword;
	public static String firstName;
	public static String lastName;
	public static String dob;
	public static String countryName;

	public static String wineName;
	public static String brand;
	public static String varietal;
	public static String classType;
	public static String subClass;
	public static String region;
	public static String compatibleFoods;
	public static String priceRange;
	public static String personalRating;

	public static boolean valid;	
	public static boolean signUp;	//button signUP true
	public static boolean addWine;	//button addWine true


	public static Connection sql;

	public static void WineDemo()
	{		

		table = "UserProfile";
		resultFullTable = ViewTable.fullTableQuery(table);
		ViewTable.printTable(resultFullTable);


		resultWineName = FilterOriginalWineDatabase.wineName(wineNameCondition);

		resultBrand = FilterOriginalWineDatabase.brand(brandCondition);

		resultVarietal = FilterOriginalWineDatabase.varietal(varietalCondition);
		ViewTable.printTable(resultVarietal);

		condition = "GreaterThan";
		resultClassType = FilterOriginalWineDatabase.classType(condition,classTypeCondition);
		ViewTable.printTable(resultClassType);

		resultSubClass = FilterOriginalWineDatabase.subClass(subClassCondition);
		ViewTable.printTable(resultSubClass);

		resultRegion = FilterOriginalWineDatabase.region(regionCondition); 
		ViewTable.printTable(resultRegion);

		resultCompatibleFoods = FilterOriginalWineDatabase.compatibleFoods(foodCondition); 
		ViewTable.printTable(resultCompatibleFoods);

		condition = "LessThan";
		resultPriceRange = FilterOriginalWineDatabase.priceRange(condition, priceCondition);
		ViewTable.printTable(resultPriceRange);

		condition = "";
		resultGlobalRating = FilterOriginalWineDatabase.globalRating(condition, globalRatingCondition); 
		ViewTable.printTable(resultGlobalRating);

		condition = "";
		resultFilteredCountry = FilterCountry.drinkingAges(condition,countryCondition);
		ViewTable.printTable(resultFilteredCountry);


		//close Database
		if (sql != null) 
		{
			try {
				sql.close();
			} catch (SQLException e) {
				//ignore
			}
		}

	}

	//Establish Sequel Connection
	public static void initiateConnection()
	{		
		/** Creates an instance of the database connection **/
		try {
			sql = DriverManager.getConnection(url, user, pswd);
		}
		catch (SQLException e){
			System.out.println(e.getMessage()); //Handle exceptions
		}
	}
	/*	//TODO: ERROR this doesn't check correctly -> logic error
	public static boolean dateCheck(String dob)
	{
		String strDoB = dob;
		String [] arrOfStr = strDoB.split("-", 2);
		boolean validDob = true;

		if (arrOfStr[0].length() != 4)
		{
			System.out.println("ALERT: Invalid Date Of Birth");
			validDob = false;
		}
		if (arrOfStr[1].length() != 2 || arrOfStr[2].length() != 2)
		{
			System.out.println("ALERT: Invalid Date Of Birth");
			validDob = false;
		}
		return validDob;
	}
	 */

	//verify that a single string is in database
	public static boolean verifyData(String str, ResultSet result)
	{
		boolean verifyData = false;

		try {


			while ( result.next())
			{

				for (int col = 1; col <= 6; col++) 
				{
					String nextVal = result.getString(col);
					if(str.equals(nextVal))
					{
						verifyData = true;
					}

				}

			}
		}catch(SQLException e) //Handle exception
		{
			System.out.println(e.getMessage());

		}
		return verifyData;
	}

	//verify that a single string is in database
	public static boolean verifyWine(String str1, String str2, ResultSet result)
	{
		boolean verifyData = false;

		try {


			while (result.next())
			{
				ResultSetMetaData rsmd = result.getMetaData();
				int numCols = rsmd.getColumnCount();
				for (int i = 1; i < numCols; i++) 
				{
					String nextVal = result.getString(i);
					String nextVal2 = result.getString(i +1);

					if(str1.equals(nextVal) && str2.equals(nextVal2)) 
					{
						verifyData = true; //only true if wineName, brand, already exist
					}

				}

			}
		}catch(SQLException e) //Handle exception
		{
			System.out.println(e.getMessage());

		}
		return verifyData;
	}
		
}