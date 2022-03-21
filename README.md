# task-management-service 
Task Management Service

##Connect oracle cloud:

ssh -i {private-key-file} user@{Public IP address}

##Setup in Cloud Machine

git clone https://github.com/umasankar12/task-management-service.git
cd task-management-service
docker build -t task-management-service .
docker run -it -p 8080:8080 -p 8081:8081 --name task-management-service --network mynet task-management-service

Then open the local browser and hit http://{Public IP address}:8080/tms/task/1