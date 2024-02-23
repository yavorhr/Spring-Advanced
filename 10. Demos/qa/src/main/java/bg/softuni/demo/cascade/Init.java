package bg.softuni.demo.cascade;

import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Init implements CommandLineRunner {

  private final AddressRepository addressRepository;
  private final UserRepository userRepository;

  public Init(AddressRepository addressRepository,
      UserRepository userRepository) {
    this.addressRepository = addressRepository;
    this.userRepository = userRepository;
  }

  @Override
  public void run(String... args) throws Exception {
    UserEntity user1 = new UserEntity().setName("Lucho");

    AddressEntity address1 =  new AddressEntity().setStreet("Sofia Unkn. street");
    address1.setUser(user1);
    AddressEntity address2 =  new AddressEntity().setStreet("Na selo :-)");
    address2.setUser(user1);

    user1.setAddresses(List.of(address1, address2));

    user1 = userRepository.save(user1);



    AddressEntity addressEntity = user1.getAddresses().get(0);

    System.out.println("---------------");

    addressRepository.delete(addressEntity);
  }
}
