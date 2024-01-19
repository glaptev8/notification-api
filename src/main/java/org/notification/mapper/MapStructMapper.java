package org.notification.mapper;

import org.leantech.notification.NotificationDto;
import org.mapstruct.Mapper;
import org.notification.entity.Notification;

@Mapper(componentModel = "spring")
public interface MapStructMapper {
  Notification mapperNotification(NotificationDto notificationDto);
}
