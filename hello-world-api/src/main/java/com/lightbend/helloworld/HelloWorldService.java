package com.lightbend.helloworld;

import akka.NotUsed;
import com.lightbend.lagom.javadsl.api.Descriptor;
import com.lightbend.lagom.javadsl.api.Service;
import com.lightbend.lagom.javadsl.api.ServiceCall;

import static com.lightbend.lagom.javadsl.api.Service.named;
import static com.lightbend.lagom.javadsl.api.Service.namedCall;

/**
 * Descriptor => This interface defines how the service is invoked and implemented,
 * and the metadata that describes how the interface is mapped down onto an underlying transport protocol.
 * <p>
 * Its implementation and consumption
 * should remain agnostic to what transport is being used,
 * whether that’s REST, websockets, or some other transport.
 * <p>
 * AutoAcl(true) will register the service with the service locator
 * to allow interaction with other services.
 *
 * @return
 */

public interface HelloWorldService extends Service {

    ServiceCall<NotUsed, String> helloWorld(); //Not used because its gonna be GET

    @Override
    default Descriptor descriptor() {
        return named("hello-world-service").withCalls(
                namedCall("hello-world", this::helloWorld)
        ).withAutoAcl(true);
    }


}
