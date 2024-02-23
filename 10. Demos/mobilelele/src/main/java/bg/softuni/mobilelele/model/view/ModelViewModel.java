package bg.softuni.mobilelele.model.view;

import bg.softuni.mobilelele.model.entity.enums.CategoryEnum;

public class ModelViewModel {

  private Long id;
  private String name;
  private CategoryEnum category;
  private String imageUrl;
  private Integer startYear;
  private Integer endYear;

  public String getName() {
    return name;
  }

  public ModelViewModel setName(String name) {
    this.name = name;
    return this;
  }

  public Long getId() {
    return id;
  }

  public ModelViewModel setId(Long id) {
    this.id = id;
    return this;
  }

  public CategoryEnum getCategory() {
    return category;
  }

  public ModelViewModel setCategory(CategoryEnum category) {
    this.category = category;
    return this;
  }

  public String getImageUrl() {
    return imageUrl;
  }

  public ModelViewModel setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
    return this;
  }

  public Integer getStartYear() {
    return startYear;
  }

  public ModelViewModel setStartYear(Integer startYear) {
    this.startYear = startYear;
    return this;
  }

  public Integer getEndYear() {
    return endYear;
  }

  public ModelViewModel setEndYear(Integer endYear) {
    this.endYear = endYear;
    return this;
  }
}
