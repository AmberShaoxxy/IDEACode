package com.atguigu.juc;

//题目: 三个售票员 卖出30张票

import sun.rmi.runtime.NewThreadAction;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 多线程编程:
 * 线程      操作    资源类
 * 第一步:先创建一个资源类
 * 第二步:几个线程要对这个资源类进行什么样的操作,操作就是方法,方法要在资源类自己身上带着,这个类自己带着一个可以对外提供服务的方法(空调的case制冷和制热的方法空调自己带着)
 * 第三步:创建new Thread();多个线程调用资源类中的方法来操作资源类
 *
 * 只要多线程操作同一个资源类就先创建一个资源类
 * 操作:对外暴露的调用方法,资源类自身暴露出的方法,可以被线程调用
 *
 * 匿名内部类:
 * new接口的现象就叫做匿名内部类
 */

//创建一个资源类
class Ticket {

    private int num = 30;
    private Lock lock = new ReentrantLock();
    //在资源类中写线程操作资源类的方法
    public void sale() {

        lock.lock();
        try {

            if (num > 0) {

                System.out.println(Thread.currentThread().getName() + "正在卖票" + "当前卖出的是第" + (num--) + "还剩" + num + "张");

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            lock.unlock();
        }

    }

}

public class SaleTicket {
    public static void main(String[] args) throws InterruptedException {//main是程序的入口
        /**
         *  创建多个线程,分别调用资源类中的方法来操作资源类
         *  创建线程的方法可以在Java8API中的Thread类中查找到
         *  Thread(Runnable target, String name)
         *  方法中传入两个参数,一个是实现了runnable接口的类,另一个是该线程的名字
         *
         */

        Ticket ticket = new Ticket();
        //创建线程,操作资源类
        //第一个线程

        //
        //new Thread(()->{for (int i = 0; i <40 ; i++) ticket.sale();},"a" ).start();
        //new Thread()
        new Thread(new Runnable() {

            @Override
            public void run() {
                System.out.println(1231231);
            }
        }, "a");

       //第二个线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for (int i = 0; i < 40; i++) {
                    ticket.sale();
                }
            }
        }, "b").start();


        //第三个线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 40; i++) {

                    ticket.sale();
                }
            }
        }, "c").start();

    }

}
