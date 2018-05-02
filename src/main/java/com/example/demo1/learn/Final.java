package com.example.demo1.learn;

//关于final关键字
public final class Final {
    //1.经常与static连用，定义常量
    //final变量是只读的
    public static final String ADDRESS = "China.ShangHai";

    public void setAddress(String address){
        //final变量是只读的
        //this.ADDRESS = address;
    }
    //2.final方法，代表不能在子类重写(会报错)
    public final String getName(){
        return "personal address";
    }
    //3.final类，不能被继承
    //4.final修饰的成员变量，必须初始化值，不然报错
    //5.final类不可能是abstract的

    //6.final修饰集合类变量，代表地址不能改变，但是里面的元素可以删除，添加
}
