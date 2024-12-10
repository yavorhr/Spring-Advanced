package com.example.cache.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.logging.Logger;

@Component
public class StudentsServiceImpl implements StudentsService {

  private final Logger logger = Logger.getLogger(StudentsServiceImpl.class.getName());

  @Override
  @Cacheable("students")
  public Map<String, String> getAllStudentsNames() {

    logger.info("Doing something in StudentService component...");

    try {
      Thread.sleep(4000);
    } catch (InterruptedException ignored) {

    }

    logger.info("doing something additionally...");

    return Map.of(  "student1", "Pesho",
            "student2", "Georgi",
            "student3", "Mike");
  }
}
