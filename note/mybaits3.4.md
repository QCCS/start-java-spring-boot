## 基础注解
MyBatis 主要提供了以下CRUD注解：
```$xslt
@Select
@Insert
@Update
@Delete
```

增删改查占据了绝大部分的业务操作，掌握这些基础注解的使用还是很有必要的，例如下面这段代码无需XML即可完成数据查询：
```$xslt
@Mapper
public interface UserMapper {
    @Select("select * from t_user")
    List<User> list();
}


```

## 映射注解
Mybatis主要提供这些映射注解：

@Results 用于填写结果集的多个字段的映射关系.
@Result 用于填写结果集的单个字段的映射关系.
@ResultMap 根据ID关联XML里面<resultMap>.
例如上面的list方法，我们可以在查询SQL的基础上，指定返回的结果集的映射关系，其中property表示实体对象的属性名，column表示对应的数据库字段名。
```$xslt
 @Results({
            @Result(property = "userId", column = "USER_ID"),
            @Result(property = "username", column = "USERNAME"),
            @Result(property = "password", column = "PASSWORD"),
            @Result(property = "mobileNum", column = "PHONE_NUM")
    })
    @Select("select * from t_user")
    List<User> list();
```
   
查询结果如下，：
```$xslt
[
  {
    "userId": "1",
    "username": "admin",
    "password": "admin",
    "mobileNum": "15011791234"
  },
  {
    "userId": "2",
    "username": "roots",
    "password": "roots",
    "mobileNum": "18812342017"
  }
]
```

为了方便演示和免除手工编写映射关系的烦恼，这里提供了一个快速生成映射结果集的方法，具体内容如下：
```$xslt
 /**
     * 1.用于获取结果集的映射关系
     */
    public static String getResultsStr(Class origin) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("@Results({\n");
        for (Field field : origin.getDeclaredFields()) {
            String property = field.getName();
            //映射关系：对象属性(驼峰)->数据库字段(下划线)
            String column = new PropertyNamingStrategy.SnakeCaseStrategy().translate(field.getName()).toUpperCase();
            stringBuilder.append(String.format("@Result(property = \"%s\", column = \"%s\"),\n", property, column));
        }
        stringBuilder.append("})");
        return stringBuilder.toString();
    }
```
 
在当前Main方法执行效果如下：然后我们将控制台这段打印信息复制到接口方法上即可。


##高级注解
MyBatis-3 主要提供了以下CRUD的高级注解：
```$xslt
@SelectProvider
@InsertProvider
@UpdateProvider
@DeleteProvider
```

见名知意，这些高级注解主要用于动态SQL，这里以@SelectProvider 为例，主要包含两个注解属性，其中type表示工具类，method 表示工具类的某个方法，用于返回具体的SQL。
```$xslt
@Mapper
public interface UserMapper {
    @SelectProvider(type = UserSqlProvider.class, method = "list222")
    List<User> list2();
}
```

工具类代码如下：
```$xslt
public class UserSqlProvider {
    public String list222() {
        return "select * from t_user ;
    }
}
```

## 关联查询案例
地址表
```$xslt
package com.example.demo1.domain.p;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by zhouli on 18/5/8
 * Email 2565510046@qq.com
 * wechat qianchaoshushui
 */
@Entity
public class Address {
    @Id
    @GeneratedValue
    private Integer id;

    private String province;
    private String city;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}

```
用户表
```$xslt
package com.example.demo1.domain.p;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

/**
 * Created by zhouli on 18/5/4
 * Email 2565510046@qq.com
 * wechat qianchaoshushui
 */
//@Entity一旦加了实体注释，结合jpa
//public interface UserRepository extends JpaRepository<User, Long> {
//spring就会把这个实体的成员对表的字段对应起来
    //当有关联表的时候，需要处理
//@Entity
public class User {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer age;
    //地址信息，和用户是一对一的关系
    private Address address;
    //地址id
    private Integer addressId;
    //用户拥有的车，和用户是一对多的关系
    private List<Car> cars;


    public User(){}

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }


    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

}

```
车表
```$xslt
package com.example.demo1.domain.p;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by zhouli on 18/5/8
 * Email 2565510046@qq.com
 * wechat qianchaoshushui
 */
@Entity
public class Car {

    @Id
    @GeneratedValue
    private Integer id;
    private String color;
    private String name;
    //用户id
    private Integer userId;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}

```
addressMapper
```$xslt
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

```
userMapper
```$xslt
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
```
carMapper
```$xslt
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
```

测试
```$xslt
        //user与address在不同的表
        System.out.println("测试关联查询-user-address");
        User u1 = userMapper.findUserWithAddress(1);
        System.out.println("用户name -----" +u1.getName());
        System.out.println("用户age -----" +u1.getAge());
        System.out.println("用户address -----" +u1.getAddress().getCity());
        System.out.println("用户address -----" +u1.getAddress().getProvince());
        System.out.println("用户addressId -----" +u1.getAddressId());
        System.out.println("用户card -----" +u1.getCars());
        System.out.println("测试关联查询-user-car");
        //user与cars在不同的表
        User u2 = userMapper.getUserWithCar(1);
        System.out.println("用户name -----" + u2.getName());
        System.out.println("用户age -----" + u2.getAge());
        System.out.println("用户address -----" + u2.getAddress());
        System.out.println("用户addressId -----" + u2.getAddressId());
        Car c1 = u2.getCars().get(0);
        Car c2 = u2.getCars().get(1);
        System.out.println("用户cars -----" + u2.getCars());
        System.out.println("用户cars1 -----" +c1.getColor());
        System.out.println("用户cars1 -----" +c1.getName());
        System.out.println("用户cars1 -----" +c1.getId());
        System.out.println("用户cars1 -----" +c1.getUserId());

        System.out.println("用户cars2 -----" +c2.getColor());
        System.out.println("用户cars2 -----" +c2.getName());
        System.out.println("用户cars2 -----" +c2.getId());
        System.out.println("用户cars2 -----" +c2.getUserId());
```