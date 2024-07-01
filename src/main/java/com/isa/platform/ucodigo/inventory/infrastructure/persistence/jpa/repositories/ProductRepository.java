package com.isa.platform.ucodigo.inventory.infrastructure.persistence.jpa.repositories;

import com.isa.platform.ucodigo.inventory.domain.model.aggregates.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findBySerialNumber(String serialNumber);
}
