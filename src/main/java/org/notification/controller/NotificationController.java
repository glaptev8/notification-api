package org.notification.controller;

import org.notification.entity.Notification;
import org.notification.service.NotificationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/notification")
public class NotificationController {
  private final NotificationService notificationService;

  @PostMapping("/update")
  public Mono<Notification> update(@RequestBody Notification notification) {
    return notificationService.save(notification);
  }

  @PostMapping("/")
  public Flux<Notification> getUsersNotifications(@RequestParam String userUid) {
    return notificationService.getUsersNotifications(userUid);
  }
}
