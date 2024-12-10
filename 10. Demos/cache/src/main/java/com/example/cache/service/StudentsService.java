package com.example.cache.service;

import java.util.Map;

public interface StudentsService {

  Map<String, String> getAllStudentsNames();

  void addStudent(String id, String name);
}
