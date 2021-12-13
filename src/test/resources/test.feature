Feature:
  # Gherkin language
  # Ruby language-Backend Language
  # BDD-Behavioral Development Driven
  #With cucumber tool we are creating scenario. When we create a scenario,
  # we are getting some benefit from gherkin language
  #We are using Given/ When/Then/And keywords
  #Given means I want do something firstly, like go website
  #We are putting a structure of our scenario in Cucumber

  # What is cucumber testing Tool?
  # We can create scenario with plain language
  # The cucumber tool bring collaboration to team
  # We are using Gherkin
  # to start a test a test case we need to declerate "Scenario"
  # it is readable
  # it is reusable

 # Gherkin Language
  # is plain language driven from Ruby
  # langugae that testers use to define test cases in cucumber
  # this language describe use cases or scenarios in a way that can be read and understand by
  # almost everyone in the team

  # 75% of the market uses TestNG 25% Cucumber
  # Main purpose of cucumber is more understandable scenario languages.
  # It is reusable and the other part is readability.

  #Given #When #Then #And #But

  Scenario: Login to Matrix LMS
    Given The user wants to go to website of matrix
    When The user wants to enter username
    Then The user wants to enter password
    Then The user wants to click remember me
    And The user wants to click submit button

  #Let's create another scenario
  #We can test negative way like: wrong email with correct password
  Scenario: Login with incorrect data (negative scenario)
    Given The user wants to go to website
    When The user wants to enter incorrect user name
    Then The user wants to enter password
    And The user wants to click submit button

  #First and last two steps are same this means:
  #   - BDD and Cucumber is reusable when you create those steps you don't
  #   have to create every time!
  # It is reusable and the other part is readability.
  #   - Every one in the team can easily understand everything that we
  #   create in the scenarios.

  # Selenium TestNG            SeleniumCucumber
  #Test Driven Development    Plain Language
  #Declare @Test              Reusable & Readable
  #Browser Utils
  #Reusable Methods

  Scenario: Verify login to Gmail with positive credentials
    Given The user wants to go to Google.com
    When The user wants to click Gmail
    Then The user wants to enter email
    And The user wants to enter password
    Then The user wants to click login
    And The user wants to verify the first email

  @Hook
  Scenario: Verify That the Hooks works fine
    Given The user wants to login website
    Then the user wants to verify that we can login
