package com.example.testcode.CompletableFuture;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Slf4j
public class CompletableFutureCombinationExample {

    public static void main(String[] args) throws InterruptedException, ExecutionException {


        CompletableFuture<String> future = CompletableFuture
                .supplyAsync(() -> {
                    return "CompletableFutureExample with ";
                });
        CompletableFuture<String> customFuture = CompletableFuture
                .supplyAsync(() -> {
                    return "thenCombine";
                });

        CompletableFuture<String> finalFuture1 = future.thenCompose(s -> CompletableFuture.completedFuture(s + customMethod()));
        CompletableFuture<String> finalFuture2 = future.thenCombine(customFuture, (f1, f2) -> f1 + f2);

        log.info(finalFuture1.get());
        log.info(finalFuture2.get());
    }

    private static CompletableFuture<String> customMethod(){
        return CompletableFuture.supplyAsync(()->{
            return "thenCompose";
        });
    }
}
