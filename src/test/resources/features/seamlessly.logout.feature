@SEAMLES10-395
Feature: Logout function

  Background:
    Given user logged in

  @SEAMLES10-575
  Scenario: Logout and ends up in login page
    When user clicks on the avatar image dropdown
    And user clicks on the Log out button
    Then user can go back to the login page

  @SEAMLES10-576
  Scenario: verify user can not go to home page again by clicking step back button after successfully logged out
    When user logged out successfully
    And user clicks on step back button
    Then user can not go to home page again