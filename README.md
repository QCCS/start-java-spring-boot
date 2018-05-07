# start-java-spring-boot
好好学习一下spring-boot;
所以

开始复习java基础知识点

#
###java基础

final,static

泛型

多肽
#
###容器 集合

ArrayList-LinkerList

HashMap-LinkedHashMap-TreeMap

HashSet-linkedHashSet-treeSet

#
###数据结构
各种算法

#
文件操作
file类
#
###线程

继承Thread

实现Runnable接口

线程组-线程池
#
###网页开发
servlet类


#
###数据库
配置依赖

jdbc链接配置

测试类

jpa配置

实体类-DAO类-service-controller
数据的增删改查

#
###切面编程
添加网络拦截器

#
###异常处理

#
###单元测试

#
###多数据源配置

#
###redis
依赖添加
```$xslt
	<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-redis</artifactId>
		</dependency>
```
配置

```$xslt
# REDIS (RedisProperties)
# Redis数据库索引（默认为0）
spring.redis.database=0
# Redis服务器地址
spring.redis.host=localhost
# Redis服务器连接端口
spring.redis.port=6379
# Redis服务器连接密码（默认为空）
spring.redis.password=
# 连接池最大连接数（使用负值表示没有限制）
spring.redis.pool.max-active=8
# 连接池最大阻塞等待时间（使用负值表示没有限制）
spring.redis.pool.max-wait=-1
# 连接池中的最大空闲连接
spring.redis.pool.max-idle=8
# 连接池中的最小空闲连接
spring.redis.pool.min-idle=0
# 连接超时时间（毫秒）
spring.redis.timeout=0
```

添加类

RedisConfig

RedisObjectSerializer

测试redis
```$xslt
 //主要是测试redis
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate<String, TestRediser> redisTemplate;

    @Test
    public void test() throws Exception {

        // 保存字符串
        stringRedisTemplate.opsForValue().set("aaa", "111");
        Assert.assertEquals("111", stringRedisTemplate.opsForValue().get("aaa"));

        // 保存对象
        TestRediser testRediser = new TestRediser("超人", 20);
        redisTemplate.opsForValue().set(testRediser.getUsername(), testRediser);

        testRediser = new TestRediser("蝙蝠侠", 30);
        redisTemplate.opsForValue().set(testRediser.getUsername(), testRediser);

        testRediser = new TestRediser("蜘蛛侠", 40);
        redisTemplate.opsForValue().set(testRediser.getUsername(), testRediser);

        Assert.assertEquals(20, redisTemplate.opsForValue().get("超人").getAge().longValue());
        Assert.assertEquals(30, redisTemplate.opsForValue().get("蝙蝠侠").getAge().longValue());
        Assert.assertEquals(40, redisTemplate.opsForValue().get("蜘蛛侠").getAge().longValue());

    }
```

安装与启动

##https://redis.io/download
```
$ wget http://download.redis.io/releases/redis-4.0.9.tar.gz
$ tar xzf redis-4.0.9.tar.gz
$ cd redis-4.0.9
$ make
安装完毕
-----
启动
$ src/redis-server

最好配置环境变量
------
链接
$ src/redis-cli
redis> set foo bar
OK
redis> get foo
"bar"
```

#
###mybaits
User

UserMapper

```$xslt
package com.example.demo1.domain.p;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

//整合MyBaits  userMapper
@Mapper
@Service
public interface UserMapper {

    @Select("SELECT * FROM user WHERE name = #{name}")
    User findByName(@Param("name") String name);

    @Results({
            @Result(property = "name", column = "name"),
            @Result(property = "age", column = "age")
    })
    @Select("SELECT name, age FROM user")
    List<User> findAll();

    @Insert("INSERT INTO user(name, age, id) VALUES(#{name}, #{age},#{id})")
    int insert(@Param("name") String name, @Param("age") Integer age, @Param("id") Integer id);

    @Update("UPDATE user SET age=#{age} WHERE name=#{name}")
    void update(User user);

    @Delete("DELETE FROM user WHERE id =#{id}")
    void delete(Integer id);

    @Insert("INSERT INTO user(name, age) VALUES(#{name}, #{age})")
    int insertByUser(User user);

    @Insert("INSERT INTO user(name, age) VALUES(#{name,jdbcType=VARCHAR}, #{age,jdbcType=INTEGER})")
    int insertByMap(Map<String, Object> map);
}
```

```$xslt
     userMapper.insert("AAA", 20,11);
     User u = userMapper.findByName("1");
     Assert.assertEquals(20, u.getAge().intValue());
```