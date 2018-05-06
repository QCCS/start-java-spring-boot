package com.example.demo1.domain.s;

import com.example.demo1.domain.s.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

//接口需要继承JpaRepository
public interface GirlJpaDao extends JpaRepository<Girl,Integer> {
}
