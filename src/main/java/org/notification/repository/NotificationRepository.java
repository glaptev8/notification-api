package org.notification.repository;

import org.notification.entity.Notification;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

import reactor.core.publisher.Flux;

public interface NotificationRepository extends R2dbcRepository<Notification, Long> {
  Flux<Notification> findAllByUserUid(String userUid);
}
