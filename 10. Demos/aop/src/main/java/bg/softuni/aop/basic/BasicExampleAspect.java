package bg.softuni.aop.basic;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Aspect
@Component
@ConditionalOnProperty(name = "examples.basic.enabled", havingValue = "true")
public class BasicExampleAspect {

  private static final Logger LOGGER = LoggerFactory.getLogger(BasicExampleAspect.class);

  @Pointcut("execution(* bg.softuni.aop.Student.*(..))")
  public void track(){}

  @Pointcut("execution(* bg.softuni.aop.Student.echo(..))")
  public void trackEcho(){}

  @Before("track()")
  public void beforeAnyMethod(JoinPoint joinPoint) {
    LOGGER.info("Before calling: {}", joinPoint.getSignature());
  }

  @Before("trackEcho()")
  public void beforeEcho() {
    LOGGER.info("Advice execution before calling echo.");
  }

  @AfterThrowing(pointcut = "track()", throwing = "error")
  public void trackExceptions(Throwable error) {
    LOGGER.info("I have detected an exception: ", error);
  }


}
