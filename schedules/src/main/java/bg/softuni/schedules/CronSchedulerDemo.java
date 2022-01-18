package bg.softuni.schedules;

import java.time.LocalDateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class CronSchedulerDemo {

  private static final Logger LOGGER = LoggerFactory.getLogger(CronSchedulerDemo.class);

  @Scheduled(cron = "${schedulers.cron}")
  public void showTimeWithCron(){
    LOGGER.info("Hello, from cron scheduller at {}", LocalDateTime.now());
  }


}
