# mama-money Project

### To get the started
* start with maven command 
    * mvn clean to delete all jar files
    * mvn package
    * mvn build to generate files in jar
    
    ``or locate run.sh file and run it in your terminal``

* To use JDBC with H2 sql database add that to your pom file

    * 
    ``<dependency>
          <groupId>com.h2database</groupId>
          <artifactId>h2</artifactId>
           <version>1.4.199</version>
    </dependency>
  ``
* to set it up with java

`` // load the jdbc driver
Class.forName("org.h2.Driver");``
        
``set the jdbc connection string
final String jdbcURL = "jdbc:h2:file:./target/your_database_name";``
              
``// connect to the database
Connection conn = DriverManager.getConnection(jdbcURL, "sa", "");``
 