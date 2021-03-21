FROM tomcat:8.0.51-jre8-alpine
RUN rm -rf /usr/local/tomcat/webapps/*
COPY ./target/employee-time-tracking-system-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/employee-time-tracking-system.war
MAINTAINER   Ruturaj Shinde <ruturaj55@gmail.com>
CMD ["catalina.sh","run"]
