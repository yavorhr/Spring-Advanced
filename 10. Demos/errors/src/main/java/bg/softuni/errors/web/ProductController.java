package bg.softuni.errors.web;


import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductController {

  @GetMapping("/products/{id}/details")
  public String showProductDetails(@PathVariable("id") Long productId) {
    //retrieve product from repository
    //productRepository.findById(productId).orElseThrow(new ProductNotFoundException());
    throw new ObjectNotFoundException(productId);
  }
}
