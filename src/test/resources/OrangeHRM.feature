#Feature file is a place where you create test cases(This is a feature file)
#You need to define feature at the beginning.
Feature: We are creating this feature file to add Orange HRM Scenarios

#  Background: Login
#    Given The user wants to go to login
#    Then The user wants to click login

#When you create a new test cases you have to start with "Scenario" keyword and then you need to put some steps
      #We also use Gherkin Language keywords Given/When/Then/And and it is case sensitive.

  # URL : renastech-osondemand.orangehrm.com
  # Username : Admin
  # Password : Mv@UE0@dR3f@


  Scenario: Login to Orange HRM
    Given The user wants to go to orangeHRM application
    When The user wants to enter username and password
    Then The user wants to click login
    And The user should be able to navigate dashboard


  Scenario: Login with credentials
    Given The user wants to go to orangeHRM application
    When The user wants to enter username as "Admin" and the password as "Mv@UE0@dR3f@"
    Then The user wants to click login
    And The user should be able to navigate dashboard
    And The user id should be 1568

  Scenario:
    Given The user wants to go to orangeHRM application
    When The user wants to enter username as "Admin" and the password as "Mv@UE0@dR3f@"
    Then The user wants to click login
    And The user should be able to navigate dashboard
    Then The user wants to go to PIM page
    Then The user wants to add employee
    Then The user wants to add a first name as "Tom"
    Then The user wants to add a last name as "Green"
    Then The user wants to click save
    Then The user should be able to see "Personal Details"

# Parameterization
    # String
    # integer
    # double

# gherkin Language is case sensitive

  # Framework  // JAVA --> Maven --> Selenium --> Cucumber --> POM


      # Scenarios <----------Runner Class----------------> Step Definition(other coding part, we will put everything in this part)
      # Scenarios            Cucumber Runner                Utilities
      # Test Cases                                          Base Page
      #                                                     Pages
      #                                                     Test
      #                                                     Configuration Properties

  ## user story by PO
  ## Groom the story  DEV - QA - BA  -->  3 Amigos
  ## They have the rights to vote for user story
  ##    - DEV will start to develop their code
  ##    - QA will start to develop their test cases -- create scenarios

  ## QA will start to test/create coding

  # @configFile_Scenario
  # Scenario: Login
   # Given The user wants to go to login
    # Then The user wants to click login
    # And The user should be able to navigate dashboard

#  Username : Admin
#  Password : Mv@UE0@dR3f@

  @Candidate
  Scenario: Verify that we can create a candidate
    Then The user wants to navigate to Recruitment
    Then The user wants to see candidates
    And The user wants to add a candidate
    Then The user wants to enter first name as "Jame" and last name as "Michael"
    Then The user wants to enter email as "jmichael@me.com"
    Then The user wants to Consent to keep data
    Then The user wants to save the information
    Then The user wants to verify that the user is created

#  below is called pipe
#  dryRun in TestRunner is to get test definitions and tells if any step without step def
#  learning Map
#  Keyword, Value
  @Mapping_Practice
    Scenario:
      Given The user wants to go to the OrangeHRM app
      When The user wants to login to OrangeHRM
          |Username | Admin       |
          |Password |Mv@UE0@dR3f@ |
      Then The user wants to click login
      And The user should be able to navigate dashboard
      Then The user wants to go to PIM page
      Then The user wants to see add an employee
      Then The user wants to add employee
          |FirstName|Thomas   |
          |LastName |Jerrod   |
    Then The user wants to save the information
    Then The user should be able to see "Personal Details"


    #reusability
#  better to use Map because 2 things in each column
  @Mapping_Practice_TC2
    Scenario: Verify an added new employee with login credentials
      Given The user wants to go to the OrangeHRM app
      When The user wants to login to OrangeHRM
        |Username | Admin       |
        |Password |Mv@UE0@dR3f@ |
      Then The user wants to click login
      And The user should be able to navigate dashboard
      Then The user wants to go to PIM page
      Then The user wants to see add an employee
      Then The user wants to add employee
        |FirstName|Thomas   |
        |LastName |Jerrod   |
      Then The user wants to add login details
        |Username | Jessi       |
        |Password |Doowop123    |
        |Status   |Disabled     |
    Then The user wants to save the information
    Then The user should be able to see "Personal Details"
#List Ex
    #            0        1
##    0  |Admin |Mv@UE0@dR3f@ |
##    1  |Admin1 |Mv@UE0@dR3f@ |
##    2  |Admin2 |Mv@UE0@dR3f@ |
##    3  |Admin3 |Mv@UE0@dR3f@ |

@List_Practice_TC1
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

  @Hook
  Scenario: Verify That the Hooks works fine
    Given The user wants to login website
    Then the user wants to verify that we can login

  @PageObjectModel
  Scenario: Verify that the user should be able to add new nationality
    Given The user wants to login as admin
    Then The user wants to verify dashboard
    When The user wants to go to admin
    Then The user wants to go to Nationalities
    Then The user wants to add new Nationalities
    Then The user wants to add Nationalities as "Catwoman"
    And The user wants to click save Nationality
    And The user should be able to see "Catwoman" in Nationality Page

    @PageObjectModel2 @Parallel
    Scenario: Verify that we can click all the checkboxes are available
      Given The user wants to login as admin
      Then The user wants to verify dashboard
      When The user wants to go to admin
      Then The user wants to go to Nationalities
      Then The user wants to click all checkboxes

      @Excel
      Scenario: Verify that we can login with Excell
        When The user wants to login with excel
        Then The user wants to verify dashboard

        # need to know row, column, and sheet
        # need file input
        # open resources with explorer and drag and drop the excel sheet into there
        # or just create new with right-click in the file open