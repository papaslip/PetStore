package com.example.pets.repository;

import com.example.pets.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    List<User> findAllByFirstName(String firstName);


//    @Query("select User from User where username = :username")
//    Optional<User> myFindByUsername (String username);

//    @Query(value = "SELECT * FROM USER U WHERE U.USERNAME = :username", nativeQuery = true)
//    Optional<User> mySqlFindByUsername (String username);



}
