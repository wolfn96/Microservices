package com.example.service.Service;

@org.springframework.stereotype.Service
// Der Service implementiert das Greeting-Interface und gibt den Inhalt einfach zurück
public class ServiceImplementation implements Service {
@Override
    public String greeting(String content){
     return content;
    }
}
