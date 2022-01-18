package bg.softuni.test.di;

import org.springframework.stereotype.Component;

@Component("aleMachine")
public class AleBeerMachine implements BeerMachineIfc {
  @Override
  public String makeBeer() {
    return "Tasteful indian pale ale!";
  }
}
