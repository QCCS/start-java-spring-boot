package com.example.demo1.domain.p;

import java.io.Serializable;


public class TestRediser implements Serializable {

    private static final long serialVersionUID = -1L;

    private String username;
    private Integer age;

    public TestRediser(String username, Integer age) {
        this.username = username;
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

}