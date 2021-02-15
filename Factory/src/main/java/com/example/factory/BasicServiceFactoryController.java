package com.example.factory;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.RemoteEndpoint;
import java.io.Console;
import java.util.List;

@RestController
public class BasicServiceFactoryController {

    @Autowired
    private DiscoveryClient discoveryClient;

    private BasicService firstService;
    private BasicService secondService;
    private BasicService thirdService;

    @GetMapping(path="/addBasicService")
    public String greeting(@RequestParam(name="name",defaultValue="User")String name){
      BasicServiceFactory factory = new BasicServiceFactory();
      int counter = 0;

      try {
          BasicService service = factory.getObject();
          counter = service.getId();

          switch (counter){
              case 1:
                  firstService = service;
                  break;
              case 2:
                  secondService = service;
                  break;
              case 3:
                  thirdService = service;
                  break;
              default:
                  counter = 3;
                  return "Es wurden bereits 3 Services erstellt und deswegen kann leider kein neuer hinzugefügt werden";

          }

      }catch(Exception e){
          e.printStackTrace();
      }

     return "Service mit Id "+counter+" wurde erstellt";
    }

@RequestMapping("/service-instances/{applicationName}")
    public List<ServiceInstance> serviceInstancesByApplicationName(@PathVariable String applicationName){
        return this.discoveryClient.getInstances(applicationName);
}


}
