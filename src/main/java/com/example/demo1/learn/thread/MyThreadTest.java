package com.example.demo1.learn.thread;

/**
 * Created by zhouli on 18/5/3
 * Email 2565510046@qq.com
 * wechat qianchaoshushui
 */
public class MyThreadTest {
    public static void main(String[] args) {
//        test0();
//        test1();
//        test2();
//        test3();
//        test4();
//        test5();
//        test6();
//        test7();
//        test8();
//        testMovieTicket();
//        testMovieTicketSecurity();
        MovieTicketSecurityAbosolute();
    }
    //synchronized解决线程安全
    //由于是三个线程还会出现超买
    public static void MovieTicketSecurityAbosolute(){
        // 创建一个票资源
        MovieTicketSecurityAbosolute mt = new MovieTicketSecurityAbosolute();

        // 创建三个线程
        Thread t1 = new Thread(mt, "窗口1");
        Thread t2 = new Thread(mt, "窗口2");
        Thread t3 = new Thread(mt, "窗口3");

        t1.start();
        t2.start();
        t3.start();
    }
    //synchronized解决线程安全
    //由于是三个线程还会出现超买
    public static void testMovieTicketSecurity(){
        // 创建三个线程对象
        MovieTicketSecurity mt1 = new MovieTicketSecurity();
        MovieTicketSecurity mt2 = new MovieTicketSecurity();
        MovieTicketSecurity mt3 = new MovieTicketSecurity();

        mt1.setName("窗口1");
        mt2.setName("窗口2");
        mt3.setName("窗口3");

        mt1.start();
        mt2.start();
        mt3.start();
    }
    //为什么会有这样的问题产生呢?什么情况下会产生线程安全问题呢?
    // * A:多线程环境
    // * B:有共享数据
    // * C:多条语句操作共享数据
    //三个进程（三个窗口）销售10张电影票
    public static void testMovieTicket(){
        // 创建三个线程对象
        MovieTicket mt1 = new MovieTicket();
        MovieTicket mt2 = new MovieTicket();
        MovieTicket mt3 = new MovieTicket();

        mt1.setName("窗口1");
        mt2.setName("窗口2");
        mt3.setName("窗口3");

        mt1.start();
        mt2.start();
        mt3.start();
    }
    //实现Runnable接口
    public static void test8(){
        // 创建MyRunnable的对象
        MyRunnable my = new MyRunnable();

        // 创建Thread类的对象，并把C步骤的对象作为构造参数传递
        // Thread(Runnable target)
        // Thread(Runnable target, String name)
        Thread t1 = new Thread(my, "线程1");
        Thread t2 = new Thread(my, "线程2");

        // 启动线程
        t1.start();
        t2.start();
    }
    /*
     * public static void yield():礼让线程,暂停当前正在执行的线程对象，并执行其他线程。
     */
    public static void test7(){
        MyThreadYield mt1 = new MyThreadYield("线程1");
        MyThreadYield mt2 = new MyThreadYield("线程2");
        MyThreadYield mt3 = new MyThreadYield("线程3");
        //相互礼让线程
        mt1.start();
        mt2.start();
        //当只有两个线程的时候，可以看出礼让效果
        //mt3.start();
    }
    /*
     * 线程休眠
     */
    public static void test6(){
        MyThreadSleep mt1 = new MyThreadSleep("线程1");
        MyThreadSleep mt2 = new MyThreadSleep("线程2");
        //执行一次休眠一次
        mt1.start();
        mt2.start();
    }
    /*
     * 中断线程
     *		public final void stop():直接死
     *		public void interrupt():死后还可以写遗嘱
     */
    public static void test5(){
        MyThreadKill mt1 = new MyThreadKill("线程1");
        mt1.start();
        // 这个线程会休息10秒，在休息的时候，杀死
        // 假设我三秒就不让让你再执行了，必须让你死去
        try {
            Thread.sleep(3000);
            // mt1.stop();
            mt1.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    //等待该线程终止
    //public final void join()
    public static void test4(){
        MyThread mt1 = new MyThread("线程1");
        MyThread mt2 = new MyThread("线程2");
        mt2.start();
        try {
            mt2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        mt1.start();
    }
    //守护进程
    public static void test3(){
        MyThread mt1 = new MyThread("线程1");
        MyThread mt2 = new MyThread("线程2");
        // 设置守护线程
        mt1.setDaemon(true);
        mt2.setDaemon(true);
        mt1.start();
        mt2.start();
        System.out.println("主线程:"+Thread.currentThread().getName());
    }
    //设置优先级
    public static void test2(){
        // java采用的是抢占式调度模型：谁优先级高谁先执行，当然可以设置优先级
        // java是如何获取和设置线程的优先级呢?
        // 我们现在并没有给出每个线程的优先级，但是，它一样可以跑。说明了，它应该是有默认优先级。
        // public final int getPriority():返回线程的优先级。 通过测试，我们知道线程的默认优先级是5
        // public final void setPriority(int newPriority):更改线程的优先级。 通过查看源码，我们知道线程的优先级范围是：1-10。默认是5
        // 线程的优先级高，不代表一定会先执行完毕。只有在次数特别多的情况下，才能体现出来。

        MyThread mt1 = new MyThread("线程1");
        MyThread mt2 = new MyThread("线程2");
        MyThread mt3 = new MyThread("线程3");
        System.out.println("默认优先级："+mt2.getPriority());
        mt1.setPriority(10);
        mt3.setPriority(1);
        mt1.start();
        mt2.start();
        mt3.start();
    }

    //可以设置线程名称
    public static void test1(){
        // 创建子类对象
        // MyThread mt1 = new MyThread();
        // MyThread mt2 = new MyThread();
        // mt1.run();
        // mt2.run();

        MyThread mt1 = new MyThread("线程1");
        MyThread mt2 = new MyThread("线程2");
        //启动两个线程输出1-100
        mt1.start();
        mt2.start();
        System.out.println("主线程:"+Thread.currentThread().getName());
    }

    public static void test0(){
        MyThread mt1 = new MyThread();
        MyThread mt2 = new MyThread();
        mt1.start();
        mt2.start();
    }


}
