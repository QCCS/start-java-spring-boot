package com.example.demo1.learn;

/**
 * Created by zhouli on 18/5/1.
 * 静态成员
 * 关于static关键字
 */
public class Static {

    //静态成员
    static String name;
    static String nation;

    String sex;
    int age;

    static public void showName(){

    }


    //getter and setter
    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        Static.name = name;
    }

    public static String getNation() {
        return nation;
    }

    public static void setNation(String nation) {
        Static.nation = nation;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
