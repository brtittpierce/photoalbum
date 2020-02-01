To run the photo album application:

You will need to take this code and compile it into a JAR.  I would import it into an Eclipse workspace, as a Maven project.
 
After it has been imported into Eclipse, you will need to build the JAR file by running a Maven Install.
    In Eclipse, right click on the pom.xml file and choose "Run As" and then Maven Install.

In your console, you will see where the JAR was built.  There will be a line such as :
 
[INFO] Building jar: C:\Users\Monker\eclipse-workspaces\lt\photoalbum\target\photoalbum-0.0.1-SNAPSHOT.jar

This is the location and name of the JAR file that you will execute.

To execute the program, using the above as the path and JAR name:
	Go to a command line
	Change the current folder to where the JAR file is located.
	Run the program by typing (your JAR name may be different):
		java -jar photoalbum-0.0.1-SNAPSHOT.jar 1

	The "1" at the end is the parameter for what gallery you are requesting.

After executing, you should see the gallery display in the same format as in the instructions for the Showcase1.


A few notes that I would like to add:

The project was created using Spring Initializr to create a Spring Boot project.
I left all of my debugging System.out.printlin's in but commented them out.  I would normally remove them, but thought you may be interested.
There are some minor things I would change if I wanted to spend more time:
	I would like to add a "Business Rules" type class, instead of having the IF's and error messages where they currently are.
	I would like to have created a Controller class instead of executing the service layer directly...that would be standard, encapsulating the business logic.
	To make it a web app, I'd include Thymeleaf and use that to create a simple web screen with an input for the ID.
	I'd create some more Junit tests for the BR class that I mention above.  Each of those business rules should have a JUnit test.

I kept things pretty simple but I hope this is what you are looking for.

THANKS!