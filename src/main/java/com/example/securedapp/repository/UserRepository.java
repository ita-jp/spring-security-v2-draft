package com.example.securedapp.repository;

import com.example.securedapp.service.user.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Optional;

@Mapper
public interface UserRepository {

    @Select("""
            SELECT
                username
              , password
              , authority
            FROM users u
            WHERE u.username = #{username}
            """)
    Optional<User> findByUsername(@Param("username") String username);

    @Insert("""
            INSERT INTO users (
                username
              , password
            ) VALUES (
                #{username}
              , #{password}
            )
            """)
    void insert(@Param("username") String username, @Param("password") String password);

    @Select("""
            SELECT
                username
              , '********'
              , authority
            FROM users
            """)
    List<User> findAll();
}
