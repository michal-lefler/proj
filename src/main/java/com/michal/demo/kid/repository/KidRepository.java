package com.michal.demo.kid.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.michal.demo.kid.entity.Kid;

public interface KidRepository extends JpaRepository<Kid, Long> {
}
