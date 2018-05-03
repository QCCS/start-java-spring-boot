##泛型


在Java中不允许创建泛型数组，类似下面这样的做法编译器会报错：

```
List<Integer>[] arrayOfLists = new List<Integer>[2];  // compile-time error
```