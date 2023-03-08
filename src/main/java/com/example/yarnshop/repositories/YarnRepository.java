package com.example.yarnshop.repositories;

import com.example.yarnshop.models.entities.Yarn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface YarnRepository extends JpaRepository<Yarn, Long> {
}
