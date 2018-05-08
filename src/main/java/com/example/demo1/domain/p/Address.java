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
