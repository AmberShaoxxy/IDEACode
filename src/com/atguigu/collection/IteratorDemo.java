package com.atguigu.collection;

import java.util.*;

public class IteratorDemo {
    public static void main(String[] args) {

        Collection col = new ArrayList<String>();

        col.add("123");
        List<String> list = Arrays.asList("1", "2", "3"); //可以一次添加多个元素
        boolean b = col.addAll(list);
        Iterator iterator = col.iterator();

        while (iterator.hasNext()) {
            Object next = iterator.next();
            System.out.println(next);

        }
        System.out.println("====================================");
        /**
         * 迭代器每使用完一次后,将集合遍历过一次后就要重新获取,不能重复使用
         *
         */
        Iterator iterator1 = col.iterator();

        while (iterator1.hasNext()) {

            Object next = iterator1.next();
            System.out.println(next);

        }

        //在使用迭代器遍历集合的同时,调用remove()方法移除元素就会出现ConcurrentModificationException

        Iterator iterator2 = col.iterator();
        while (iterator2.hasNext()) {
            Object next = iterator2.next();
            col.remove("1");
            System.out.println(next);
        }

        //for循环增强遍历集合和数组
        for (Object c : col) {

            System.out.println(c);

        }
    }
}
