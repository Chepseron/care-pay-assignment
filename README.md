springblog
====

My project is a REST API to write blog content, A user logs in and adds a post (title and content)

The project requires the following to execute 

1. JDK 1.8
2. Apache Tomcat or TOM EE
3. MYSQL 5.7
4. You can choose an IDE of your prefference netbeans/eclipse/intellij
5. Theres is an application.properties file which you will configure the database url and credentials. The file path is springblog\src\main\resources


## Tests

Test options are found on the package 
springblog\src\test\java\com\amon\blog\springblog
however we have more tests ongoing

More developments on the interface and additional patterns (Observer patterns to check for current posts and render them real time ongoing)

## Security

The application uses Json Web Tokens for authentication. for more information check on 
https://mvnrepository.com/artifact/io.jsonwebtoken/jjwt


## Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the main method in the com.amon.blog.springblog.SpringblogApplication class from your IDE.

Alternatively you can use the Spring Boot Maven plugin like so:

mvn spring-boot:run


## Deploying the application to Apache Tomcat 

follow the link at https://www.codejava.net/servers/tomcat/how-to-deploy-a-java-web-application-on-tomcat.
The Web Archive is located at springblog\target\

## Copyright

This project is for DEMO purposes. You can contact 
https://www.linkedin.com/in/amon-sabul-msc-b593b386/

