package bg.softuni.mobilelele.web;

import bg.softuni.mobilelele.model.binding.OfferAddBindModel;
import bg.softuni.mobilelele.model.binding.OfferUpdateBindingModel;
import bg.softuni.mobilelele.model.entity.enums.EngineEnum;
import bg.softuni.mobilelele.model.entity.enums.TransmissionEnum;
import bg.softuni.mobilelele.model.service.OfferAddServiceModel;
import bg.softuni.mobilelele.model.service.OfferUpdateServiceModel;
import bg.softuni.mobilelele.model.view.OfferDetailsView;
import bg.softuni.mobilelele.service.BrandService;
import bg.softuni.mobilelele.service.OfferService;
import bg.softuni.mobilelele.service.impl.MobileleUser;
import java.security.Principal;
import javax.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class OffersController {
    private final OfferService offerService;
    private final ModelMapper modelMapper;
    private final BrandService brandService;

    public OffersController(OfferService offerService,
                            ModelMapper modelMapper, BrandService brandService) {
        this.offerService = offerService;
        this.modelMapper = modelMapper;
        this.brandService = brandService;
    }

    // GET
    @GetMapping("/offers/all")
    public String allOffers(Model model) {
        model.addAttribute("offers",
                offerService.getAllOffers());
        return "offers";
    }

    @GetMapping("/offers/{id}/details")
    public String showOffer(
            @PathVariable Long id, Model model,
            Principal principal) {
        model.addAttribute("offer", this.offerService.findById(id, principal.getName()));
        return "details";
    }

    // DELETE
    @PreAuthorize("isOwner(#id)")
    //@PreAuthorize("@offerServiceImpl.isOwner(#principal.name, #id)")
    @DeleteMapping("/offers/{id}")
    public String deleteOffer(@PathVariable Long id,
        Principal principal) {

        // Most naive approach - check explicitly if the current user is an
        //owner and throw exception if this is not the case.
//        if (!offerService.isOwner(principal.getName(), id)) {
//            throw new RuntimeException();
//        }
        offerService.deleteOffer(id);

        return "redirect:/offers/all";
    }

    // UPDATE

    @GetMapping("/offers/{id}/edit")
    public String editOffer(@PathVariable Long id, Model model,
        @AuthenticationPrincipal MobileleUser currentUser) {

        OfferDetailsView offerDetailsView = offerService.findById(id, currentUser.getUserIdentifier());
        OfferUpdateBindingModel offerModel = modelMapper.map(
                offerDetailsView,
                OfferUpdateBindingModel.class
        );
        model.addAttribute("engines", EngineEnum.values());
        model.addAttribute("transmissions", TransmissionEnum.values());
        model.addAttribute("offerModel", offerModel);
        return "update";
    }

    @GetMapping("/offers/{id}/edit/errors")
    public String editOfferErrors(@PathVariable Long id, Model model) {
        model.addAttribute("engines", EngineEnum.values());
        model.addAttribute("transmissions", TransmissionEnum.values());
        return "update";
    }

    @PatchMapping("/offers/{id}/edit")
    public String editOffer(
            @PathVariable Long id,
            @Valid OfferUpdateBindingModel offerModel,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {

            redirectAttributes.addFlashAttribute("offerModel", offerModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.offerModel", bindingResult);

            return "redirect:/offers/" + id + "/edit/errors";
        }

        OfferUpdateServiceModel serviceModel = modelMapper.map(offerModel,
                OfferUpdateServiceModel.class);
        serviceModel.setId(id);

        offerService.updateOffer(serviceModel);

        return "redirect:/offers/" + id + "/details";
    }

    @GetMapping("/offers/add")
    public String getAddOfferPage(Model model) {

        if (!model.containsAttribute("offerAddBindModel")) {
            model.
                addAttribute("offerAddBindModel", new OfferAddBindModel()).
                addAttribute("brandsModels", brandService.getAllBrands());
        }
        return "offer-add";
    }

    @PostMapping("/offers/add")
    public String addOffer(@Valid OfferAddBindModel offerAddBindModel,
                           BindingResult bindingResult,
                            RedirectAttributes redirectAttributes,
                            @AuthenticationPrincipal MobileleUser user) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("offerAddBindModel", offerAddBindModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.offerAddBindModel", bindingResult)
                    .addFlashAttribute("brandsModels", brandService.getAllBrands());
            return "redirect:/offers/add";
        }
        OfferAddServiceModel savedOfferAddServiceModel = offerService.addOffer(offerAddBindModel, user.getUserIdentifier());
        return "redirect:/offers/" + savedOfferAddServiceModel.getId() + "/details";
    }
}
