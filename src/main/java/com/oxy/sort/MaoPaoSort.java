package com.oxy.sort;

import java.util.Arrays;

/**
 * @author oxy
 * 冒泡排序
 */
public class MaoPaoSort {
    public static void main(String[] args) {
        int[] sourceArray = {1, 3, 5, 4, 8, 6, 9, 10};
        int[] arr = sort(sourceArray);
        for (int num : arr) {
            System.out.print(num + " ");
        }

    }

    public static int[] sort(int[] sourceArray) {
        // 赋值数组，避免改变源数组
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

        for (int i = 0; i < arr.length; i++) {
            //mark 用于标志数组位置是否发生替换，如果不发生替换说明此时数组已是有序可以直接退出
            boolean mark = true;
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    mark = false;
                }
            }
            if (mark) {
                return arr;
            }
        }
        return arr;
    }
}
