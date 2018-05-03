package com.example.demo1.learn.thread;

/**
 * Created by zhouli on 18/5/3
 * Email 2565510046@qq.com
 * wechat qianchaoshushui
 */
public class MovieTicket extends Thread {
    // 定义成员变量
    private static int tickets = 10;

    @Override
    public void run() {
        // 定义10张票
        // int tickets = 10;
        while (true) {
            if (tickets > 0) {
                System.out.println(getName() + "正在出售第" + (tickets--) + "张票");
            }
        }
    }
}
