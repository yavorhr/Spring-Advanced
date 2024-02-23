package bg.softuni.schedules;

import java.time.LocalDateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class FixedDelaySchedulerDemo {

  private static final Logger LOGGER = LoggerFactory.getLogger(FixedDelaySchedulerDemo.class);

  // This fixed delay waits N millis after the execution of the previous task ends
  @Scheduled(fixedDelay = 20000, initialDelay = 10000)
  public void showTimeWithFixedDelay(){
    LOGGER.info("Hello, from fixed delay scheduller at {}", LocalDateTime.now());
  }


}
