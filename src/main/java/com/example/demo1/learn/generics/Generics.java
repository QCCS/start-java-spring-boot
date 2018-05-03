package com.example.demo1.learn.generics;

/**
 * Created by zhouli on 18/5/3
 * Email 2565510046@qq.com
 * wechat qianchaoshushui
 * 泛型
 */
public class Generics {
    //内部类
    public class Box1 {
        //name只能是字符串
        private String name;

        public void set(String name) {
            this.name = name;
        }

        public String get() {
            return name;
        }
    }

    //使用泛型类
    //<T>类型的参数
    public class Box2<T> {
        // T代表类型
        //可以传入类型
        private T t;

        public void set(T t) {
            this.t = t;
        }

        public T get() {
            return t;
        }
    }

    //泛型方法：在GenericeTest中测试
    public static <K, V> boolean compare(Pair<K, V> p1, Pair<K, V> p2) {
        return p1.getKey().equals(p2.getKey()) && p1.getValue().equals(p2.getValue());
    }
    //泛型类：在GenericeTest中测试
    public class Pair<K, V> {
        private K key;
        private V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }
}
