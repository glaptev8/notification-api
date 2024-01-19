package org.notification.consumer;

import org.leantech.notification.NotificationDto;
import org.notification.filterchain.NotificationHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class NotificationConsumer {

  private final NotificationHandler handler;

  @KafkaListener(topics = "notification-topic", groupId = "notification-group")
  public void listen(NotificationDto notification) {
    log.info("kafka received a notification {} ", notification.toString());
    handler.handle(notification)
      .subscribe();
  }
}
