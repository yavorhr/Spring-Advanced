package bg.softuni.mobilelele.model.binding;

import bg.softuni.mobilelele.model.entity.enums.EngineEnum;
import bg.softuni.mobilelele.model.entity.enums.TransmissionEnum;
import java.math.BigDecimal;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

public class OfferAddBindModel {
    private Long id;
    @NotNull
    private Long modelId;
    @NotNull
    @DecimalMin("100")
    private BigDecimal price;
    @NotNull
    private EngineEnum engine;
    @NotNull
    private TransmissionEnum transmission;
    @NotNull
    @Min(1930)
    private Integer year;
    @NotNull
    @PositiveOrZero
    private Integer mileage;
    @NotEmpty
    private String description;
    @NotEmpty
    private String imageUrl;

    public Long getModelId() {
        return modelId;
    }

    public OfferAddBindModel setModelId(Long modelId) {
        this.modelId = modelId;
        return this;
    }

    public Long getId() {
        return id;
    }

    public OfferAddBindModel setId(Long id) {
        this.id = id;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public OfferAddBindModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public EngineEnum getEngine() {
        return engine;
    }

    public OfferAddBindModel setEngine(EngineEnum engine) {
        this.engine = engine;
        return this;
    }

    public TransmissionEnum getTransmission() {
        return transmission;
    }

    public OfferAddBindModel setTransmission(TransmissionEnum transmission) {
        this.transmission = transmission;
        return this;
    }

    public Integer getYear() {
        return year;
    }

    public OfferAddBindModel setYear(Integer year) {
        this.year = year;
        return this;
    }

    public Integer getMileage() {
        return mileage;
    }

    public OfferAddBindModel setMileage(Integer mileage) {
        this.mileage = mileage;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public OfferAddBindModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public OfferAddBindModel setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }
}
