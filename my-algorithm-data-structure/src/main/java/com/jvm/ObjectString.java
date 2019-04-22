package com.jvm;

import java.lang.reflect.Field;

/**
 * String、StringBuilder、Stringbuffer比较
 */
public class ObjectString {

    public static void test1(){
        //StringBuffer对象和StringBuilder对象的底层也是一个char[]数组：
        //char[] value;并没有用final修饰，所以数组的值是可变的
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("1111");
        System.out.println(stringBuilder.hashCode());
        System.out.println(stringBuilder.toString());
        stringBuilder.append("22222");
        System.out.println(stringBuilder.hashCode());
        System.out.println(stringBuilder.toString());
        //上面我们可以看到，stringBuilder的hashCode值 和 stringBuilder的hashCode值都一直没有改变。
        //但是对应的toString值却发生了变化，这就说明是同一个对象。
        //在线程安全上，StringBuilder是线程不安全的，而StringBuffer是线程安全的


        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("1111");
        System.out.println(stringBuffer.hashCode());
        System.out.println(stringBuffer.toString());
        stringBuffer.append("22222");
        System.out.println(stringBuffer.hashCode());
        System.out.println(stringBuffer.toString());

        //在这方面运行速度快慢为：StringBuilder > StringBuffer > String
        //String最慢的原因：
        //String为字符串常量，而StringBuilder和StringBuffer均为字符串变量，即String对象一旦创建之后该对象
        // 是不可更改的，但后两者的对象是变量，是可以更改的。

        //String 对象的底层实际为一个final类型的 char[]
        //private final char value[];
        //用final修饰的对象值可变，但是引用不变，即：value指向不可变，但是value[]数组的值可变，
        // 但因为有private关键字对其进行封装达到value[]数组值也不可变的目的
        String str = "1111";
        System.out.println(str.hashCode());
        str = str + "22222";
        System.out.println(str.hashCode());
        //如果运行这段代码会发现先输出“abc”，然后又输出“abcde”，好像是str这个对象被更改了，
        // 其实，这只是一种假象罢了，JVM对于这几行代码是这样处理的，首先创建一个String对象str，
        // 并把“abc”赋值给str，然后在第三行中，其实JVM又创建了一个新的对象也名为str，
        // 然后再把原来的str的值和“de”加起来再赋值给新的str，而原来的str就会被JVM的垃圾回收机制（GC）给回收掉了
        // ，所以，str实际上并没有被更改，也就是前面说的String对象一旦创建之后就不可更改了。
        // 所以，Java中对String对象进行的操作实际上是一个不断创建新的对象并且将旧的对象回收的一个过程，
        // 所以执行速度很慢。


		//String：适用于少量的字符串操作的情况
		//StringBuilder：适用于单线程下在字符缓冲区进行大量操作的情况
		//StringBuffer：适用多线程下在字符缓冲区进行大量操作的情况
    }

    public static void test2() {
//        StringBuilder stringBuilder = new StringBuilder();
//        stringBuilder.append("01234567890123456789");
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("01234567890123456789");
    }


    public static void test3(){
        //用反射， 可以反射出String对象中的value属性， 进而改变通过获得的value引用改变数组的结构

        //在这个过程中，s始终引用的同一个String对象，但是再反射前后，这个String对象发生了变化，
        // 也就是说，通过反射是可以修改所谓的“不可变”对象的。但是一般我们不这么做。
        // 这个反射的实例还可以说明一个问题：如果一个对象，他组合的其他对象的状态是可以改变的，那么这个对象很可能不是不可变对象。
        // 例如一个Car对象，它组合了一个Wheel对象，虽然这个Wheel对象声明成了private final 的，
        // 但是这个Wheel对象内部的状态可以改变， 那么就不能很好的保证Car对象不可变。
        try {
            String str = "hello word";
            System.out.println(str.hashCode());
            Field field = String.class.getDeclaredField("value");
            field.setAccessible(true);
            char[] value = (char[]) field.get(str);
            value[5] = '_';
            value[1] = 'G';
            System.out.println(str);
            System.out.println(str.hashCode());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        test3();
    }
}
