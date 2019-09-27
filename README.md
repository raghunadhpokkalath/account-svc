Wholesale Digital Account Services
=========================================

#Reading guide
File names are relative to this repoistory's root unless otherwise stated

###Development Stack
- Java 8
- Spring Boot 2.1.6.RELEASE
- Gradle 5.2.1 (gradlew can be used )
- Swagger
- Spock
- Mocha and SuperTest for api-tests

### Set up guide for  Mac
-- install homebrew
-- install openjdk java8
-- install npm 


### Repository is layout as follows 



### Running application locally 
Before running the application ensure that the setup required for mac is completed
   -  git clone https://github.com/raghunadhpokkalath/anz-wd-account-svc.git
   -  cd anz-wd-account-svc
   - run "./gradlew clean build"  (This will build and run the test .Jacoco plugin is integrated to ensure code coverage is 100%)
   - run "./gradlew bootRun"  ("This will start the application in 8080 port")
   - access the api using below endpoint or import the postman collection from postman-collection/



#

#Accounts Endpoint
This endpoint will return the list of accounts corresponding to a customer id
http://localhost:8080/api/customers/123/accounts

Used Jaccoo for code coverage report

Run the Tests
 ./gradlew test
 
 
 Integrate checkstyle
 integrate find bug
 
 
 H2 Console can be accessed using .Please confirm the jdbc url is jdbc:h2:mem:accountdb .If this is not the url please change Please dont change userid password
 http://localhost:8080/api/h2-console 
 
 ##api-tests 
 APi tests uses super test to configure api tests please install npm as below
 
 To run the api tests install npm using brew command
 brew install npm
 
 Swagger -ui 
http://localhost:8080/api/swagger-ui.html

 
 