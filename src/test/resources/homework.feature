Feature:
  #
#  - Create scenarios :
#            1) Verify that "Get Quote" button  is navigating application ?
#            2) Verify that in finance detail you should be able to select only one option.
#            3) Verify that when you complete application you should be able to see "Let us call you" button
#

# Example
  Scenario: Login with incorrect data (negative scenario)
    Given The user wants to go to website
    When The user wants to enter incorrect user name
    Then The user wants to enter password
    And The user wants to click submit button

#  Gherkin Syntax:
#Feature: Title of the Scenario
#Given [Preconditions or Initial Context]
#When [Event or Trigger]
#Then [Expected output]

  Scenario: Verify that "Get Quote" button is navigating application
    Given The user navigates to practicereanastech.com
    When The user clicked the "Insurance" button
    And The user clicks the "Get a Quote" button
    Then The user is able to proceed with application

  Scenario: Verify only one option in finance detail
    Given The user navigates to practicereanastech.com
    And The user clicked the "Insurance" button
    And The user clicked "Get a Quote"
    When The user clicks "Finance Details"
    And The user selects an option
    Then The user should be only have one option that can be selected

  Scenario: Verify "Let us call you" displays at end of application
    Given The user navigates to practicereanastech.com
    When The user clicked the "Insurance" button
    And Proceeds with "Get a Quote" button
    Then The application is displayed
    When The user clicks "Vehicle Details"
    And Selects Vehicle Year
    And Selects Vehicle Make
    And Selects Vehicle Model
    And Selects "Next" button
    Then The user reaches "Finance Details" section
    When The user selects a Finance Detail Option
    And Selects "Next" button
    Then The user reaches "Driving Distance" section
    When The user enters or selects driving distance
    And Checks the options that contribute to driving distance
    And Selects "Next" button
    Then The user reaches "Coverage Start Date" section
    When The user chooses coverage start date
    And Selects the "Next" button
    Then The user reaches "Savings and Discounts" section
    When The user chooses Yes or No for first question
    And Chooses Yes or No for second question
    And Selects the "Next" button
    Then The user reaches "The Driver" section
    When The user enters Drivers License Number
    And Selects the "Next" button
    Then The user reaches "Driver's License History" section
    When The user selects Yes or No option to question
    And Selects "Submit"
    Then "Let us call you" is displayed to the user

    #homework 2: Guru99 Demo Site create new employee
  # Task
# Login to OrangeHRM
# Go to PIM and click Employee List
# Click the last employee and verify that "Personal Details" is appear on the page
# update :
# Driver's License Number
# License Expiry Date
# Marital Status
# Nationality
# Date of Birth  and Save
# and click add attachment and upload a sample file. for example  "anySample.pdf"
#
#  Username : Admin
#  Password : Mv@UE0@dR3f@

  @Upload_File_To_OrangeHRM
  Scenario: Create a new employee and verify that they have been uploaded successfully
    Given The user wants to go to the OrangeHRM app
    When The user wants to enter username and password
    And Clicks login
    Then Should see the Dashboard
    When The user clicks the PIM section
    And Clicks on Employee List
    And Clicks the last employee created
    Then The user should be able to see "Personal Details"
    When The user clicks the edit button
    And Wants to update Driver's License
    And Update License Expiration Date
    And Update Marital Status
    And Update Nationality
    And Update Date of Birth
    And Wants to click save
    Then The user wants to verify save is successful
    When The user wants to click add an attachment
    And Clicks Choose File
    And Clicks upload button
    Then The user verifies file was uploaded successfully





