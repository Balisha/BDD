Feature: To check the open cart app

Background:
Given I should open the browser and navigate to login page
@PositiveTesting
Scenario: To test the login credentials
When Enter email "anamika@gmail.com"
And Enter password "anamika2"
And Click on login
Then Should navigate to account detail page

@NegativeTesting
Scenario: To test the login credentials
When Enter email "balisha@gmail.com"
And Enter password "balisha5"
And Click on login
Then Should throw error



