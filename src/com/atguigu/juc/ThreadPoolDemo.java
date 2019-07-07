package com.atguigu.juc;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class ThreadPoolDemo {
    public static void main(String[] args) {
        /*   *//**
         三种线程池
         *//*
        //1.固定数量的线程池
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        //2.只有一个线程的线程池
        ExecutorService executorService1 = Executors.newSingleThreadExecutor();

        //3.不确定数量线程的线程池
        ExecutorService executorService2 = Executors.newCachedThreadPool();

        //查看cpu的内核数
        int i = Runtime.getRuntime().availableProcessors();
        System.out.println(i);

        //自定义创建线程池
        //线程池的最大线程数是cpu内核数+1


        */


        //函数式接口
        Function<String, Integer> stringFunction = new Function<String, Integer>() {

            @Override
            public Integer apply(String s) {
                boolean empty = s.isEmpty();
                System.out.println("function:" + empty);
                return 123;
            }
        };
        System.out.println("function:" + stringFunction.apply("1"));

        //函数式接口 λ表达式
        Function<String, String> function = (s) -> {
            return "123";
        };
        System.out.println("function λ:" + function.apply("1"));


        //断定型接口
        Predicate predicate = new Predicate<String>() {
            @Override
            public boolean test(String s) {

                return s.isEmpty();
            }
        };
        System.out.println("predicate:" + predicate.test("123"));

        //断定型接口 λ表达式
        Predicate pridicate = (s) -> {
            return s.toString().isEmpty();
        };
        System.out.println("predicate λ:" + pridicate.test(123));


        //消费型接口
        Consumer consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {

                System.out.println("Consumer:" + s.isEmpty());
            }
        };
        consumer.accept("123");

        //消费型接口 λ
        Consumer consumer1 = (s) -> {
            System.out.println("Consumer λ" + "     1");
        };
        consumer1.accept("123");


        //供给型接口
        Supplier supplier = new Supplier() {
            @Override
            public Object get() {

                return "123";
            }
        };
        System.out.println("supplier:"+supplier.get());

        //供给型接口 λ
        Supplier supplier1=()->{return "123";};
        System.out.println("supplier λ:"+supplier1.get());

    }
}
