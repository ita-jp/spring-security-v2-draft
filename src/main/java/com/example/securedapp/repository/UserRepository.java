package com.example.securedapp.repository;

import com.example.securedapp.service.user.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Optional;

@Mapper
public interface UserRepository {

    @Select("""
            SELECT
                username
              , password
            FROM users u
            WHERE u.username = #{username}
            """)
    Optional<User> findByUsername(@Param("username") String username);

}
