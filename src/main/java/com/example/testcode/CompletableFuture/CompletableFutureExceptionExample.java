package com.example.testcode.CompletableFuture;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Slf4j
public class CompletableFutureExceptionExample {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        CompletableFuture<String> future = CompletableFuture
                .supplyAsync(() -> {
                    throw new RuntimeException("RuntimeException Error");
                });

        CompletableFuture<String> exceptionallyFuture = future
                .exceptionally(e -> {
                    return e.getMessage();
                });

        CompletableFuture<String> handleFuture = future
                .handle((result, e) -> {
                    return e == null ? result : e.getMessage();
                });

        log.info(exceptionallyFuture.get());
        log.info(handleFuture.get());
    }
}
