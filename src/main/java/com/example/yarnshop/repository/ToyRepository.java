package com.example.yarnshop.repository;

import com.example.yarnshop.model.entity.Toy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToyRepository extends JpaRepository<Toy, Long> {
}
