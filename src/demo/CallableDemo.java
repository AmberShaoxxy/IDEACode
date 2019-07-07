package demo;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;


class MyThread implements Callable<Integer>
{
    @Override
    public Integer call() throws Exception
    {
        System.out.println("*******come in Callable");
        //暂停一会儿线程
        try { TimeUnit.SECONDS.sleep( 4 ); } catch (InterruptedException e) { e.printStackTrace(); }
        return 1024;
    }
}

/**
 * @auther zzyy
 * @create 2019-02-18 17:11
 * java
 * 多线程中，第3种获得多线程的方式
 *
 * 1    get方法一般请放在最后一行
 */
public class CallableDemo
{
    public static void main(String[] args) throws InterruptedException, ExecutionException
    {
        FutureTask futureTask = new FutureTask(new MyThread());
        new Thread(futureTask,"A").start();
        new Thread(futureTask,"B").start();




        System.out.println(Thread.currentThread().getName()+"*****计算完成");


        System.out.println(futureTask.get());
    }
}
