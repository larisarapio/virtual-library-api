package br.com.larissasarapio.virtual_library_api.domain;

import br.com.larissasarapio.virtual_library_api.dtos.UserDTO;
import br.com.larissasarapio.virtual_library_api.repositories.UserRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@AllArgsConstructor
@Getter
@Setter
public class User {
    private final String name;
    private final int maxLoan;


    public boolean canTakeLoan(int loadMoment) {
        return loadMoment < maxLoan;
    }

    public class UserComum extends User {
        public UserComum(String name) {
            super(name, 2);
        }
    }
    
    public class UserPremium extends User {
        public UserPremium(String name) {
            super(name, 5);
        }
    }
}


