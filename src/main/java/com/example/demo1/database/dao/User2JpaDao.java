package com.example.demo1.database.dao;

/**
 * Created by zhouli on 18/5/4
 * Email 2565510046@qq.com
 * wechat qianchaoshushui
 */

import java.util.List;

import com.example.demo1.database.model.User2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;


public interface User2JpaDao extends JpaRepository<User2, Long> {
    /*
     * Jpa命名规范，查询
     */
    User2 findByNameAndPasswordAndId(String name, String password, Integer id);

    /*
     * (non-Javadoc)新增用户
     * @see org.springframework.data.repository.CrudRepository#save(S)
     */
    User2 save(User2 user2);

    //查询全部
    List<User2> findAll();

    //分页查询
    //Page<User2> findAll(PageRequest pageRequest);
    Page<User2> findAll(Pageable pageable);

    @Modifying
    @Query("update User2 as c set c.name = ?1 where c.password=?2")
    int updateNameByPassword(String name, String password);

    void delete(User2 entity);

}