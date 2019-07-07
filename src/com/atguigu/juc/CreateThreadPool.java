package com.atguigu.juc;

import java.util.concurrent.*;

public class CreateThreadPool {
    public static void main(String[] args) {
        //获取最大线程数
        int i = Runtime.getRuntime().availableProcessors();

        //创建线程
        ThreadPoolExecutor ThreadPool = new ThreadPoolExecutor(2, i + 1, 2L, TimeUnit.SECONDS, new LinkedBlockingQueue<>(3), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

        try {
            for (int j = 0; j < 10; j++) {
                //线程池执行任务
                ThreadPool.execute(() -> {
                    System.out.println("当前线程是:" + Thread.currentThread().getName());

                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //线程池使用结束后要记得关闭
            ThreadPool.shutdown();
        }

    }
}