package com.algorithm;

public class MonkeyPeaches{
    //桃子总数
    int ts = 0;
    //分桃子的次数
    int fs = 1;
    //猴子的数量
    int hs = 5;
    //桃子数的取值范围
    int tsscope = 5000;
    public int test8(int t){
        if (t == tsscope){
            //当桃子数量达到最大到时候取消递归
            System.out.println("结束");
            return 0;
        }else {
            if ((t-1)%hs == 0 && fs<=hs){
                if (fs == hs){
                    System.out.println("桃子数为"+ ts+"时，满足猴子分桃");
                }
                fs += 1 ;
                return test8((t-1)/5*4);
            }else {
                //没满足条件时候，将分的次数重置为1
                fs = 1;
                return test8(ts+=1);
            }
        }
    }

    public static void main(String[] args) {
        new MonkeyPeaches().test8(0);
    }


}
