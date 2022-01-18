package bg.softuni.test.di;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class BartenderClass {

  private BeerMachineIfc beerMachine;

  public BartenderClass(@Qualifier("aleMachine") BeerMachineIfc beerMachine) {
    this.beerMachine = beerMachine;
  }

  public String serveBeer() {
    return beerMachine.makeBeer();
  }
}
