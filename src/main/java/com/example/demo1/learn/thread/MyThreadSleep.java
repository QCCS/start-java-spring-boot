package com.example.demo1.learn.thread;

/**
 * Created by zhouli on 18/5/3
 * Email 2565510046@qq.com
 * wechat qianchaoshushui
 */
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyThreadSleep extends Thread {
    public MyThreadSleep() {
    }

    //可以设置线程名称
    public MyThreadSleep(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int x = 0; x < 10; x++) {
            System.out.println(getName()
                    + ":"
                    + x
                    + "---"
                    + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
                    .format(new Date()));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}