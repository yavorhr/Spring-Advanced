package com.example.service;

import com.example.events.UserRegisterEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {
  private final ApplicationEventPublisher eventPublisher;

  public UserServiceImpl(ApplicationEventPublisher eventPublisher) {
    this.eventPublisher = eventPublisher;
  }

  @Override
  public void registerUser(String username) {
    System.out.println("User registered: " + username);

    // Publish an event
    UserRegisterEvent event = new UserRegisterEvent(this, username);
    eventPublisher.publishEvent(event);
    System.out.println("Published UserRegisteredEvent for: " + username);
  }
}
