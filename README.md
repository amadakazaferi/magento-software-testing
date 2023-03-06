# magento-software-testing

This is a Software Testing Project developed to test UI. 

This site was built using [Gradle Build Tool](https://gradle.org/).
To start the Test Suite, please run the **TestRunner.java** or run in the terminal the Gradle command './gradlew clean test --info'

- Serenity BDD is a library that makes it easier to write high quality automated acceptance tests, with powerful reporting and living documentation features. It has strong support for both web testing with Selenium, and API testing using RestAssured. 
- Design patterns like Page Objects, Step & Settings Classes approach are used in this solution to make the tests very readable and easily maintainable.
- Tests are written in BDD Gherkin format and it is represented as a living documentation in the test report in the directory 'target/site/serenity/'
- Application under test: (https://magento.softwaretestingboard.com/)

##Exclaimer 

The webdriver will quit after every Scenario, this is why for Preconditions is used the Background option. 

## Other Configurations configuration

All of the below mentioned test run configurations are configured in the `src/main/resources/serenity.conf` file.

### Webdriver configuration 
Configuration for running tests in local and other browser properties are defined here.
The project also bundles some of the WebDriver binaries that you need to run Selenium tests in the `utils/drivers/LocalChromeDriver.java` directories.  

