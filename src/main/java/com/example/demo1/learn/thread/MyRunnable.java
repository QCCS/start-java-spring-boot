package com.example.demo1.learn.thread;

/**
 * Created by zhouli on 18/5/3
 * Email 2565510046@qq.com
 * wechat qianchaoshushui
 */
/*
 * 实现Runnable接口的步骤：
 * A:定义类MyRunnable实现接口Runnable
 * B:重写run()方法
 * C:创建MyRunnable的对象
 * D:创建Thread类的对象，并把C步骤的对象作为构造参数传递
 * E:启动线程
 *
 * 有了继承Thread类的方式，为什么还要有实现Runnable接口的方式?
 * 原因是因为类是单继承。
 */
public class MyRunnable implements Runnable {

    @Override
    public void run() {
        for (int x = 0; x < 11; x++) {
            System.out.println(Thread.currentThread().getName() + ":" + x);
        }
    }

}
