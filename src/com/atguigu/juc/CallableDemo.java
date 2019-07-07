package com.atguigu.juc;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;


/**
 * 创建线程的方法:实现Runnable接口
 */
class MyThread2 implements Runnable {

    @Override
    public void run() {
        System.out.println("啦啦啦,是run呀~~");
    }
}

/**
 * 创建线程的方法:实现Callable接口
 */
class MyThread1 implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {

        System.out.println("啦啦啦,是call呀~~");

        return 123;
    }
}

public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        //实现Callable接口
        MyThread1 myThread1 = new MyThread1();
        //实现Runnable接口
        MyThread2 myThread2 = new MyThread2();

        //因为Thread中不能直接传入Callable接口
        FutureTask futureTask = new FutureTask(myThread1);
        new Thread(futureTask, "A").start();

        System.out.println( futureTask.get());

        //Thread中可以直接传入Runnable接口
        new Thread(myThread2,"B").start();

    }

}

