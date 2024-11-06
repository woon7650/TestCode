package com.example.testcode.Algorithm.RangeSearch;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class TwoPointerSlidingWindow {

    public static void main(String[] args) {


        int[] arr = {1 ,11, 5, 2, 7, 9, 23, 15, 27, 32};
        int target = 30;
        int windowSize = 3;

        Arrays.sort(arr);

        System.out.println("TwoPoint 개수 : " + TwoPointerSum(arr, target));
        System.out.println("SlidingWindow 최대값 : " + SlidingWindowMaxWithTwoPoint(arr, windowSize));



    }

    public static int TwoPointerSum(int[] arr, int target){
        int cnt = 0;
        int left = 0;
        int right = arr.length - 1;

        while(left < right){
            int sum = arr[left] + arr[right];

            if(sum == target){
                cnt++;
                left++;
                right--;
            }else if(sum < target){
                left++;
            }else{
                right--;
            }
        }
        return cnt;
    }



    private static int SlidingWindowMaxWithTwoPoint(int[] arr, int k){
        int initialSum = 0;
        int maxSum = 0;

        for(int i=0; i<k; i++){
            initialSum += arr[i];
        }

        for(int i = k; i< arr.length; i++){
            initialSum = initialSum - arr[i-k] + arr[i];
            maxSum = Math.max(maxSum, initialSum);
        }
        return maxSum;
    }



}