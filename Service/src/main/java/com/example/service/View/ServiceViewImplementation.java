package com.example.service.View;

import com.example.service.Service.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// Die ServiceView implementiert
@Component
public class ServiceViewImplementation implements ServiceView<JsonNode> {

    // Das Template für die Antwort
    private final String template = "Hello %s";

    // Es wird ein Service erstellt, der die Anfrage bearbeitet
    @Autowired
    Service service;

    // Die Methode gibt für den übergebenen String ein Greeting zurück
    // Dabei wird auf das Template zurückgegriffen
    @Override
    public String greeting(String content){
        String result = service.greeting(content);
        return String.format(template,result);
    }

    // Das generische Interface wird mit JSON implementiert
    @Override
    public JsonNode greetingGeneric(String contentJson){
        // Es wird ein JSON-Node und ein ObjectMapper erstellt
        ObjectMapper om = new ObjectMapper();
        JsonNode node = null;

        try{
            // der Objekt-Mapper liest den Inhalt der JSON-Datei aus
            node = om.readTree(contentJson);

        }catch(Exception e){
            // Wenn ein Fehler auftritt, wird diese auf der Konsole ausgegeben
            e.printStackTrace();
        }
        // Der Content wird auf das content-Feld der JSON-Datei festgelegt
        String content = node.get("content").textValue();

        String result = service.greeting(content);
        ObjectNode resNode = om.createObjectNode();
        resNode.put("greeting",String.format(template,result));

        return resNode;
    }

}
