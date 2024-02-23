package bg.softuni.errors.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

  @GetMapping("/test")
  public String test() {
    // complicated calculations
    if (true) {
      throw new NullPointerException("WOW, I did it wrong!");//<--this is a bug :-)
    }

    return "hello";
  }

}
