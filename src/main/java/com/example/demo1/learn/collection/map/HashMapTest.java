package com.example.demo1.learn.collection.map;

import com.example.demo1.learn.MyUtil;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;

/**
 * Created by zhouli on 18/5/2
 * Email 2565510046@qq.com
 * wechat qianchaoshushui
 */
public class HashMapTest {
    String name;
    //内部类
    class Edge {
        public int u;
        public int v;
        public Edge(int u, int v) {
            this.u = u;
            this.v = v;
        }
        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + u;
            result = prime * result + v;
            return result;
        }
        //重写equals，对象比较全等
        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Edge other = (Edge) obj;
            if (u != other.u)
                return false;
            if (v != other.v)
                return false;
            return true;
        }
        @Override
        public String toString() {
            return "Edge [u=" + u + ", v=" + v + "]";
        }

    }
    public static void main(String[] args) {
        //keySet遍历
        listHashMapKeySet();
        //entrySet遍历
        listHashMapEntrySet();

        HashMapTest hashMapTest1 = new HashMapTest();
        hashMapTest1.testObjectMap();

        //打印方法
        MyUtil myUtil = new MyUtil();
        myUtil.printClassMethodMessage(hashMapTest1,true);
        myUtil.printFieldMessage(hashMapTest1,true);
        myUtil.printConMessage(hashMapTest1);
    }
    //效率比较低
    public static void listHashMapKeySet() {
        HashMap hashmap = new HashMap();
        for (int i = 0; i < 10; i++) {
            hashmap.put(i, "thanks");
        }
        long start = Calendar.getInstance().getTimeInMillis();
        //keySet遍历
        Iterator iterator = hashmap.keySet().iterator();
        while (iterator.hasNext()) {
            System.out.println(hashmap.get(iterator.next()));
        }
        long end = Calendar.getInstance().getTimeInMillis();
        System.out.println("迭代输出 ："+ (end - start));
    }
    //对HashMap的遍历：推荐使用
    public static void listHashMapEntrySet() {
        HashMap hashmap = new HashMap();
        for (int i = 0; i < 10; i++) {
            hashmap.put(i, "All right");
        }
        long bs = Calendar.getInstance().getTimeInMillis();
        //entrySet遍历
        Iterator iterator = hashmap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            // entry.getKey() 返回与此项对应的键
            // entry.getValue() 返回与此项对应的值
            System.out.println(entry.getValue());
        }
        System.out.println(Calendar.getInstance().getTimeInMillis() - bs);
    }

    public void testObjectMap() {
        Map<Edge, Integer> map = new HashMap<Edge, Integer>();
        map.put(new Edge(0, 1), 5);
        //key不能一样,不然会覆盖
        //如果要存入一样的key，需要重写key的hashCode（）和map的put（）方法，
        map.put(new Edge(0, 1), 6);
        map.put(new Edge(1, 0), 5);
        //对HashMap的遍历：推荐使用
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Edge, Integer> entry = (Map.Entry) it.next();
            Edge edge = entry.getKey();
            int value = entry.getValue();
            System.out.println(edge.toString() + "," + value);
        }
        System.out.println("=====");
        //效率比较低
        Iterator itkey = map.keySet().iterator();
        while (itkey.hasNext()) {
            Edge edge = (Edge) itkey.next();
            int value = map.get(edge);
            System.out.println(edge + "," + value);
        }

        System.out.println("map.values方式遍历");
        for(Integer value : map.values()){
            System.out.println(value);
        }

        //利用O(1)时间查询指定关键值的值
        Edge find = new Edge(0, 1);
        int weight = map.get(find);
        System.out.println("=====");
        System.out.println(weight);


    }
}
/*

* map.values()//for循环迭代对象值
* map.put(t)//设置
* map.get(t)//取出
* map.containsKey(t)//是否包含
* map.entrySet().iterator()//生成迭代器
* map.keySet().iterator()//生成迭代器
*
* */