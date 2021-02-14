package com.example.service.controller;


import com.example.service.view.ServiceView;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceController {

@Autowired
    ServiceView<JsonNode> view;

@GetMapping(path="/greeting")
    public String greeting(@RequestParam(name="name",defaultValue="User")String name){
    return view.greeting(name);
}

@PostMapping(path = "/greetingJson",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public String greetingJson(@RequestParam String contentJson) {

        JsonNode node = view.greetingGeneric(contentJson);
        return node.toPrettyString();

    }

}
