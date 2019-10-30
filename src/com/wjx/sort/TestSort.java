package com.wjx.sort;


import java.util.Arrays;

/**
 * @Auther:wjx
 * @Date:2019/4/27
 * @Description:com.wjx.sort
 * @version:1.0
 */
public class TestSort {
    public static void main(String[] args) {
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 100);
        }
        System.out.println(Arrays.toString(arr));
        test(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void test(int[] arr) {
        int temp;
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                temp = arr[minIndex];
                arr[minIndex] = arr[i];
                arr[i] = temp;
            }

        }
    }


}
