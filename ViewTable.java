import java.sql.*;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class ViewTable {


	public String table = "";
	public static ResultSet results;


	public static ResultSet fullTableQuery(String table)
	{
		try {

			//SQL Select Query
			String query = "SELECT * FROM " + table;

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


	public static void printTable(ResultSet results) {

		try {

			//if NULL print message saying no search results
			if (results.first())
			{
				ResultSetMetaData rsmd = results.getMetaData();
				int numCols = rsmd.getColumnCount();
				for (int i= 1; i <= numCols; i++) {
					if (i == numCols)
						System.out.println(rsmd.getColumnLabel(i));
					else
						System.out.print(rsmd.getColumnLabel(i) +", ");
				}
				System.out.println("");


				//From our results, we can now print out the data retrieved.
				//  - result.next() advances the result record to the next result tuple
				//     * Your initial result.next() advances to the first record
				//     * returns null when you have reached the end of the result set.

				//Let's look at the data

				do
				{
					//Given the result, you now must retrieve the value column-by-column
					// * We are generically retrieving ech column as type string, which returns the string
					//   representation of the tuple element.
					for (int i=1; i <= numCols; i++) {

						//Retrieving the value for the ith column in the tuple
						String nextVal = results.getString(i);
						if (i==numCols)
							System.out.println(nextVal);
						else
							System.out.print(nextVal + ", ");
					}

				}while (results.next());
				System.out.println("\n****************************************************************************************************\n");
			}
			else
			{
				//ResultSet results is empty
				System.out.println("\tNo search results\n");
				System.out.println("****************************************************************************************************\n");

			}


		} catch(SQLException e) { //Handle exceptions
			System.out.println(e.getMessage());
		}

	}

	public static void GUITable(ResultSet results, GridPane gridPane) {

		try {
			gridPane.getChildren().clear();
			gridPane.setHgap(10); //horizontal gap in pixels => that's what you are asking for
			gridPane.setVgap(10); //vertical gap in pixels
			gridPane.setPadding(new Insets(10, 10, 10, 10)); //margins around the whole grid
			                                             //(top/right/bottom/left)
			//if NULL print message saying no search results
			if (results.first())
			{
				ResultSetMetaData rsmd = results.getMetaData();
				int numCols = rsmd.getColumnCount();
				for (int i= 1; i <= numCols; i++) 
				{	
					Label la = new Label();
					la.setText(rsmd.getColumnLabel(i));
					gridPane.add(la, (i-1), 0);

				}	


				//From our results, we can now print out the data retrieved.
				//  - result.next() advances the result record to the next result tuple
				//     * Your initial result.next() advances to the first record
				//     * returns null when you have reached the end of the result set.

				//Let's look at the data
				int row = 1;
				do
				{
					//Given the result, you now must retrieve the value column-by-column
					// * We are generically retrieving each column as type string, which returns the string
					//   representation of the tuple element.

					for (int i = 1; i <= numCols; i++) 
					{
						Label la = new Label();
						//Retrieving the value for the ith column in the tuple
						String nextVal = results.getString(i);

						la.setText(nextVal);
						gridPane.add(la, (i-1), row);
					}
					row++;
				} while (results.next());

			}
			else
			{
				Label la = new Label();
				//ResultSet results is empty
				la.setText("No search results");
				gridPane.add(la, 0, 0);
			}

		} catch(SQLException e) { //Handle exceptions
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}

}
