package com.example.factory;

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

    @Autowired
    private DiscoveryClient discoveryClient;


    private int Id;
    private String name = "Service with Id "+Id;

    public BasicService(int Id){
        this.Id = Id;

    }

    public int getId(){
        return Id;
    }

    public String getName(){
        return name;
    }
}
