package br.com.larissasarapio.virtual_library_api.services;

import br.com.larissasarapio.virtual_library_api.domain.User;
import br.com.larissasarapio.virtual_library_api.dtos.UserDTO;
import br.com.larissasarapio.virtual_library_api.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(UserDTO userDTO) {
        validateNameDoesNotExist(userDTO.name());
        User user = new User(null, userDTO.name(), 2);
        return userRepository.save(user);
    }

    private void validateNameDoesNotExist(String name) {
        if (userRepository.existsByName(name)) {
            throw new IllegalArgumentException("A user with this name already exists!");
        }
    }

}
