Feature: Customers

#Background: Below are common steps for every scenario
#Given user launches the browser
#When user opens the url "https://admin-demo.nopcommerce.com/login"
#And user enters Email as "admin@yourstore.com"
#And user enters Password as "admin"
#And user click on Login Button
#Then Page Title should be displayed as "Dashboard / nopCommerce administration"

#Scenario: Add a New Customer
#Given user launches the browser
#When user opens the url "https://admin-demo.nopcommerce.com/login"
#And user enters Email as "admin@yourstore.com"
#And user enters Password as "admin"
#And user click on Login Button
#Then Page Title should be displayed as "Dashboard / nopCommerce administration"
#And user click on customers menu
#And click on customers menu item
#And click on Add New Button
#Then user can view Add new customer page
#When user enters customer info
#And click on Save Button
#Then user can view confirmation message as "The new customer has been added successfully."
#When user click on Logout Button
#Then Page Title should be displayed as "Your store. Login"
#And close the Browser

@sanity
Scenario: Search Customer by EmailID
Given user launches the browser
When user opens the url "https://admin-demo.nopcommerce.com/login"
And user enters Email as "admin@yourstore.com"
And user enters Password as "admin"
And user click on Login Button
Then Page Title should be displayed as "Dashboard / nopCommerce administration"
And user click on customers menu
And click on customers menu item
And enter customer Email
When user click on search button
Then user should found email in the search table
And close the Browser


