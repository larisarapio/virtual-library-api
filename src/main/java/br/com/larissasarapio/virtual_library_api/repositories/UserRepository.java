package br.com.larissasarapio.virtual_library_api.repositories;

import br.com.larissasarapio.virtual_library_api.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByName(String name);

}
