package br.com.larissasarapio.virtual_library_api.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {
    private String name;
    private int maxLoan;

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

/*

Herança e Polimorfismo
Tipos diferentes de usuário:
UsuarioComum: Pode pegar até 2 livros.
UsuarioPremium: Pode pegar até 5 livros.
Polimorfismo para definir a regra de limite no método pegarEmprestimo().
 */
