package bg.softuni.mobilelele.service;

import bg.softuni.mobilelele.model.service.UserRegistrationServiceModel;

public interface UserService {

  void initializeUsersAndRoles();

  void registerAndLoginUser(UserRegistrationServiceModel userRegistrationServiceModel);

  boolean isUserNameFree(String username);
}
