package bg.softuni.test.di;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component("lagerBeer")
public class LagerBeerMachine implements BeerMachineIfc {

  @Override
  public String makeBeer() {
    return "A glass(es) of cold pale lager! ";
  }

  @PostConstruct
  public void afterConstruct() {
    System.out.println("Lager machine ready for action!");
  }

  @PreDestroy
  public void destroy() {
    System.out.println("Cleaning up the lager machine");
  }
}
