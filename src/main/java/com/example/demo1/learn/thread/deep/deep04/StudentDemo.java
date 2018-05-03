package com.example.demo1.learn.thread.deep.deep04;

/*
 * 我们针对学生可以设置学生的属性，也可以获取学生的属性。这里我们就把设置看成是生产，获取看成是消费就可以了。
 * 基本的类：
 * 		学生类
 * 		设置属性的线程
 * 		获取属性的线程
 * 		测试类
 * 
 * 问题1：写了一些简单的代码后，我们发现数据有问题，是null---0
 * 原因:
 * 		我们设置的对象和获取的对象不是同一个，所以，拿不到值
 * 解决：
 * 		把设置和获取的对象变成同一个
 * 
 * 为了让效果更好一些，我们给了两组不同的值。并用循环模拟。
 * 这次，效果好点了，但是又出现了新的问题
 * 问题2:
 * 		A:相同的数据出现了多次
 * 			CPU的一点点时间就足够我们执行很多次
 * 		B:数据对应出现了问题
 * 			林青霞 31
 * 			刘意	28
 * 
 * 			线程的随机性
 * 
 * 回想一个问题：线程安全问题
 * 		A:多线程环境	是
 * 		B:共享数据		s对象
 * 		C:多条语句操作共享数据		有
 * 
 * 解决线程安全问题,怎么解决呢?
 * 		上锁。同步代码块。
 * 		注意：
 * 			A:不同种类的线程操作的时候，要加锁，同时都要加。
 * 			B:不但同时加锁，还要求锁是同一把
 */
public class StudentDemo {
	public static void main(String[] args) {
		// 创建一个学生资源
		Student s = new Student();

		// 创建线程对象
		SetThread st = new SetThread(s);
		GetThread gt = new GetThread(s);

		Thread t1 = new Thread(st);
		Thread t2 = new Thread(gt);

		t1.start();
		t2.start();
	}
}
