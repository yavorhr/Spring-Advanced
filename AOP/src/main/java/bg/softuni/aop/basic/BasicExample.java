package bg.softuni.aop.basic;

import bg.softuni.aop.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
/* @ConditionalOnProperty we can exclude @Beans from Spring container. It is configured in yaml :
examples:
  basic.enabled: false - we are excluding the basic package.
  modifying.enabled: false - we are including the modifying package in Spring.
*/
@ConditionalOnProperty(name = "examples.basic.enabled", havingValue = "true")
public class BasicExample implements CommandLineRunner {

  private final Student student;

  public BasicExample(Student student) {
    this.student = student;
  }

  @Override
  public void run(String... args) throws Exception {
    student.sayHello();
    student.echo("ARGUMENT!");
    student.concat("A", "B");
    try {
      student.boom();
    } catch (Exception ex) {

    }

  }
}
