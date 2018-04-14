# GurukulaAssignment

Introduction
The Assignment is as a Maven Project created using Cucumber in BDD framework with Selenium libraries used for automation ( in JAVA ).

Project Name-Gurukula
Description- All the test scenarios are split into individual Feature files like ( Login , Entities , Register New User, etc).
Corressponding to the Feature files , Step Definitions are created containing the corressponding selenium test cases.

1. src/test/resources-
Feature - Consists of 5 feature file covering all the scenarios w.r.t. each Feature
in business readable language.
drivers - Consists of all the driver files.
data.properties - contains startup variables
extent-config.xml - xml config for extent report
log4j.xml - configuration for log4j.

2. src/test/java - 
1. dataProvider - 
It consist of three program files
a. ConfigRead.java-This is responsible for loading the configurations from properties files located at /src/test/resources/configuration/config.properties 
b. Testbase.java-This is responsible for Initializing the WebDriver.
c. TestUtil.java-This consist of generic methods(For e.g. waitForElementToDisplay,clickWebelement etc) 

