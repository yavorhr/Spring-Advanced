package bg.softuni.test.di;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CLITest implements CommandLineRunner {

  private final BartenderClass bartender;

  public CLITest(BartenderClass bartender) {
    this.bartender = bartender;
  }

  @Override
  public void run(String... args) throws Exception {
    System.out.println(bartender.serveBeer());
  }
}
