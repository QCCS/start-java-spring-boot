package com.example.demo1.learn.thread;

/**
 * Created by zhouli on 18/5/3
 * Email 2565510046@qq.com
 * wechat qianchaoshushui
 */
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyThreadKill extends Thread {
    public MyThreadKill() {
    }

    //可以设置线程名称
    public MyThreadKill(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println("开始执行："
                + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
                .format(new Date()));

        try {
            // 亲，不要打扰我，我要休息10秒
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            // e.printStackTrace();
            System.out.println("我被杀死了");
        }

        System.out.println("结束执行："
                + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
                .format(new Date()));
    }
}