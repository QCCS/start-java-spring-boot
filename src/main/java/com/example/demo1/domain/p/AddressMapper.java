package com.example.demo1.domain.p;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

/**
 * Created by zhouli on 18/5/8
 * Email 2565510046@qq.com
 * wechat qianchaoshushui
 */
@Mapper
@Service
public interface AddressMapper {
    /**
     * 根据地址id查询地址
     */
    @Select("SELECT * FROM `address` WHERE id = #{id}")
    Address findAddressById(Integer id);
}
