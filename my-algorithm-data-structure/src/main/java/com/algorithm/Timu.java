package com.algorithm;

import org.junit.Test;

public class Timu {

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



}
