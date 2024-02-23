package bg.softuni.kotlin.web

import bg.softuni.kotlin.service.GreeterService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
class GreeterController(val greeterService: GreeterService) {

  @GetMapping("/greet")
  fun greet(@RequestParam(name = "person",
      defaultValue = "Anonymous") person : String,
      model: Model) : String {

    model.addAttribute("greeting", greeterService.
        greeting(person))
    return "hello"
  }
}
