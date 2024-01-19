package org.notification.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {

  private final JavaMailSender mailSender;
  private final String SENDER = "gleb.laptev.00@bk.ru";

  @Override
  public Mono<Void> sendEmail(String to, String subject, String text) {
    return Mono.fromRunnable(() -> {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setFrom(SENDER);
        message.setSubject(subject);
        message.setText(text);
        mailSender.send(message);
    })
      .subscribeOn(Schedulers.boundedElastic())
      .then(Mono.empty());
  }
}
