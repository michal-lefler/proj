package com.michal.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.michal.demo.entity.Kid;

public interface KidRepository extends JpaRepository<Kid, Long> {
}
