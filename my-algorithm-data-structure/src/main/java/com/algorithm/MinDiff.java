package com.algorithm;

public class MinDiff {
    public static void main(String[] args){
        int[] aa={2,5,4,3,1,0};
        int[] bb={7,9,8,10,6,11};
        exchange(aa,bb);

    }
    static void exchange(int[] a,int[] b){

        int n=a.length;
        int diff=0;
        for(int i=0;i<n;i++){
            //计算两组数的差
            diff+=a[i]-b[i];
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                //计算两组数中单个元素的差值
                int tp=a[i]-b[j];
                //单个元素差值和数组的差值比较
                int t=tp-diff;
                if(t*tp<0){
                    //以此条件判断是否需要交换
                    int ex=a[i];
                    a[i]=b[j];
                    b[j]=ex;
                    //计算数据交换后两个数组的差值
                    diff-=2*tp;
                }
            }
        }
        for(int i=0;i<n;i++){
            System.out.println(a[i]+" "+b[i]);
        }
    }
}