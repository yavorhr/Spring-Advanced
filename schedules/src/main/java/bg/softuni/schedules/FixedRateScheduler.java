package bg.softuni.schedules;

import java.time.LocalDateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class FixedRateScheduler {

  private static final Logger LOGGER = LoggerFactory.getLogger(FixedRateScheduler.class);

  // This fixed rate starts the task every N millis
  // ATTENTION: it does not wait for the previous task to end
  @Scheduled(fixedRate = 5000)
  public void showTimeWithFixedDelay(){
    LOGGER.info("Hello, from fixed rate scheduller at {}", LocalDateTime.now());
  }

}
