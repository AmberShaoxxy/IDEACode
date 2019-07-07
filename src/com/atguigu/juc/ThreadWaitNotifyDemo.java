package com.atguigu.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 题目:
 * 两个线程可以操作初始值为零的一个变量
 * 实现一个线程对该变量加1,一个线程对该变量减1
 * 实现交替,10轮变量初始值为0
 */

//资源类
class Variable {
    //初始值为0的变量
    private int n = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    //加一的操作
    public synchronized void add() {

        //多线程中使用while防止线程虚假唤醒
        lock.lock();

        try {
            //1.判断
            while (n != 0) {

                condition.await();// this.wait();
            }

            //2.干活
            n++;
            System.out.println("当前线程:" + Thread.currentThread().getName() + "->" + n);

            //3.唤醒
            condition.signalAll(); //this.notifyAll();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {

            lock.unlock();
        }
    }

    //减一的操作
    public synchronized void sub() throws InterruptedException {

        //1.判断
        while (n == 0) {

            this.wait();
        }

        //干活
        n--;
        System.out.println("当前线程:" + Thread.currentThread().getName() + "->" + n);

        //3.唤醒
        this.notifyAll();

    }

}


public class ThreadWaitNotifyDemo {
    public static void main(String[] args) {

        Variable variable = new Variable();

        //线程一先加
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    variable.add();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "First").start();

        //线程二再减
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    variable.sub();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "Second").start();

    }
}
