package bg.softuni.aop.sla;

import java.util.ArrayList;
import java.util.List;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "slos-config")
public class SLOsConfig {

  private List<SLOConfig> slos = new ArrayList<>();

  public List<SLOConfig> getSlos() {
    return slos;
  }

  public SLOsConfig setSlos(List<SLOConfig> slos) {
    this.slos = slos;
    return this;
  }

  public static class SLOConfig {
    private String id;
    private int treshold;

    public String getId() {
      return id;
    }

    public SLOConfig setId(String id) {
      this.id = id;
      return this;
    }

    public int getTreshold() {
      return treshold;
    }

    public SLOConfig setTreshold(int treshold) {
      this.treshold = treshold;
      return this;
    }
  }
}
