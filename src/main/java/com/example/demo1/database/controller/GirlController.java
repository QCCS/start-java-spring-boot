package com.example.demo1.database.controller;

import com.example.demo1.database.dao.GirlJpaDao;
import com.example.demo1.database.model.Girl;
import com.example.demo1.database.model.Result;
import com.example.demo1.database.service.GirlService;
import com.example.demo1.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by zhouli on 18/5/5
 * Email 2565510046@qq.com
 * wechat qianchaoshushui
 */
@RestController
public class GirlController {

    @Autowired
    private GirlJpaDao girlJpaDao;

    @Autowired
    private GirlService girlService;
    //新增post
//    @PostMapping(value = "/girls")
    @GetMapping(value = "/girls1")
    public Girl girlAdd(@RequestParam("cupSize") String cupSize,
                        @RequestParam("age") Integer age,
                        @RequestParam("money") Double money) {
        Girl girl = new Girl();
        girl.setCupSize(cupSize);
        girl.setAge(age);
        girl.setMoney(money);
        return girlJpaDao.save(girl);
    }



    /**
     * 重构接口
     * 添加一个女生
     * @return
     */
//    @PostMapping(value = "/girls11")
    @GetMapping(value = "/girls11")
    public Result<Girl> girlAdd(@Valid Girl girl, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResultUtil.error(1, bindingResult.getFieldError().getDefaultMessage());
        }

        girl.setCupSize(girl.getCupSize());
        girl.setAge(girl.getAge());
        girl.setMoney(girl.getMoney());
        return ResultUtil.success(girlJpaDao.save(girl));
    }


    //删除
//    @DeleteMapping(value = "/girls/{id}")
    @GetMapping(value = "/girls2/{id}")
    public void deleteGirl(@PathVariable("id") Integer id) {
        Girl girl = new Girl();
        girl.setId(id);
        girlJpaDao.delete(girl);
    }

    //修改
    @GetMapping(value = "/girls3/{id}")
    public Girl girlUpdate(@PathVariable("id") Integer id,
                           @RequestParam("cupSize") String cupSize,
                           @RequestParam("age") Integer age) {
        Girl girl = new Girl();
        girl.setCupSize(cupSize);
        girl.setAge(age);
        girl.setId(id);
        return girlJpaDao.save(girl);
    }

    //查询一个get
    @GetMapping(value = "/girls/{id}")
    public Girl girlFindOne(@PathVariable("id") Integer id) {
        //下面写法不行了
        //return girlJpaDao.findOne(id);
        Girl girl = new Girl();
        girl.setId(id);
        Example<Girl> girlExample = Example.of(girl);
        return girlJpaDao.findOne(girlExample).orElse(null);
    }

    //查询所有get
    @GetMapping(value = "/girls")
    public List<Girl> girlList() {
        return girlJpaDao.findAll();
    }

    //事务
    @GetMapping(value = "/two/girls")
    public void girlTwo(){
        girlService.insertTwo();
    }

}
