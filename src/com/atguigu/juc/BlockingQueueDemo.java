package com.atguigu.juc;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * 队列遵循先进先出的原则,移除时先移除最先添加的,检查元素时也是从最先添加的开始
 */

public class BlockingQueueDemo {
    public static void main(String[] args) throws InterruptedException {


        ArrayBlockingQueue blockingQueue = new ArrayBlockingQueue(3);
/*

        //抛出异常
        //添加元素
        System.out.println(blockingQueue.add("a"));
        System.out.println(blockingQueue.add("b"));
        System.out.println(blockingQueue.add("c"));
       // System.out.println(blockingQueue.add("d"));//队列中只有三个位置,当加入第四个时就会抛出异常
        //检查元素,返回的都是第一个?
        System.out.println(blockingQueue.element());
        System.out.println(blockingQueue.element());
        System.out.println(blockingQueue.element());
        //移除元素
        System.out.println(blockingQueue.remove());//移除最先加入的元素,返回移除的元素
        System.out.println(blockingQueue.remove("c"));//移除指定的元素,返回Boolean
*/

      /*  //返回特殊值
        //插入
        System.out.println(blockingQueue.offer("A"));
        System.out.println(blockingQueue.offer("B"));
        System.out.println(blockingQueue.offer("C"));
        //检查元素
        System.out.println(blockingQueue.peek());
        System.out.println(blockingQueue.peek());
        System.out.println(blockingQueue.peek());
        //移除元素
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());//当队列中没有元素,继续移除会返回null
*/
/*
        //阻塞
        //加入元素
        blockingQueue.put("H");
        blockingQueue.put("J");
        blockingQueue.put("K");
        blockingQueue.put("L");//队列中元素已满后,再继续添加元素会导致生产者线程一直阻塞,程序显示一直在运行中,直到有元素被移除
        //移除元素
        blockingQueue.take();
      */

        //超时退出
        //添加
        System.out.println(blockingQueue.offer("Z",3L, TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer("X",3L, TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer("C",3L, TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer("V",3L, TimeUnit.SECONDS)); //生产者线程会等待3秒,3秒之内如果队列中还没有位置线程就会退出,继续执行下面的移除部分

        //移除
        System.out.println(blockingQueue.poll(3L,TimeUnit.SECONDS));
        System.out.println(blockingQueue.poll(3L,TimeUnit.SECONDS));
        System.out.println(blockingQueue.poll(3l,TimeUnit.SECONDS));

    }
}
