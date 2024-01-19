package org.notification.filterchain;

import org.leantech.notification.NotificationDto;
import org.leantech.notification.NotificationStatus;
import org.leantech.notification.ObjectTypeEnum;
import org.leantech.notification.TriggerCodeEnum;
import org.notification.mapper.MapStructMapper;
import org.notification.repository.NotificationRepository;
import org.notification.service.EmailService;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
public class RegistrationNotificationHandler extends NotificationHandler {

  private final EmailService emailService;
  private final MapStructMapper mapper;
  private final NotificationRepository notificationRepository;
  public RegistrationNotificationHandler(NotificationHandler handler,
                                         EmailService emailService,
                                         MapStructMapper mapper,
                                         NotificationRepository notificationRepository) {
    super(handler);
    this.mapper = mapper;
    this.notificationRepository = notificationRepository;
    this.emailService = emailService;
  }

  @Override
  public Mono<Void> handle(NotificationDto notificationDto) {
    if (notificationDto.getTriggerCode() == TriggerCodeEnum.INDIVIDUAL_REGISTERED_101) {
      if (notificationDto.getObjectType() == ObjectTypeEnum.EMAIL) {
        return emailService
          .sendEmail(notificationDto.getObjectId(), notificationDto.getSubject(), notificationDto.getMessage())
          .onErrorResume(e -> {
            log.info("error {}", e.getMessage());
            notificationDto.setNotificationStatus(NotificationStatus.ERROR);
            notificationDto.setError(e.getMessage());
            return Mono.empty();
          })
          .then(Mono.defer(() ->
             notificationRepository.save(mapper.mapperNotification(notificationDto))
          ))
          .then(Mono.empty());
      }
      return Mono.empty();
    }

    if (handler == null) return Mono.empty();

    return handler.handle(notificationDto);
  }
}
