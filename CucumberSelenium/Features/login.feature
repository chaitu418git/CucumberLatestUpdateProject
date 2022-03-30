Feature: Login Functionality Check

@sanity
Scenario: Verify Login Functionality
Given user launches the browser
When user opens the url "https://admin-demo.nopcommerce.com/login"
And user enters Email as "admin@yourstore.com"
And user enters Password as "admin"
And user click on Login Button
Then Page Title should be displayed as "Dashboard / nopCommerce administration"
When user click on Logout Button
Then Page Title should be displayed as "Your store. Login"
And close the Browser

@regression
Scenario Outline:Login Data Driven
Given user launches the browser
When user opens the url "https://admin-demo.nopcommerce.com/login"
And user enters Email as "<email>"
And user enters Password as "<password>"
And user click on Login Button
Then Page Title should be displayed as "Dashboard / nopCommerce administration"
When user click on Logout Button
Then Page Title should be displayed as "Your store. Login"
And close the Browser

Examples:
|email|password|
|admin@yourstore.com|admin|
|admin1@yourstore.com|admin123|