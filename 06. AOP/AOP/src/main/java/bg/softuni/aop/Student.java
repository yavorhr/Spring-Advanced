package bg.softuni.aop;

import org.springframework.stereotype.Component;

@Component
public class Student {

  public void sayHello() {
    System.out.println("HELLO!");
  }

  public void echo(String echo) {
    System.out.println("ECHO: " + echo);
  }

  public String concat(String a, String b) {
    return a + b;
  }

  public void boom() {
    throw new IllegalStateException("DON'T CALL ME!!! DO NOT!!!!");
  }
}
