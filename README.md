# Sample automation framework


## Test Scenario:

* Navigate to https://www.officeworks.com.au/
* Enter login credentials and login to the site (you don't have to automate the registration process, just the login) 
* Navigate to Technology ->  iPhones & Mobile Phones ->iPhones
* Add the first two items on the screen to the shopping cart by clicking on "Add to cart" for each item
* Verify that both items are added to the shopping cart


## Objective:

* Use Selenium WebDriver automation tool with one of these languages Java/C#/Javascript
* Create an automation framework based on Page Object Model
* Fetch the test data from an external file.
* Use shell script to run the tests (Optional)
* Generate a custom report (Optional)
* Push it to a public git repo 

## Running the tests

### Pre-requisites

* Install Java 1.8 and set `JAVA_HOME` environment variable
* Install Maven and set `MAVEN_HOME` environment variable
* Chrome browser version should be 74.x or below

### Run from Terminal

* Clone the project
* Open terminal and change directory to the root directory of the project
* Use the below commands to run the test:

To run SmokeTests test suite:

`
mvn clean test -DtestSuite=SmokeTests
`

To run FullRegression test suite:

`
mvn clean test -DtestSuite=FullRegression
`

https://user-images.githubusercontent.com/11371576/119584666-5f23d180-be0c-11eb-9cfc-9638510acb58.mp4


https://user-images.githubusercontent.com/11371576/119584989-21737880-be0d-11eb-9e07-408bcc4458b5.mp4



### Run from IntelliJ

* Clone the project
* Navigate to `/src/test/resources/testSuites` and right click on `SmokeTests.xml` or `FullRegression.xml` and select Run

## Test Reports

The test results can be viewed in the console logs. Along with that, at the end of the test an HTML report is also generated. It is located at `'/src/test/resources/test-output/CustomTestReport.html'`
If any test fails, a screenshot of the page where the test failed is also attached to the report across corresponding scenario. This report gets overwritten when a new test is run. 


https://user-images.githubusercontent.com/11371576/119585039-38b26600-be0d-11eb-8bde-60afbc4a6c74.mp4



## Framework Details

Below tools are used in the framework:

* Selenium WebDriver
* Cucumber
* Gherkin
* TestNG (for running testSuites)
* Extent Report API 
* Maven

## Project Structure

The project is setup as a maven project and so all the test related code is placed under `'/src/test/java'` directory. Similarly, the test related resources are placed under `'/src/test/resources'` directory

### Pages

The project uses Page Object Model. The `pages` directory contains the page classes for different pages of the website. The page classes use `Pagefatory` for accessing the elements of the pages

### Setup

The `@BeforeSuite` and `@AfterSuite` methods are within the setup package. 

### Steps

The step definitions and the cucumber setup and teardown classes are available in the `steps` package. All the step definitions (i.e. Cucumber glue code) of the features is written in the `StepDefs` class.
The `CucumberSetup` class contains `@Before` and `@After` methods that are run before and after a scenario respectively.

### TestRunners

The `testRunners` package consists of runner classes to run different features. Currently, there are runner classes for Login and iPhone ordering functionality. There is also a runner class for `SmokeTest` which would only run the scenarios that have the `@SmokeTest` tag.
The runner classes use `@CucumberOptions` to define the features we intend to run. Withing `@CucumberOptions` we can provide the path of the features we intend to run. We can also pick and choose certain scenarios or features from a given location by using `tags`.  
The `TestNGCucumberRunner` class provided by Cucumber is used to achieve this. 

### Utils

The `utils` package consists of multiple utility classes.

#### ConfigReader

This class reads the test configuration from the `config.properties` file. This file can consist of different configurations like the test browser and base url.

#### Constants

This class consists of the constants used throughout the project like various file paths, URLs, error messages, test data keys, etc. 
Using a constants class server 2 purposes:
1. If the location of file, test data key names or the error messages etc. changes then we only need to change that 1 location
2. Using constants for test data keys helps in avoiding any spelling errors

#### TestDataReader

This class consists of methods used to read the test data from the `TestData.json` file.

#### TestReportGenerator

This class consists of methods that assist with HTML report generation using Extent Report API.

#### Features

This directory consists of all the feature files. The files are written using the `Gherkin` language. This is one of the important components that helps to achieve BDD approach.

#### Test-Output

This directory is where the `CustomeTestReport.html` is generated at the end of each test run. Within this package there is also the screenshots directory where the screenshots are placed in case a test fails and that screenshot is used in the test report.

#### TestSuites

This directory consists of various TestNG testSuite XML files. We can create testSuites and use them to run the tests. Check out the 2 XML test suites created as an example.
