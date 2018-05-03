package com.example.demo1.learn.generics;

/**
 * Created by zhouli on 18/5/3
 * Email 2565510046@qq.com
 * wechat qianchaoshushui
 */
public class GenericsTest {
    public static void main(String[] args) {
        Generics generics = new Generics();
        //实例内部类
        Generics.Pair<Integer, String> p1 = generics.new Pair<>(1, "apple");
        Generics.Pair<Integer, String> p2 = generics.new Pair<>(1, "apple");
        Generics.Pair<Integer, String> p3 = generics.new Pair<>(2, "pear");
        //使用静态方法
        boolean same = Generics.compare(p1, p2);
        boolean same1 = Generics.compare(p1, p3);
        System.out.println(same);
        System.out.println(same1);
    }
}
