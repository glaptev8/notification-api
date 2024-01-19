package org.notification.entity;

import org.leantech.notification.NotificationStatus;
import org.leantech.notification.ObjectTypeEnum;
import org.leantech.notification.TriggerCodeEnum;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import java.time.LocalDateTime;

import lombok.Data;

@Data
@Table("notifications")
public class Notification {

  @Id
  private Long id;
  private LocalDateTime createdAt;
  private LocalDateTime modifiedAt;
  private LocalDateTime expirationDate;
  private String message;
  private String error;
  private String userUid;
  private NotificationStatus notificationStatus;
  private String messageType;
  private TriggerCodeEnum triggerCode;
  private ObjectTypeEnum objectType;
  private String objectId;
  private String subject;
  private String createdBy;
  private Boolean hasConfirmOtp;
  private Boolean suggestToAddToTrusted;
}
