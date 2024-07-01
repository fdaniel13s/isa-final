package com.isa.platform.ucodigo.inventory.domain.services;

import com.isa.platform.ucodigo.inventory.domain.model.aggregates.Product;
import com.isa.platform.ucodigo.inventory.domain.model.queries.GetProductById;
import com.isa.platform.ucodigo.inventory.domain.model.queries.GetProductBySerialNumber;

import java.util.Optional;

public interface ProductQueryService {
    Optional<Product> handle(GetProductBySerialNumber query);

    Optional<Product> handle(GetProductById query);
}
