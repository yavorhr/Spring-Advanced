package bg.softuni.errors.web.controllers;


import bg.softuni.errors.web.exceptions.ObjectNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ProductController {

  @GetMapping("/products/{id}/details")
  public String showProductDetails(@PathVariable("id") Long productId) {
    //retrieve product from repository
    //productRepository.findById(productId).orElseThrow(new ProductNotFoundException());
    throw new ObjectNotFoundException(productId);
  }
}
