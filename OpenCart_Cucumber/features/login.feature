Feature: Login Page

  @sanity @regression
  Scenario: Successful login
    Given the user navigates to login page
    When the user enters email as "laksh@yahoo.com" and password as "Lakshmi"
    And the user clicks login button
    Then the user is navigated to my account page
    #@regression
  #Scenario Outline: Login Data Driven
    #Given the user navigates to login page
    #When user enters email as "<email>" and password as "<password>"
    #And the user clicks on the Login button
    #Then the user should be redirected to the MyAccount Page
#
    #Examples: 
      #| email                     | password |
      #| pavanol@gmail.com         | test123  |
      #| pavanoltraining@gmail.com | test@123 |
