package org.notification.service;

import org.notification.entity.Notification;
import org.notification.repository.NotificationRepository;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {

  private final NotificationRepository notificationRepository;

  @Override
  public Flux<Notification> getUsersNotifications(String userUuid) {
    return notificationRepository.findAllByUserUid(userUuid);
  }

  @Override
  public Mono<Notification> save(Notification notification) {
    return notificationRepository.save(notification);
  }
}
