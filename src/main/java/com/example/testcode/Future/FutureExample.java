package com.example.testcode.Future;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Slf4j
public class FutureExample {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        ExecutorService executor = Executors.newFixedThreadPool(1);

        Future<String> future = executor.submit(
                ()-> {
                    Thread.sleep(5000);
                    return "task complete";
                }
        );
        log.info("wait until Future gets complete result");

        log.info(future.get());
        executor.shutdown();
    }
}
