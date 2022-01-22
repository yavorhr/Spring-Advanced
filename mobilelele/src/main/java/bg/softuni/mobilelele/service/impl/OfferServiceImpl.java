package bg.softuni.mobilelele.service.impl;

import bg.softuni.mobilelele.model.binding.OfferAddBindModel;
import bg.softuni.mobilelele.model.entity.ModelEntity;
import bg.softuni.mobilelele.model.entity.OfferEntity;
import bg.softuni.mobilelele.model.entity.UserEntity;
import bg.softuni.mobilelele.model.entity.UserRoleEntity;
import bg.softuni.mobilelele.model.entity.enums.EngineEnum;
import bg.softuni.mobilelele.model.entity.enums.TransmissionEnum;
import bg.softuni.mobilelele.model.entity.enums.UserRoleEnum;
import bg.softuni.mobilelele.model.service.OfferAddServiceModel;
import bg.softuni.mobilelele.model.service.OfferUpdateServiceModel;
import bg.softuni.mobilelele.model.view.OfferDetailsView;
import bg.softuni.mobilelele.model.view.OfferSummaryView;
import bg.softuni.mobilelele.repository.ModelRepository;
import bg.softuni.mobilelele.repository.OfferRepository;
import bg.softuni.mobilelele.repository.UserRepository;
import bg.softuni.mobilelele.service.OfferService;
import bg.softuni.mobilelele.web.exception.ObjectNotFoundException;
import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class OfferServiceImpl implements OfferService {

  private final OfferRepository offerRepository;
  private final ModelMapper modelMapper;
  private final ModelRepository modelRepository;
  private final UserRepository userRepository;

  public OfferServiceImpl(OfferRepository offerRepository, ModelMapper modelMapper,
      ModelRepository modelRepository, UserRepository userRepository) {
    this.offerRepository = offerRepository;
    this.modelMapper = modelMapper;
    this.modelRepository = modelRepository;
    this.userRepository = userRepository;
  }

  @Override
  public void initializeOffers() {

    if (offerRepository.count() == 0) {
      OfferEntity offer1 = new OfferEntity();
      offer1
          .setModel(modelRepository.findById(1L).orElse(null))
          .setEngine(EngineEnum.GASOLINE)
          .setTransmission(TransmissionEnum.MANUAL)
          .setMileage(22500)
          .setPrice(14300)
          .setYear(2019)
          .setDescription("Used, but well services and in good condition.")
          .setSeller(userRepository.findByUsername("pesho")
              .orElse(null)) // or currentUser.getUserName()
          .setImageUrl(
              "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQcXp1KBpDKgYs6VqndkBpX8twjPOZbHV86yg&usqp=CAU");

      OfferEntity offer2 = new OfferEntity();
      offer2
          .setModel(modelRepository.findById(1L).orElse(null))
          .setEngine(EngineEnum.DIESEL)
          .setTransmission(TransmissionEnum.AUTOMATIC)
          .setMileage(209000)
          .setPrice(5500)
          .setYear(2000)
          .setDescription("After full maintenance, insurance, new tires...")
          .setSeller(userRepository.findByUsername("admin")
              .orElse(null)) // or currentUser.getUserName()
          .setImageUrl(
              "https://www.picclickimg.com/d/l400/pict/283362908243_/FORD-ESCORT-MK5-16L-DOHC-16v-ZETEC.jpg");

      offerRepository.saveAll(List.of(offer1, offer2));
    }
  }

  @Override
  public List<OfferSummaryView> getAllOffers() {
    return offerRepository.
        findAll().
        stream().
        map(this::map).
        collect(Collectors.toList());
  }

  @Override
  public OfferDetailsView findById(Long id, String currentUser) {
    OfferDetailsView offerDetailsView = this.offerRepository.
        findById(id).
        map(o -> mapDetailsView(currentUser, o))
        .get();
    return offerDetailsView;
  }

  @Override
  public void deleteOffer(Long id) {
    offerRepository.deleteById(id);
  }

  public boolean isOwner(String userName, Long id) {
    Optional<OfferEntity> offerOpt = offerRepository.
        findById(id);
    Optional<UserEntity> caller = userRepository.
        findByUsername(userName);

    if (offerOpt.isEmpty() || caller.isEmpty()) {
      return false;
    } else {
      OfferEntity offerEntity = offerOpt.get();

      return isAdmin(caller.get()) ||
          offerEntity.getSeller().getUsername().equals(userName);
    }
  }

  private boolean isAdmin(UserEntity user) {
    return user.
        getRoles().
        stream().
        map(UserRoleEntity::getRole).
        anyMatch(r -> r == UserRoleEnum.ADMIN);
  }


  @Override
  public void updateOffer(OfferUpdateServiceModel offerModel) {

    OfferEntity offerEntity =
        offerRepository.findById(offerModel.getId()).orElseThrow(() ->
            new ObjectNotFoundException("Offer with id " + offerModel.getId() + " not found!"));

    offerEntity.setPrice(offerModel.getPrice())
        .setDescription(offerModel.getDescription())
        .setEngine(offerModel.getEngine())
        .setImageUrl(offerModel.getImageUrl())
        .setMileage(offerModel.getMileage())
        .setTransmission(offerModel.getTransmission())
        .setYear(offerModel.getYear());

    offerRepository.save(offerEntity);
  }

  @Override
  public OfferAddServiceModel addOffer(OfferAddBindModel offerAddBindModel, String ownerId) {
    UserEntity userEntity = userRepository.findByUsername(ownerId).orElseThrow();
    OfferAddServiceModel offerAddServiceModel = modelMapper.map(offerAddBindModel,
        OfferAddServiceModel.class);
    OfferEntity newOffer = modelMapper.map(offerAddServiceModel, OfferEntity.class);
    newOffer.setCreated(Instant.now());
    newOffer.setSeller(userEntity);
    ModelEntity model = modelRepository.getById(offerAddBindModel.getModelId());
    newOffer.setModel(model);

    OfferEntity savedOffer = offerRepository.save(newOffer);
    return modelMapper.map(savedOffer, OfferAddServiceModel.class);
  }

  private OfferSummaryView map(OfferEntity offerEntity) {
    OfferSummaryView summaryView = this.modelMapper
        .map(offerEntity, OfferSummaryView.class);

    summaryView.setModel(offerEntity.getModel().getName());
    summaryView.setBrand(offerEntity.getModel().getBrand().getName());

    return summaryView;
  }

  private OfferDetailsView mapDetailsView(String currentUser, OfferEntity offer) {
    OfferDetailsView offerDetailsView = this.modelMapper.map(offer, OfferDetailsView.class);
    offerDetailsView.setCanDelete(isOwner(currentUser, offer.getId()));
    offerDetailsView.setModel(offer.getModel().getName());
    offerDetailsView.setBrand(offer.getModel().getBrand().getName());
    offerDetailsView.setSellerFullName(
        offer.getSeller().getFirstName() + " " + offer.getSeller().getLastName());
    return offerDetailsView;
  }
}
