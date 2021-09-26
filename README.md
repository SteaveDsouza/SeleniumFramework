# SeleniumFramework

A standard Framework with Docker integration for simultaneous executions on multiple browsers and detailed reporting using Extent Framework.

The execution can be wholly controlled through Config.properties (src/main/java/test/java/resources/Config/config.properties)

The test cases to execute , Data, browsers on which to execute , Number of times to execute and priority can be controlled from the Data sheet located at (src/main/java/test/java/resources/data/data.xlsx)

The framework is designed using page object model , custom annotations and custom exceptions.

Custom listener are written in (src/main/java/com/steave/listeners) and configured in testng.xml file at root.

To run the test cases on Docker make sure to have Docker installed. The compose file i.e. docker-compose.yaml will automatically provision the required.

To execute , simply enter the appropriate class name containing test cases in testng.xml file and run it
