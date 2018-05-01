package com.example.demo1.learn;

/**
 * Created by zhouli on 18/5/1.
 * 测试static关键字
 */
public class StaticTest {
    public static void main(String[] args) {
        System.out.println(Static.name);

        //构造方法不能调用,这么看来,不是静态方法
        //System.out.println(Static.Static);

        //只能访问静态成员或静态方法,其他只能创建类之后才能访问
        //System.out.println(Static.age);
        Static static1 = new Static("male", 1);
        System.out.println(static1.age);
        Static static2 = new Static("male", 1);

        //静态成员在所以实例对象中共享
        static1.setNation("China");
        System.out.println(static1.nation == static2.nation);
        static2.setNation("UK");
        System.out.println(static1.nation == static2.nation);

    }
}
