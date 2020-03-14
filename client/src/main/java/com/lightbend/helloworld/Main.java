package com.lightbend.helloworld;

import com.lightbend.lagom.javadsl.client.integration.LagomClientFactory;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) throws URISyntaxException, ExecutionException, InterruptedException {
        try{
            LagomClientFactory clientFactory = LagomClientFactory.create(
                    "client", LagomClientFactory.class.getClassLoader());

            HelloWorldService service = clientFactory.createClient(HelloWorldService.class, new URI("http://localhost:9000"));
            //helloWorldService#helloWorld() returns a service call, which needs to be invoke()d
            String result = service.helloWorld().invoke().toCompletableFuture().get();
            System.out.println(result);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
