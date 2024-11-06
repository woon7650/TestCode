package com.example.testcode.Algorithm.RangeSearch;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class BinarySearch {

    public static void main(String[] args) {


        int[] arr = {1 ,35, 321, 53, 64, 643, 32};

        System.out.println("for문 : " + BinarySearch(arr, 321));
        System.out.println("Recursive : " + BinarySearchRecursive(arr, 32, 0, arr.length-1));

        Arrays.sort(arr);

        System.out.println("for문 : " + BinarySearch(arr, 321));
        System.out.println("Recursive : " + BinarySearchRecursive(arr, 32, 0, arr.length-1));
    }

    public static boolean BinarySearch(int[] arr, int n){
        int left = 0;
        int right = arr.length - 1;
        int mid;

        while(left <= right){
            mid = (left + right) / 2;
            if(arr[mid] < n) left = mid + 1;
            else if(arr[mid] > n) right = mid -1;
            else return true;
        }
        return false;
    }

    public static boolean BinarySearchRecursive(int[] arr, int n, int left, int right){
        if(left > right) return false;
        int mid = (left + right) / 2;

        if(arr[mid] < n) return BinarySearchRecursive(arr, n, mid+1, right);
        else if(arr[mid] > n) return BinarySearchRecursive(arr, n, left,mid-1);
        else return true;
    }
}