package com.atguigu.collection;

import java.util.*;

public class IteratorDemo {
    public static void main(String[] args) {

        Collection col = new ArrayList<String>();

        col.add("123");
        List<String> list = Arrays.asList("1", "2", "3");
        boolean b = col.addAll(list);
        Iterator iterator = col.iterator();

        while (iterator.hasNext()) {
            Object next = iterator.next();
            System.out.println(next);

        }
        System.out.println("====================================");

        while (iterator.hasNext()) {
            Object next = iterator.next();
            System.out.println(next);

        }
        Iterator iterator1 = col.iterator();

        while(iterator1.hasNext()){

            Object next = iterator1.next();
            System.out.println(next);

        }

    }
}
