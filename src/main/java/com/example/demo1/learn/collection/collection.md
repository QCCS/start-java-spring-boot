Java容器类类库的用途是保存对象，可以将其分为2个概念。

Collection

一个独立元素的序列，这些元素都服从一条或多条规则。
其中List必须按照插入的顺序保存元素、Set不能有重复的元素、
Queue按照排队规则来确定对象的产生顺序（通常也是和插入顺序相同）


1、List（有序、可重复）
List里存放的对象是有序的，同时也是可以重复的，List关注的是索引，
拥有一系列和索引相关的方法，查询速度快。
因为往list集合里插入或删除数据时，会伴随着后面数据的移动，所有插入删除数据速度慢。

2、Set（无序、不能重复）
Set里存放的对象是无序，不能重复的，集合中的对象不按特定的方式排序，
只是简单地把对象加入集合中。

3、Map（键值对、键唯一、值不唯一）
Map集合中存储的是键值对，键不能重复，值可以重复。根据键得到值，
对map集合遍历时先得到键的set集合，对set集合进行遍历，得到相应的值。
一组成对的值键对对象，允许用键来查找值。
ArrayList允许我们用数字来查找值，它是将数字和对象联系在一起。
而Map允许我们使用一个对象来查找某个对象，它也被称为关联数组。或者叫做字典。