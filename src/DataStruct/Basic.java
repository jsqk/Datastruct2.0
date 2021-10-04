package DataStruct;

import java.util.Arrays;

/**
 * Author: hanzy
 * Date: 2021/9/23, 21:31
 * introduce:
 */
public class Basic {

    /**
     * 根据传入的数据，返回一个随机数数组
     * @param n 数组长度
     * @param start 数组内数据的起始值
     * @param end 数组内数据的结束范围， 比如n=5, start=1, end=10，则返回数据大小在（1，10）范围内的一个长度为5的数组
     * @return
     *      int[]
     */
    public static int[] getRandomArray(int n, int start, int end){
        int[] array = new int[n];
        int real_end = end - start;
        java.util.Random random = new java.util.Random();
        for(int i = 0; i < array.length; i++){
            array[i] = random.nextInt(real_end) + start;
        }
        return array;
    }

    /**
     * 交换数组中m、n位置的元素
     * @param arr
     * @param m
     * @param n
     */
    public static void swap(int[] arr, int m, int n){
        int t = arr[m];
        arr[m] = arr[n];
        arr[n] = t;
    }

    /**
     * 判断一个数组是否有序
     * @param arr
     * @return
     */
    public static boolean isOrder(int[] arr){
        for(int i = 1; i < arr.length; i++){
            if(arr[i] < arr[i-1]){
                return false;
            }
        }
        return true;
    }

    /**
     * 输出一个数组
     * @param arr
     */
    public static void show(int[] arr){
        System.out.println(Arrays.toString(arr));
    }

}
