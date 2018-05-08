package com.example.demo1.domain.p;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

//整合MyBaits  userMapper
@Mapper
@Service
public interface UserMapper {

    @Select("SELECT * FROM user WHERE name = #{name}")
    User findByName(@Param("name") String name);

//    @Results 用于填写结果集的多个字段的映射关系.
//    @Result 用于填写结果集的单个字段的映射关系.
    @Results({
            @Result(property = "name", column = "name"),
            @Result(property = "age", column = "age")
    })
    @Select("SELECT name, age FROM user")
    List<User> findAll();

    @Insert("INSERT INTO user(name, age, id) VALUES(#{name}, #{age},#{id})")
    int insert(@Param("name") String name, @Param("age") Integer age, @Param("id") Integer id);

    @Update("UPDATE user SET age=#{age} WHERE name=#{name}")
    void update(User user);

    @Delete("DELETE FROM user WHERE id =#{id}")
    void delete(Integer id);

    @Insert("INSERT INTO user(name, age) VALUES(#{name}, #{age})")
    int insertByUser(User user);

    @Insert("INSERT INTO user(name, age) VALUES(#{name,jdbcType=VARCHAR}, #{age,jdbcType=INTEGER})")
    int insertByMap(Map<String, Object> map);

    //根据用户id查询用户的方法
    //一对一，一个用户对应一个地址
//    我们要使用@Resutl注解对返回的结果进行配置，
//            - property = “address”, 表示要将返回的查询结果赋值给user的address属性
//- column = “address_id” 是指将user表中的address_id作为com.example.demo1.domain.p.AddressMapper.findAddressById的查询参数
//- one 表示这是一个一对一的查询
//- @One(select = “方法全路径) 表示我们调用的方法
    @Select("SELECT * FROM `user` where id = #{id}")
    @Results({
            @Result(property = "address",
                    column = "address_id",
                    one = @One(select = "com.example.demo1.domain.p.AddressMapper.findAddressById"))
    })
    User findUserWithAddress(Integer id);


    /**
     * 查询带有车信息的用户===============演示一对多(关于多对多其实就是两个一对多组成)
     */
//    我们要使用@Resutl注解对返回的结果进行配置，
//            - property = “cars”, 表示要将返回的查询结果赋值给user的cars属性
//- column = “id” 是指将user表中的用户主键id作为com.example.demo1.domain.p.CarMapper.findCarByUserId的查询参数
//- many 表示这是一个一对多的查询
//- @Many(select = “方法全路径) 表示我们调用的方法, 方法参数userId就是上面column指定的列值
    @Select("SELECT * FROM `user` WHERE id = #{id}")
    @Results({
            @Result(property = "cars",
                    column = "id",
                    many = @Many(select = "com.example.demo1.domain.p.CarMapper.findCarByUserId"))
    })
    User getUserWithCar(Integer id);
}



//一对多
//多对一



//一对一
//多对多,  配置一个一对多，反过来在配置一个一对多