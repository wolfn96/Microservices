package com.example.service.service;

@org.springframework.stereotype.Service
public class ServiceImplementation implements Service {
@Override
    public String greeting(String content){
     return content;
    }
}
