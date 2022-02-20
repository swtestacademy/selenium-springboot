Feature: Login Feature

  @negative
  Scenario Outline: I login the website with invalid username and invalid password
    Given I am on the login page
    When I try to login with "<username>" and "<password>"
    Then I verify invalid login message
    Examples:
      | username               | password |
      | onur@swtestacademy.com | 11223344 |


  @negative
  Scenario Outline: I login the website with empty username and empty password
    Given I am on the login page
    When I try to login with "<username>" and "<password>"
    Then I verify invalid login message
    Examples:
      | username | password |
      |          |          |