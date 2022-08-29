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
        if(left >= right){
           return arr;
        }
        int i ,j ,temp;
        i = left;
        j = right;
        temp = arr[left];
        while (i < j){
            while (arr[j] >= temp && i < j){
                j--;
            }
            while (arr[i] <= temp && i < j){
                i++;
            }
            if(i < j){
                int t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
            }
        }
        arr[left] = arr[i];
        arr[i] = temp;

        quickSort(arr,left,i-1);
        quickSort(arr,j+1,right);
        return arr;
    }


}
