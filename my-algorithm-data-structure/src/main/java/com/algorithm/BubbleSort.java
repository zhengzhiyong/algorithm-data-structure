package com.algorithm;

import org.junit.Test;

import java.util.stream.IntStream;

/**
 * 冒泡排序
 * // 从左到右使用相邻两个元素进行比较，如果第一个比第二个大，则交换两个元素。这样会使较大数下沉到数组的尾端，即较小数像泡泡一样冒到数组首端。
 *
 * 时间、空间复杂度及稳定性分析：
 * 时间复杂度：由于内外循环都发生N次迭代，所以时间复杂度为O(n^2)。并且这个界是精确的。思考最坏的情况，输入一个逆序的数组，则比较次数为：
 * (N-1)+(N-2)+(N-3)+..+2+1 = n*(n-1)/2 = O(n^2)
 * 空间复杂度：只使用了一个临时变量，所以为O(1)；
 *
 * 是否稳定：稳定排序
 *
 * 三、总结
 * 冒泡排序可以通过增加boolean标识是否已经排好序来进行优化；还可以记录下最后一次交换元素的位置来进行优化，防止无意义的比较。冒泡排序是稳定排序，时间复杂度为O(n^2)，空间复杂度为O(1)。
 * */
public class BubbleSort {

    @Test
    public void test1(){
        int [] array = {3,5,2,9,8,6,7,4,1};
        int temp = 0;
        int length = array.length;
        for (int i = 0;i<length-1;i++){
            for (int j = 0;j<length - 1 -i ;j++){
                if(array[j]>array[j+1]){
                    temp = array[j];
                    array[j]=array[j+1];
                    array[j+1]=temp;
                }
            }
        }
        IntStream.range(0,length).forEach(i -> System.out.println(array[i]));
    }

    @Test
    public void test2(){
        // 优化版本
        int [] array = {3,5,2,9,8,6,7,4,1};
        //int 默认0
        int temp;
        int length = array.length;
        //boolean默认false
        boolean isOrdered;
        for (int i = 0;i<length-1;i++){
            isOrdered = true;
            for (int j = 0;j<length - 1 -i ;j++){
                if(array[j]>array[j+1]){
                    isOrdered = false;
                    temp = array[j];
                    array[j]=array[j+1];
                    array[j+1]=temp;
                }
            }
            if (isOrdered){
                break;
            }
        }
        IntStream.range(0,array.length).forEach(i -> System.out.println(array[i]));
    }
    @Test
    public void test3(){
        //加强版
        int [] array = {3,5,2,9,8,6,7,4,1};
        //int 默认0
        int temp ;
        int length = array.length;
        int lastExchangeIndex = 0;
        //当前趟无序的边界
        int unorderedBorder = length - 1;
        //boolean默认false
        boolean isOrdered ;
        for (int i = 0;i<length-1;i++){
            isOrdered = true;
            for (int j = 0;j< unorderedBorder ;j++){
                if(array[j]>array[j+1]){
                    temp = array[j];
                    array[j]=array[j+1];
                    array[j+1]=temp;
                    isOrdered = false;
                    lastExchangeIndex = j;
                }
            }
            unorderedBorder = lastExchangeIndex;
            if (isOrdered){
                break;
            }
        }
        IntStream.range(0,array.length).forEach(i -> System.out.println(array[i]));
    }
}