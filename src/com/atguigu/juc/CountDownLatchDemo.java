package com.atguigu.juc;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {

        CountDownLatch countDownLatch = new CountDownLatch(10);

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                countDownLatch.countDown();
                System.out.println("第" + Thread.currentThread().getName() + "个.....");

            }, String.valueOf(i)).start();
        }
        countDownLatch.await();
        System.out.println("最后一个......");
    }
}
