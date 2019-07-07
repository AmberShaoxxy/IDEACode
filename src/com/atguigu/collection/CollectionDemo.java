package com.atguigu.collection;

public class CollectionDemo {
    public static void main(String[] args) {
        Demo demo = new Demo();
        System.out.println(demo.getClass());
        System.out.println(demo.getClass().getClassLoader());
        System.out.println(demo.getClass().getClassLoader().getParent());
        long maxMemory = Runtime.getRuntime().maxMemory();
        System.out.println(maxMemory);
        long totalMemory = Runtime.getRuntime().totalMemory();
        System.out.println(totalMemory);

    }
}

class Demo{
    public int age;


}