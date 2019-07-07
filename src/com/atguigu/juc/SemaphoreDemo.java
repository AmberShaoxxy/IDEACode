package com.atguigu.juc;
/**
 * Semaphore 抢车位
 * 用于控制多线程的并发数量
 *
 */


import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreDemo {
    public static void main(String[] args) {

        Semaphore semaphore = new Semaphore(4);

        for (int i = 0; i < 6 ; i++) {
             new Thread(()->{

                 try {

                     semaphore.acquire(); //抢占到资源
                     System.out.println(Thread.currentThread().getName()+"抢占到了车位~~");

                     //停3秒
                     try {
                         TimeUnit.SECONDS.sleep(3);
                     } catch (InterruptedException e) {
                         e.printStackTrace();
                     }

                     System.out.println(Thread.currentThread().getName()+"离开了车位~~");

                 } catch (InterruptedException e) {
                     e.printStackTrace();
                 } finally {

                     semaphore.release(); //离开时释放资源

                 }

             },String.valueOf(i)).start();
        }
    }
}
