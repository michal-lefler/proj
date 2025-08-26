package com.michal.demo.kid.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.michal.demo.kid.entity.Parent;

public interface ParentRepository extends JpaRepository<Parent, Long> {
}
