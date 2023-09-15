package com.example.grpc.service;

import com.example.grpc.GrpcServiceGrpc;
import com.example.grpc.GrpcServiceOuterClass;
import io.grpc.stub.StreamObserver;

public class GrpcServiceImpl extends GrpcServiceGrpc.GrpcServiceImplBase {
    @Override
    public void testeGrpc(GrpcServiceOuterClass.HelloRequest request, StreamObserver<GrpcServiceOuterClass.HelloResponse> responseObserver) {
        System.out.println(request);

        GrpcServiceOuterClass.HelloResponse response = GrpcServiceOuterClass.HelloResponse.newBuilder()
                .setResponse("Hello " + request.getName() + " " + request.getLastName())
                .build();

        // Use responseObserver to send a single response back
        responseObserver.onNext(response);

        // When you are done, you must call onCompleted.
        responseObserver.onCompleted();
    }
}
