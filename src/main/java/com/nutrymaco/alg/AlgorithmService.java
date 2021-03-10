package com.nutrymaco.alg;

import io.grpc.stub.StreamObserver;

public class AlgorithmService extends AlgorithmServiceGrpc.AlgorithmServiceImplBase {
    @Override
    public void getResult(AlgorithmRequest request, StreamObserver<AlgorithmResponse> responseObserver) {
        responseObserver.onNext(
                AlgorithmResponse.newBuilder()
                        .setResult(100)
                        .build()
        );
        responseObserver.onCompleted();
    }
}
