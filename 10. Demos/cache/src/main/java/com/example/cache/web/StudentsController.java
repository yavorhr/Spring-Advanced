package com.example.cache.web;

import com.example.cache.service.StudentsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
@RequestMapping("/students")
public class StudentsController {
  private final StudentsService studentsService;

  public StudentsController(StudentsService studentsService) {
    this.studentsService = studentsService;
  }

  @GetMapping
  public ResponseEntity<Map<String, String>> getStudents() {
    Map<String, String> studentsNames = this.studentsService.getAllStudentsNames();

    return ResponseEntity.ok(studentsNames);

  }
}
