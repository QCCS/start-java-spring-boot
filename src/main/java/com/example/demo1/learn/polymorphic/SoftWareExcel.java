package com.example.demo1.learn.polymorphic;

public class SoftWareExcel extends SoftWare{

    String name;
    int id;
    public SoftWareExcel(String name,int id) {
        //1.继承父类，需要调用父类非默认构造器
        //子类不能继承父类的构造器（构造方法或者构造函数）；
        //父类的构造器带有参数的，
        //则必须在子类的构造器中显式地通过super关键字调用父类的构造器并配以适当的参数列表
        super(name);
        this.name = name;
        this.id = id;
    }

    //重写父类方法
    public void showName(){
        System.out.println(this.name);
    }
}
