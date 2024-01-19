package org.notification.service;

import org.notification.entity.Notification;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface NotificationService {
  Flux<Notification> getUsersNotifications(String userUuid);

  Mono<Notification> save(Notification notification);
}
