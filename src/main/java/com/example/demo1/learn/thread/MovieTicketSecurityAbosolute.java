package com.example.demo1.learn.thread;

/**
 * Created by zhouli on 18/5/3
 * Email 2565510046@qq.com
 * wechat qianchaoshushui
 */
//这样才不会超买
public class MovieTicketSecurityAbosolute implements Runnable {
    // 定义10张票
    private static int tickets = 10;
    private int x = 0;

    @Override
    public void run() {
        while (true) {
            if (x % 2 == 0) {
                synchronized (MovieTicket.class) {
                    if (tickets > 0) {
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        System.out.println(Thread.currentThread().getName()
                                + "正在出售第" + (tickets--) + "张票");
                    }
                }
            } else {
                sellTicket();
            }
            x++;
        }
    }

    //同步方法
    private static synchronized void sellTicket() {
        if (tickets > 0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + "正在出售第"
                    + (tickets--) + "张票");
        }
    }
}