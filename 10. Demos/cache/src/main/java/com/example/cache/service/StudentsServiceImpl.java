package com.example.cache.service;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

@Component
public class StudentsServiceImpl implements StudentsService {

  private final Logger logger = Logger.getLogger(StudentsServiceImpl.class.getName());
  private Map<String, String> students;

  public StudentsServiceImpl() {
    students = new HashMap<>();
    students.put("student1", "Pesho");
    students.put("student2", "Georgi");
    students.put("student3", "Mike");
  }

  @Override
  @Cacheable("students")
  public Map<String, String> getAllStudentsNames() {

    logger.info("Doing something in StudentService component...");

    try {
      Thread.sleep(4000);
    } catch (InterruptedException ignored) {
    }

    logger.info("doing something additionally...");
    return students;
  }

  @CacheEvict(value = "students", allEntries = true) // Clear all cache entries for "students"
  public void addStudent(String id, String name) {
    logger.info("Adding new student: " + id + " - " + name);
    students.put(id, name);
  }

}
