package com.jvm;

import org.junit.Test;

public class IntegerClass {

    @Test
    public void test1(){
        Integer  a = 100;
        Integer  b = 100;
        Integer  c = 0;
        Integer a1 = new Integer(100);
        Integer b1 = new Integer(100);
        Integer c1 = new Integer(0);
        Integer integer1 = 127;
        Integer integer2 = 127;
        Integer integer3 = 128;
        Integer integer4 = 128;
        Integer integer5 = -1;
        Integer integer6 = -1;

        System.out.println(a == b);
        System.out.println(a == a1);
        System.out.println(a1 == b1);
        System.out.println(c == c1);
        System.out.println( b == c + a1);
        System.out.println( b == c + a);
        System.out.println(b == c + b);
        System.out.println(b1 == c1 + a1);
        System.out.println(integer1==integer2);
        System.out.println(integer3==integer4);
        System.out.println(integer5==integer6);
    }
}



