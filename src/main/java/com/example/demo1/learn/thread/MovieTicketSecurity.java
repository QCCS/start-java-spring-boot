package com.example.demo1.learn.thread;

/**
 * Created by zhouli on 18/5/3
 * Email 2565510046@qq.com
 * wechat qianchaoshushui
 */
public class MovieTicketSecurity extends Thread {
    // 定义成员变量
    private static int tickets = 10;
    @Override
    public void run() {
        // 定义10张票
        // int tickets = 10;
        while (true) {
            // t1,t2,t3
            // t1过来了，看到了同步代码块的锁标记，绿色标记(火车上厕所，过马路的红绿灯)
            // t2,t3都只能在这里傻傻的等待

            synchronized (this) {
                // t1就进来了，立马修改标记为红色标记
                //线程安全了？但是由于线程很多，tickets > 0就进入程序还是有超买的问题
                if (tickets > 0) {
                    // 更符合现实情况
                    try {
                        Thread.sleep(100); // t1休息会
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName()
                            + "正在出售第" + (tickets--) + "张票");
                }
            }
            // t1出来了，立马修改标记为绿色标记
        }
    }
}
