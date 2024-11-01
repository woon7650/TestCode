package com.example.testcode.ArrayList;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;

public class ArrayWithList {

    public static void main(String[] args){

        //Array
        String[] array = {"1", "2", "3", "4", "5", "6", "7", "8"};

        Time arrayTime =new Time();
        Time listTime =new Time();

        arrayTime.setStartTime();
        String arrayData = array[7];
        arrayTime.setEndTime();

        //List
        List<String> list = Arrays.asList(array);

        listTime.setStartTime();
        String listData = list.get(7);
        listTime.setEndTime();

        arrayTime.printNanoSec();
        listTime.printNanoSec();
    }
}
