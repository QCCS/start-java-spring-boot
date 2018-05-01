package com.example.demo1.learn.polymorphic;

//软件类
public class SoftWare {
    String name;

    public SoftWare(String name){
        this.name = name;
    }
    public void showName(){
        System.out.println(this.name);
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

}
