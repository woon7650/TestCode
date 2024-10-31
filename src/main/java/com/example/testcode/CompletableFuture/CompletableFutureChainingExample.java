package com.example.testcode.CompletableFuture;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Slf4j
public class CompletableFutureChainingExample {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        CompletableFuture<Void> future = CompletableFuture
                .supplyAsync(() -> {
                    log.info("supplyAsync with Thread : "+ Thread.currentThread().getName());
                    return "first return data";
                })
                .thenApply(s -> {
                    log.info("thenApply with Thread : "+ Thread.currentThread().getName());
                    return s.toUpperCase();
                })
                .thenAccept(a -> {
                    log.info("thenAccept with Thread : "+ Thread.currentThread().getName());
                    log.info(a);
                });
        log.info("Main Thread : "+Thread.currentThread().getName());
    }
}
