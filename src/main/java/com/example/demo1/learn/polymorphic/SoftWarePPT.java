package com.example.demo1.learn.polymorphic;

public class SoftWarePPT extends SoftWare{
    String name;
    int id;
    public SoftWarePPT(String name,int id) {
        super(name);
        this.name = name;
        this.id = id;
    }
    //重写父类方法
    public void showName(){
        System.out.println(this.name);
    }
}
