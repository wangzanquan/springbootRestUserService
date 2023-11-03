package com.springbootpracticemvn.webservices.restfulwebservices.user;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserResource {

    private UserDaoService service;

    public UserResource(UserDaoService service) {
        this.service = service;
    }

    //GET /users/
    @GetMapping("/users")
    public List<User> retrieveAllUser(){

        return service.findAll();
    }

    //GET /users/{id}
    @GetMapping("/users/{id}")
    public User retrieveUser(@PathVariable int id){

        return service.findById(id);
    }

    //POST /users/
    @PostMapping("/users")
    public ResponseEntity<Object> createUser(@RequestBody User user){

        service.save(user);
        return ResponseEntity.created(null).build();
    }

}
