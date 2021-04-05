package itiseveri.pcto.pcto.service;

import itiseveri.pcto.pcto.model.User;
import itiseveri.pcto.pcto.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("userService")
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
         List<User> usersList= (List<User>) userRepository.findAll();
        return usersList;
    }

    @Override
    public Optional<User> getUserById(long id) {
        Optional<User> user= userRepository.findById(id);
        return user;
    }

    @Override
    public void createOrUpdateUser(User user) {
            Optional<User> user1 = userRepository.findById(user.getId());
            if(user1.isPresent()){
                User newUser= user1.get();
                newUser.setNome(user.getNome());
                newUser.setCognome(user.getCognome());
                userRepository.save(newUser);
            } else{
                userRepository.save(user);
            }
        }

    @Override
    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }

}
