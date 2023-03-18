package com.example.yarnshop.repositories;

import com.example.yarnshop.models.entities.YarnShopUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<YarnShopUser, Long> {
    Optional<YarnShopUser> findUserByEmail(String email);
}
