package com.example.demo1;

        import com.example.demo1.domain.p.TestRediser;
        import com.example.demo1.domain.p.User;
        import com.example.demo1.domain.p.UserMapper;
        import com.example.demo1.domain.s.Girl;
        import com.example.demo1.database.service.GirlService;
        import org.junit.Assert;
        import org.junit.Test;
        import org.junit.runner.RunWith;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.boot.test.context.SpringBootTest;
        import org.springframework.data.redis.core.RedisTemplate;
        import org.springframework.data.redis.core.StringRedisTemplate;
        import org.springframework.test.annotation.Rollback;
        import org.springframework.test.context.junit4.SpringRunner;

        import java.util.HashMap;
        import java.util.List;
        import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GirlServiceTest {

    @Autowired
    private GirlService girlService;

    @Test
    public void findOneTest() {
        //接口service：从数据库取出id是22的人，比较年纪
        //由于配置了多数源，要分享获取的哪一个数据库
        Girl girl = girlService.findOne(1);
        Assert.assertEquals(new Integer(112), girl.getAge());
    }

    //主要是测试MyBaits
    @Autowired
    private UserMapper userMapper;

    @Test
    @Rollback
    public void testUserMapper() throws Exception {
        // insert一条数据，并select出来验证
        userMapper.insert("AAA", 20,12);
        User u = userMapper.findByName("1");
        Assert.assertEquals(20, u.getAge().intValue());
        // update一条数据，并select出来验证
        u.setAge(30);
        userMapper.update(u);
        u = userMapper.findByName("AAA");
        Assert.assertEquals(30, u.getAge().intValue());
        // 删除这条数据，并select验证
        userMapper.delete(u.getId());
        u = userMapper.findByName("AAA");
        Assert.assertEquals(null, u);

        u = new User("BBB", 30);
        userMapper.insertByUser(u);
        Assert.assertEquals(30, userMapper.findByName("BBB").getAge().intValue());

        Map<String, Object> map = new HashMap<>();
        map.put("name", "CCC");
        map.put("age", 40);
        userMapper.insertByMap(map);
        Assert.assertEquals(40, userMapper.findByName("CCC").getAge().intValue());

        List<User> userList = userMapper.findAll();
        for(User user : userList) {
            Assert.assertEquals(null, user.getId());
            Assert.assertNotEquals(null, user.getName());
        }

    }

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

}
