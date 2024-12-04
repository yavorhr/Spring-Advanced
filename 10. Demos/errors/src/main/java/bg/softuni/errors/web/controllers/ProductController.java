package bg.softuni.errors.web.controllers;

import bg.softuni.errors.web.exceptions.OrderNotFoundException;
import bg.softuni.errors.web.exceptions.ProductNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletResponse;

@Controller
public class ProductController {

  @GetMapping("/products/{id}/details")
  public String showProductDetails(@PathVariable("id") String productId) {
    //retrieve product from repository
    //productRepository.findById(productId).orElseThrow(new ProductNotFoundException());
    throw new ProductNotFoundException("Product with ID " + productId + " not found.");
  }

  @GetMapping("/products/add")
  public String  addProduct() {
    throw new NullPointerException("Product can't be null");
  }

  @ExceptionHandler(ProductNotFoundException.class)
  public String handleNotFound(ProductNotFoundException ex, Model model, HttpServletResponse response) {
    response.setStatus(HttpServletResponse.SC_NOT_FOUND); // Set HTTP status to 404
    model.addAttribute("notFound", ex.getMessage());
    return "/error/404";
  }
}
