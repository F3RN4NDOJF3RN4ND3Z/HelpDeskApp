# What is this app?
A responsive web application that provides help desk/ticketing functionality.
The application should require authentication to access it with two roles (Admin and Standard)
existing for users. 
* Admin users can access all functions of the application including setup screens and managing users. 
* Standard users will see their dashboard and be able to enter tickets.
* Admin users will have a single view and will be able to switch to the help desk of different organizations in the application.
* Users will belong to a specific organization and will only be able to see tickets for their organization.
* Help desk tickets should have a basic description and category of the problem and should record who submitted the ticket
and when it was submitted. There will also be a status field to keep track of the current status of the ticket. 
* Each ticket can have comments added to it and comments should track the user who added the comment and when it was added.
* The main screen for a Standard User should be a dashboard that shows a graph that indicates the number of tickets created across all users within the organization by day. Below that should be a list of the most recent tickets created for the logged in user.
# Repository Structure
* docs: Contains the documentation and architecture diagrams for this application.
* frontend: Contains the front-end code.
* backend: Contains the back-end code. Devided in three isolated domains Following a DDD. Each of wich will in turn have sub-packages called boundary, control, and entity. The structure follows the Boundary-Control-Entity (BCE)/Entity-Control-Boundary (ECB) pattern.
    * users 
    * tickets
    * organizations

# Application Architecture
The projects is created as standard Java EE projects, which are Skinny WARs, that will be deployed using the Payara Micro server. 
The projects where created usign Maven with a webapp archretype.
Java EE 8 and Payara Micro
* Mockito and JUnit dependencies for efficient testing
* beans.xml with bean-discovery-mode="all" for ready to go dependency injection
* persistence.xml configured for JTA persistence unit
* JAX-RS 
* Docker Deployable containers
* API GateWay for virtualizing services and have an orchestrated architecture

# Installation
run inside each folder of the backend.
``` mvn clean install ```
Download Payara Micro. Run de payara server inside each folder replace xxx with the version of your jar and make sure that the target is pointing to the correct war do this for each of the components. Be careful to point to different ports.
``` java -jar payara-micro-xxx.jar --deploy users/target/users.war --autoBindHttp ```
