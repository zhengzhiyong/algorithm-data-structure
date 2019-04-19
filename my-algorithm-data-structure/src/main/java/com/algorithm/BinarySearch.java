package com.algorithm;

import org.junit.Test;

/**
 * 折半查找(二分查找)
 * 算法思想：又叫折半查找，要求待查找的序列有序。每次取中间位置的值与待查关键字比较，如果中间位置的值比待查关键字大，
 * 则在前半部分循环这个查找的过程，如果中间位置的值比待查关键字小，则在后半部分循环这个查找的过程。直到查找到了为止，
 * 否则序列中没有待查的关键字。
 */
public class BinarySearch {
    public int [] array = {1,3,5,7,8,10,12,15,17,25,35,45};

    /**
     * 非递归代码 方式
     * @param array 待检索的数组
     * @param key 待查找的元素
     * @return 待查找元素在数组中的索引位置，未找到返回-1
     */
    public int search(int[] array,int key){
        int min = 0;
        int max = array.length - 1;
        int mid = 0;
        while (min<=max){
            //计算出中间索引位置
            mid = (min+max)/2;
            //被查找的元素和中间索引进行比较，如果被查找的元素比中间索引大，则最小索引指向(中间索引+1)的位置；
            //如果被查找的元素比中间索引小，则最大索引指向(中间索引-1)的位置；
            //如果被查找的元素等于中间索引，说明找到了该元素，返回对应索引位置；
            if (key> array[mid]){
                min = mid + 1;
            }else if(key< array[mid]){
                max = mid - 1;
            }else {
                return mid;
            }
        }
        return  -1;
    }


    /**
     *  递归方式
     * @param array 待检索的数组
     * @param key 待查找的元素
     * @param min 要查找区间对应索引的最小值
     * @param max 要查找的区间对应索引的最大值
     * @return 待查找元素在数组中的索引位置，未找到返回-1
     */
    public int search2(int[] array,int key,int min,int max){
        if (min>max){
            return -1;
        }
        int mid = (max + min)/2;
        if (key == array[mid]){
            return mid;
        }else if (key > array[mid]){
            return search2(array,key,mid+=1,max);
        }else {
            return search2(array,key,min,mid-=1);
        }
    }

    /**
     *
     * @param array 待检索的数组
     * @param key 待查找的元素
     * @return 待查找元素在数组中的索引位置，未找到返回-1
     */
    public int search3(int[] array,int key){
        int min = 0;
        int max = array.length-1;
        int mid = (max + min)/2;
        while (true){
            if (key > array[mid]){
                min = mid + 1;
            }else if (key < array[mid]){
                max = mid -1 ;
            }else {
                return mid;
            }
            mid = (max+min)/2;
            if (min>max){
                return -1;
            }
        }
    }

    @Test
    public void test1(){
       int index = search(array,15);
       System.out.println(index);


       int index2 = search2(array,15,0,array.length);
       System.out.println(index2);


       int index3 = search3(array,15);
       System.out.println(index3);
    }
}
