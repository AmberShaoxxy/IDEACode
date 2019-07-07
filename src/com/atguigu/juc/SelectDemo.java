package com.atguigu.juc;


import java.util.ArrayList;
import java.util.List;

class User{

    private Integer id;
    private String  username;
    private int     age;

    public User(Integer id, String username, int age) {
        this.id = id;
        this.username = username;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", age=" + age +
                '}';
    }
}


public class SelectDemo {
    public static void main(String[] args) {
        List list =new ArrayList<>();
        User u1 = new User(11,"a",23);
        User u2 = new User(12,"b",24);
        User u3 = new User(13,"c",22);
        User u4 = new User(14,"d",28);
        User u5 = new User(16,"e",26);

        list.add(u1);
        list.add(u2);
        list.add(u3);
        list.add(u4);
        list.add(u5);

        /**
         * @auther zzyy
         * @create 2019-02-26 22:24
         *
         * 题目：请按照给出数据，找出同时满足以下条件的用户,也即以下条件全部满足
         *      偶数id且年龄大于24且用户名转为大写且用户名字母倒排序
         *      只输出一个用户名字
         */





    }
}
