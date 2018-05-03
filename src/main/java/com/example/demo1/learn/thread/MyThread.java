package com.example.demo1.learn.thread;

/**
 * Created by zhouli on 18/5/3
 * Email 2565510046@qq.com
 * wechat qianchaoshushui
 */
//通过继承Thread
//A:自定义类MyThread继承自Thread类
//B:重写run()方法
//     因为run()方法封装的代码才是被线程执行的代码。
//C:创建子类对象
//D:启动线程
//      启动线程使用的是那个方法呢?
//      start():启动线程，并自动调用run()方法。
public class MyThread extends Thread {
    public MyThread() {
    }

    //可以设置线程名称
    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        // 重写run方法
        // 要被线程执行的代码，一般来说应该是比较耗时的
        for (int x = 0; x < 10; x++) {
            System.out.println("hello" + x);
            System.out.println("线程名称:"+Thread.currentThread().getName());
        }
    }
}