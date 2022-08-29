package com.oxy.sort;

import java.util.Arrays;

/**
 * @author oxy
 * 插入排序
 */
public class ChaRuSort {
    public static void main(String[] args) {
        int[] sourceArray = {105,10,1, 3, 5, 4, 8, 6, 9, 10};
        int[] arr = sort(sourceArray);
        for (int num : arr) {
            System.out.print(num + " ");
        }

    }

    public static int[] sort(int[] sourceArray) {
        // 赋值数组，避免改变源数组
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

        for (int i = 1; i < arr.length; i++) {
            int index = i;
            int temp = arr[i];
            while (index >0 && temp < arr[index-1]){
                arr[index] = arr[index-1];
                index--;
            }
            if(index != i){
                arr[index] = temp;
            }
        }
        return arr;
    }

}
