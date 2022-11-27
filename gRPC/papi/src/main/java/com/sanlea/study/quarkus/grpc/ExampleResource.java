package com.sanlea.study.quarkus.grpc;

import com.sanlea.study.quarkus.grpc.spec.Greeter;
import com.sanlea.study.quarkus.grpc.spec.HelloReply;
import com.sanlea.study.quarkus.grpc.spec.HelloRequest;
import io.quarkus.grpc.GrpcClient;
import io.smallrye.mutiny.Uni;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class ExampleResource {

    @GrpcClient("hello")
    Greeter greeter;


    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Uni<String> hello() {
        var request = HelloRequest.newBuilder().setName("Kut Zhang").build();
        return greeter.sayHello(request).onItem().transform(HelloReply::getMessage);
    }
}