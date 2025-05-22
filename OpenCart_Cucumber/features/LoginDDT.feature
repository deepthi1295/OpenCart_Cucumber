Feature: Login DDT

  @regression
  Scenario Outline: login test with DDT file
    Given the user navigates to login page
    Then the user should be redirected to the MyAccount Page by passing email and password with excel row "<row_index>"

    Examples: 
      | row_index |
      |         1 |
      |         2 |
      |         3 |
      |         4 |
      |         5 |
