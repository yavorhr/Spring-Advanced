package bg.softuni.mobilelele.service;


import bg.softuni.mobilelele.model.view.BrandViewModel;
import java.util.List;

public interface BrandService {

    void initializeBrand();

    List<BrandViewModel> getAllBrands();
}
