package com.example.demo1.learn.collection.list;
import java.util.*;
/**
 * Created by zhouli on 18/5/2
 * Email 2565510046@qq.com
 * wechat qianchaoshushui
 */
//
//        add(E e):                     在数组末尾添加元素
//        size():                           数组中实际元素个数，并不是数组容量
//        add(int index, E e):    在数组指定位置添加元素
//        clear():                         将数组中元素清空
//        contains(E e):             判断数组中是否含有某个元素
//        get(int index):             返回数组指定位置的元素
//        indexOf(E e):              返回数组指定元素第一次出现的位置
//        set(int index, E e):     替换数组指定位置的值
//        remove(int index):     移除数组指定位置的元素
//        remove(E e):              移除数组中第一次出现的指定元素
//        addAll(Collection<? extends E> c):                     在数组末尾添加另一个数组
//        addAll(int index, collection<? extends E> c):     在数组指定位置添加另一个数组
//        removeAll(Collection<?>c):                                   将数组中属于数组 c 中的元素全部删除
//

public class ArrayListTest {

    //两个内部类
    class Human{
    }

    class Male extends Human{
    }

    public static void main(String[] args) {
        ArrayList<Integer> list1=new ArrayList<Integer>();
        list1.add(1); // Appends the specified element to the end of this list
        list1.add(2);
        list1.add(3);
        System.out.println(list1.size());
        System.out.println(list1);

        list1.add(2,4); // Inserts the specified element at the specified position in this list
        System.out.println(list1);

        list1.clear(); // Removes all of the elements from this list
        System.out.println(list1);

        list1.add(5);
        ArrayList<Integer> list2=new ArrayList<Integer>();
        list2.add(1);
        list2.add(2);
        list2.add(3);
        list2.addAll(list1); // Appends all of the elements in the specified collection to the end of this list
        System.out.println(list2);

        System.out.println(list2.contains(5)); // Judge if this list contains the specified element
        System.out.println(list2.get(2)); // Returns the element at the specified position in this list
        System.out.println(list2.indexOf(5)); // Returns the index of the first occurrence of the specified element, or -1 if this list doesn't contain

        list2.set(2, 10); // Replaces the element at the specified position in this list with the specified element
        System.out.println(list2);

        list2.remove(2); // Removes the element at the specified position in this list
        System.out.println(list2);
        list2.remove(Integer.valueOf(1)); // Removes the first occurrence of the specified element from this list, if it is present
        System.out.println(list2);
        list2.removeAll(Arrays.asList(5)); // Removes from this list all of its elements that are contained in the specified collection
    }
}
