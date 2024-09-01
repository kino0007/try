# Use the official Tomcat image from the Docker Hub
FROM tomcat:10-jdk17

# Add the WAR file to the webapps directory of Tomcat
ADD build/libs/ROOT.war /usr/local/tomcat/webapps/

ADD https://repo1.maven.org/maven2/com/h2database/h2/1.4.200/h2-1.4.200.jar /h2.jar

# Expose port 8080
EXPOSE 8080

# Start Tomcat
CMD ["catalina.sh", "run"]