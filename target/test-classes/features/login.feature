Feature: Rediff Application

Scenario Outline: Login to Rediff
Given user initalizes driver
And navigate to website
When user enters invalid <username> and <password>
Then user should get an error

Examples:
|username|password|
|vijay|54365|
|sanesh|rtrt4|