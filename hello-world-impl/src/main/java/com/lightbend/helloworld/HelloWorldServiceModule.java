package com.lightbend.helloworld;

import com.google.inject.AbstractModule;
import com.lightbend.lagom.javadsl.server.ServiceGuiceSupport;

public class HelloWorldServiceModule extends AbstractModule implements ServiceGuiceSupport {

    //bind instance of implementation to any request to the service
    @Override
    protected void configure(){
        bindService(HelloWorldService.class, HelloWorldServiceImpl.class);
    }
}
