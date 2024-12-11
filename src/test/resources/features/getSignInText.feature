Feature: navigating to sign in page
  Scenario: get sign in text from sign in page
    Given user is on google landing page
    When user clicks on sign in button
    Then user should be navigated to sign in page
    Then user should see sign in text and print it to console