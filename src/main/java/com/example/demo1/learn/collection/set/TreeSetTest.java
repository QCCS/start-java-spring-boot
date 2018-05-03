package com.example.demo1.learn.collection.set;

import java.util.*;

/**
 * Created by zhouli on 18/5/2
 * Email 2565510046@qq.com
 * wechat qianchaoshushui
 */
//boolean       add(E object)
//boolean       addAll(Collection<? extends E> collection)
//void           clear()
//Object         clone()
//boolean        contains(Object object)
//E             first()
//boolean        isEmpty()
//E             last()
//E             pollFirst()
//E             pollLast()
//E             lower(E e)
//E             floor(E e)
//E             ceiling(E e)
//E             higher(E e)
//boolean       remove(Object object)
//int            size()
//Comparator<? super E>   comparator()
//Iterator<E>        iterator()
//Iterator<E>        descendingIterator()
//SortedSet<E>       headSet(E end)
//NavigableSet<E>      descendingSet()
//NavigableSet<E>      headSet(E end, boolean endInclusive)
//SortedSet<E>       subSet(E start, E end)
//NavigableSet<E>      subSet(E start, boolean startInclusive, E end, boolean endInclusive)
//NavigableSet<E>      tailSet(E start, boolean startInclusive)
//SortedSet<E>       tailSet(E start)
// TreeSet的API测试
public class TreeSetTest {

    public static void main(String[] args) {
        testTreeSetAPIs();
    }

    // 测试TreeSet的api
    public static void testTreeSetAPIs() {
        String val;
        // 新建TreeSet
        TreeSet tSet = new TreeSet();
        // 将元素添加到TreeSet中
        tSet.add("aaa");
        // Set中不允许重复元素，所以只会保存一个“aaa”
        tSet.add("aaa");
        tSet.add("bbb");
        tSet.add("eee");
        tSet.add("ddd");
        tSet.add("ccc");
        System.out.println("TreeSet:" + tSet);

        // 打印TreeSet的实际大小
        System.out.println("size : " + tSet.size());

        // 导航方法
        // floor(小于、等于)
        System.out.println("floor bbb: " + tSet.floor("bbb"));
        //        // lower(小于)
        System.out.println("lower bbb: " + tSet.lower("bbb"));
        // ceiling(大于、等于)
        System.out.println("ceiling bbb: " + tSet.ceiling("bbb"));
        System.out.println("ceiling eee: " + tSet.ceiling("eee"));
        // ceiling(大于)
        System.out.println("higher bbb: " + tSet.higher("bbb"));
        // subSet()
        System.out.println("subSet(aaa, true, ccc, true): " + tSet.subSet("aaa", true, "ccc", true));
        System.out.println("subSet(aaa, true, ccc, false): " + tSet.subSet("aaa", true, "ccc", false));
        System.out.println("subSet(aaa, false, ccc, true): " + tSet.subSet("aaa", false, "ccc", true));
        System.out.println("subSet(aaa, false, ccc, false): " + tSet.subSet("aaa", false, "ccc", false));
        // headSet()
        System.out.println("headSet(ccc, true): " + tSet.headSet("ccc", true));
        System.out.println("headSet(ccc, false): " + tSet.headSet("ccc", false));
        // tailSet()
        System.out.println("tailSet(ccc, true): " + tSet.tailSet("ccc", true));
        System.out.println("tailSet(ccc, false): " + tSet.tailSet("ccc", false));


        // 删除“ccc”
        tSet.remove("ccc");
        // 将Set转换为数组
        String[] arr = (String[]) tSet.toArray(new String[0]);
        for (String str : arr)
            System.out.println("for each : " + str);

        // 打印TreeSet
        System.out.println("TreeSet:" + tSet);

        // 遍历TreeSet
        for (Iterator iter = tSet.iterator(); iter.hasNext(); ) {
            System.out.println("Iterator : " + iter.next());
        }

        // 删除并返回第一个元素
        val = (String) tSet.pollFirst();
        System.out.println("pollFirst= , set=" + val + tSet);

        // 删除并返回最后一个元素
        val = (String) tSet.pollLast();
        System.out.println("pollLast= , set=" + val + tSet);
        // 清空HashSet
        tSet.clear();
        // 输出HashSet是否为空
        System.out.println(tSet.isEmpty() ? "set is empty" : "set is not empty");
    }
}
