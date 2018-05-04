package com.example.demo1.database.controller;

/**
 * Created by zhouli on 18/5/4
 * Email 2565510046@qq.com
 * wechat qianchaoshushui
 */

import java.util.ArrayList;
import java.util.List;

import com.example.demo1.database.model.User2;
import com.example.demo1.database.service.User2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class User2Controller {
    @Autowired
    private User2Service user2Service;

    @RequestMapping("/getRedis")
    public String getRedis() {
        String string2 = "zouyunke111111";
        return string2;
    }

    @RequestMapping("/findByNameAndPasswordAndId")
    public User2 findByNameAndPassword() {
        User2 user2 = user2Service.findByNameAndPasswordAndId("zouyunke122", "zouyunke122", 3);
        //User2 user2=user2Service.findByNameAndPwdAndId("zouyunke", "yunke123",1);
        return user2;
    }

    @RequestMapping("/saveUser2")
    public List<User2> saveUser2() {
        List<User2> user3 = new ArrayList<User2>();
        for (int i = 0; i < 10; i++) {
            User2 user2 = new User2("zouyunke12" + i, "zouyunke12" + i);
            user3.add(user2);
        }
        for (User2 user2 : user3) {
            User2 user = user2Service.save(user2);
        }
        //User2 user2=user2Service.findByNameAndPwdAndId("zouyunke", "yunke123",1);
        return user2Service.findAll();
    }

    @RequestMapping("/updateUser2")
    public User2 updateUser2() {
        User2 user2 = new User2();
        user2.setId(1);
        user2.setName("zhaodanya");
        user2.setPassword("123");
        return user2Service.save(user2);
    }


    @RequestMapping("/deleteUser2")
    public void deleteUser2() {
        User2 user2 = new User2();
        user2.setId(3);
        user2.setName("zouyunke120");
        user2.setPassword("zouyunke120");
        user2Service.delete(user2);
    }

    @RequestMapping(value = "/pageUser2")
    public Page<User2> pageUser2() {
        Sort sort = new Sort(Sort.Direction.ASC, "id");
        Pageable pageable = new PageRequest(2, 6, sort);
        Page<User2> page = user2Service.findAll(pageable);
        return page;
    }
}
