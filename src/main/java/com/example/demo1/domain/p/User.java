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
//    在配置文件中配置：#自动重新创建表，只要有表就不创建，只是更新数据
//            spring.jpa.hibernate.ddl-auto=update
//public interface UserRepository extends JpaRepository<User, Long> {
//spring就会把这个实体的成员对表的字段对应起来
    //当有关联表的时候，需要处理

// 由于User关联多个表，这个实体对象的成员不能创建数据库中的表，所以就不需要加上Entity注解，并且不实现JpaRepository接口，
// 不然会因为无法创建表报错
    //如果要用自动创建表，就需要单独创建一个实体对象，把这个类当做视图类
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
