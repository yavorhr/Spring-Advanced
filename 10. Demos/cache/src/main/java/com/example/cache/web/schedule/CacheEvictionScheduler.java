package com.example.cache.web.schedule;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class CacheEvictionScheduler {

  @Scheduled(fixedRate = 60000 ) //
  @CacheEvict(value = "students", allEntries = true)
  public void evictCache() {
    // This method will clear the "students" cache 1 minute
    System.out.println("Cache evicted at: " + LocalDateTime.now());
  }

}
