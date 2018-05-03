package com.example.demo1.learn.collection.list;

import java.util.*;

/**
 * Created by zhouli on 18/5/2
 * Email 2565510046@qq.com
 * wechat qianchaoshushui
 */
//
//add(E e): 在数组末尾添加元素
//size(): z数组中实际元素个数，并不是数组容量
//add(int index, E e): 在数组指定位置添加元素
//clear():  将数组中元素清空
//contains(E e):判断数组中是否含有某个元素
//get(int index):返回数组指定位置的元素
//indexOf(E e):返回数组指定元素第一次出现的位置
//set(int index, E e):替换数组指定位置的值
//remove(int index): 移除数组指定位置的元素
//remove(E e):移除数组中第一次出现的指定元素
//addAll(Collection<? extends E> c):在数组末尾添加另一个数组
//addAll(int index, collection<? extends E> c):在数组指定位置添加另一个数组
//removeAll(Collection<?>c): 将数组中属于数组 c 中的元素全部删除

public class ArrayListTest {

    public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        System.out.println(list1.size());
        System.out.println(list1);

        list1.add(2, 4);
        System.out.println(list1);

        list1.clear();
        System.out.println(list1);

        list1.add(5);
        ArrayList<String> list2 = new ArrayList<String>();
        list2.add("a");
        list2.add("a");
        list2.add("c");

        //类型须一样
        //list1.addAll(list2);
        list2.addAll(list2);
        System.out.println(list2);

        System.out.println(list2.contains(5));
        System.out.println(list2.get(2));
        System.out.println(list2.indexOf(5));

        list2.set(2, "d");
        System.out.println(list2);

        list2.remove(2);
        System.out.println(list2);
        list2.remove(Integer.valueOf(1));
        System.out.println(list2);
        list2.removeAll(Arrays.asList(5));

        //所有的类型都是对象
        ArrayList os = new ArrayList();
        os.add("a");
        ArrayList os2 = new ArrayList();
        os2.add(1);
        os.addAll(os2);
        System.out.println(os);

    }
}
