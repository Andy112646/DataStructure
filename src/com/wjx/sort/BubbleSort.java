package com.wjx.sort;

import java.util.Arrays;

/**
 * @Auther:wjx
 * @Date:2019/4/27
 * @Description:com.wjx.sort 冒泡排序
 * @version:1.0
 */
public class BubbleSort {
    private static void bubbleSort(int[] arr) {
        int temp; // 交换变量
        for (int i = 0; i < arr.length - 1; i++) {
            boolean flag = true; // 默认数组有序
            for (int j = 0; j < arr.length - 1-i; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = false;
                }
            }
            // 一趟比较完，没有发生交换，说明剩下的元素都是有序的
            if (flag) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        // 生成一个随机数组
        int[] arr = new int[10];
        for (int i = 0; i < arr.length - 1; i++) {
            arr[i] = (int) (Math.random() * 100);
        }
        // 输出该随机数组
        System.out.println(Arrays.toString(arr));

        // 快速排序
        bubbleSort(arr);

        // 输出快排后的数组
        System.out.println(Arrays.toString(arr));
    }
}
