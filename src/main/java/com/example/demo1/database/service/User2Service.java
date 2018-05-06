package com.example.demo1.database.service;
/**
 * Created by zhouli on 18/5/4
 * Email 2565510046@qq.com
 * wechat qianchaoshushui
 */

import java.util.List;

import com.example.demo1.domain.s.User2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

//先定义用户的curd接口
public interface User2Service {
    User2 findByNameAndPasswordAndId(String name, String password, Integer id);

    User2 save(User2 user2);

    List<User2> findAll();

    int updateNameByPassword(String name, String password);

    //Page<User2> findAll(PageRequest pageRequest);
    Page<User2> findAll(Pageable pageable);

    //删除用户
    void delete(User2 entity);
}
