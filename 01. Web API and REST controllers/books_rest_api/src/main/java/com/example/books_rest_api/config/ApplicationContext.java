package com.example.books_rest_api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Scanner;

@Configuration
public class ApplicationContext {

  @Bean
  public Scanner scanner() {
    return new Scanner(System.in);
  }
}
