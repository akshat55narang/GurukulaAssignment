# GurukulaAssignment

Introduction
The Assignment is as a Maven Project created using Cucumber in BDD framework with Selenium libraries used for automation ( in JAVA ).

Project Name-Gurukula
Description- All the test scenarios are split into individual Feature files like ( Login , Entities , Register New User, etc).
Corressponding to the Feature files , Step Definitions are created containing the corressponding selenium test cases.

1. src/test/resources-
Feature - Consists of 5 feature file covering all the scenarios w.r.t. each Feature
in business readable language.
drivers - Consists of all the drivers ( both for windows and linux).
data.properties - contains startup variables like, url , browser, driver paths, etc.
extent-config.xml - xml config for extent report
log4j.xml - configuration for log4j.

2. src/test/java - Contains the below mentioned packages.
1. dataProvider - Contains ConfigFileReader.java - Contains all the methods to load the property file values.
2. objectRepository - Contains the page object classes for all the pages using the Selenium Page Factory Implementation.
3. stepDefinition - Contains all the stepDefinition classes( corressponding to the Feature files ).
4. runners - Contains the TestRunner class to run all the test cases. Also contains the path to extent reports.
5. managers - Contains classes to manage the the number of objects created for the Page Object classes or WebDriver or Confir File classes i.e. Singleton design. The same object should not be created again and again. But to use single object for all the step definition files.
6. cucumber - Contains class Test Context to share the context between muliple Step Definition files as few steps in a scenario might be present in another StepDefinition class file.This has been accompalished by Pico Container Dependency Injector.Also, the package contains Log.java class to setup methods for all the Log4j messages.

3. logfile.log - The log files for the test run.

How To Run - 
In IDE , Open the TestRunner.java class and Run as a Junit Test.

Test Report location - The Extent Report will be created in the folder cucumber-reports with the name report.html.


