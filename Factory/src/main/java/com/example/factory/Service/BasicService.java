package com.example.factory.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.context.WebServerApplicationContext;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.stereotype.Component;


@EnableEurekaClient
@EnableDiscoveryClient
public class BasicService {
    // Es wird ein Discovery-Client erstellt, um sich bei dem Eureka-Server zu registrieren
    @Autowired
    private DiscoveryClient discoveryClient;
    // Jedem Basic-Service wird eine ID und ein Name zugeordnet
    private int Id;
    private String name = "Service with Id "+Id;

    // Der Konstruktor des BasicService
    public BasicService(int Id){
        this.Id = Id;

    }
    // Accessoren
    public int getId(){
        return Id;
    }
    public String getName(){
        return name;
    }
}
