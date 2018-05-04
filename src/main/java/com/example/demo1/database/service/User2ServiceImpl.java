package com.example.demo1.database.service;

/**
 * Created by zhouli on 18/5/4
 * Email 2565510046@qq.com
 * wechat qianchaoshushui
 */

import java.util.List;

import com.example.demo1.database.dao.User2JpaDao;
import com.example.demo1.database.model.User2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class User2ServiceImpl implements User2Service {
    @Autowired
    private User2JpaDao user2JpaDao;

    @Override
    public User2 findByNameAndPasswordAndId(String name, String password, Integer id) {
        // TODO Auto-generated method stub
        return user2JpaDao.findByNameAndPasswordAndId(name, password, id);
    }

    @Override
    public User2 save(User2 user2) {
        // TODO Auto-generated method stub
        return user2JpaDao.save(user2);
    }

    @Override
    public List<User2> findAll() {
        // TODO Auto-generated method stub
        return user2JpaDao.findAll();
    }

    @Override
    public int updateNameByPassword(String name, String password) {
        // TODO Auto-generated method stub
        return user2JpaDao.updateNameByPassword(name, password);
    }

    @Override
    public void delete(User2 entity) {
        // TODO Auto-generated method stub
        user2JpaDao.delete(entity);
    }

    @Override
    public Page<User2> findAll(Pageable pageable) {
        // TODO Auto-generated method stub
        return user2JpaDao.findAll(pageable);
    }
}