package com.rest.consumer;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class GreetingService {
	
	 @Bean
	  public RestTemplate restTemplate() {
	    return new RestTemplate();
	  }

	 @HystrixCommand(fallbackMethod = "defaultGreeting")
	  public String getGreeting(String username) {
		 	return	restTemplate().getForObject("http://localhost:9090/greeting/{username}", 
	          String.class, username);
	    }
	 
	 /** fallback method**/
	    @SuppressWarnings("unused")
		private String defaultGreeting(String username) {
	        return "Hello Guest!";
	    }
	
	

}
