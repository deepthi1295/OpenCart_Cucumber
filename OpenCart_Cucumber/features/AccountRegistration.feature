Feature: Register account

  @regression
  Scenario: new account registration
    Given the user navigates to registration page
    When the user enters the details as below
      | firstname | Jhon      |
      | lastname  | kennedy   |
      | telephone | 423432432 |
      | password  | test@123  |
    And the user agrees and click continue
    Then the registration message is shown to user
