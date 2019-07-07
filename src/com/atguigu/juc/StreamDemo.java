package com.atguigu.juc;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Users {
    private int id;
    private String userName;
    private int age;

    public Users(int id, String userName, int age) {
        this.id = id;
        this.userName = userName;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", age=" + age +
                '}';
    }
}

/**
 * 题目:找出以下条件全部都满足的用户
 * <p>
 * 1.偶数ID,且年龄大于24
 * 2.用户名转为大写且用户名字母倒排序
 * 3.只输出一个用户名字
 */

public class StreamDemo {
    public static void main(String[] args) {
        Users aa = new Users(1, "aa", 10);
        Users bb = new Users(2, "bb", 25);
        Users cc = new Users(4, "ee", 30);

        List<Users> list = Arrays.asList(aa, bb, cc);

        list.stream().filter(u -> {//Filter表示筛选和过滤,传入断定型接口predicate,u表示集合中的每一个对象user,return中写的是要满足的过滤条件
            return u.getId() % 2 == 0;
        }).filter((u) -> {
            return u.getAge() > 24;
        }).map((u) -> {
            return u.getUserName().toUpperCase();
        }).sorted((o1, o2) -> {
            return o2.compareTo(o1);
        }).limit(1).forEach(System.out::println);

        //forEach(System.out::println);//遍历筛选后的集合,输出满足条件的对象

        List<Integer> list1 = Arrays.asList(1, 2, 3);
        List<Integer> list3 = list1.stream().map((u) -> {
            return u * 2;
        }).collect(Collectors.toList());

        for (Integer i :list3) {
            System.out.println(i);
        }

    }

}
