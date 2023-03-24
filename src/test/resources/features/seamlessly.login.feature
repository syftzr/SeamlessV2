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


  Background: Homepage
    Given User is on the login page


  @SEAMLES10-486
  Scenario: AC 1: User can login with valid credentials by clicking login button
    When user can write valid username
    And user can write valid password
    And user can click login button
    Then user can see dashboard

  @SEAMLES10-487
  Scenario: AC 1: User can login with valid credentials by pressing enter key
    When user can write valid username
    And user can write valid password
    And user can press Enter key
    Then user can see the dashboard

  @SEAMLES10-540
  Scenario Outline: AC 2: User can not login with any invalid credentials (Invalid Username and/or Password)
    When user can write valid or invalid username "<username>"
    And user can write valid or invalid password "<password>"
    And user can press Enter key
    Then user can not see dashboard and "<message>" message should be displayed
    Examples:
      | username     | password     | message                     |
      | Employee     | 123456       | Wrong username or password. |
      | Employee160  | EMPLOYEE123  | Wrong username or password. |
      | Employee160  | employee123  | Wrong username or password. |
      | Employee160  | Employee 123 | Wrong username or password. |
      | Employee 160 | Employee123  | Wrong username or password. |
      | EMPLOYEE160  | Employee123  | Wrong username or password. |
      | Employee.160 | Employee123  | Wrong username or password. |

  @SEAMLES10-541
  Scenario Outline: AC 2: User can not login and "Please fill out this field" message is displayed when username box is empty and password box is filled
    When user can write valid or invalid username "<username>"
    And user can write valid or invalid password "<password>"
    And user can press Enter key
    Then user can not login and "<message>" should be displayed
    Examples:
      | username | password    | message                    |
      |          | 123456      | Please fill out this field |
      |          | Employee123 | Please fill out this field |


  @SEAMLES10-542
  Scenario Outline: AC 2: User can not login and "Please fill out this field" message is displayed when username box is filled and password box is empty
    When user can write valid or invalid username "<username>"
    And user can write valid or invalid password "<password>"
    And user can press Enter key
    Then user can not login and "<message>" should be displayed
    Examples:
      | username    | password | message                    |
      | Employee160 |          | Please fill out this field |
      | Employeeety |          | Please fill out this field |


  @SEAMLES10-543
  Scenario Outline: AC  3-User can see the password in a form of dots by default
    When user can write valid or invalid password "<password>"
    Then user can see the password in a form of dots
    Examples:
      | username    | password    |
      | Employee160 | Employee123 |
      | Employee    | 123456      |

  @SEAMLES10-544
  Scenario Outline: AC 4-User can see the password explicitly if needed
    When user can write valid or invalid username "<username>"
    When user can write valid or invalid password "<password>"
    And user clicks eye icon
    Then User can see the password explicitly
    Examples:
      | username | password    |
      |          | Employee123 |
      |          | 123456      |

  @SEAMLES10-545
  Scenario: AC 5-User can see the "Forgot password?" link on the login page
    Then User can see the "Forgot password?" link

  @SEAMLES10-546
  Scenario: AC 5-User can see the "Reset Password" button on the next page after clicking on forget password link
    When user clicks the "Forgot password?" link
    Then User can see the "Reset Password" button

  @SEAMLES10-547
  Scenario: AC 6- User can see valid placeholders on Username and Password fields
    Then User can see valid placeholder on username field
    Then User can see valid placeholder on password field
