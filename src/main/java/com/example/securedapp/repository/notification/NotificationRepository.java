package com.example.securedapp.repository.notification;

import com.example.securedapp.service.notification.Notification;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface NotificationRepository {

    @Select("""
            SELECT *
            FROM notifications
            """)
    public List<Notification> select();

    @Insert("""
            INSERT INTO notifications (message, username)
            VALUES (#{message}, #{username})
            """)
    void insert(@Param("message") String message, @Param("username") String username);
}
