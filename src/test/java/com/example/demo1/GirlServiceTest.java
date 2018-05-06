package com.example.demo1;

import com.example.demo1.domain.s.Girl;
import com.example.demo1.database.service.GirlService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GirlServiceTest {

    @Autowired
    private GirlService girlService;

    @Test
    public void findOneTest() {
        //接口service：从数据库取出id是22的人，比较年纪
        Girl girl = girlService.findOne(22);
        Assert.assertEquals(new Integer(112), girl.getAge());
    }
}
