package com.example.testcode.Algorithm.Sort;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Sort {

    public static void main(String[] args) {


        int[] arr = {1 ,35, 321, 53, 64, 643, 32};

        arraySort(arr);
        collectionSort(arr);
        comparatorSort(arr);


    }

    private static void arraySort(int[] arr){
        Arrays.sort(arr);
        System.out.println("array sort : " + Arrays.toString(arr));
    }

    private static void collectionSort(int[] arr){

        List<Integer> list = intArrToList(arr);
        Collections.sort(list);
        System.out.println("Collection Sort : " + list);
        Collections.sort(list, Collections.reverseOrder());
        System.out.println("Collection Reverse Sort : " +list);
    }

    private static void comparatorSort(int[] arr){

        List<Integer> list = intArrToList(arr);

        Comparator<Integer> listComp = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        };

        Collections.sort(list, listComp);
        System.out.println("Collection Comparator Sort : " + list);

    }


    //Array<->List
    private static List<Integer> intArrToList(int[] arr){
        List<Integer> list = Arrays
                .stream(arr)
                .boxed()
                .collect(Collectors.toList());
        return list;
    }

    private static List<String> stringArrToList(String[] arr){
        List<String> list = Stream
                .of(arr)
                .collect(Collectors.toList());
        return list;
    }

    private static int[] intListToArray(List<Integer> list){
        int[] arr = list
                .stream()
                .mapToInt(x->x)
                .toArray();
        return arr;
    }

    private static String[] stringListToArray(List<String> list){
        String[] arr = list
                .stream()
                .toArray(String[]::new);
        return arr;
    }

}