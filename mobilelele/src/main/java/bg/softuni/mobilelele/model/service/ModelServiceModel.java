package bg.softuni.mobilelele.model.service;

import bg.softuni.mobilelele.model.entity.enums.CategoryEnum;

public class ModelServiceModel {
    private Long id;
    private String name;
    private CategoryEnum category;
    private String imageUrl;
    private Integer startYear;
    private Integer endYear;

    public Long getId() {
        return id;
    }

    public ModelServiceModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ModelServiceModel setName(String name) {
        this.name = name;
        return this;
    }

    public CategoryEnum getCategory() {
        return category;
    }

    public ModelServiceModel setCategory(CategoryEnum category) {
        this.category = category;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public ModelServiceModel setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public Integer getStartYear() {
        return startYear;
    }

    public ModelServiceModel setStartYear(Integer startYear) {
        this.startYear = startYear;
        return this;
    }

    public Integer getEndYear() {
        return endYear;
    }

    public ModelServiceModel setEndYear(Integer endYear) {
        this.endYear = endYear;
        return this;
    }
}
