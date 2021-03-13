package com.nutrymaco.alg;

import io.grpc.netty.NettyServerBuilder;

import java.io.IOException;

public class AlgorithmServer {
    public static void main(String[] args) throws IOException, InterruptedException {
        final var server = NettyServerBuilder
                .forPort(8080)
                .addService(new ApacheAlgorithmService())
                .addService(new DebattyAlgorithmService())
                .build();
        server.start();
        server.awaitTermination();
    }
}
