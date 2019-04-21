package com.hashmap;

import java.util.HashMap;

/**
 * hashMap 利用 key 去创建一个链表，把相同key值得对象放到一个链表中，方便检索。可以简单的理解为二维数组。
 *
 */
public class Test {

    public static void main(String[] args) {
        User user = new User(1);
        User user2 = new User(1);
//        System.out.println(user.hashCode());
//        System.out.println(user2.hashCode());
//        System.out.println(user.toString());
//        System.out.println(user2.toString());

        HashMap<User,User> hashMap = new HashMap<>();
        hashMap.put(user,user);
        User userO = hashMap.get(user2);
        System.out.println(userO);
//        System.out.println(new Object().hashCode());
//        System.out.println(new String("123456abc").hashCode());
//        char[] ch = new char [] {'a','b'};
//        System.out.println(ch[0]);
    }
}
