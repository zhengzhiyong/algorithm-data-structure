package com.algorithm;

import org.junit.Test;

/**
 *  奇怪的计数器(建议时间复杂度O(logn),空间复杂度O(1)) *
 *  BOb 有一个奇怪的计数器，在第一秒它显示的数字为3，之后每隔一秒计数器显示的数字都会减一，直到1为止。
 *  计数器的衰减是循环的，减到1之后的下一秒，计数器会重置成2乘以前一个循环的初始值，然后每隔一秒开始衰减。
 *  如图所示:doc/DecreasingCounter.jpg
 *  问题：计算在时间t(秒)时计数器显示的值。
 *  函数原型：long strangeCounter(long t)
 *  限制条件1<=t<10的12次方
 *  解释：
 *  t = 4 时是第二个周期的开始，它显示的是2乘以第一个周期的开始值：2*3 = 6 *
 *  第一组
 *  3   2   1
 *  1   2   3
 *  第二组
 *  6  5  4  3  2  1
 *  4  5  6  7  8  9
 *  第三组
 *  12   11  10    9    8    7    6     5     4     3     2     1
 *  10   11  12   13   14   15   16    17    18    19    20    21
 */
public class DecreasingCounter {

    /**
     * 返回第n个分片t+v的值，每个分片的t+v是一个固定值
     * @param n
     * @return
     */
    public int test1(int n){
        //计算出第n个分片的长度
        int length = (int)Math.pow(2,(n-1))*3;

        //System.out.println("计算出第"+n+"个分片的长度："+length+",该分片的最大值为："+length+" 最小值为1,开始时间为："+(length-2)+",结束时间为："+((length-2)+(length-1)));
        int count = 0;
        for (int i = 1; i <= n; i++) {
            count = count + (int)Math.pow(2,(i-1))*3;
        }
        //System.out.println("计算出前"+n+"个分片的总共长度："+count);
        return  count+1;
    }

    /**
     *
     * @param t 分片数
     * @param num 需要比较的数字
     * @return 返回num所在的分片数
     */
    public int test2(int t,final int num){
        int count = 0;
        for (int i = 1; i <= t; i++) {
            count = count + (int)Math.pow(2,(i-1))*3;
        }
        if (count<num){
            return test2(t += 1,num);
        }else {
            return t<=1?1:t;
        }
    }

    public void test3(final int num){
        int t = test2(1,num);
        //System.out.println("数字"+num+"在第"+t+"个分片上");
        int tvCount = test1(t);
        System.err.println("第"+num+"秒，显示的值为："+(tvCount - num));
    }

    @Test
    public void test4(){
         test3(92);
    }

}
