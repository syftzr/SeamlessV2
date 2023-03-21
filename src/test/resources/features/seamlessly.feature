@SEAMLES10-394
Feature: Login functionality

  User Story :

  As a user, I should be able to login.

  Acceptance Criteria:

  1-User can login with valid credentials (either clicking on the "Login button" or hitting the "Enter" key from the keyboard as the last step)
  2-User can not login with any invalid credentials
  -"Wrong username or password." should be displayed for invalid credentials
  -"Please fill out this field" message should be displayed if the password or username is empty
  3-User can see the password in a form of dots by default
  4-User can see the password explicitly if needed
  5-User can see the "Forgot password?" link on the login page and can see the "Reset Password" button on the next page after clicking on forget password link
  6-User can see valid placeholders on Username and Password fields
  sword fields


#  Background: Homepage


  @SEAMLES10-486
  Scenario: AC 1: User can login with valid credentials by clicking login button
    Given User is on the login page
    When user can write valid username
    And user can write valid password
    And user can click login button
    Then user can see dashboard

  @SEAMLES10-487
  Scenario: AC 1: User can login with valid credentials by clicking login button
    Given User is on the login page
    When user can write valid username
    And user can write valid password
    And user can press Enter key
    Then user can see dashboard


  Scenario Outline: AC 2: User can not login with any invalid credentials (Invalid Username and/or Password)
    Given User is on the login page
    When user can write valid/invalid username "<username>"
    And user can write valid/invalid password "<password>"
    And user can press Enter key
    Then user can not see dashboard and "Wrong username or password." massage should be displayed
    Examples:
      | username     | password     |
      | Employee     | 123456       |
      | Employee160  | EMPLOYEE123  |
      | Employee160  | employee123  |
      | Employee160  | Employee 123 |
      | Employee 160 | Employee123  |
      | EMPLOYEE160  | Employee123  |
      | Employee.160 | Employee123  |


Scenario Outline: AC 2: User can not login and "Please fill out this field" message is displayed when username box is empty and password box is filled
