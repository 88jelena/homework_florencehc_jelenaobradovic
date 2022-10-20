# Florence Automation Task

Automation project containing test solutions for UI testing (on website https://parabank.parasoft.com/).
Tests are written in Java using Selenium, in combination with TestNG and Maven.

All task requirements can be found in test_requirements.txt.

Used in this project:
1. Java (v1.8)
2. Selenium (v3.141.0)
3. TestNG (v6.14.3)
4. javaFaker (v1.0.2) for mockup data 
5. webdrivermanager (v5.3.0) to manage chromeDriver


In this suite main focus is testing user registration, login, forgot user details and site account options pages.

_Note:_ Site https://parabank.parasoft.com/ is demo site, and not working always as expected.
It is possible that some pages are not working at the moment of test run, so tests will fail.


To run tests, clone this code to your local machine, navigate to the file testng.xml and run it.
After test run the reports will be generated in output directory.
When test fails, screenshot is created and can be found in same output directory.
Reports can be open by any desired browser.