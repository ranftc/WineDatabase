import java.sql.ResultSet;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class WineGUI extends Application {

	// Declare panes of different layout types
	private GridPane logInPane;
	private GridPane profilePane;
	private GridPane enterWinePane;
	private GridPane originalWinePane;
	private GridPane userWinePane;
	private GridPane countryPane;
	GridPane wineResultGridPane = new GridPane();
	GridPane userWineResultGridPane = new GridPane();
	GridPane countryResultGridPane = new GridPane();
	//private Pane testPane;

	// Delcare all buttons
	private Button 
	// logInPane (grid pane)
	newUserBt, logInBt,
	// profilePane (grid pane)
	createBt, addBt, deleteBt, updateBt,
	// originalWinePane
	accessUserWineBt, accessProfileBt, accessCountryListBt,
	ogGoBt,
	// userWinePane
	returnToWineLibrary,
	// countryPane
	returnToUserWine, returnToWineLibrary2, countryGoBt,
	// enterWinePane
	enterBt;


	// Declare text to add to the panes
	private Label 
	//logInPane (grid pane)
	logInInvalid1, logInInvalid2, userNameInvalid, userNameInvalid1, logInInvalid3,
	wineNotLabel, usernameLabel, passwordLabel,
	// labels for profile page
	profileLabel, firstNameLabel, lastNameLabel, profileUserNameLabel, profilePasswordLabel, 
	countryLabel, birthdateLabel,
	// labels for original wine
	originalWineLabel,
	// label for user wine
	userWineLabel, userFillerLabel, userFillerLabel2, enterWineLabel, wineNameLabel, brandLabel,
	varietalLabel, classTypeLabel, subClassLabel, regionLabel, compatibleFoodLabel, priceRangeLabel,
	personalRatingLabel,userNameLabel, deleteNameLabel, deleteBrandLabel, updateRatingLabel,
	// label for country pane
	countryHeaderLabel, countryFillerLabel;

	private TabPane tabPane;
	private Tab logInTab, profileTab, originalWineTab, userWineTab, countryTab, enterWineTab;

	// Declare TextField Save Values
	public static String userName; 
	public static String userPassword;
	public static String firstName;
	public static String lastName;
	public static String dob;
	public static String countryName;

	//Declare TextField Save Values
	public static String wineName;
	public static String brand;
	public static String varietal;
	public static String classType;
	public static String subClass;
	public static String region;
	public static String compatibleFood;
	public static String priceRange;
	public static String personalRating;

	public static boolean validCheckPassword;
	public static boolean validCheckUserName;
	public static boolean validCheck;

	public static String originalFilterChoice = "";
	public static String countryFilterChoice = "";
	public static String originalOperationChoice = "";
	public static String countryOperationChoice = "";
	public static String originalSearch = "";
	public static String countrySearch = "";
	public static String condition = "";

	//  constructor
	public WineGUI() {

		logInPane =  new GridPane();
		profilePane =  new GridPane();
		originalWinePane =  new GridPane();
		userWinePane =  new GridPane();
		countryPane = new GridPane();
		enterWinePane = new GridPane();

		profilePane.setPadding(new Insets(10, 50, 10, 50)); //margins around the whole grid(top/right/bottom/left)
		originalWinePane.setPadding(new Insets(10, 10, 10, 10)); //margins around the whole grid(top/right/bottom/left)
		userWinePane.setPadding(new Insets(10, 10, 10, 10)); //margins around the whole grid(top/right/bottom/left)
		countryPane.setPadding(new Insets(10, 10, 10, 10)); //margins around the whole grid (top/right/bottom/left)
		logInPane.setPadding(new Insets(10, 50, 10, 50)); //margins around the whole grid (top/right/bottom/left)
		enterWinePane.setPadding(new Insets(10, 50, 10, 50));

		// Initiate Tabs
		tabPane = new TabPane();
		profileTab = new Tab();
		originalWineTab = new Tab();
		userWineTab = new Tab();
		countryTab = new Tab();
		logInTab = new Tab();
		enterWineTab = new Tab();

		tabPane.getTabs().add(originalWineTab);
		tabPane.getTabs().add(profileTab);
		tabPane.getTabs().add(userWineTab);
		tabPane.getTabs().add(countryTab);
		tabPane.getTabs().add(logInTab);	//leave visible in the beginning
		tabPane.getTabs().add(enterWineTab);

		originalWineTab.setDisable(true);
		profileTab.setDisable(true);
		userWineTab.setDisable(true);
		countryTab.setDisable(true);
		enterWineTab.setDisable(true);

		// -------------------------------------------------------------------------------------------
		// TABS

		// Add panes to TabPane
		// logInTab
		logInTab.setText("Log In");
		logInTab.setContent(logInPane);
		tabPane.getSelectionModel().select(logInTab);

		// profileTab
		profileTab.setText("User Profile");
		profileTab.setContent(profilePane);		

		// originalWineTab
		originalWineTab.setText("Wine Database");
		originalWineTab.setContent(originalWinePane);

		// userWineTab
		userWineTab.setText("Personal Wine Database");
		userWineTab.setContent(userWinePane);

		// country tab
		countryTab.setText("International Drinking Ages");
		countryTab.setContent(countryPane);

		enterWineTab.setText("Enter Wine");
		enterWineTab.setContent(enterWinePane);
		// -------------------------------------------------------------------------------------------


		// LOG IN PANE

		// intialize the pane
		logInPane.setAlignment(Pos.BASELINE_CENTER);
		logInPane.setVgap(20);
		// inialize the labels
		wineNotLabel = new Label("                 WINE NOT?");
		// Set the position
		wineNotLabel.setPrefSize(3000, 50);
		// Set the appearance
		wineNotLabel.setFont(new Font("Georgia", 75));
		wineNotLabel.setBackground(new Background(new BackgroundFill(Color.CADETBLUE, null, null)));
		usernameLabel = new Label("Username: ");
		// create the textfield
		TextField logInUsernameTF = new TextField();
		HBox logInUsernameHB = new HBox();
		logInUsernameHB.getChildren().addAll(usernameLabel, logInUsernameTF);
		logInUsernameHB.setSpacing(20);	
		// set the font
		usernameLabel.setFont(new Font("Georgia", 40));
		passwordLabel = new Label("Password:  ");
		// create the textfield
		TextField logInPasswordTF = new TextField();
		HBox logInPasswordHB = new HBox();
		logInPasswordHB.getChildren().addAll(passwordLabel, logInPasswordTF);
		logInPasswordHB.setSpacing(20);
		// set the font
		passwordLabel.setFont(new Font("Georgia", 40));
		// intialize the buttons
		newUserBt = new Button("New User");
		// edit parameters
		newUserBt.setFont(new Font("Georgia", 30));
		newUserBt.setTextFill(Color.WHITE);
		newUserBt.setStyle("color:navy; -fx-background-color: navy");

		// change to to profile pane when clicked
		newUserBt.setOnMouseClicked(e -> {
			tabPane.getSelectionModel().select(profileTab); //Select profileTab
		});

		logInBt = new Button("Log In");
		// edit parameters
		logInBt.setFont(new Font("Georgia", 30));
		logInBt.setTextFill(Color.WHITE);
		logInBt.setStyle("color:navy; -fx-background-color: navy");

		// change to original wine database when clicked
		logInBt.setOnMouseClicked(e -> {

			userName = logInUsernameTF.getText();
			userPassword = logInPasswordTF.getText();


			if (!userName.isEmpty() && !userPassword.isEmpty())
			{
				tabPane.getSelectionModel().select(originalWineTab);
				originalWineTab.setDisable(false);
				userWineTab.setDisable(false);
				countryTab.setDisable(false);                                             		
			}
			else
			{
				//logInBt.setVisible(false);
				logInInvalid1.setVisible(true);
				logInInvalid1.setFont(new Font("Georgia", 40));
			}

		});

		logInInvalid1 = new Label();
		logInInvalid1.setText("INVALID USERNAME OR PASSWORD");
		logInInvalid1.setVisible(false);

		// adding
		// add labels
		logInPane.add(wineNotLabel, 0, 0);
		// add buttons
		logInPane.add(newUserBt, 0, 8);
		logInPane.add(logInInvalid1, 0, 5);


		logInPane.add(logInBt, 0, 6);
		// add labels with textfields
		logInPane.add(logInUsernameHB, 0, 3);
		logInPane.add(logInPasswordHB, 0, 4);

		// --------------------------------------------------------------------------------------------





		// --------------------------------------------------------------------------------------------
		// PROFILE PANE

		// intialize the pane
		profilePane.setAlignment(Pos.BASELINE_CENTER);
		profilePane.setVgap(20);


		// inialize the labels
		profileLabel = new Label("                 User Profile");
		// Set the position
		profileLabel.setPrefSize(2000, 50);
		// Set the appearance
		profileLabel.setFont(new Font("Georgia", 75));
		profileLabel.setBackground(new Background(new BackgroundFill(Color.CADETBLUE, null, null)));
		firstNameLabel = new Label("First Name:  ");
		// Create Text Field
		TextField firstNameTF = new TextField();
		HBox firstNameHB = new HBox();
		firstNameHB.getChildren().addAll(firstNameLabel, firstNameTF);
		firstNameHB.setSpacing(20);
		// set the font
		firstNameLabel.setFont(new Font("Georgia", 40));
		lastNameLabel = new Label("Last Name:   ");
		// Create Text Field
		TextField lastNameTF = new TextField();
		HBox lastNameHB = new HBox();
		lastNameHB.getChildren().addAll(lastNameLabel, lastNameTF);
		lastNameHB.setSpacing(20);
		// set the font
		lastNameLabel.setFont(new Font("Georgia", 40));
		profileUserNameLabel = new Label("Username:    ");
		// Create Text Field
		TextField profileUsernameTF = new TextField();
		HBox profileUsernameHB = new HBox();
		profileUsernameHB.getChildren().addAll(profileUserNameLabel, profileUsernameTF);
		profileUsernameHB.setSpacing(20);
		// set the font
		profileUserNameLabel.setFont(new Font("Georgia", 40));
		profilePasswordLabel = new Label("Password:     ");
		// Create Text Field
		TextField profilePasswordTF = new TextField();
		HBox profilePasswordHB = new HBox();
		profilePasswordHB.getChildren().addAll(profilePasswordLabel, profilePasswordTF);
		profilePasswordHB.setSpacing(20);
		// Set the Font
		profilePasswordLabel.setFont(new Font("Georgia", 40));
		countryLabel = new Label("Country:        ");
		// Create the Text Field
		TextField countryTF = new TextField();
		HBox countryHB = new HBox();
		countryHB.getChildren().addAll(countryLabel, countryTF);
		countryHB.setSpacing(20);
		// Set the Font
		countryLabel.setFont(new Font("Georgia", 40));
		birthdateLabel = new Label("Birthdate:      ");
		// Create the Text Field
		TextField birthdateTF = new TextField();
		HBox birthdateHB = new HBox();
		birthdateHB.getChildren().addAll(birthdateLabel, birthdateTF);
		birthdateHB.setSpacing(20);
		// Set the Font
		birthdateLabel.setFont(new Font("Georgia", 40));	

		// intialize the buttons
		createBt = new Button("Create/Update Profile");
		// change font for profilePane buttons
		createBt.setFont(new Font("Georgia", 30));
		createBt.setTextFill(Color.WHITE);
		createBt.setStyle("color:navy; -fx-background-color: navy");

		// change to original wine database when clicked
		createBt.setOnMouseClicked(e -> {
			logInTab.setDisable(true);
			firstName = firstNameTF.getText();
			lastName= lastNameTF.getText();
			userName = profileUsernameTF.getText();
			userPassword = profilePasswordTF.getText();
			dob = birthdateTF.getText();
			countryName = countryTF.getText();

			if (!userName.isEmpty() && !userPassword.isEmpty() && !firstName.isEmpty() 
					&& !lastName.isEmpty() && !dob.isEmpty() && !countryName.isEmpty())
			{

				if (WineDemo.verifyData(userName, ViewTable.fullTableQuery("UserProfile"))) //return true if userName already exist
				{
					//error invalid input
					userNameInvalid.setVisible(true);
					logInInvalid2.setVisible(false);
					userNameInvalid.setFont(new Font("Georgia", 30));

				}
				else
				{
					//Insert data into userProfile
					InsertData.addUserProfile( userName, userPassword, firstName, lastName, dob, countryName);

					originalWineTab.setDisable(false);
					userWineTab.setDisable(false);
					countryTab.setDisable(false);   
					tabPane.getSelectionModel().select(originalWineTab); //Select OriginalWineTab

				}

			}
			else
			{
				logInInvalid2.setVisible(true);
				logInInvalid2.setFont(new Font("Georgia", 30));
			}

		});	
		userNameInvalid = new Label();
		userNameInvalid.setText("USERNAME ALREADY CLAIMED");
		userNameInvalid.setVisible(false);
		logInInvalid2 = new Label();
		logInInvalid2.setText("INVALID USERNAME OR PASSWORD");
		logInInvalid2.setVisible(false);

		// adding				
		// add labels - ALL WILL NEED TO 
		profilePane.add(profileLabel, 0, 0);
		// add buttons
		profilePane.add(createBt, 0, 9);
		// add labels with textfileds
		profilePane.add(logInInvalid2, 0, 10);
		profilePane.add(userNameInvalid, 0, 10);
		profilePane.add(firstNameHB, 0, 3);
		profilePane.add(lastNameHB, 0, 4);
		profilePane.add(profileUsernameHB, 0, 5);
		profilePane.add(profilePasswordHB, 0, 6);
		profilePane.add(countryHB, 0, 7);
		profilePane.add(birthdateHB, 0, 8);					
		// --------------------------------------------------------------------------------------------





		// --------------------------------------------------------------------------------------------
		// ORIGINAL WINE PANE

		// intialize the pane
		originalWinePane.setAlignment(Pos.BASELINE_CENTER);
		originalWinePane.setVgap(20);


		//TODO: add Database to GUI
		//ViewTable.

		// inialize the labels
		originalWineLabel = new Label("  Wine Library");
		// Set the position
		originalWineLabel.setPrefSize(1500, 50);
		// Set the appearance
		originalWineLabel.setFont(new Font("Georgia", 70));
		originalWineLabel.setBackground(new Background(new BackgroundFill(Color.CADETBLUE, null, null)));
		userFillerLabel2 = new Label("  ");
		// Set the position
		userFillerLabel2.setPrefSize(250, 80);
		userFillerLabel2.setBackground(new Background(new BackgroundFill(Color.CADETBLUE, null, null)));
		// adding

		TextField ogSearchTF = new TextField();
		HBox ogSearchHB = new HBox();
		ogSearchHB.getChildren().addAll(ogSearchTF);
		ogSearchHB.setSpacing(20);
		// create filter box
		ComboBox<String> originalWineFilter = new ComboBox<>();
		originalWineFilter.setPrefWidth(250);
		originalWineFilter.getItems().addAll(
				"Original",
				"Wine Name",
				"Brand",
				"Varietal",
				"Class Type",
				"Sub Class",
				"Region",
				"Compatible Foods",
				"Price Range",
				"Rating"
				);
		originalWineFilter.setPromptText("Select a Filter");
		originalWineFilter.setStyle("-fx-font: 20px \"Georgia\";" + "color:white; -fx-background-color: white");
		// create operations filter
		ComboBox<String> originalOperationsFilter = new ComboBox<>();
		originalOperationsFilter.setPrefWidth(250);
		originalOperationsFilter.getItems().addAll(
				"Search",
				"Ascending",
				"Descending",
				"<=",
				">=",
				"="
				);
		originalOperationsFilter.setPromptText("Operation");
		originalOperationsFilter.setStyle("-fx-font: 20px \"Georgia\";" + "color:white; -fx-background-color: white");
		// GO BUTTON
		ogGoBt = new Button("Go!");
		//edit parameters
		ogGoBt.setFont(new Font("Georgia", 30));
		ogGoBt.setTextFill(Color.WHITE);
		ogGoBt.setStyle("color:navy; -fx-background-color: navy");

		ogGoBt.setOnMouseClicked(e -> {
			originalFilterChoice = originalWineFilter.getSelectionModel().getSelectedItem();
			originalOperationChoice = originalOperationsFilter.getSelectionModel().getSelectedItem();
			originalSearch = ogSearchTF.getText();

			// CASEY - ADD FILTER CODE
			if (originalFilterChoice.equals("Wine Name"))
			{
				ViewTable.GUITable(FilterOriginalWineDatabase.wineName(originalSearch), wineResultGridPane);
			}
			if (originalFilterChoice.equals("Brand"))
			{
				ViewTable.GUITable(FilterOriginalWineDatabase.brand(originalSearch), wineResultGridPane);

			}
			if (originalFilterChoice.equals("Varietal"))
			{
				ViewTable.GUITable(FilterOriginalWineDatabase.varietal(originalSearch), wineResultGridPane);

			}
			if (originalFilterChoice.equals("Class Type"))
			{
				ViewTable.GUITable(FilterOriginalWineDatabase.classType(originalOperationChoice,originalSearch), wineResultGridPane);

			}
			if (originalFilterChoice.equals("Sub Class"))
			{
				ViewTable.GUITable(FilterOriginalWineDatabase.subClass(originalSearch), wineResultGridPane);

			}
			if (originalFilterChoice.equals("Region"))
			{
				ViewTable.GUITable(FilterOriginalWineDatabase.region(originalSearch), wineResultGridPane);

			}
			if (originalFilterChoice.equals("Compatible Foods"))
			{
				ViewTable.GUITable(FilterOriginalWineDatabase.compatibleFoods(originalSearch), wineResultGridPane);

			}
			if (originalFilterChoice.equals("Price Range"))
			{
				ViewTable.GUITable(FilterOriginalWineDatabase.priceRange(originalOperationChoice,originalSearch), wineResultGridPane);

			}
			if (originalFilterChoice.equals("Rating"))
			{
				ViewTable.GUITable(FilterOriginalWineDatabase.globalRating(originalOperationChoice,originalSearch), wineResultGridPane);

			}
			if(originalFilterChoice.equals("Original"))
			{
				ViewTable.GUITable(ViewTable.fullTableQuery("OriginalWineDatabase"), wineResultGridPane);

			}
		});

		// adding
		// add labels
		//originalWinePane.setGridLinesVisible(true);

		ViewTable.GUITable(ViewTable.fullTableQuery("OriginalWineDatabase"), wineResultGridPane);

		ScrollPane sp = new ScrollPane(wineResultGridPane);
		originalWinePane.add(sp,0,1,2,10);

		originalWinePane.add(originalWineLabel, 0, 0);
		userWinePane.add(userFillerLabel2, 3, 0);
		originalWinePane.add(ogSearchHB, 3, 5);
		// add buttons
		originalWinePane.add(ogGoBt, 3, 6); // filter at 3, operation at 4, search at 5
		// add drop down boxes
		originalWinePane.add(originalWineFilter, 3,2);
		originalWinePane.add(originalOperationsFilter, 3,4);
		// --------------------------------------------------------------------------------------------





		// --------------------------------------------------------------------------------------------
		// USER WINE PANE

		// intialize the pane

		//userWinePane.setGridLinesVisible(true);

		ViewTable.GUITable(ViewTable.fullTableQuery("UserWineDatabase"), userWineResultGridPane);

		ScrollPane sp2 = new ScrollPane(userWineResultGridPane);
		userWinePane.add(sp2,0,1,2,10);

		userWinePane.setAlignment(Pos.BASELINE_CENTER);
		userWinePane.setVgap(20);

		// intialize the buttons
		returnToWineLibrary = new Button("Return");
		// change font for profilePane buttons
		returnToWineLibrary.setFont(new Font("Georgia", 30));
		returnToWineLibrary.setTextFill(Color.WHITE);
		returnToWineLibrary.setStyle("color:navy; -fx-background-color: navy");

		// change to original wine pane when clicked
		returnToWineLibrary.setOnMouseClicked(e -> {
			tabPane.getSelectionModel().select(originalWineTab); //OriginalWineDatabase
		});	

		addBt = new Button("Add");
		// change font for profilePane buttons
		addBt.setFont(new Font("Georgia", 30));
		addBt.setTextFill(Color.WHITE);
		addBt.setStyle("color:navy; -fx-background-color: navy");

		// add a wine when clicked
		addBt.setOnMouseClicked(e -> {

			enterWinePane.setDisable(false);
			tabPane.getSelectionModel().select(enterWineTab); //enterWine
		});

		deleteBt = new Button("Delete");
		// change font for profilePane buttons
		deleteBt.setFont(new Font("Georgia", 30));
		deleteBt.setTextFill(Color.WHITE);
		deleteBt.setStyle("color:navy; -fx-background-color: navy");

		deleteNameLabel = new Label("Wine Name:    ");
		// Create Text Field
		TextField deleteNameTF = new TextField();
		HBox deleteNameHB = new HBox();
		deleteNameHB.getChildren().addAll(deleteNameLabel, deleteNameTF);
		deleteNameHB.setSpacing(20);
		// set the font
		deleteNameLabel.setFont(new Font("Georgia", 30));

		deleteBrandLabel = new Label("Brand:    ");
		// Create Text Field
		TextField deleteBrandTF = new TextField();
		HBox deleteBrandHB = new HBox();
		deleteBrandHB.getChildren().addAll(deleteBrandLabel, deleteBrandTF);
		deleteBrandHB.setSpacing(20);
		// set the font
		deleteBrandLabel.setFont(new Font("Georgia", 30));

		// delete a wine when clicked
		deleteBt.setOnMouseClicked(e -> {

			//deleteWine(wineName, brand, userName);
			wineName = deleteNameTF.getText();
			brand = deleteBrandTF.getText();
			if(WineDemo.verifyWine(wineName, brand, ViewTable.fullTableQuery("UserWineDatabase")))
			{
				DeleteData.deleteWine(wineName, brand);
				ViewTable.GUITable(ViewTable.fullTableQuery("UserWineDatabase"), userWineResultGridPane);

			}
			else
			{
				System.out.println("ALERT: DELETE DID NOT WORK");

			}

		});

		updateBt = new Button("Update");
		// change font for profilePane buttons
		updateBt.setFont(new Font("Georgia", 30));
		updateBt.setTextFill(Color.WHITE);
		updateBt.setStyle("color:navy; -fx-background-color: navy");
		
		updateRatingLabel = new Label("New Rating:    ");
		// Create Text Field
		TextField updateRatingTF = new TextField();
		HBox updateRatingHB = new HBox();
		updateRatingHB.getChildren().addAll(updateRatingLabel, updateRatingTF);
		updateRatingHB.setSpacing(20);
		// set the font
		updateRatingLabel.setFont(new Font("Georgia", 30));


		// upadate a rating when clicked
		updateBt.setOnMouseClicked(e -> {

			//Update(wineName, brand, userName);
			wineName = deleteNameTF.getText();
			brand = deleteBrandTF.getText();
			personalRating = updateRatingTF.getText();
			
			if(WineDemo.verifyWine(wineName, brand, ViewTable.fullTableQuery("UserWineDatabase")))
			{
				UpdateData.updateUserWineDatabase(wineName, brand, personalRating);
				ViewTable.GUITable(ViewTable.fullTableQuery("UserWineDatabase"), userWineResultGridPane);

			}
			else
			{
				System.out.println("ALERT: UPDATE DID NOT WORK");

			}


			// CASEY - ADD UPDATE CODE HERE
		});

		// inialize the labels
		userWineLabel = new Label("          Personal Wine Library");
		// Set the position
		userWineLabel.setPrefSize(2000, 50);
		// Set the appearance
		userWineLabel.setFont(new Font("Georgia", 70));
		userWineLabel.setBackground(new Background(new BackgroundFill(Color.CADETBLUE, null, null)));
		userFillerLabel = new Label("  ");
		// Set the position
		userFillerLabel.setPrefSize(250, 80);
		userFillerLabel.setBackground(new Background(new BackgroundFill(Color.CADETBLUE, null, null)));
		// adding
		// add labels
		userWinePane.add(userWineLabel, 0, 0, 2, 1);
		userWinePane.add(userFillerLabel, 2, 0);
		userWinePane.add(deleteNameLabel, 2, 5);
		userWinePane.add(deleteBrandLabel, 2, 6);
		userWinePane.add(updateRatingLabel, 2, 8);
		userWinePane.add(deleteNameHB, 3, 5);
		userWinePane.add(deleteBrandHB, 3, 6);
		userWinePane.add(updateRatingHB, 3, 8);

		// add buttons
		userWinePane.add(returnToWineLibrary, 2, 10);
		userWinePane.add(addBt, 2, 3); // delete 4, update 5
		userWinePane.add(deleteBt, 2, 4);
		userWinePane.add(updateBt, 2, 7);
		// add labels with textfileds	


		// --------------------------------------------------------------------------------------------

		// Enter Wine Pane

		// intialize the pane
		enterWinePane.setAlignment(Pos.BASELINE_CENTER);
		enterWinePane.setVgap(20);


		// inialize the labels
		enterWineLabel = new Label("                 Enter Wine");
		// Set the position
		enterWineLabel.setPrefSize(2000, 50);
		// Set the appearance
		enterWineLabel.setFont(new Font("Georgia", 75));
		enterWineLabel.setBackground(new Background(new BackgroundFill(Color.CADETBLUE, null, null)));

		wineNameLabel = new Label("Wine Name:  ");
		// Create Text Field
		TextField wineNameTF = new TextField();
		HBox wineNameHB = new HBox();
		wineNameHB.getChildren().addAll(wineNameLabel, wineNameTF);
		wineNameHB.setSpacing(20);
		// set the font
		wineNameLabel.setFont(new Font("Georgia", 40));

		brandLabel = new Label("Brand:   ");
		// Create Text Field
		TextField brandTF = new TextField();
		HBox brandHB = new HBox();
		brandHB.getChildren().addAll(brandLabel, brandTF);
		brandHB.setSpacing(20);
		// set the font
		brandLabel.setFont(new Font("Georgia", 40));

		varietalLabel = new Label("Varietal (ex- Red):    ");
		// Create Text Field
		TextField varietalTF = new TextField();
		HBox varietalHB = new HBox();
		varietalHB.getChildren().addAll(varietalLabel, varietalTF);
		varietalHB.setSpacing(20);
		// set the font
		varietalLabel.setFont(new Font("Georgia", 40));

		classTypeLabel = new Label("Class Type (Sweetness 0-10):     ");
		// Create Text Field
		TextField classTypeTF = new TextField();
		HBox classTypeHB = new HBox();
		classTypeHB.getChildren().addAll(classTypeLabel, classTypeTF);
		classTypeHB.setSpacing(20);
		// Set the Font
		classTypeLabel.setFont(new Font("Georgia", 40));

		subClassLabel = new Label("Sub Class (ex- Pinot):        ");
		// Create the Text Field
		TextField subClassTF = new TextField();
		HBox subClassHB = new HBox();
		subClassHB.getChildren().addAll(subClassLabel, subClassTF);
		subClassHB.setSpacing(20);
		// Set the Font
		subClassLabel.setFont(new Font("Georgia", 40));

		regionLabel = new Label("Region:      ");
		// Create the Text Field
		TextField regionTF = new TextField();
		HBox regionHB = new HBox();
		regionHB.getChildren().addAll(regionLabel, regionTF);
		regionHB.setSpacing(20);
		// Set the Font
		regionLabel.setFont(new Font("Georgia", 40));

		compatibleFoodLabel = new Label("Compatible Food:      ");
		// Create the Text Field
		TextField compatibleFoodTF = new TextField();
		HBox compatibleFoodHB = new HBox();
		compatibleFoodHB.getChildren().addAll(compatibleFoodLabel, compatibleFoodTF);
		compatibleFoodHB.setSpacing(20);
		// Set the Font
		compatibleFoodLabel.setFont(new Font("Georgia", 40));

		priceRangeLabel = new Label("Price Range:      ");
		// Create the Text Field
		TextField priceRangeTF = new TextField();
		HBox priceRangeHB = new HBox();
		priceRangeHB.getChildren().addAll(priceRangeLabel, priceRangeTF);
		priceRangeHB.setSpacing(20);
		// Set the Font
		priceRangeLabel.setFont(new Font("Georgia", 40));

		personalRatingLabel = new Label("Rating:      ");
		// Create the Text Field
		TextField personalRatingTF = new TextField();
		HBox personalRatingHB = new HBox();
		personalRatingHB.getChildren().addAll(personalRatingLabel, personalRatingTF);
		personalRatingHB.setSpacing(20);
		// Set the Font
		personalRatingLabel.setFont(new Font("Georgia", 40));

		userNameLabel = new Label("Username:      ");
		// Create the Text Field
		TextField userNameTF = new TextField();
		HBox userNameHB = new HBox();
		userNameHB.getChildren().addAll(userNameLabel, userNameTF);
		userNameHB.setSpacing(20);
		// Set the Font
		userNameLabel.setFont(new Font("Georgia", 40));


		// intialize the buttons
		enterBt = new Button("Done");
		// change font for profilePane buttons
		enterBt.setFont(new Font("Georgia", 30));
		enterBt.setTextFill(Color.WHITE);
		enterBt.setStyle("color:navy; -fx-background-color: navy");

		// change to original wine database when clicked
		enterBt.setOnMouseClicked(e -> {
			wineName = wineNameTF.getText();
			brand= brandTF.getText();
			varietal = varietalTF.getText();
			classType = classTypeTF.getText();
			subClass= subClassTF.getText();
			region = regionTF.getText();
			compatibleFood = compatibleFoodTF.getText();
			priceRange = priceRangeTF.getText();
			personalRating = personalRatingTF.getText();
			userName = userNameTF.getText();

			if (!wineName.isEmpty() && !brand.isEmpty() && !varietal.isEmpty() 
					&& !subClass.isEmpty() && !personalRating.isEmpty())
			{

				if (WineDemo.verifyWine(wineName, brand, ViewTable.fullTableQuery("UserWineDatabase"))
						|| WineDemo.verifyWine(wineName, brand, ViewTable.fullTableQuery("OrinignalWineDatabase"))) //return true if userName already exist
				{
					//error invalid input
					userNameInvalid1.setVisible(true);
					logInInvalid3.setVisible(false);
					userNameInvalid1.setFont(new Font("Georgia", 30));

				}
				else
				{
					//Insert data into userProfile
					InsertData.addUserWineDatabase(wineName, brand, userName, personalRating);
					ViewTable.GUITable(ViewTable.fullTableQuery("UserWineDatabase"), userWineResultGridPane);

					//Insert data into OriginalWineDatabase
					InsertData.addOriginalWine( wineName, brand, varietal, classType, subClass, region,
							compatibleFood, priceRange, personalRating);
					ViewTable.GUITable(ViewTable.fullTableQuery("OriginalWineDatabase"), wineResultGridPane);

				}


				tabPane.getSelectionModel().select(userWineTab); //Select OriginalWineTab

			}
			else
			{
				logInInvalid3.setVisible(true);
				logInInvalid3.setFont(new Font("Georgia", 30));
			}

		});	

		userNameInvalid1 = new Label();
		userNameInvalid1.setText("WINE ALREADY EXISTS");
		userNameInvalid1.setVisible(false);
		logInInvalid3 = new Label();
		logInInvalid3.setText("MUST ENTER WINE NAME, BRAND, VARIETAL, SUBCLASS, RATING, AND USERNAME");
		logInInvalid3.setVisible(false);

		// adding				
		// add labels - ALL WILL NEED TO 
		enterWinePane.add(enterWineLabel, 0, 0);
		// add buttons
		enterWinePane.add(enterBt, 0, 13);
		// add labels with textfileds
		enterWinePane.add(userNameInvalid1, 0, 14);		
		enterWinePane.add(logInInvalid3, 0, 14);
		enterWinePane.add(wineNameHB, 0, 3);
		enterWinePane.add(brandHB, 0, 4);
		enterWinePane.add(varietalHB, 0, 5);
		enterWinePane.add(classTypeHB, 0, 6);
		enterWinePane.add(subClassHB, 0, 7);
		enterWinePane.add(regionHB, 0, 8);
		enterWinePane.add(compatibleFoodHB, 0, 9);					
		enterWinePane.add(priceRangeHB, 0, 10);					
		enterWinePane.add(personalRatingHB, 0, 11);
		enterWinePane.add(userNameHB, 0, 12);


		// --------------------------------------------------------------------------------------------




		// --------------------------------------------------------------------------------------------
		// COUNTRY PANE
		ViewTable.GUITable(ViewTable.fullTableQuery("Country"), countryResultGridPane);

		ScrollPane sp3 = new ScrollPane(countryResultGridPane);
		countryPane.add(sp3,0,1,2,10);

		// intialize the pane
		countryPane.setAlignment(Pos.BASELINE_CENTER);
		countryPane.setVgap(20);

		returnToWineLibrary2 = new Button("Return");
		// change font for profilePane buttons
		returnToWineLibrary2.setFont(new Font("Georgia", 15));
		returnToWineLibrary2.setTextFill(Color.WHITE);
		returnToWineLibrary2.setStyle("color:navy; -fx-background-color: navy");
		returnToWineLibrary2.setPrefSize(300,30);

		// change to original wine pane when clicked
		returnToWineLibrary2.setOnMouseClicked(e -> {
			tabPane.getSelectionModel().select(originalWineTab); //originalWineTab
		});	

		countryGoBt = new Button("Go!");
		//edit parameters
		countryGoBt.setFont(new Font("Georgia", 30));
		countryGoBt.setTextFill(Color.WHITE);
		countryGoBt.setStyle("color:navy; -fx-background-color: navy");	
		// inialize the labels
		countryHeaderLabel = new Label("    International Drinking Ages");
		// country search text field
		TextField countrySearchTF = new TextField();
		HBox countrySearchHB = new HBox();
		countrySearchHB.getChildren().addAll(countrySearchTF);
		countrySearchHB.setSpacing(20);
		ComboBox<String> countryFilter = new ComboBox<>();
		countryFilter.setPrefWidth(500);
		countryFilter.getItems().addAll(
				"Original",
				"Country Name",
				"Legal Drinking Age"
				);
		countryFilter.setPromptText("Select a Filter");
		countryFilter.setStyle("-fx-font: 20px \"Georgia\";" + "color:white; -fx-background-color: white");
		// operation text field
		ComboBox<String> countryOperationsFilter = new ComboBox<>();
		countryOperationsFilter.setPrefWidth(250);
		countryOperationsFilter.getItems().addAll(
				"Search by Name",
				"Total Ban",
				"Unknown",
				"Ascending",
				"Descending",
				"<=",
				">=",
				"="
				);
		countryOperationsFilter.setPromptText("Operations");
		countryOperationsFilter.setStyle("-fx-font: 20px \"Georgia\";" + "color:white; -fx-background-color: white");
		// Set the position
		countryHeaderLabel.setPrefSize(2000, 50);
		// Set the appearance
		countryHeaderLabel.setFont(new Font("Georgia", 70));
		countryHeaderLabel.setBackground(new Background(new BackgroundFill(Color.CADETBLUE, null, null)));	
		countryFillerLabel = new Label("  ");
		// Set the position
		countryFillerLabel.setPrefSize(250, 80);
		countryFillerLabel.setBackground(new Background(new BackgroundFill(Color.CADETBLUE, null, null)));

		// go button
		countryGoBt.setOnMouseClicked(e -> {
			countryFilterChoice = countryFilter.getSelectionModel().getSelectedItem();
			countryOperationChoice = countryOperationsFilter.getSelectionModel().getSelectedItem();
			countrySearch = countrySearchTF.getText();
			// CASEY - ADD FILTER CODE

			//TODO: I don't know why I'm getting an error
			if (countryFilterChoice.equals("Legal Drinking Age"))
			{
				ViewTable.GUITable(FilterCountry.drinkingAges(countryOperationChoice, countrySearch),countryResultGridPane);
			}
			if (countryFilterChoice.equals("Country Name"))
			{
				ViewTable.GUITable(FilterCountry.drinkingAges(countryOperationChoice, countrySearch),countryResultGridPane);

			}
			if (countryFilterChoice.equals("Original"))
			{
				ViewTable.GUITable(ViewTable.fullTableQuery("Country"), countryResultGridPane);

			}

		});



		// adding
		// add labels
		countryPane.add(countryHeaderLabel, 0, 0, 1, 1);
		countryPane.add(countrySearchHB, 1, 4);
		countryPane.add(countryFillerLabel, 1,0);
		// add buttons
		countryPane.add(returnToWineLibrary2, 1, 7);
		countryPane.add(countryGoBt, 1, 5); // filter 2, operation 3, search 4
		countryPane.add(countryFilter, 1, 2);
		countryPane.add(countryOperationsFilter, 1, 3);
		// add labels with textfileds
		// --------------------------------------------------------------------------------------------




		// TEST PANE
		// initialize
		//testPane = new Pane();
		//	testPane.setBackground(new Background(new BackgroundFill(Color.BEIGE, null, null)));


		// -------------------------------------------------------------------------------------------						
		// DROP SHADDOWS FOR BUTTONS

		DropShadow dropShadow = new DropShadow ();
		dropShadow.setRadius (5.0);
		dropShadow.setOffsetX (3.0);
		dropShadow.setOffsetY (3.0);
		dropShadow.setColor ( Color . color (0.4 , 0.5 , 0.5));
		// logInPane buttons
		newUserBt.setEffect ( dropShadow );
		logInBt.setEffect ( dropShadow );
		// profilePane buttons
		createBt.setEffect ( dropShadow );
		enterBt.setEffect( dropShadow );
		// originalWinePane buttons
		// userWinePane buttons
		// countryListPane buttons
		// -------------------------------------------------------------------------------------------	

	}  // end of constructor LayoutsDemo()



	@Override
	public void start(Stage primaryStage) throws Exception {

		// Set the scene and the stage
		Scene scene = new Scene(tabPane, 1200, 1200);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Wine Not?");
		tabPane.setStyle("color:aliceblue; -fx-background-color: aliceblue");

		// Display the GUI
		primaryStage.show();

	}

	public static void main(String[] args) { 
		WineDemo.initiateConnection();

		launch(args); }


} // end of class LayoutDemo