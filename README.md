 - company microservice - 8081 port
 - job microservice - 8082 port
 - review microservice - 8083 port

 - eureka server - [8761](http://localhost:8761/)
 - postgresql - 5432 port - Running from docker
 - pgAdmin - running from docker

 - zipkin - http://localhost:9411/zipkin/
 - API gateway - 8084 port

- Resilence4J - [Documentation for reference](https://resilience4j.readme.io/docs/getting-started)
- rabbitMQ - http://localhost:15672/#/queues

docker run -d --name rabbitmq 5672:5672 -p 15672:15672 rabbitmq:3-management

./mvnw spring-boot:build-image "-Dspring-boot.build-image.imageName=<usaername>/<imagename>"

./mvnw spring-boot:build-image "-Dspring-boot.build-image.imageName=poojitak/servicereg"


if above command is nt working using below plugin and run the below commands:
```xml
            <plugin>
				<groupId>com.google.cloud.tools</groupId>
				<artifactId>jib-maven-plugin</artifactId>
				<version>3.3.2</version>
				<configuration>
					<from>
						<image>eclipse-temurin:21-jre</image>
					</from>
					<to>
						<image>poojitak/servicereg</image>
					</to>
					<container>
						<mainClass>com.jobportal.service_reg.ServiceRegApplication</mainClass>
					</container>
				</configuration>
			</plugin>

```
command: ./mvnw compile jib:dockerBuild
if you want to directly push to docker hib without creating image in local, use command: ./mvnw compile jib:build

if you are seeing error for above command also try below command:
 - ./mvnw clean compile jib:dockerBuild -DskipTests
