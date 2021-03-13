package com.nutrymaco.alg;

import info.debatty.java.stringsimilarity.Levenshtein;
import io.grpc.stub.StreamObserver;

public class DebattyAlgorithmService extends DebattyAlgorithmServiceGrpc.DebattyAlgorithmServiceImplBase {

    private final Levenshtein levenshtein = new Levenshtein();

    @Override
    public void getResult(AlgorithmRequest request, StreamObserver<AlgorithmResponse> responseObserver) {
        System.out.println("deb " + request);
        responseObserver.onNext(
                AlgorithmResponse.newBuilder()
                        .setResult(
                                (int)levenshtein.distance(
                                        request.getString1(),
                                        request.getString2()
                                )
                        )
                        .build()
        );
        responseObserver.onCompleted();
    }
}
