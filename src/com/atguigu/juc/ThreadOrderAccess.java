package com.atguigu.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 多线程之间实现按顺序调用 A->B->C
 * <p>
 * A打印5次,B打印10次,C打印15次 共10轮
 * <p>
 * 线程 操作 资源类
 * 判断 干活 通知
 * 使用while判断,防止多线程的虚假唤醒
 * 修改标志位
 */

//资源类
class Println {
    private int num = 1;
    Lock lock = new ReentrantLock();//锁
    Condition condition1 = lock.newCondition();
    Condition condition2 = lock.newCondition();
    Condition condition3 = lock.newCondition();

    //操作
    public void println5() {
        //锁
        lock.lock();
        try {
            //判断
            while (num != 1) {

                condition1.await();

            }
            //干活
            for (int i = 0; i < 5; i++) {
                System.out.println("当前线程:" + Thread.currentThread().getName());
            }

            //通知
            num = 2;
            condition2.signal();

        } catch (InterruptedException e) {

            e.printStackTrace();

        } finally {

            lock.unlock();//释放锁

        }

    }

    public void println10() {

        lock.lock();//锁
        try {
            //判断
            while (num != 2) {

                condition2.await();

            }
            //干活
            for (int i = 0; i < 10; i++) {
                System.out.println("当前线程:" + Thread.currentThread().getName());
            }

            //通知
            num = 3;
            condition2.signal();

        } catch (InterruptedException e) {

            e.printStackTrace();

        } finally {

            lock.unlock();//释放锁
        }

    }

    public void println15() {
        //加锁
        lock.lock();
        try {
            //判断
            while (num != 3) {

                condition3.await();
            }
            //干活
            for (int i = 0; i < 15; i++) {
                System.out.println("当前线程:" + Thread.currentThread().getName());
            }

            //通知
            num = 1;
            condition1.signal();

        } catch (InterruptedException e) {

            e.printStackTrace();

        } finally {

            lock.unlock();
        }

    }

}


public class ThreadOrderAccess {
    public static void main(String[] args) {

        Println println = new Println();

        new Thread(() -> {

            for (int i = 0; i < 10; i++) {
                println.println5();
            }

        }, "A").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                println.println10();
            }

        }, "B").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                println.println15();
            }

        }, "C").start();
    }
}
