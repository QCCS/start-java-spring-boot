package com.example.demo1.learn.collection.set;

import java.util.LinkedHashSet;

/**
 * Created by zhouli on 18/5/2
 * Email 2565510046@qq.com
 * wechat qianchaoshushui
 */
public class LinkedHashSetTest {
    /**
     * LinkedHashSet
     * 底层是链表实现的,是set集合中唯一一个能保证怎么存就怎么取的集合对象
     * 因为是HashSet的子类,所以也是保证元素唯一的,与HashSet的原理一样
     */
    public static void main(String[] args) {
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("a");
        linkedHashSet.add("a");
        linkedHashSet.add("a");
        linkedHashSet.add("a");
        linkedHashSet.add("b");
        linkedHashSet.add("c");
        linkedHashSet.add("d");
        System.out.println(linkedHashSet);
    }
}
