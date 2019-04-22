package com.algorithm;

import org.junit.Test;

/**
 * 排序算法总结
 */
public class SortWays {

    public int [] array = {3,5,2,9,8,6,7,4,1};

    /**
     * 冒泡排序法
     * @param array
     * @return
     */
    public int[] bubleSort(int[] array) {
        if (array.length==0){
            return array;
        }
        for (int i = 0; i < array.length-1; i++) {
            for (int j = 0; j < array.length-1-i; j++) {
                if (array[j] > array[j+1]){
//                    int temp = array[j];
//                    array[j] = array[j+1];
//                    array[j+1] = temp;
                    int temp = array[j+1];
                    array[j+1] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }




    /**
     *  选择排序法
     * @param array
     * @return
     */
    public int [] selectionSort(int [] array){
        if (array.length == 0){
            return array;
        }
        for (int i = 0; i < array.length; i++) {
            int min = i;
            for (int j = i; j < array.length; j++) {
                if (array[j] < array[min]){
                    min = j;
                }
            }
            int temp = array[min];
            array[min] = array[i];
            array[i] = temp;
        }
       return array;
    }

    @Test
    public void test1(){
        //int[] arrays = bubleSort(array);
        int[] arrays = selectionSort(array);
        for (int i = 0; i < arrays.length; i++) {
            System.out.println(arrays[i]);
        }
    }

}
