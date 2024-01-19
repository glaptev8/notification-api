package org.notification.filterchain;


import org.leantech.notification.NotificationDto;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Mono;

@AllArgsConstructor
public abstract class NotificationHandler {
  protected NotificationHandler handler;

  public abstract Mono<Void> handle(NotificationDto notificationDto);
}
