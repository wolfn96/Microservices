package com.example.factory;

import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.stereotype.Service;

@EnableEurekaClient
public class BasicService {
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
