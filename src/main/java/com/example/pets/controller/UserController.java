package com.example.pets.controller;

import com.example.pets.entity.User;
import com.example.pets.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public ResponseEntity<User> save(@RequestBody User user){
        User save = userRepository.save(user);
        return ResponseEntity.ok(save);
    }
    @PostMapping("/createWithList")
    public ResponseEntity<List<User>> saveListUsers(@RequestBody List<User> list){
        userRepository.saveAll(list);
        return ResponseEntity.ok(list);
    }

    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        List<User> all = userRepository.findAll();
        return ResponseEntity.ok(all);
    }
    @GetMapping("/findByUsername")
    public ResponseEntity<User> findByUsername(String username){
        Optional<User> byUsername = userRepository.findByUsername(username);
        return byUsername.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PutMapping
    public ResponseEntity<User> updateUser(String username, @RequestBody User user){
        Optional<User> byUsername = userRepository.findByUsername(username);
        if(byUsername.isPresent()){
            user.setId(byUsername.get().getId());
            userRepository.save(user);
            return ResponseEntity.ok(user);
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping
    public ResponseEntity<User> deleteUser(String username){
        Optional<User> byUsername = userRepository.findByUsername(username);
        if(byUsername.isPresent()){
            userRepository.delete(byUsername.get());
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }



}
