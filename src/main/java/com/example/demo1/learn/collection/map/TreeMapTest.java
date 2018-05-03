package com.example.demo1.learn.collection.map;
import java.util.*;

/**
 * Created by zhouli on 18/5/2
 * Email 2565510046@qq.com
 * wechat qianchaoshushui
 */
//Entry<K, V>                ceilingEntry(K key)
//K                          ceilingKey(K key)
//void                       clear()
//Object                     clone()
//Comparator<? super K>      comparator()
//boolean                    containsKey(Object key)
//NavigableSet<K>            descendingKeySet()
//NavigableMap<K, V>         descendingMap()
//Set<Entry<K, V>>           entrySet()
//Entry<K, V>                firstEntry()
//K                          firstKey()
//Entry<K, V>                floorEntry(K key)
//K                          floorKey(K key)
//V                          get(Object key)
//NavigableMap<K, V>         headMap(K to, boolean inclusive)
//SortedMap<K, V>            headMap(K toExclusive)
//Entry<K, V>                higherEntry(K key)
//K                          higherKey(K key)
//boolean                    isEmpty()
//Set<K>                     keySet()
//Entry<K, V>                lastEntry()
//K                          lastKey()
//Entry<K, V>                lowerEntry(K key)
//K                          lowerKey(K key)
//NavigableSet<K>            navigableKeySet()
//Entry<K, V>                pollFirstEntry()
//Entry<K, V>                pollLastEntry()
//V                          put(K key, V value)
//V                          remove(Object key)
//int                        size()
//SortedMap<K, V>            subMap(K fromInclusive, K toExclusive)
//NavigableMap<K, V>         subMap(K from, boolean fromInclusive, K to, boolean toInclusive)
//NavigableMap<K, V>         tailMap(K from, boolean inclusive)
//SortedMap<K, V>            tailMap(K fromInclusive)

/**
 * @desc TreeMap测试程序
 * @author skywang
 */
public class TreeMapTest  {
    public static void main(String[] args) {
        // 测试常用的API
//        testTreeMapOridinaryAPIs();
        // 测试TreeMap的子Map函数
//        testSubMapAPIs();
        // 测试TreeMap的导航函数
        testNavigableMapAPIs();
    }
    /**
     * 测试常用的API
     */
    private static void testTreeMapOridinaryAPIs() {
        // 初始化随机种子
        Random r = new Random();
        // 新建TreeMap
        TreeMap tmap = new TreeMap();
        // 添加操作
        tmap.put("one", r.nextInt(10));
        tmap.put("two", r.nextInt(10));
        tmap.put("three", r.nextInt(10));

        System.out.println(" ---- testTreeMapOridinaryAPIs ----");
        // 打印出TreeMap
        System.out.println(tmap);

        // 通过Iterator遍历key-value
        Iterator iter = tmap.entrySet().iterator();
        while(iter.hasNext()) {
            Map.Entry entry = (Map.Entry)iter.next();
            System.out.println("next : - " + entry.getKey() + entry.getValue());
        }

        // TreeMap的键值对个数
        System.out.println("size: "+ tmap.size());

        // containsKey(Object key) :是否包含键key
        System.out.println("contains key two : " + tmap.containsKey("two"));
        System.out.println("contains key five : " + tmap.containsKey("five"));

        // containsValue(Object value) :是否包含值value
        System.out.println("contains value 0 : " + tmap.containsValue(new Integer(0)));

        // remove(Object key) ： 删除键key对应的键值对
        tmap.remove("three");
        System.out.println("tmap:"+tmap );
        // clear() ： 清空TreeMap
        tmap.clear();
        // isEmpty() : TreeMap是否为空
        System.out.println((tmap.isEmpty() ? "TreeMap为空" : "TreeMap不是空") );
    }
    /**
     * 测试TreeMap的子Map函数（节点下面的子节点）
     *
     */
    public static void testSubMapAPIs() {
        // 新建TreeMap
        TreeMap tmap = new TreeMap();
        // 添加“键值对”
        tmap.put("a", 101);
        tmap.put("b", 102);
        tmap.put("c", 103);
        tmap.put("d", 104);
        tmap.put("e", 105);

        System.out.println(" ---- testSubMapAPIs ----");
        // 打印出TreeMap
        System.out.println("tmap:"+ tmap);

        // 测试 headMap(K toKey)
        System.out.println("tmap.headMap(c):"+ tmap.headMap("c"));
        // 测试 headMap(K toKey, boolean inclusive)
        System.out.println("tmap.headMap(c, true):"+ tmap.headMap("c", true));
        System.out.println("tmap.headMap(c, false):"+ tmap.headMap("c", false));

        // 测试 tailMap(K fromKey)
        System.out.println("tmap.tailMap(c):"+ tmap.tailMap("c"));
        // 测试 tailMap(K fromKey, boolean inclusive)
        System.out.println("tmap.tailMap(c, true):"+ tmap.tailMap("c", true));
        System.out.println("tmap.tailMap(c, false):"+ tmap.tailMap("c", false));

        // 测试 subMap(K fromKey, K toKey)
        System.out.println("tmap.subMap(a, c):"+ tmap.subMap("a", "c"));
        // 测试
        System.out.println("tmap.subMap(a, true, c, true):"+
                tmap.subMap("a", true, "c", true));
        System.out.println("tmap.subMap(a, true, c, false):"+
                tmap.subMap("a", true, "c", false));
        System.out.println("tmap.subMap(a, false, c, true):"+
                tmap.subMap("a", false, "c", true));
        System.out.println("tmap.subMap(a, false, c, false):"+
                tmap.subMap("a", false, "c", false));

        // 测试 navigableKeySet()
        System.out.println("tmap.navigableKeySet():"+ tmap.navigableKeySet());
        // 测试 descendingKeySet()
        System.out.println("tmap.descendingKeySet():"+ tmap.descendingKeySet());
    }
    /**
     * 测试TreeMap的导航函数
     */
    public static void testNavigableMapAPIs() {
        // 新建TreeMap
        NavigableMap nav = new TreeMap();
        // 添加“键值对”
        nav.put("aaa", 111);
        nav.put("bbb", 222);
        nav.put("eee", 333);
        nav.put("ccc", 555);
        nav.put("ddd", 444);

        System.out.println(" ---- testNavigableMapAPIs ----");
        // 打印出TreeMap
        System.out.println("Whole list:" + nav);

        // 获取第一个key、第一个Entry
        System.out.println("First key: sFirst entry: " + nav.firstKey() + nav.firstEntry());

        // 获取最后一个key、最后一个Entry
        System.out.println("Last key: sLast entry: " + nav.lastKey() + nav.lastEntry());

        // 获取“小于/等于bbb”的最大键值对
        System.out.println("Key floor before bbb: " + nav.floorKey("bbb"));

        // 获取“小于bbb”的最大键值对
        System.out.println("Key lower before bbb: " + nav.lowerKey("bbb"));

        // 获取“大于/等于bbb”的最小键值对
        System.out.println("Key ceiling after ccc: " + nav.ceilingKey("bbb"));

        // 获取“大于bbb”的最小键值对
        System.out.println("Key higher after ccc: " + nav.higherKey("bbb"));
    }

}
