package com.example.service.Controller;


import com.example.service.View.ServiceView;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// Der Restcontroller hat Handler für die verschiedenen Anfragen implementiert
@RestController
public class ServiceController {

    // randomValue bekommt einen zufälligen Wert zugeordnet
@Value("${random.value}")
private String randomValue;

// Der ApplicationContext wird benötigt, um später den Microservice zu beenden
@Autowired
private ApplicationContext appContext;

// Der Serviceview wird verwendet, um eine Antwort zurückzugeben
@Autowired
    ServiceView<JsonNode> view;

// Bei Aufruft der URL wird eine Antwort auf der Webseite angezeigt, die den zufälligen Wert beinhaltet
@GetMapping(path="/greeting")
    public String greeting(@RequestParam(name="name",defaultValue="User")String name){
    return view.greeting(name)+" from Service with random Value "+randomValue;
}

// Über die URL wird der Microservice beendet
@GetMapping(path="/shutdown")
public void shutdown(){
 SpringApplication.exit(appContext, () -> 0);
}

// Über die URL kann mit einer Post-Methode ein JSON-Datei übergeben werden. Anschließend bekommt man ebenfalls eine Antwort.
@PostMapping(path = "/greetingJson",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public String greetingJson(@RequestParam String contentJson) {
        // Dem JSON-Node werden die JSON-Informationen übergeben
        JsonNode node = view.greetingGeneric(contentJson);
        // Anschließend wird JSON zurückgegeben, zusammen mit dem zufälligem Wert
        return node.toPrettyString()+" "+randomValue;

    }

}
