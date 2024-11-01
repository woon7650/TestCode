package com.example.testcode.ArrayList;
import java.util.concurrent.TimeUnit;

public class Time {
    long startTime = 0;
    long endTime = 0;

    public Time() {
    }

    public void setStartTime() {
        if (endTime != 0)
            throw new RuntimeException("already endTime initialized");

        startTime = System.nanoTime();
    }

    public void setEndTime() {
        if (startTime == 0)
            throw new RuntimeException("startTime not initialized yet");

        endTime = System.nanoTime();
    }

    public void printNanoSec() {
        if (startTime == 0 || endTime == 0)
            throw new RuntimeException("time not initialized");

        long nanoSec = endTime - startTime;

        System.out.println(nanoSec + "ns");
        initializeTime();
    }

    public void printMilliSec() {
        if (startTime == 0 || endTime == 0)
            throw new RuntimeException("time already not initialized");

        long nanoSec = endTime - startTime;
        long milliSec = TimeUnit.MILLISECONDS.convert(nanoSec, TimeUnit.NANOSECONDS);

        System.out.println(milliSec + "ms");
        initializeTime();
    }

    private void initializeTime(){
        startTime=0;
        endTime=0;
    }
}