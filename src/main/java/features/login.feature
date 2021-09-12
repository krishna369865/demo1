Feature:  Application Login



Scenario: Home page default login
Given Initialize chrome browser
And Navigate to "https://www.yatra.com" site
And Move to more and click on trains
When click on alert and click search button 
Then  validate homepage title


Scenario: Home page default login
Given Initialize chrome browser
And Navigate to "https://www.yatra.com" site
And click on signup button
When  User signup to application using "esakonunaidu@gmail.com" 
Then  validate homepage title

