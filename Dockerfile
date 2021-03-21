FROM java:8
EXPOSE 8083
ADD target/employee-time-tracking-system-0.0.1-SNAPSHOT.war ettsapp.war
ENTRYPOINT ["java","-jar","demo.war"]
