package br.com.larissasarapio.virtual_library_api.domain;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "user")
@AllArgsConstructor
@Getter
@Setter
public class User {
    
    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private final String name;

    @Column(nullable = false)
    private final int maxLoan;

    public boolean canTakeLoan(int loadMoment) {
        return loadMoment < maxLoan;
    }

    public class UserComum extends User {
        public UserComum(String name) {
            super(id, name, 2);
        }
    }
    
    public class UserPremium extends User {
        public UserPremium(String name) {
            super(null, name, 5);
        }
    }
}


