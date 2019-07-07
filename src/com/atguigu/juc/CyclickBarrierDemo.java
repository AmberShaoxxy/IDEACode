package com.atguigu.juc;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 与CountDownLatch功能相同,但是计数器不同,是递增的
 */
public class CyclickBarrierDemo {
    public static void main(String[] args) {

        CyclicBarrier cyclickBarrier = new CyclicBarrier(7, () -> {

            System.out.println("最后一个~~");
        });

        for (int i = 0; i < 7; i++) {

            final int temp = i;

            new Thread(() -> {

                System.out.println("当前是第" + temp + "个~~");

                try {
                    cyclickBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }, String.valueOf(i)).start();
        }
    }
}
