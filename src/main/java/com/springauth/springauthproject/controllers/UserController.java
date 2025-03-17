package com.springauth.springauthproject.controllers;

import com.springauth.springauthproject.entities.User;
import com.springauth.springauthproject.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/users")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        List<User> userList = service.findAll();
        return ResponseEntity.ok().body(userList);
    }

    @GetMapping(value = "/public")
    public ResponseEntity<List<User>> findAllPublic() {
        List<User> userList = service.findAll();
        return ResponseEntity.ok().body(userList);
    }

    @PostMapping(value = "/create")
    public User createUser(@RequestBody User obj) {
        return service.create(
                obj.getName(),
                obj.getEmail(),
                obj.getPassword()
        );
    }
}
