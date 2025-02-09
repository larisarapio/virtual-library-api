package br.com.larissasarapio.virtual_library_api.services;

import br.com.larissasarapio.virtual_library_api.domain.User;
import br.com.larissasarapio.virtual_library_api.dtos.UserDTO;
import br.com.larissasarapio.virtual_library_api.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    public void createUser(UserDTO userDTO) {
        validateNameDoesNotExist(userDTO.name());
        // Código para salvar o usuário no banco
        User user = new User(userDTO.name(), 2);
        userRepository.save(user);
    }

    private void validateNameDoesNotExist(String name) {
        if (userRepository.existsByName(name)) {
            throw new IllegalArgumentException("A user with this name already exists!");
        }
    }

}
