FROM openjdk:11
EXPOSE 8080
ADD target/ps-football-league.jar ps-football-league.jar
ENTRYPOINT ["java","-jar","/ps-football-league.jar"]