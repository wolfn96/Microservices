package com.example.service.controller;


import com.example.service.view.ServiceView;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.core.Application;

@RestController
public class ServiceController {

@Value("${random.value}")
private String randomValue;

@Autowired
private ApplicationContext appContext;

@Autowired
    ServiceView<JsonNode> view;

@GetMapping(path="/greeting")
    public String greeting(@RequestParam(name="name",defaultValue="User")String name){
    return view.greeting(name)+" from Service with random Value "+randomValue;
}

@GetMapping(path="/shutdown")
public void shutdown(){
 SpringApplication.exit(appContext, () -> 0);
}

@PostMapping(path = "/greetingJson",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public String greetingJson(@RequestParam String contentJson) {

        JsonNode node = view.greetingGeneric(contentJson);
        return node.toPrettyString()+" "+randomValue;

    }

}
