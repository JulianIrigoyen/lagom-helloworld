package com.lightbend.helloworld;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static com.lightbend.lagom.javadsl.testkit.ServiceTest.*;

public class HelloWorldServiceImplTest {

    @Test
    public void helloWorld_shouldReturnTheExpectedResult() throws Exception {
        withServer(defaultSetup(), server -> {
            //service.client will generate a client and try to talk to a live running app
            HelloWorldService service = server.client(HelloWorldService.class);

            String result = service.
                    helloWorld()
                    .invoke()
                    .toCompletableFuture()
                    .get(5, TimeUnit.SECONDS);

            assertEquals("Hello World", result);
        });

    }
}