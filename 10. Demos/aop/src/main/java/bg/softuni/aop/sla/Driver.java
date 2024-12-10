package bg.softuni.aop.sla;

public class Driver {

  private String name;
  private String licenceCategory;

  public String getName() {
    return name;
  }

  public String getLicenceCategory() {
    return licenceCategory;
  }

  public Driver setName(String name) {
    this.name = name;
    return this;
  }

  public Driver setLicenceCategory(String licenceCategory) {
    this.licenceCategory = licenceCategory;
    return this;
  }
}
