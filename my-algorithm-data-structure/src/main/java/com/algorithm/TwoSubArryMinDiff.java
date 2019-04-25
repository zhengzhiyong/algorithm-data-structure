package com.algorithm;

import org.junit.Test;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class TwoSubArryMinDiff {
    /**
     * 华为面试题（8分钟写出代码） 有两个数组a,b，大小都为n,数组元素的值任意，无序；
     * 要求：通过交换a,b中的元素，使数组a元素的和与数组b元素的和之间的差最小
     * 今天在富通天下面试刚好遇到这个题目(尬尴。没回答出来)
     * 思路：
     *     https://blog.csdn.net/qq_15720911/article/details/77860012
     *
     *     1、分别计算a、b两个数组的元素之和suma和sumb，并求他们的差diff=suma-sumb;
     * 	   2、对单个元素进行操作，a[0]-b[0]=1-5=-4,这里a[0]和b[0]的差值小于a数组和b数组整体的差，交换他们，此时，a={5,2},b={1,3},diff=3;
     * 	       然后继续a[0]-b[1]=5-3=2，2<3=diff,交换a[0]和b[1],此时a={3,2},b={1,5}，差值为diff=-1.到此，一次循环结束。
     * 	   3、按照步骤2的方法,把数组a的元素从头到尾和b数组中所有元素比较，直到最后一个数组元素。
     *
     * 	   4.利用(singleDiff - diff)*singleDiff<0为条件去判断是否数据交换,交换后利用(diff -= 2 * singleDiff)公式做差值。
     */

    //合并两个数组
    public static int[] megerArrays(int[] array1,int[] array2){
        int length1 = array1.length;
        int length2 = array2.length;
        //将数组扩容
        array1 = Arrays.copyOf(array1,length1+length2);
        //将数组array2复制到扩容后的数组array1中，从位置length1开始，往后顺延length2个长度
        System.arraycopy(array2,0,array1,length1,length2);
        //返回扩容后的数组
        return array1;
    }

    public static void minDiff (int[] array1,int[] array2){
        //lambda表达式写法
        //计算出两个数组的差值
        final int[] diff = {Arrays.stream(array1).sum() - Arrays.stream(array2).sum()};
        IntStream.range(0,array1.length).forEach(i -> {
            IntStream.range(0,array1.length).forEach(j -> {
                //计算出两个数组中单个元素的差值
                int singleDiff = array1[i] - array2[j];
                //单个元素的差值和数组的差值比l较
                if ((singleDiff - diff[0])*singleDiff<0) {
                    int temp = array1[i];
                    array1[i] = array2[j];
                    array2[j] = temp;
                    //计算数据交换后两个数组的差值
                    diff[0] -= 2 * singleDiff;
                }
            });
        });

            //常规写法
//        //计算出两个数组的差值
//        int diff = Arrays.stream(array1).sum() - Arrays.stream(array2).sum();
//        for (int i = 0; i < array1.length; i++) {
//            for (int j = 0; j < array1.length; j++) {
//                //计算出两个数组中单个元素的差值
//                int singleDiff = array1[i] - array2[j];
//                //单个元素的差值和数组的差值比l较
//                if ((singleDiff - diff)*singleDiff<0){
//                    int temp = array1[i];
//                    array1[i] = array2[j];
//                    array2[j] = temp;
//                    //计算数据交换后两个数组的差值
//                    diff -= 2 * singleDiff;
//                }
//            }
//        }
        Arrays.sort(array1);
        Arrays.sort(array2);
        int sum1 = Arrays.stream(array1).sum();
        int sum2 = Arrays.stream(array2).sum();
        System.out.println("两个数组总和为："+(sum1+sum2)+",array1总和为："+sum1+",array2总和为："+sum2);
        IntStream.range(0,array1.length).forEach(i ->{
            System.out.println("array1["+i+"]:"+array1[i]+"，array2["+i+"]:"+array2[i]);
        });
    }

    public static void getTwoSubArrayMinDiff(int[] array){
        int[] array1 = Arrays.copyOfRange(array,0,array.length/2);
        int[] array2 = Arrays.copyOfRange(array,array.length/2,array.length);
        minDiff(array1,array2);
    }

    public static void main(String[] args) {
        int[] array1 = new int[]{1,10,20,40};
        int[] array2 = new int[]{80,200,1000,2000};
//        System.out.println("============================");
        minDiff(array2,array1);
//        System.out.println("============================");
//        int[] array = megerArrays(array1,array2);
//        getTwoSubArrayMinDiff(array);
    }
}

