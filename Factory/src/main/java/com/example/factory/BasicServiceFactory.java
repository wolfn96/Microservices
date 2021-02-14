package com.example.factory;

import org.springframework.beans.factory.FactoryBean;

public class BasicServiceFactory implements FactoryBean<BasicService> {
private int factoryId;
private static int serviceId = 1;


@Override
    public BasicService getObject() throws Exception{
    return new BasicService(serviceId++);
}
@Override
    public Class<?> getObjectType(){
    return BasicService.class;
}

@Override
    public boolean isSingleton(){
    return false;
}

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
