package com.example.demo1.learn;

/**
 * Created by zhouli on 18/5/1.
 * 静态成员
 * 关于static关键字
 * 每一个序号代表一个需要复习的一个知识点
 */
public class Static {

    //静态成员
    //1.在对象没有创建的时候,就可以访问此成员
    static String name = "static";
    //3.静态成员在所以实例对象中共享
    static String nation;

    //4.static代码块,创建类的时候只执行一次,优化程序性能


    String sex;
    int age = 0;

    //构造方法
    public Static(String sex,int age){
        this.sex = sex;
        this.age = age;
    }
    public static void showName(){
        //2.静态方法不能访问非静态成员
        //System.out.println(this.name);
    }

    public void showNation(){
        System.out.println(this.nation);
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
