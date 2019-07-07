package com.atguigu.juc;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 多个线程同时读一个资源类没有任何问题，所以为了满足并发量，读取共享资源应该可以同时进行。
 * 但是
 * 如果有一个线程想去写共享资源来，就不应该再有其它线程可以对该资源进行读或写
 * 小总结：
 *          读-读能共存
 *          读-写不能共存
 *          写-写不能共存
 */
public class ReadWriteLockDemo {
    public static void main(String[] args) {

        ReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();

        //写锁
        reentrantReadWriteLock.writeLock().lock();
        //线程向集合中写入数据
        reentrantReadWriteLock.writeLock().unlock();

        //读锁
        reentrantReadWriteLock.readLock().lock();
        //线程向集合中读取数据
        reentrantReadWriteLock.readLock().unlock();

    }
}
