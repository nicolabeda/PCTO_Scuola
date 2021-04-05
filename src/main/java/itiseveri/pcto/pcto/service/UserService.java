package itiseveri.pcto.pcto.service;

import itiseveri.pcto.pcto.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> getAllUsers();
    Optional<User> getUserById(long id);
    void createOrUpdateUser(User user);
    void deleteUser(long id);
}
