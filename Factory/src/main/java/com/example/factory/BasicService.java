package com.example.factory;

import org.springframework.stereotype.Service;


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
