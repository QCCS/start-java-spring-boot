package com.example.demo1.learn.thread;

/**
 * Created by zhouli on 18/5/3
 * Email 2565510046@qq.com
 * wechat qianchaoshushui
 */
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyThreadYield extends Thread {
    public MyThreadYield() {
    }

    //可以设置线程名称
    public MyThreadYield(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int x = 0; x < 10; x++) {
            System.out.println(getName() + ":" + x);
            //让其他线程执行
            Thread.yield();
        }
    }
}