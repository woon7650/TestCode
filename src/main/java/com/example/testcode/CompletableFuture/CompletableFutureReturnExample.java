package com.example.testcode.CompletableFuture;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Slf4j
public class CompletableFutureReturnExample {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        CompletableFuture<Void> runAsyncFuture = CompletableFuture.runAsync(() -> {
            log.info("runAsync with Thread : " + Thread.currentThread().getName());
        });
        log.info("Thread : " + Thread.currentThread().getName());

        CompletableFuture<String> supplyAsyncFuture = CompletableFuture.supplyAsync(() -> {
            return "Task Complete";
        });
        log.info("Before SupplyAsyncFuture Result");
        log.info(supplyAsyncFuture.get());
        log.info("After SupplyAsyncFuture Result");
    }
}
