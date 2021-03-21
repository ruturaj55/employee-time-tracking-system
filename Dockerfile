#Use java 8 base image expose port 9292 add war to container and provide entrypoint for docker
FROM java:8
EXPOSE 9292
ADD target/employee-time-tracking-system-0.0.1-SNAPSHOT.war employee-time-tracking-system.war
ENTRYPOINT ["java","-jar","employee-time-tracking-system.war"]
