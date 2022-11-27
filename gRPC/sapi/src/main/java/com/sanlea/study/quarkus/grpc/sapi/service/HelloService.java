package com.sanlea.study.quarkus.grpc.sapi.service;

import com.sanlea.study.quarkus.grpc.spec.Greeter;
import com.sanlea.study.quarkus.grpc.spec.HelloReply;
import com.sanlea.study.quarkus.grpc.spec.HelloRequest;
import io.quarkus.grpc.GrpcService;
import io.smallrye.mutiny.Uni;

@GrpcService
public class HelloService implements Greeter {
    @Override
    public Uni<HelloReply> sayHello(HelloRequest request) {
        return Uni.createFrom().item(() ->
            HelloReply.newBuilder()
                    .setMessage("Show me the money - " + request.getName())
                    .build()
        );
    }
}
