package com.example.demo1.database.service;

import com.example.demo1.domain.s.GirlJpaDao;
import com.example.demo1.domain.s.Girl;
import com.example.demo1.enums.ResultEnum;
import com.example.demo1.exception.GirlException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
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

    public void getAge(Integer id) throws Exception{
        Girl girl =  findOne(id);
        Integer age = girl.getAge();
        if (age < 10) {
            //返回"你还在上小学吧" code=100
            throw new GirlException(ResultEnum.PRIMARY_SCHOOL);
        }else if (age > 10 && age < 16) {
            //返回"你可能在上初中" code=101
            throw new GirlException(ResultEnum.MIDDLE_SCHOOL);
        }

        //如果>16岁,加钱
        //...
    }

    /**
     * 通过Id查询一个女生的信息
     * @param id
     * @return
     */
    public Girl findOne(Integer id) {
        //下面写法不行了
        //return girlJpaDao.findOne(id);
        Girl girl = new Girl();
        girl.setId(id);
        Example<Girl> girlExample = Example.of(girl);
        return girlJpaDao.findOne(girlExample).orElse(null);
    }
}
