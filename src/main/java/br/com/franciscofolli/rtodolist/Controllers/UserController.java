package br.com.franciscofolli.rtodolist.Controllers;

import br.com.franciscofolli.rtodolist.DTOS.UserDTO;
import br.com.franciscofolli.rtodolist.Services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private IUserService service;

    @PostMapping("/")
    public ResponseEntity<UserDTO> create(@RequestBody UserDTO userDTO){
        try {
            return ResponseEntity.ok(this.service.create(userDTO));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
