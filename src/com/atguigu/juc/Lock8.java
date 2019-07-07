package com.atguigu.juc;
/*
        题目：多线程8锁
        1 标准访问，请问先打印邮件还是短信？
        2 邮件方法暂停4秒钟，请问先打印邮件还是短信？
        3 新增一个普通方法hello()，请问先打印邮件还是hello？
        4 两部手机，请问先打印邮件还是短信？
        5 两个静态同步方法，同一部手机，请问先打印邮件还是短信？
        6 两个静态同步方法，2部手机，请问先打印邮件还是短信？
        7 1个普通同步方法,1个静态同步方法，1部手机，请问先打印邮件还是短信？
        8 1个普通同步方法,1个静态同步方法，2部手机，请问先打印邮件还是短信？
*/


import java.util.concurrent.TimeUnit;

class Phone {

    public synchronized void SMS() throws Exception {

        System.out.println("线程:" + Thread.currentThread().getName() + " --->打印SMS....");
    }

    public synchronized void Email() throws Exception {
        TimeUnit.SECONDS.sleep(10);
        System.out.println("线程:" + Thread.currentThread().getName() + "--->打印Email...");
    }

     public void call(){

        System.out.println("线程:"+Thread.currentThread().getName()+"-->打印call...");
    }

}


public class Lock8 {
    public static void main(String[] args) {

        Phone phone = new Phone();
        // Phone phone1 = new Phone();

        new Thread(() -> {
            try {

                phone.Email();


            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "A").start();

        new Thread(() -> {
            try {


                phone.SMS();


            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "B").start();

        new Thread(() -> {
            try {


                phone.call();


            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "C").start();

        new Thread(() -> {
            try {


                phone.SMS();


            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "D").start();

        new Thread(() -> {
            try {


                phone.call();


            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "F").start();

    }
}
