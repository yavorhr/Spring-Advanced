package bg.softuni.mobilelele.model.service;

import java.util.List;

public class BrandServiceModel {

    private String name;
    private List<ModelServiceModel> models;

    public String getName() {
        return name;
    }

    public BrandServiceModel setName(String name) {
        this.name = name;
        return this;
    }

    public List<ModelServiceModel> getModels() {
        return models;
    }

    public BrandServiceModel setModels(List<ModelServiceModel> models) {
        this.models = models;
        return this;
    }
}
