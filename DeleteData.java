import java.sql.*;


public class DeleteData{
	

/**
     * Deletes a game and its associated releases
     * @param title - title of game to delete
     * @param year - year of game to delete
     */
	//Delete only in UserWineDatabase
    public static void deleteWine(String wineName, String brand)
    {


        //Prepare the delete statement strings with ? for the key attributes of title and year
        String deleteUserWine = "DELETE FROM UserWineDatabase WHERE wineName = ? AND brand = ?";

        //Declare prepared statement variables.
        PreparedStatement deleteUserWineStmt;

        try {

            //Start Transaction by Setting Auto Commit to False
            //  Note: we must re-enable auto-commit when we are done to restore the system to the default
            //  state.
            WineDemo.sql.setAutoCommit(false);

            //Perform the first delete by preparing and executing the statement
            deleteUserWineStmt = WineDemo.sql.prepareStatement(deleteUserWine);
            deleteUserWineStmt.setString(1, wineName);
            deleteUserWineStmt.setString(2, brand);
            deleteUserWineStmt.executeUpdate();


            //Commit the change to make the change live to the database.
            WineDemo.sql.commit();

        } catch(SQLException e) {

            //If an exception occurs, we will roll back the transaction to avoid having an error state.

            try {
                System.out.println("Rolling Back Transaction.");

                //Performs the roll back.
                WineDemo.sql.rollback();
            } catch(SQLException e2) {
                System.out.println(e2.getMessage()); //Handle exception
            }

        } finally {

            //Finally is called after the try ends by reaching the end of its code or from a return statement.
            //  We include it here so that we can reenable autocommit and take it out of transaction mode.

            try {
                //Re-enable autocommit
                WineDemo.sql.setAutoCommit(true);
            } catch(SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}