package br.com.larissasarapio.virtual_library_api.controller;


import br.com.larissasarapio.virtual_library_api.domain.User;
import br.com.larissasarapio.virtual_library_api.dtos.UserDTO;
import br.com.larissasarapio.virtual_library_api.services.BookService;
import br.com.larissasarapio.virtual_library_api.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping()
    public ResponseEntity<User> addUser(@RequestBody UserDTO userDTO){
        User user = userService.createUser(userDTO);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

}
