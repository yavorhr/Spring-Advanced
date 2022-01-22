package bg.softuni.mobilelele.web;

import bg.softuni.mobilelele.model.view.BrandViewModel;
import bg.softuni.mobilelele.service.BrandService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/brands")
public class BrandsController {
    private final BrandService brandService;
    private final ModelMapper modelMapper;

    public BrandsController(BrandService brandService, ModelMapper modelMapper) {
        this.brandService = brandService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/all")
    public String getAllBrandsPage(Model model) {
        List<BrandViewModel> brandViewModels = brandService.getAllBrands().stream()
                .map(brandServiceModel -> modelMapper.map(brandServiceModel, BrandViewModel.class))
                .collect(Collectors.toList());
        model.addAttribute("allBrands", brandViewModels);
        return "brands";
    }
}
