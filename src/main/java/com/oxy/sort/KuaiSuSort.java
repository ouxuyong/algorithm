package com.oxy.sort;

import java.util.Arrays;

/**
 * 快速排序
 * @author oxy
 */
public class KuaiSuSort {
    public static void main(String[] args) {
        int[] sourceArray = {105,10,1, 3, 8,5, 4, 8, 6, 9, 10};
        int[] arr = sort(sourceArray);
        for (int num : arr) {
            System.out.print(num + " ");
        }

    }

    public static int[] sort(int[] sourceArray) {
        // 赋值数组，避免改变源数组
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

        return quickSort(arr,0,arr.length-1);
    }

    private static int[] quickSort(int[] arr, int left, int right) {
        if(left < right){
            int index = partition(arr,left,right);
            quickSort(arr,left,index-1);
            quickSort(arr,index+1,right);
        }
        return arr;
    }

    private static int partition(int[] arr, int left, int right) {
        int temp = arr[left];
        int mark = left;
        for(int i = mark; i <= right; i++){
            if(arr[i] < temp){
                if(i != mark){
                    int tempMark = arr[mark];
                    arr[mark] = arr[i];
                    arr[i] = tempMark;
                }
                mark = i;
            }
        }

        return mark;
    }

}
