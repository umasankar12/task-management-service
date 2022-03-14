FROM openjdk:16-alpine3.13
WORKDIR /var/opt/task-management-service

ADD build/libs/task-management-service-1.0-SNAPSHOT-all.jar /var/opt/task-management-service/task-management-service.jar
ADD tms-docker.yml /var/opt/task-management-service/tms.yml
EXPOSE 8080:8081

ENTRYPOINT ["java", "-jar", "task-management-service.jar", "server", "tms.yml"]
