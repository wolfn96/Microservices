package com.example.service.view;

import com.example.service.service.Service;
import com.fasterxml.jackson.core.JsonProcessingException;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class ServiceViewImplementation implements ServiceView<JsonNode> {
    private final String template = "Hello %s";

    @Autowired
    Service service;

    @Override
    public String greeting(String content){
        String result = service.greeting(content);
        return String.format(template,result);
    }

    @Override
    public JsonNode greetingGeneric(String contentJson){
        ObjectMapper om = new ObjectMapper();
        JsonNode node = null;

        try{
            node = om.readTree(contentJson);

        }catch(Exception e){
            e.printStackTrace();
        }

        String content = node.get("content").textValue();
        String result = service.greeting(content);
        ObjectNode resNode = om.createObjectNode();
        resNode.put("greeting",String.format(template,result));

        return null;
    }

}
