# springboot-rest-web-hystrix
spring boot apps to demonstrate the working of netfilx-hystrix fault tolerance.

rest-producer is a producer microservice with the endpoint:  
`http://localhost:9090/greeting/{username}`  
It returns a string : ```Hello {username}!```  
  
 rest-consumer is a consumer microservice which calls the above microservice endpoint by calling:  
 `http://localhost:9000/get-greeting/{username}`  
 
 rest-consumer has Hystrix fault tolerance enabled in case rest-producer server is not up/not able to serve request.  
 
 ## rest-consumer main class:  
 ```
@SpringBootApplication
@EnableHystrix
@EnableHystrixDashboard
public class RestConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestConsumerApplication.class, args);
	}

}
```  
## rest-consumer service class:  
```

	 @HystrixCommand(fallbackMethod = "defaultGreeting")
	  public String getGreeting(String username) {
		 	return	restTemplate().getForObject("http://localhost:9090/greeting/{username}", 
	          String.class, username);
	 }
  ```  
  ## rest-consumer fallback method:  
  ```
  @SuppressWarnings("unused")
		private String defaultGreeting(String username) {
	        return "Hello Guest!";
	    }
   ```  
   

