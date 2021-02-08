# GlaucusTask
The task is to consistently increment a number in a database when parallel threads are racing to increment the number.
Create a table Number in MySQL database with one integer type field.
Create a RESTful API using Spring Boot architecture that increments this number.
Use Jmeter (Do not use postman because it does not send parallel requests) to call this API with 5000 users so that a lot of parallel requests are sent to server to increment the number.
Now set the initial value of Number to 0.
After the execution of Jmeter, the value of the number in the database shall be 5000. (Try the same with a bigger number 100000)
The API should be scalable i.e. if deployed on multiple machines with same database, the result should be consistent.

# Documentation with Instruction
Software Requirements: 
Windows : 7/8/10 , Linux
IDE     : Eclipse, Visual Code Studio
Database: MySQL

Hardware Requirements: 
RAM 	  : 4GB/8GB
Processor : i3/i5/i7

Changes required:
1)Change the database name, user, password values present in application.properties and persistence.xml
Given below are the lines in which change is required.

Persistence.xml
<!-- <property name="javax.persistence.jdbc.url" value="jdbc:mysql://localhost:3306/naman"/>
<property name="javax.persistence.jdbc.user" value="root"/>
<property name="javax.persistence.jdbc.password" value="root"/> -->

application.properties
spring.datasource.url=jdbc:mysql://localhost:3306/naman
spring.datasource.username=root
spring.datasource.password=root

2)Changes the database name in TagRepository, in methods: insertFirstValue(), findOne(String tagId), save(Tag tag)

Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/naman", "root", "root");

How to operate & Flow of Code:

Run the program from TagcountApplication.java.
Once the localhost server starts, hit the url using URI /incrementingTag.
The API will the increment the number in the database.
Flow: TagController -> TagService -> TagRepository

	
	


