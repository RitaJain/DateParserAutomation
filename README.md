# Propine
QA Assignment

## Table of contents
* [General info](#general-info)
* [Technologies](#technologies)
* [Setup](#setup)
* [Folder structure conventions](#folder-structure-conventions)
* [Test execution](#test-execution)
* [Reporting](#reporting)

General info
============
This automation project aims to help developers to detect and prevent any issues releated to Date Parser Module

Technologies
============
- Java Compiler 1.8 : used to compile the project
- JUNIT 5.3.0 - Java unit testing framework
- Testng 7.1.0 - Support for data-driven testing (with @DataProvider)and other Annotations (@Test , @BeforeTest, @AfterTest)
- Selenium 3.141.59 - Selenium automates browsers.
- MVN  3.6.3 - build automation tool

Setup
=====
Mac OS installation instructions:
* Install Java JDK 8 on your local machine
* Install Maven
$ brew install maven
$ mvn -v
* Install IntelliJ IDEA please follow the steps [here](https://www.jetbrains.com/idea/)
* Launch IntelliJ IDEA and click on `Import project
Folder structure conventions
============================
> Folder structure for an automation software project

### A top-level directory layout
    .
    ├── src                     # Source files
    ├── test-output             # Test report generated files by Testng
    ├── README.md               # Project Details
    ├── Testng.xml              # Testsuite
    ├── target                  # Internal test report generated files

### Source files
    .
    ├── ...
    ├── src
    │
    │   └── main
    │       ├── java
    │       │    ├── com.propine.page
    │       │    │   ├── PropinePage   # containing css selectors
    │       │    │
    │       │    │
    │       │    └── common
    │       └── resources
    │           ├── Driver  # contains mac chrome Driver
    │           └── ...
    └── ...

 .

    ├── src
    │
    │   └── test
    │       ├── java
    │       │    ├── com.propine.tests
    │       │    │   ├── PropineDateTest   # containing date parser tests
    │       │    │

   Test Execution
    ==============
    Maven  tool is used for the project build and dependencies configuration.
    > Execution from a terminal window example:


    $ mvn clean test  -Dbrowser=chrome

   Reporting
   =========
   Testng Default reporting listner is used for generation of reports can be found  in test-output folder  named with below names:
    - Index.html
    - emailable-report.html