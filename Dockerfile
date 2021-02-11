FROM openjdk:11
EXPOSE 8080
ADD target/sapient-football-league-backend-0.0.1.jar sapient-football-league-backend.jar
ENTRYPOINT ["java","-jar","/sapient-football-league-backend.jar"]