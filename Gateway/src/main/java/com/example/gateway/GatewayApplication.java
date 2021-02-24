package com.example.gateway;

import com.example.gateway.Filter.StandardFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

// Das Gateway ist ein ZuulProxy
// Es wird ein Discovery-Client verwendet, um sich beim Discovery-Service zu registrieren
@EnableZuulProxy
@EnableDiscoveryClient
@SpringBootApplication
public class GatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}

	// Beispiel eines Filters, der bei dem Proxy angewandt werden kann
	@Bean
	public StandardFilter simpleFilter(){
		return new StandardFilter();
	}


}
