package com.example.pets.controller;

import com.example.pets.entity.Category;
import com.example.pets.entity.User;
import com.example.pets.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryRepository categoryRepository;

    @PostMapping("/createWithList")
    public ResponseEntity<List<Category>> saveListUsers(@RequestBody List<Category> list){
        categoryRepository.saveAll(list);
        return ResponseEntity.ok(list);
    }
}
