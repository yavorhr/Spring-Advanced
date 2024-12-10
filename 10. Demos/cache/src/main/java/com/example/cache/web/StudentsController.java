package com.example.cache.web;

import com.example.cache.service.StudentsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

  @PostMapping("/add")
  public ResponseEntity<Map<String, String>> addStudent(@RequestParam String id, @RequestParam String name) {
    this.studentsService.addStudent(id, name);

    return ResponseEntity.ok(this.studentsService.getAllStudentsNames());
  }
}
