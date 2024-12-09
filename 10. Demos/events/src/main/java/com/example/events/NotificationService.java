package com.example.events;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class NotificationService {

  @EventListener
  public void handleMyCustomEvent(UserRegisterEvent event) {
    System.out.println("Sending notification for user: " + event.getUsername());
  }
}
