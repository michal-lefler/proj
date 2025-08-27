package com.michal.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.michal.demo.entity.Parent;

public interface ParentRepository extends JpaRepository<Parent, Long> {
}
