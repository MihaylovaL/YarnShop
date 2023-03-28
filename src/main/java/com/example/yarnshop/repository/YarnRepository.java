package com.example.yarnshop.repository;

import com.example.yarnshop.model.entity.Yarn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface YarnRepository extends JpaRepository<Yarn, Long> {
    Optional<Yarn> getYarnById(Long id);
}
