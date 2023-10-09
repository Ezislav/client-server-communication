package com.example.gRPCserver;

import com.example.grpc.HelloRequest;
import com.example.grpc.HelloResponse;
import com.example.grpc.HelloWorldServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class HelloWorldServiceImpl extends HelloWorldServiceGrpc.HelloWorldServiceImplBase {

    @Override
    public void sayHello(HelloRequest request, StreamObserver<HelloResponse> responseObserver) {
        HelloResponse helloResponse = HelloResponse.newBuilder()
                .setMessage("Hello, " + request.getName())
                .build();
        responseObserver.onNext(helloResponse);
        responseObserver.onCompleted();
    }
}
