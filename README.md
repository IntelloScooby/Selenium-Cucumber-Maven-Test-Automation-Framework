# LexiconCodeChallenge


## Test Scenario:

* Navigate to https://www.officeworks.com.au/
* Enter login credentials and login to the site (you don't have to automate the registration process, just the login) 
* Navigate to Technology ->  iPhones & Mobile Phones ->iPhones
* Add the first two items on the screen to the shopping cart by clicking on "Add to cart” for each item
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

* Install Java 1.8 and set JAVA_HOME environment variable
* Install Maven and set MAVEN_HOME environment variable
* Chrome browser version should be 74.x

### Run from Terminal

* Clone the project
* Open terminal and change directory to the root directory of the project
* Use the below commands to run the test:

To run SmokeTests test suite:

`shell
mvn clean test -DtestSuite=SmokeTests
`

To run FullRegression test suite:

`shell
mvn clean test -DtestSuite=FullRegression
`

### Run from IntelliJ

* Clone the project
* Navigate to /src/test/resources/testSuites and right click on SmokeTests.xml or FullRegression.xml and select Run

## Framework Details

Below tools are used in the framework:

* Selenium WebDriver
* Cucumber
* TestNG (for running testSuites)
* Extent Report API 
* Maven

## Project Structure

The project is setup as a maven project and so all the test related code is placed under `'/src/test/java'` directory. Similarly, the test related resources are placed under `'/src/test/resources'` directory

### Pages

The project uses Page Object Model. The `pages` directory contains the page classes for different pages of the website. The page classes use `Pagefatory` for accessing the elements of the pages

### Setup






















