# README #


### What is this repository for? ###
* This is the product select application for sky
* Version 1.1

The application is designed to receive a customerId from the calling system, however seen as this is just a test prototye the customerId has been randomly generated to be an integer between 1 and 10.
The Location Service is also a stubbed service, and will return London if the customerId is even and Liverpool if it is odd.
The customerId is held as a cookie so will have to be deleted if another customerId wants to be used.

### Design and Architecture ###
This web system has been built using:
* Play Framework
* Java
* Angular JS
* H2 In Memory Database

The system has been designed to use Restful Services. I decided to use these technologies not based on experience but a desire to learn. I am quite new to Play and Angular and wanted to stretch myself for this exercise.


### How do I run the application? ###
####Pre-requisites
*JDK 8 Intalled and JAVA_HOME and PATH environment variables set for the JDK

1. At the commandline navigate to a suitable local directory and clone the repository from github, using the following URL
  https://github.com/yasinmustafa/SkyProducts.git
2. Navigate to SkyProducts: cd SkyProducts
3. If you are using Windows execute the following command: activator run
   If you are using linux execute the following command: ./activator run
   Note:- this step will take several minutes if it is the first time you have run activator on your machine
4. In a browser Navigate to http://localhost:9000
  Note:- this step will take several minutes aswell if it is the first time

### Tests ###
The test strategy covers three areas.
1. Unit testing of methods
2. Restful Services Testing
3. Functional Integration Testing

A decision was made not to unit test DAO methods as they are implicitly tested by the REST tests,
The Unit Testing class is TestCustomerLocationServiceStub and can be run as a Junit test with the IDE.
The restful services test needs the application to be running (although there is a TODO to incorporate a 'Fake Application' into the test
Functional Integration testing is done using Protractor (see test/resources/integration/protractor). However this is just a skeleton test at the moment and there is a TODO to complete the Functional Tests.

### TODOS ###
1. Make the Restful services test self contained by starting up a server within the tests
2. Complete the automated Functional tests using Protractor.


### Who do I talk to? ###

Yasin Mustafa
yasin.mustafa@gmail.com
