Feature: To Test Smoke Tests

Scenario: Login to Orange HRM
  Given The user wants to go to orangeHRM application
  When The user wants to enter username and password
  Then The user wants to click login
  And The user should be able to navigate dashboard



  @Smoke_Test @Parallel
Scenario: Verify add new employee with login cred (with List)
Given The user wants to go to the OrangeHRM app
When The user wants to login to OrangeHRM using List
|Admin |Mv@UE0@dR3f@ |
Then The user wants to click login
And The user should be able to navigate dashboard
Then The user wants to go to PIM page
Then The user wants to see add an employee
Then The user wants to add employee using List
|Geraldeen   |The-Cucumber   |
Then The user wants to add login details using List
|thisIsAUsername |R3nasTech45!  |Disabled     |
Then The user wants to save the information
Then The user should be able to see "Personal Details"

