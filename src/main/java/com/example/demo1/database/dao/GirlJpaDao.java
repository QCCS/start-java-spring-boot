package com.example.demo1.database.dao;

import com.example.demo1.database.model.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

//接口需要继承JpaRepository
public interface GirlJpaDao extends JpaRepository<Girl,Integer> {
}
