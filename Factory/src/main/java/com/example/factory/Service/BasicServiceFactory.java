package com.example.factory.Service;

import com.example.factory.Service.BasicService;
import org.springframework.beans.factory.FactoryBean;

// Diese Klasse implementiert das FactoryBean-Pattern, welches zum erstellen von Services in einer Instanz geeignet ist
public class BasicServiceFactory implements FactoryBean<BasicService> {
    // Die
private int factoryId;
private static int serviceId = 1;

// Über diese Methode kann ein neuer Service erstellt und zurückgegeben werden
@Override
    public BasicService getObject() throws Exception{
    return new BasicService(serviceId++);
}

// Diese Methode gibt den Typ des Services zurück
@Override
    public Class<?> getObjectType(){
    return BasicService.class;
}

// Diese Methode gibt zurück, ob es sich um ein Singleton handelt
@Override
    public boolean isSingleton(){
    return false;
}

// Weitere Accessoren
    public void setFactoryId(int factoryId) {
        this.factoryId = factoryId;
    }
    public int getFactoryId(){
        return factoryId;
    }
    public void setServiceId(int serviceId){
        this.serviceId = serviceId;
    }
    public int getServiceId(){
        return serviceId;
    }
}
