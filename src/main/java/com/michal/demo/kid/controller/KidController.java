package com.michal.demo.kid.controller;

import com.michal.demo.kid.entity.Kid;
import com.michal.demo.kid.entity.Parent;
import com.michal.demo.kid.repository.KidRepository;
import com.michal.demo.kid.repository.ParentRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/kids/kids")
public class KidController {

    private final KidRepository kidRepository;
    private final ParentRepository parentRepository;

    public KidController(KidRepository kidRepository, ParentRepository parentRepository) {
        this.kidRepository = kidRepository;
        this.parentRepository = parentRepository;
    }

    @PostMapping
    public ResponseEntity<Kid> createKid(@RequestBody KidRequest request) {

        // Load parents by IDs
        List<Parent> parents = parentRepository.findAllById(request.getParents());

        // Create kid
        Kid kid = new Kid();
        kid.setName(request.getName());
        kid.setPhoneNumber(request.getPhoneNumber());
        kid.setParents(parents);

        Kid savedKid = kidRepository.save(kid);
        return ResponseEntity.ok(savedKid);
    }

    // Get all kids
    @GetMapping
    public ResponseEntity<List<Kid>> getAllKids() {
        List<Kid> kids = kidRepository.findAll();
        return ResponseEntity.ok(kids);
    }

    // Get kid by ID
    @GetMapping("/{id}")
    public ResponseEntity<Kid> getKidById(@PathVariable Long id) {
        return kidRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
