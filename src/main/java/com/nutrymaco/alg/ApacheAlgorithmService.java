package com.nutrymaco.alg;

import io.grpc.stub.StreamObserver;
import org.apache.commons.text.similarity.LevenshteinDistance;

public class ApacheAlgorithmService extends ApacheAlgorithmServiceGrpc.ApacheAlgorithmServiceImplBase {

    private final LevenshteinDistance levenshteinDistance = new LevenshteinDistance();

    @Override
    public void getResult(AlgorithmRequest request, StreamObserver<AlgorithmResponse> responseObserver) {
        System.out.println("apache " + request);
        responseObserver.onNext(
                AlgorithmResponse.newBuilder()
                        .setResult(
                                levenshteinDistance.apply(
                                        request.getString1(),
                                        request.getString2()
                                )
                        )
                        .build()
        );
        responseObserver.onCompleted();
    }
}
