package com.algorithm;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Exercises {

    /**
     * 1.题目（盛大无线面试题）：在一个字符串数组中有红、黄、蓝三种颜色的球，且个数不相等、顺序不一致，
     * 请为该数组排序，使得排序后数组中球的顺序为:黄、红、蓝
     * 例如：红蓝蓝黄红黄蓝红红黄红 排序后为：黄黄黄红红红红红蓝蓝蓝
     */
    @Test
    public void test1(){
        String strs [] = {"红","黄","蓝","红","黄","蓝","红","黄","蓝"};
        String colors [] = {"红","黄","蓝"};
        String temp = "";
        int k = 0;
        for (int j = 0;j<strs.length;j++){
            if (strs[j].equals(colors[0])){
                if(j>k){
                    temp = strs[k];
                    strs[k] = strs[j];
                    strs[j] = temp;
                }
                k++;
            }
        }

        if (k +1 >strs.length){
            return;
        }

        k ++;
        for (int j = k;j<strs.length;j++){
            if (strs[j].equals(colors[1])){
                if(j>k){
                    temp = strs[k];
                    strs[k] = strs[j];
                    strs[j] = temp;
                }
                k++;
            }
        }

        for (int i = 0; i < strs.length; i++) {
            System.out.println(strs[i]);
        }
    }


    /**
     * 递归法
     */
    @Test
    public void test2(){
        String strs [] = {"红","黄","蓝","红","黄","蓝","红","黄","蓝"};
        String colors [] = {"红","黄","蓝"};
        orderColorBalls(strs,colors,0,0);
        for (int i = 0; i < strs.length; i++) {
            System.out.println(strs[i]);
        }
    }

    public void orderColorBalls(String[] balls,String colors[],int colorBallIndex,int offIndex){
        int len = 0;
        if (balls == null || (len=balls.length)==0 ){
            return;
        }
        int len1 = 0;
        if (colors == null || (len1=colors.length)==0){
            return;
        }
        if (len<offIndex || len1<colorBallIndex){
            return;
        }
        int k = offIndex;
        String temp = "";
        for (int j = offIndex;j<len;j++){
            if (balls[j].equals(colors[colorBallIndex])){
                if(j>k){
                    temp = balls[k];
                    balls[k] = balls[j];
                    balls[j] = temp;
                }
                k++;
            }
        }
        orderColorBalls(balls,colors,++colorBallIndex,++k);
    }


    /**
     * 2.题目：取一个整数a从右端开始的4～7位。
     * 程序分析：可以这样考虑：
     * (1)先使a右移4位。
     * (2)设置一个低4位全为1,其余全为0的数。可用(0 < <4)
     * (3)将上面二者进行&运算。
     */
    @Test
    public void test3(){
        int a = 0;
        long b =  18745678;
        a = (int)Math.floor(b%Math.pow(10,7)/Math.pow(10,3));
        System.out.println(a);
        System.out.println(Math.pow(10,7));
        System.out.println(Math.pow(10,3));
        System.out.println(b%Math.pow(10,7)/Math.pow(10,3));
        System.out.println(Math.floor(1000000.1231));
    }

    /**
     * 3.题目：打印出杨辉三角形（要求打印出10行如下图）
     * 程序分析：
     * 1
     * 1 1
     * 1 2 1
     * 1 3 3 1
     * 1 4 6 4 1
     * 1 5 10 10 5 1
     */
    @Test
    public void test4(){
        int i ,j ;
        int a [] [];
        a = new int [8][8];
        for (i = 0;i <8;i++){
            a[i][i]=1;
            a[i][0]=1;
        }

        for (i = 2 ;i < 8 ;i++){
            for (j=1;j<=i-1;j++){
                a[i][j] =a [i-1][j-1]+a[i-1][j];
            }
        }

        for (i =0 ;i<8;i++){
            for (j = 0;j<i;j++){
                System.out.printf("    "+a[i][j]);
            }
            System.out.println();
        }
    }

    /**
     * 4.题目：输入3个数a,b,c，按从大到小顺序输出。
     * 程序分析：利用指针方法。
     */
    @Test
    public void test5(){
        int [] arrays = {783,564,799};
        for (int i = arrays.length;--i>=0;){
            for (int j =0;j<i;j++){
                if (arrays[j]>arrays[j+1]){
                    int temp = arrays[j+1];
                    arrays[j+1] = arrays[j];
                    arrays[j] =temp;
                }
            }
        }
        for (int i = 0; i < arrays.length; i++) {
            System.out.println(arrays[i]);
        }
    }

    /**
     * 5.题目：写一个函数，求一个字符串的长度，在main函数中输入字符串，并输出其长度。
     */
    @Test
    public void test6(){
        System.out.println("请输入一个字符串");
        Scanner s = new Scanner(System.in);
        String str = s.next();
        System.out.println(str.length());
    }

    /**
     * 6.题目：字符串排序。
     */
    @Test
    public void test7(){
        ArrayList<String> list = new ArrayList<String>();
        list.add("010101");
        list.add("010001");
        list.add("010201");
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    /**
     * 7.题目：海滩上有一堆桃子，五只猴子来分。第一只猴子把这堆桃子凭据分为五份，多了一个，这只猴子把多的一个扔入海中，拿走了一份。
     * 第二只猴子把剩下的桃子又平均分成五份，又多了一个，它同样把多的一个扔入海中，拿走了一份，
     * 第三、第四、第五只猴子都是这样做的，问海滩上原来最少有多少个桃子？
     */
    class MonkeyPeaches {
        //桃子总数
        int ts = 0;
        //分桃子的次数
        int fs = 1;
        //猴子的数量
        int hs = 5;
        //桃子数的取值范围
        int tsscope = 5000;
        public int test8(int t) {
            if (t == tsscope) {
                //当桃子数量达到最大到时候取消递归
                System.out.println("结束");
                return 0;
            } else {
                if ((t - 1) % hs == 0 && fs <= hs) {
                    if (fs == hs) {
                        System.out.println("桃子数为" + ts + "时，满足猴子分桃");
                    }
                    fs += 1;
                    return test8((t - 1) / 5 * 4);
                } else {
                    //没满足条件时候，将分的次数重置为1
                    fs = 1;
                    return test8(ts += 1);
                }
            }
        }
    }

    @Test
    public void test8(){
       new Exercises().new MonkeyPeaches().test8(0);
    }
    /**
     * 8.新浪面试题：编写一个方法，计算一个字符串中，第一个不重复的字符在当前字符串中的索引。
     * 分析 ： 编写一个方法，计算一个字符串中，第一个不重复 的字符在当前字符串中的索引。
     */
    class FirstRepeat{
        public int test9(String str){
            int len = str.length();
            char curch ;
            char nextch;
            for (int i = 0; i < len; i++) {
                curch = str.charAt(i);
                for (int j = 0; j < len; j++) {
                    nextch = str.charAt(j);
                    if (curch == nextch && i != j){
                        if (i == j+1){
                            i++;
                        }
                        break;
                    }else{
                        if (j==len-1){
                            return  i;
                        }
                    }
                }
            }
            return 0;
        }
    }
    @Test
    public void test9(){
        String str = "abc123bcd21";
        int i = new FirstRepeat().test9(str);
        System.out.println(i);
    }

    /**
     * 9.题目：求一个3*3矩阵对角线元素之和
     * 1.程序分析：利用双重for循环控制输入二维数组，再将a[i][i]累加后输出。
     * 其实就是要求[1][1]、[2][2]、[3][3]对应数字之和
     */
    @Test
    public void test10(){
        int count = 0;
        int array[][]= {{1,2,3},{4,5,6},{7,8,9}};
        for (int j = 0; j < 3; j++) {
            for (int k = 0; k < 3; k++) {
                if (j == k){
                  count = count + array[j][k];
                }
            }
        }
        System.out.println(count);
    }


    /**
     * 10.题目：打印出所有的 "水仙花数 "，所谓 "水仙花数 "是指一个三位数，其各位数字立方和等于该数本身。
     * 例如：153是一个 "水仙花数 "，因为153=1的三次方＋5的三次方＋3的三次方。
     */
    @Test
    public void test11(){
        int b1,b2,b3;
        for (int i = 101; i < 1000; i++) {
            b3 = i /100;
            b2 = i % 100 / 10;
            b1 = i % 10;
            if (b3*b3*b3 + b2*b2*b2 + b1 * b1 *b1 == i){
                System.out.println(i+"是一个水仙花数");
            }
        }
    }
}
