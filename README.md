## University Microservices with Spring cloud and Spring Boot: #
1. Create Student Service
2. Create Address Service
3. Create RestTemplate in StudentService class to call Address Service for Save Address by zipCode of Student
4. Configuration of Spring cloud Config Server, Config Client , @RefreshScop
5. Get Student detail address from Address service
6. Replace RestTemplate by FeignClient
7. Create a Discovry Service to register the instnce of address service, switch to config server
* Add "spring-cloud-loadbalancer" in pom.xml for student service to change AddressFeignClientService:
from
```
@FeignClient(name="address-service" , url="localhost:8283/api/v1/address")
```
to 
```
@FeignClient(name="address-service")
```
8. Add API GateWay
```
http://localhost:8765/student-service/api/v1/students/2
```
* Exploring (building a custom route) Routes with Spring Cloud Gateway
```
http://localhost:8765/api/v1/students/1
```
Filter path :
```
http://localhost:8765/student/402
```
Code source:
```
 .route(p -> p.path("/student/**")
                .filters(f -> f.rewritePath("/student/(?<segment>.*)", "/api/v1/students/${segment}"))
                .uri("lb://student-service/"))
```


