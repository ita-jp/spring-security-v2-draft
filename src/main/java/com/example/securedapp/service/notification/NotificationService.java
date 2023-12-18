package com.example.securedapp.service.notification;

import com.example.securedapp.repository.notification.NotificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NotificationService {

    private final NotificationRepository notificationRepository;

    public List<Notification> findAll() {
        return notificationRepository.select();
    }

    @Transactional
    public void create(String message, String username) {
        notificationRepository.insert(message, username);
    }
}
