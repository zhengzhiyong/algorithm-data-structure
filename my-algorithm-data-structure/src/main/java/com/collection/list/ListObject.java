package com.collection.list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class ListObject {

    @Test
    public void test1(){
        List<String> list = new ArrayList<>();
        System.out.println(list.hashCode());
        List<String> list2 = new ArrayList<>(1);
        System.out.println(list2.hashCode());
        IntStream.range(0,10).forEach(i -> list2.add(String.valueOf(i)));
        System.out.println(list2.hashCode());
        IntStream.range(0,10).forEach(i -> list2.add(String.valueOf(i)));
        System.out.println(list2.hashCode());
        System.out.println(list2.size());
        list2.remove(0);
        System.out.println(list2.size());

    }


    class Array{
        int [] array;

        Array(){
            array = new int[]{};
        }

        Array(int[] array){
            this.array = array;
        }

        void remove(int index){
            int numMoved = array.length - (index + 1);
            System.arraycopy(array, index+1, array, index, numMoved);
            int length = array.length;
            array[--length]=0;

            int [] tempArrays = new int[length];
            System.arraycopy(array,0,tempArrays,0,length);
            array = tempArrays;
        }
    }


    @Test
    public void  test2(){
        //对数组arrays去掉索引为3的元素，并且更新数组的长度
        int [] arrays = new int[] {1,2,3,4,5,6,7,8,9};
        IntStream.range(0,arrays.length).forEach(i -> System.out.print(arrays[i]));
        System.out.println();
        int index = 3;
        int numMoved = arrays.length - (index + 1);
        System.arraycopy(arrays, index+1, arrays, index, numMoved);
        int length = arrays.length;
        arrays[--length]=0;


//        IntStream.range(0,arrays.length).forEach(i -> System.out.print(arrays[i]));
//        System.out.println();
        //定义新的数组，并且赋值给新的数组
        int [] tempArrays = new int[length];
        System.arraycopy(arrays,0,tempArrays,0,length);
        IntStream.range(0,length).forEach(i -> System.out.print(tempArrays[i]));
        System.out.println();


        int [] arrays2 = new int[] {1,2,3,4,5,6,7,8,9};
        ListObject.Array array = new ListObject().new Array(arrays2);
        array.remove(3);
        IntStream.range(0,array.array.length).forEach(i -> System.out.print(array.array[i]));
    }
}
