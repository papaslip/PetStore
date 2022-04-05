package com.example.pets.controller;

import com.example.pets.serice.PetService;
import com.example.pets.entity.Pet;
import com.example.pets.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequestMapping("/pet")
public class PetController {

    @Autowired
    private PetService petService;

    @Autowired
    private PetRepository petRepository;

    @PostMapping("/{petId}/uploadImage")
    public ResponseEntity<Object> fileUpload(@PathVariable("petId") Long petId, @RequestParam("file") MultipartFile[] files) {

            petService.savePhoto(files,petId);
            return new ResponseEntity<Object>("successful operation",HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Pet> save(@RequestBody Pet pet){
        petRepository.save(pet);
        return ResponseEntity.ok(pet);
    }






}
