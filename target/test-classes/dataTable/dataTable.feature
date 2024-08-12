Feature: Data Table
Verify the Login Functionality
	Scenario:
	Given the user on the login page
	When user Enter Valid username password
	| Fields  | Values|
	|username |akash@gmail.con|
	|password |pass@123|
	Then user loged in successfully
	