package com.example.pets.repository;

import com.example.pets.entity.Pet;
import com.example.pets.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PetRepository extends JpaRepository<Pet, Long> {
    Optional<Pet> findById(Long petId);

}
