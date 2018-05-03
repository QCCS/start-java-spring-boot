package com.example.demo1.learn.collection.set;

import java.util.Iterator;
import java.util.HashSet;

/**
 * Created by zhouli on 18/5/2
 * Email 2565510046@qq.com
 * wechat qianchaoshushui
 * <p>
 * boolean         add(E object)
 * void            clear()
 * Object          clone()
 * boolean         contains(Object object)
 * boolean         isEmpty()
 * Iterator<E>     iterator()
 * boolean         remove(Object object)
 * int             size()
 */

/*
 * HashSet常用API的使用。
 */
public class HashSetTest {
    public static void main(String[] args) {
        // 新建HashSet
        HashSet set = new HashSet();
        // 添加元素 到HashSet中
        for (int i = 0; i < 5; i++) {
            set.add("" + i);
        }
        // 通过for-each遍历HashSet
        foreachHashSet(set);
        // 通过Iterator遍历HashSet
        iteratorHashSet(set);

        // HashSet常用API
        testHashSetAPIs();
    }

    /*
     * HashSet除了iterator()和add()之外的其它常用API
     */
    private static void testHashSetAPIs() {
        // 新建HashSet
        HashSet set = new HashSet();
        // 将元素添加到Set中
        set.add("a");
        set.add("b");
        set.add("c");
        set.add("d");
        set.add("e");

        // 打印HashSet的实际大小
        System.out.println("size : "+ set.size());

        // 判断HashSet是否包含某个值
        System.out.println("HashSet 是否包含 a :"+ set.contains("a"));
        System.out.println("HashSet 是否包含 g :"+ set.contains("g"));

        // 删除HashSet中的“e”
        set.remove("e");

        // 将Set转换为数组
        String[] arr = (String[]) set.toArray(new String[0]);
        for (String str : arr){
            System.out.println("for each : "+ str);
        }

        // 新建一个包含b、c、f的HashSet
        HashSet otherset = new HashSet();
        otherset.add("b");
        otherset.add("c");
        otherset.add("f");

        // 克隆一个removeset，内容和set一模一样
        HashSet removeset = (HashSet) set.clone();
        // 删除“removeset中，属于otherSet的元素”
        removeset.removeAll(otherset);
        // 打印removeset
        System.out.println("removeset : "+ removeset);

        // 克隆一个retainset，内容和set一模一样
        HashSet retainset = (HashSet) set.clone();
        // 保留“retainset中，属于otherSet的元素”
        retainset.retainAll(otherset);
        // 打印retainset
        System.out.println("retainset : "+ retainset);

        // 遍历HashSet
        for (Iterator iterator = set.iterator(); iterator.hasNext(); ){
            System.out.println("iterator : "+ iterator.next());
        }
        // 清空HashSet
        set.clear();

        // 输出HashSet是否为空
        System.out.println( set.isEmpty() ? "set is empty" : "set is not empty");
    }

    /*
     * 通过Iterator遍历HashSet。推荐方式
     */
    private static void iteratorHashSet(HashSet set) {
        for (Iterator iterator = set.iterator(); iterator.hasNext(); ) {
            System.out.println("iterator : "+ iterator.next());
        }
    }

    /*
     * 通过for-each遍历HashSet。不推荐！此方法需要先将Set转换为数组
     */
    private static void foreachHashSet(HashSet set) {
        String[] arr = (String[]) set.toArray(new String[0]);
        for (String str : arr){
            System.out.println("for each : "+ str);
        }

    }
}
