package com.example.demo1.learn.thread.deep.deep08;

//线程：把这线程放在线程池里面
public class MyRunnable implements Runnable {
	@Override
	public void run() {
		for (int x = 0; x < 10; x++) {
			System.out.println(Thread.currentThread().getName() + ":" + x);
		}
	}

}
