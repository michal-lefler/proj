package com.michal.demo.controller;

import com.michal.demo.entity.Parent;
import com.michal.demo.repository.ParentRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/parents")
public class ParentController {
    private final ParentRepository repo;

    public ParentController(ParentRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Parent> getAll() {
        return repo.findAll();
    }

    @PostMapping
    public Parent create(@RequestBody Parent parent) {
        return repo.save(parent);
    }
}

