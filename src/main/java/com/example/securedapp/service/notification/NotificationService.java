package com.example.securedapp.service.notification;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService {

    public List<Notification> findAll() {
        return List.of(
                new Notification(1, "テストのおしらせ1"),
                new Notification(1, "テストのおしらせ2")
        );
    }
}
