package com.example.pets.controller;

import com.example.pets.entity.User;
import com.example.pets.serice.PetService;
import com.example.pets.entity.Pet;
import com.example.pets.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;


@RestController
@RequestMapping("/pet")
public class PetController {

    @Autowired
    private PetService petService;

    @Autowired
    private PetRepository petRepository;

    @PostMapping("/{petId}/uploadImage")
    public ResponseEntity<Object> fileUpload(@PathVariable Long petId, @RequestParam("file") MultipartFile[] files) {

            petService.savePhoto(files,petId);
            return new ResponseEntity<Object>("successful operation",HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Pet> save(@RequestBody Pet pet){
        petRepository.save(pet);
        return ResponseEntity.ok(pet);
    }
    @GetMapping("/{petId}")
    public ResponseEntity<Pet> getById(@PathVariable Long petId){
        Optional<Pet> byId = petRepository.findById(petId);
        if(byId.isPresent()){
            return ResponseEntity.ok(byId.get());
        }
        return ResponseEntity.badRequest().build();
    }
    @PutMapping("/{petId}")
    public ResponseEntity<Pet> updateById(@PathVariable Long petId, @RequestBody Pet pet){
        Optional<Pet> byId = petRepository.findById(petId);
        if(byId.isPresent()){
            pet.setId(petId);
            petRepository.save(pet);
            return ResponseEntity.ok(pet);
        }
        return ResponseEntity.badRequest().build();
    }




}
