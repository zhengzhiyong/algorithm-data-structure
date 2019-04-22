package com.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.IntStream;

/**
 * 排序算法集合(十大经典排序集合)
 */
public class NumberSortAll {

    /**
     * 冒泡排序法
     * @param array
     * @return
     */
    public static int [] bubbleSort(int[] array){
        if (array.length==0){
            return array;
        }
        int length = array.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length - 1 - i; j++) {
                if (array[j]>array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
        return array;
    }

    /**
     * 选择排序法
     * @param array
     * @return
     */
    public static int[] selectionSort(int[] array){
        int length = array.length;
        if (length < 2){
            return array;
        }

        for (int i = 0; i < length; i++) {
            int min = i;
            for (int j = i; j < length; j++) {
                //找到最小数的索引
                if (array[j]<array[min]){
                    //记录最小数的索引
                    min = j;
                }
            }
            int temp = array[min];
            array[min] = array[i];
            array[i] = temp;
        }
        return array;
    }

    /**
     * 插入排序法
     * @param array
     * @return
     */
    public static int[] insertionSort(int[] array){
        int length = array.length;
        if (length < 2){
            return array;
        }
        int current = 0;
        for (int i = 0; i < length - 1; i++) {
            current = array[i+1];
            int perIndex = i;
            while (perIndex>=0 && current <array[perIndex]){
                array[perIndex + 1] = array[perIndex];
                perIndex --;
            }
            array[perIndex + 1] = current;
        }
        return array;
    }

    /**
     * 希尔排序又叫缩小增量排序
     * @param array
     * @return
     */
    public static int[] shellSort(int[] array){
        int length = array.length;
        if (length < 2){
            return array;
        }
        int temp =0;
        int gap = length / 2;
        while (gap>0){
            for (int i = gap; i < length; i++) {
                temp = array[i];
                int perIndex = i - gap;
                while (perIndex>=0 && array[perIndex] > temp){
                    array[perIndex + gap] = array[perIndex];
                    perIndex -= gap;
                }
                array[perIndex + gap] = temp;
            }
            gap /= 2;
        }
        return array;
    }

    /**
     * 归并排序法
     * @param array
     * @return
     */
    public static int[] mergeSort(int[] array){
        int length = array.length;
        if (length < 2){
            return array;
        }
        int mid = length / 2;
        int[] left = Arrays.copyOfRange(array,0,mid);
        int[] right = Arrays.copyOfRange(array,mid,length);
        return merger(mergeSort(left),mergeSort(right));
    }

    public static int [] merger(int[] left,int[] right){
        int[] result = new int[left.length + right.length];
        for (int index = 0,i =0,j =0;index < result.length;index++){
            if (i >= left.length){
                result[index] = right[j++];
            }else if (j >= right.length){
                result[index] = left[i++];
            }else if(left[i] > right[j]){
                result[index] = right[j++];
            }else {
                result[index] = left[i++];
            }
        }
        return result;
    }

    /**
     * 快速排序法
     * @param array
     * @return
     */
    public static int[] quickSort(int[] array,int start,int end){
        if (array.length < 1 || start<0 || end >= array.length || start > end){
            return null;
        }
        int smallIndex = partition(array,start,end);
        if (smallIndex > start){
            quickSort(array,start,smallIndex-1);
        }
        if (smallIndex < end){
            quickSort(array,smallIndex+1,end);
        }
        return  array;
    }

    public static int partition(int[] array,int start,int end){
        int pivot = (int) (start + Math.random() *(end -start +1));
        int smallIndex = start -1;
        swap(array,pivot,end);
        for (int i = start; i <= end; i++) {
            if (array[i] <= array[end]){
                smallIndex++;
                if (i > smallIndex){
                    swap(array,i,smallIndex);
                }
            }
        }
        return smallIndex;
    }

    public static void swap(int[] array,int i,int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    /**
     * 堆排序法
     * @param array
     * @return
     */

    public static int[] heapSort(int[] array){
        int len = array.length;
        if (len <1){
            return array;
        }
        //构建一个最大的堆
        buildMaxHeap(array,len);
        //循环将堆的首位(最大值)与末位交换，然后再重新调整最大堆
        while (len > 0){
            swap(array,0,len-1);
            len--;
            adjustHeap(array,0,len);
        }
        return array;
    }

    //建立最大堆
    public static void buildMaxHeap(int[] array,int len){
        for (int i = (len-1)/2; i >=0 ; i--) {
            adjustHeap(array,i,len);
        }
    }

    //调整使之成为最大堆
    public static void adjustHeap(int[] array,int i,int len){
        int maxIndex = i;
        //如果有左子树，并且左子树大于父节点，则将最大指针指向左子树
        if (i*2<len && array[i*2] > array[maxIndex]){
            maxIndex = i * 2;
        }
        //如果有右子树，并且右子树大于父节点，则将最大指针指向右子树
        if (i*2+1<len && array[i*2+1] >array[maxIndex]){
            maxIndex = i * 2 +1;
        }
        //如果父节点不是最大值，则将父节点与最大值交换，并且递归调整与父节点交换的位置
        if (maxIndex != i){
            swap(array,maxIndex,i);
            adjustHeap(array,maxIndex,len);
        }
    }

    /**
     * 计数排序法
     * @param array
     * @return
     */
    public static int[] countingSort(int[] array){
        int length = array.length;
        if (length <2 ){
            return array;
        }
        int bias,min = array[0],max = array[0];
        for (int i = 0; i < length; i++) {
            if (array[i] > max){
                max = array[i];
            }
            if (array[i]<min){
                min = array[i];
            }
        }
        bias = 0 - min;
        int[] bucket = new int[max-min+1];
        Arrays.fill(bucket,0);
        for (int i = 0; i < length; i++) {
            bucket[array[i]+bias]++;
        }
        int index =0,i =0;
        while (index<length){
            if (bucket[i]!=0){
                array[index] = i -bias;
                bucket[i] --;
                index ++;
            }else {
                i++;
            }
        }
        return array;
    }

    /**
     * 桶排序法
     * @param array
     * @return
     */
    public static ArrayList<Integer> bucketSort(ArrayList<Integer> array,int bucketSize){
        if (null == array || array.size()< 2){
            return array;
        }
        int length = array.size();
        int max = array.get(0),min = array.get(0);
        for (int i = 0; i < length; i++) {
            Integer temp = array.get(i);
            if (temp > max){
                max = temp;
            }
            if (temp < min){
                min = temp;
            }
        }
        int bucketCount = (max - min)/bucketSize +1;
        ArrayList<ArrayList<Integer>> bucketArr = new ArrayList<>(bucketCount);
        ArrayList<Integer> resultArr = new ArrayList<>();
        for (int i = 0; i < bucketCount; i++) {
            bucketArr.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < length; i++) {
            Integer temp = array.get(i);
            bucketArr.get((temp-min)/bucketSize).add(temp);
        }
        for (int i = 0; i < bucketCount; i++) {
            if (bucketCount ==1){
                bucketSize --;
            }
            ArrayList<Integer> temp = bucketSort(bucketArr.get(i),bucketSize);
            for (int j = 0; j < temp.size(); j++) {
                resultArr.add(temp.get(j));
            }
        }
        return resultArr;
    }

    /**
     * 基数排序法
     * @param array
     * @return
     */
    public static int[] radixSort(int[] array){
        int length = array.length;
        if (length <2 ){
            return array;
        }
        //先计算出最大位数
        int max = array[0];
        for (int i = 0; i < length; i++) {
            max = Math.max(max,array[i]);
        }

        int maxDigit = 0;
        while (max!=0){
            max /= 10;
            maxDigit ++;
        }

        int mod = 10,div =1;
        ArrayList<ArrayList<Integer>> bucketList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            bucketList.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < maxDigit; i++,mod *= 10,div *= 10) {
            for (int j = 0; j < length; j++) {
                int num = (array[j] % mod)/div;
                bucketList.get(num).add(array[j]);
            }
            int index = 0;
            for (int j = 0; j < bucketList.size(); j++) {
                for (int k = 0; k < bucketList.get(j).size(); k++) {
                    array[index++] = bucketList.get(j).get(k);
                }
                bucketList.get(j).clear();
            }
        }
        return array;
    }

    public static void main(String[] args) {
        int [] array = {3,5,2,9,8,6,7,4,1};

        //冒泡排序
        //int[] arrays = bubbleSort(array);
        //选择排序
        //int[] arrays = selectionSort(array);
        //插入排序法
        //int[] arrays = insertionSort(array);
        //希尔排序法
        //int[] arrays = shellSort(array);
        //归并排序法
        //int[] arrays = mergeSort(array);
        //快速排序法
        //int[] arrays = quickSort(array,0,array.length-1);
        //堆排序法
        //int[] arrays = heapSort(array);
        //计数排序法
        //int[] arrays = countingSort(array);

        //基数排序
        int[] arrays = radixSort(array);
        IntStream.range(0,arrays.length).forEach(i -> System.out.println(arrays[i]));

        //==================================================================
        //桶排序法
//        ArrayList<Integer> list = new ArrayList();
//        IntStream.range(0,array.length).forEach(i -> list.add(new Integer(array[i])));
//        ArrayList<Integer> arrays = bucketSort(list,array.length-1);
//        arrays.stream().forEach(i -> System.out.println(i));

//        int[] temp = Arrays.copyOf(array,2);
//        int[] temp2 = Arrays.copyOfRange(array,0,2);
//        IntStream.range(0,temp.length).forEach(i -> System.out.println(temp[i]));
//        IntStream.range(0,temp2.length).forEach(i -> System.out.println(temp2[i]));
    }



}
