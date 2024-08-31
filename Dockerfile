# Use the official Tomcat image from the Docker Hub
FROM tomcat:10-jdk17

#rename war file
CMD ["mv build/libs/backend-1.0.war build/libs/ROOT.war"]

# Add the WAR file to the webapps directory of Tomcat
ADD ROOT.war /usr/local/tomcat/webapps/

ADD https://repo1.maven.org/maven2/com/h2database/h2/1.4.200/h2-1.4.200.jar /h2.jar

# Expose port 8090
EXPOSE 8090

# Start Tomcat
CMD ["catalina.sh", "run"]