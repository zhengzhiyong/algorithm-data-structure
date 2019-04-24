package com.java8;

import org.junit.Test;

import java.io.PrintStream;
import java.util.*;
import java.util.stream.Collectors;

public class Java8Object {

    //线程写法
    @Test
    public void test1(){
        Thread td = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(".............");
            }
        });
        td.start();

        Thread td2 = new Thread(() -> System.out.println("..........lambda!"));
        td2.start();
    }

    //匿名类排序
    @Test
    public void test2(){
        String [] strs = new String[]{"b","c","a"};
        List<String> list = Arrays.asList(strs);
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        Collections.sort(list,(str1,str2)-> str1.compareTo(str2));
    }

    //字符串转化
    @Test
    public void test3(){
        List<String> list = Arrays.asList(new String[]{"ni","hao","java8","lambda"});

        List<String> upperCaseList = new ArrayList<>();
        for (String str: list){
            upperCaseList.add(str.toUpperCase());
        }

        List<String> upperCaseList2 = list.stream().map(name -> {
            return name.toUpperCase();
        }).collect(Collectors.toList());
    }

    //方法引用
    @Test
    public void test4(){
        List<String> list = Arrays.asList(new String[]{"ni","hao","java8","lambda"});

        List<String> upperCaseList = new ArrayList<>();
        for (String str: list){
            upperCaseList.add(str.toUpperCase());
        }
        //方法引用
        List<String> upperCaseList2 = list.stream().map(String::toUpperCase).collect(Collectors.toList());
    }


    //this概念
    @Test
    public void test5(){
        String waibu= "lambda";
        List<String> proStrs = Arrays.asList(new String[]{"ni","hao","java8"});
        List<String> execStrs = proStrs.stream().map(chuandi ->{
            //this不是指向lambda表达式产生的那个SAM对象，而是声明它的外部对象。
            System.out.println(this.getClass().getName());

            return waibu + chuandi +"----------------------------";
        }).collect(Collectors.toList());

        //方法引用
        execStrs.forEach(System.out::println);
//        objectName::instanceMethod
//        ClassName::staticMethod
//        ClassName::instanceMethod


    }

    interface A<T>{
        void accept(T v1);
    }

    interface B<T,U,R>{
        R hello(T v,U u);
    }

    interface C<T,U>{
        boolean equals1(T t,U u);
    }

    interface D<T>{
        T get();
    }

    @Test
    public void test6(){
        PrintStream ps = System.out;
        A<String> a = (str) ->ps.println(str);
        a.accept("hello world!");

        A<String> a2 = ps::println;
        a2.accept("hello world2!");

        B<Double,Double,Double> b = (x,y) -> Math.max(x,y);
        Double r = b.hello(3.1,2.2);
        ps.println(r);

        C<String,String> c = (x,y) -> x.equals(y);
        System.out.println(c.equals1("abc","abc"));;

        C<String,String> c2 = String::equals;
        System.out.println(c2.equals1("abc","abc"));

        D<String> d = () -> new String(""+System.currentTimeMillis());
        System.out.println(d.get());

        D<String> d2 = String::new;
        System.out.println(d2.get());
    }
}
