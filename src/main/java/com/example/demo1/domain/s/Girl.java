package com.example.demo1.domain.s;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Created by zhouli on 18/5/5
 * Email 2565510046@qq.com
 * wechat qianchaoshushui
 * girl实体类，等会可以通过jpa实现数据的curd
 */
@Entity
public class Girl {
    @Id
    @GeneratedValue
    private Integer id;

    @NotBlank(message = "cupSize require")
    private String cupSize;

    @Min(value = 18, message = "no 18 years old")
//    @NotNull
//    @Max()
//    @Length()
    private Integer age;

    @NotNull(message = "money require")
    private Double money;

    public Girl() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCupSize() {
        return cupSize;
    }

    public void setCupSize(String cupSize) {
        this.cupSize = cupSize;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Girl{" +
                "id=" + id +
                ", cupSize='" + cupSize + '\'' +
                ", age=" + age +
                ", money=" + money +
                '}';
    }
}
