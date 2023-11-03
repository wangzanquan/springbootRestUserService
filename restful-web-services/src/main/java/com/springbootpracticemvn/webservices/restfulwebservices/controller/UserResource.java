package com.springbootpracticemvn.webservices.restfulwebservices.controller;

import com.springbootpracticemvn.webservices.restfulwebservices.user.User;
import com.springbootpracticemvn.webservices.restfulwebservices.user.UserDaoService;
import org.springframework.http.HttpStatus;
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
    @PostMapping("/users/create")
    public ResponseEntity<Object> createUser(@RequestBody User user){

        service.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    //POST (DELETE) /users
    @PostMapping("/users/delete")
    public ResponseEntity<Object> deleteUser(@RequestBody String id){
        int userId = Integer.parseInt(id);

        service.delete(userId);
        return ResponseEntity.status(HttpStatus.OK).build();

    }

}
