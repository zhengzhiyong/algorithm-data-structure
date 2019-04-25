package com.algorithm;

import org.junit.Test;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 本文说是《编程之美》2.18新思路，其实也是July的《微软等公司面试100题》上的32题的解法。
 * 两个序列大小均为n，序列元素的值为任一整数，无序；
 * 要求通过交换两个序列的元素，使序列a元素之和与序列b的元素之和的差最小（可能存在很多种组合，要求找出其中一种即可）。
 *
 * 《编程之美》2.18解法二中提到，从2n个数中找n个元素，有三种可能：大于Sum/2，小于Sum/2以及等于Sum/2。而大于Sum/2与小于等于Sum/2没区别，
 * 故可以只考虑小于等于Sum/2的情况，这一点我们仍然沿用这个思想。
 */
public class TwoSubArryMinDiff {

    public static void main(String[] args) {
        //int[] array = new int[]{1,2,3,4,5,6,7,8,9,10};
        //int[] array = new int[]{1,10,30,50};
        //getTwoSubArrayMinDiff(array);
    }

    /**
     * 两个序列大小均为n，序列元素的值为任一整数，无序；
     * 要求通过交换两个序列的元素，使序列a元素之和与序列b的元素之和的差最小。
     *
     * 思路：
     *     1、对数组排序。定义好两个数组a，数组b
     *     2、根据两个数组的总和和数组的长度，去判断往哪个数组中添加元素。
     *
     *     https://blog.csdn.net/qq_15720911/article/details/77860012
     */

    @Test
    public void getTwoSubArrayMinDiff(){
        int[] array = new int[]{1,2,4,8,20,100};
        int[] array1 = new int[0];
        int[] array2 = new int[0];
        int c = 0;
        int b = 0;
        Arrays.sort(array);

        for(int i = 0;i<array.length ; i++){
            if(b >= c || array2.length < array1.length){
                c = c+array[array.length -1-i];
                array2 = Arrays.copyOf(array2,array2.length+1);
                array2[array2.length-1] = array[array.length -1-i];
            }else {
                b = b+array[array.length -1-i];
                array1 = Arrays.copyOf(array1,array1.length+1);
                array1[array1.length-1] = array[array.length -1-i];
            }
        }

        System.out.println(Arrays.stream(array1).sum());
        System.out.println(Arrays.stream(array2).sum());
        System.out.println(Arrays.stream(array).sum());

        for (int i : array1){
            System.out.print("BB["+i+"]="+i+",");
        }
    }

    @Test
    public void test2(){
       // int[] array = new int[]{1,10,30,50};
        int[] array1 = new int[]{1,10};
        int[] array2 = new int[]{30,50};

        int diff = Arrays.stream(array1).sum() - Arrays.stream(array2).sum();
        IntStream.range(0,array1.length).forEach(i -> System.out.println());



    }
}
