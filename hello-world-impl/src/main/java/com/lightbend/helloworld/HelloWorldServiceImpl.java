package com.lightbend.helloworld;

import akka.NotUsed;
import com.lightbend.lagom.javadsl.api.Descriptor;
import com.lightbend.lagom.javadsl.api.ServiceCall;

import static java.util.concurrent.CompletableFuture.completedFuture;

public class HelloWorldServiceImpl implements  HelloWorldService {
    @Override
    public ServiceCall<NotUsed, String> helloWorld() { //ServiceCall<Request,Response>
        return notUsed -> completedFuture("Hello World");
    }

    @Override
    public Descriptor descriptor() {
        return null;
    }
}
