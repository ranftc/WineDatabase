# WineDatabase

Date Start: 3/26/18 
Date End: 4/16/18

Language/Requirements: MySQL Workbench 6.3 CE, Java, JavaFx

Authors: Casey Ranft and Alex Garlotte

Problem: Implement database mySQL concepts and technology in combination with Java. Must include insertion, deletion, and updating of database. Can work with a partner or alone.

Description: My partner Alex and I decided to create a wine database and GUI in java. Our program can be broken down into parts based off interfaces and application. We focused on imitating a usable ranking website that would contain a user profile and database of wines available. The main purpose was to allow the user to rank/filter results based off the features then be able to add wines to their profile.

Run: WineGUI.java with all other classes in the project folders

Warnings: This program requires a connection to a specific mySQL server which doesn't always connect. Also, the GUI doesn't scale as well depending on the screen. The full screen option should help.

Work Load Distribution: Alex did about 60% of the GUI by laying out all the base framework, specifically the menu bar, outline, and profile page. I finished off the GUI table display, implementation of different filtering results, and did all the SQL coding and connections with Java.

mySQL inputs:
- Contains a set of pre-inputted wines with multiple features such as brand, price, type, compatiable food, etc which have some values subject to change.
- mySQL contains a set of hard inputted drinking ages from around the world that cannot be changed.

User Profile which can be created or signed into:
- Java Interface for signing in which containes a username/password verification and current wines associated with their profile.
- Java Interface for creating a profile with username/password, country, and date of birth - Used to verify the drinking age.

Main interfaces:
- GUI Table that displays a dataset of wine with ten features. A drop down bar to the right has different filter options where you can sort through the table based off a feature.
- Table that displays a dataset of countries and their corresponding drinking age. A drop down bar to the right has the different filter options to sort by age.
- Add a wine to the table. All features will be need and the wine will be appeneded to the data.
- Updata a wine already in the table. Can change a feature or adjust a rating then reupdate the table.
- Delete a wine in the table. Removes the selected wine.

