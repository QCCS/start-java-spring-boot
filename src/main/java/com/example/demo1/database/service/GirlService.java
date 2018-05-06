package com.example.demo1.database.service;

import com.example.demo1.database.dao.GirlJpaDao;
import com.example.demo1.database.model.Girl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by zhouli on 18/5/5
 * Email 2565510046@qq.com
 * wechat qianchaoshushui
 */
@Service
public class GirlService {

    @Autowired
    private GirlJpaDao girlJpaDao;

    //事物处理，必须同时添加两个女孩
    @Transactional
    public void insertTwo(){

        Girl girl1 = new Girl();
        girl1.setCupSize("第1个");
        girl1.setAge(11);
        girlJpaDao.save(girl1);


        Girl girl2 = new Girl();
        girl2.setCupSize("第2个");
        girl2.setAge(22);
        girlJpaDao.save(girl2);

    }
}
