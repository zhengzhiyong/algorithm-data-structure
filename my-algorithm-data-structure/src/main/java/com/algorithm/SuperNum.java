package com.algorithm;

import org.junit.Test;

/**
 * 题目参考：
 */
public class SuperNum {

    public  int superDigit(final int superNum){
        if (superNum<10){
            return superNum;
        }else {
            String superNumStr = Integer.valueOf(superNum).toString();
            int count = 0;
            String array [] = superNumStr.split("");
            for (int i = 0; i < array.length; i++) {
                count = count + Integer.valueOf(array[i]);
            }
            return superDigit(count);
        }
    }


    public int superDigit2(final int superNum,final int k){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < k; i++) {
            stringBuilder.append(String.valueOf(superNum));
        }
        int superNumP = Integer.valueOf(stringBuilder.toString());
        return superDigit(superNumP);
    }

    @Test
    public void test1(){
        //System.out.println(superDigit(9875));
        System.out.println(superDigit2(9875,2));
    }
}
