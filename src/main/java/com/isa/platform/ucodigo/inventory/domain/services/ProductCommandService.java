package com.isa.platform.ucodigo.inventory.domain.services;

import com.isa.platform.ucodigo.inventory.domain.model.aggregates.Product;
import com.isa.platform.ucodigo.inventory.domain.model.commands.CreateProductCommand;

import java.util.Optional;

public interface ProductCommandService {
    Optional<Product> handle(CreateProductCommand command);
}
