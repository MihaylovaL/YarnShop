package com.example.yarnshop.repository;

import com.example.yarnshop.model.entity.YarnShopUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<YarnShopUser, Long> {
    Optional<YarnShopUser> findUserByEmail(String email);
}
