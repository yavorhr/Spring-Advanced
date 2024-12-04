package bg.softuni.errors.web.controllers;


import bg.softuni.errors.web.exceptions.OrderNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletResponse;

@Controller
public class OrdersController {

  @GetMapping("/orders/{id}/details")
  public String showProductDetails(@PathVariable("id") String orderId) {
    throw new OrderNotFoundException("Order with ID " + orderId + " not found.");
  }

  @ExceptionHandler(OrderNotFoundException.class)
  public String handleNotFound(OrderNotFoundException ex, Model model, HttpServletResponse response) {
//    response.setStatus(HttpServletResponse.SC_NOT_FOUND); // Set HTTP status to 404
    model.addAttribute("notFound", ex.getMessage());
    return "/error/404";
  }
}
