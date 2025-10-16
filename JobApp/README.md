## Steps to build docker image without docker file

./mvnw spring-boot:build-image "-Dspring-boot.build-image.imageName=dockerusername/job-protal"
- /.mvnw - maven wrapper. This is a script using wich we execute the commands
- spring-boot:build-image - Maven goal that is provided by spring boot maven plugin and this goal builds the docker image from the spring boot application using CNCF (Cloud native build packs).
<br>First our application will be converted toa jar file and then transferred to a image.
- -D defines the system property
- -Dspring-boot.build-image.imageName=job-protal : This is the system property which we are passing to the goal

<br>
Before running the command set the correct java hoe path
$env:JAVA_HOME="C:\Program Files\Amazon Corretto\jdk21"
<br>
$env:Path="$env:JAVA_HOME\bin;$env:Path"

- docker login
- docker push username/job-protal:latest

Docker commands after migrating the database to postgresql
- docker network create my-network

- docker run -d --name db --network my-network -e POSTGRES_PASSWORD=poojita postgre
- docker run -d --name pgadmin --network my-network -e PGADMIN_DEFAULT_EMAIL=admin@admin.com -e PGADMIN_DEFAULT_PASSWORD=poojita -p 5050:80 dpage/pgadmin4
- docker exec -it pgadmin ping db  
