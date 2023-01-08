Feature: Login can be performed via input of email and password on elephant landing page and click on login button

  Scenario: check password encapsulation

    Given open elephant login page "http://localhost:7000/"
    And type into password "N.rwKjF82.tmQ7e"
    When press button with eye symbol on login page
    Then password changed to readable text

  Scenario: perform login with valid data

    Given open elephant login page "http://localhost:7000/"
    And type into email "vlpiatachenko@gmail.com"
    And type into password "N.rwKjF82.tmQ7e"
    When press button with text login on login page
    Then redirect to profile page "http://localhost:7000/home"
