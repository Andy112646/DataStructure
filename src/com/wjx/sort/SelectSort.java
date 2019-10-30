package com.wjx.sort;

import java.util.Arrays;

/**
 * @Auther:wjx
 * @Date:2019/4/27
 * @Description:com.wjx.sort 简单选择排序
 * @version:1.0
 */
public class SelectSort {
    /**
     * 简单选择排序
     *
     * @param arr
     */
    private static void selectSort(int[] arr) {
        int temp = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i; // 默认当前下标的元素是最小值
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j; // 更新最小值下标
                }
            }
            if (i != minIndex) {
                temp = arr[minIndex];
                arr[minIndex] = arr[i];
                arr[i] = temp;
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
        selectSort(arr);

        // 输出快排后的数组
        System.out.println(Arrays.toString(arr));
    }
}
