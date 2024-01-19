package org.notification.config;

import org.notification.filterchain.NotificationHandler;
import org.notification.filterchain.RegistrationNotificationHandler;
import org.notification.mapper.MapStructMapper;
import org.notification.repository.NotificationRepository;
import org.notification.service.EmailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {


  @Bean
  public NotificationHandler configureHandler(EmailService emailService,
                                              MapStructMapper mapper,
                                              NotificationRepository notificationRepository) {
    var registerHandler = new RegistrationNotificationHandler(null,
                                                              emailService,
                                                              mapper,
                                                              notificationRepository);

        // if there is more handlers it should be configured here

    return registerHandler;
  }
}
