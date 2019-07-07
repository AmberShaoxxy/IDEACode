package com.atguigu.juc;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

*/
/*
List不安全的例子
 *//*

public class NotSaft {
    public static void main(String[] args) {
       // List list = new Vector();
        //  List list = Collections.synchronizedList(new ArrayList<String>());
          List list = new CopyOnWriteArrayList();
        for (int i = 0; i < 50; i++) {
            new Thread(() -> {
                //写入
                list.add(UUID.randomUUID().toString().substring(0, 5));
                //读取
                System.out.println(list);
            }, String.valueOf(i)).start();
        }
    }
}
*/
/*

 */
/*
Set不安全的例子
 *//*


import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArraySet;

public class NotSaft {
    public static void main(String[] args) {
        Set set = new HashSet();
        //Set set =Collections.synchronizedSet(new HashSet<String>());
        //Set set = new CopyOnWriteArraySet();
        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                set.add(UUID.randomUUID().toString().substring(0, 5));
                System.out.println(set);
            }, String.valueOf(i)).start();

        }
    }
}*/

/*
Map不安全的例子
 */
public class NotSaft {
    public static void main(String[] args) {
        Map map = new HashMap<>();
        HashSet set = new HashSet();
       // Map map = new ConcurrentHashMap();
        for (int i = 0; i < 50; i++) {
            new Thread(() -> {
                map.put(Thread.currentThread().getName(), UUID.randomUUID().toString().substring(0, 5));
                System.out.println(map);
            }, String.valueOf(i)).start();
        }
     }
}