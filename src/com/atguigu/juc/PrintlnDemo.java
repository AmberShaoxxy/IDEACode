package com.atguigu.juc;

import java.util.Arrays;
import java.util.List;

public class PrintlnDemo {
    public static void main(String[] args) {
        //创建一个数组
        List<String> list = Arrays.asList("aa", "bb", "cc");
        //遍历打印出数组中的每一个元素
        list.forEach((L) -> {
            System.out.println(L);
        });

        list.forEach(System.out::println);

    }
}

class Demo {
    /**
     * 对要遍历的操作添加add操作
     */
    public void addString(String s) {

        System.out.println(s + "add");

    }

    public void test(){

        List<String> list = Arrays.asList("aa", "bb", "cc");

        list.forEach(new Demo()::addString);

    }
}