package com.example.yarnshop.repository;

import com.example.yarnshop.model.entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface SaleRepository extends JpaRepository<Sale, Long> {

    List<Sale> findSaleByDateOfOrderBefore(LocalDate yearBack);
}
