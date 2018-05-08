package com.example.demo1.domain.p;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhouli on 18/5/8
 * Email 2565510046@qq.com
 * wechat qianchaoshushui
 */
@Mapper
@Service
public interface CarMapper {
    /**
     * 根据用户id查询所有的车
     */
    @Select("SELECT * FROM `car` WHERE user_id = #{userId}")
    List<Car> findCarByUserId(Integer userId);
}
