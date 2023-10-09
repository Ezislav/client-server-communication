package com.example.gRPCclient;

import com.example.grpc.HelloRequest;
import com.example.grpc.HelloResponse;
import com.example.grpc.HelloWorldServiceGrpc;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

@Service
public class HelloWorldClient {

    @GrpcClient("local-grpc-server")
    private HelloWorldServiceGrpc.HelloWorldServiceBlockingStub helloWorldServiceBlockingStub;

    public String sayHello(String name) {
        HelloRequest request = HelloRequest.newBuilder().setName(name).build();
        HelloResponse response = helloWorldServiceBlockingStub.sayHello(request);
        return response.getMessage();
    }
}
