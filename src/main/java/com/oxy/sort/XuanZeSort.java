package com.oxy.sort;

import java.util.Arrays;

/**
 * @author oxy
 * 选择排序
 */
public class XuanZeSort {
    public static void main(String[] args) {
        int[] sourceArray = {1,7, 3, 5, 4, 8, 6, 9, 10};
        int[] arr = sort(sourceArray);
        for (int num : arr) {
            System.out.print(num + " ");
        }

    }

    public static int[] sort(int[] sourceArray) {
        // 赋值数组，避免改变源数组
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

        for (int i = 0; i < arr.length; i++) {
            int index = i;
            for (int j = i +1 ; j < arr.length; j++) {
                if (arr[index] > arr[j]) {
                    index = j;
                }
            }
            if(index != i){
                int temp = arr[i];
                arr[i] = arr[index];
                arr[index] = temp;
            }
        }
        return arr;
    }
}
