package bg.softuni.booksclient;

import bg.softuni.booksclient.model.BookDTO;
import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class Init implements CommandLineRunner {

  private static final Logger LOGGER = LoggerFactory.getLogger(Init.class);

  private final RestTemplate restTemplate;

  public Init(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  @Override
  public void run(String... args) throws Exception {
    ResponseEntity<BookDTO[]> booksResponse = restTemplate.getForEntity("http://localhost:8080/books",
        BookDTO[].class);

    if (booksResponse.hasBody()) {
      BookDTO[] books = booksResponse.getBody();
      for (BookDTO book : books) {
        LOGGER.info("A book that came from the server: {}", book);
      }
    }
  }
}
