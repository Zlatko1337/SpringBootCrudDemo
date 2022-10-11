This simple Spring Boot app that demonstrates CRUD operations. It uses H2 in-memory database. Fronted is made with Thymeleaf and Datatables with server-side processing (paging). Credits go to creators of these great libs.
This demo app uses few software design patterns, Controller-Service-Repository and Data Transfer Object pattern to name a few.

The goal was is not a make a pretty gui, but to experiment with libs and test some concepts.

To build:
1. Import as Maven project
2. run 'clean package' or 'mvn clean package'

To run:
1. Run .exe or .jar (java -jar SpringBootCrudDemo.jar)

In case of problems:
1. netstat -ano | findStr "8080"		//which process (pid_id) uses port 8080
2. taskkill /F /PID pid_id
3. Run .exe or .jar

