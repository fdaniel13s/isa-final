package com.isa.platform.ucodigo.inventory.application.internal.commandservices;

import com.isa.platform.ucodigo.inventory.domain.model.aggregates.Product;
import com.isa.platform.ucodigo.inventory.domain.model.commands.CreateProductCommand;
import com.isa.platform.ucodigo.inventory.domain.services.ProductCommandService;
import com.isa.platform.ucodigo.inventory.infrastructure.persistence.jpa.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductCommandServiceImpl implements ProductCommandService {
    private final ProductRepository productRepository;

    public ProductCommandServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Override
    public Optional<Product> handle(CreateProductCommand command) {
        var product = new Product(command);

        try {
            productRepository.save(product);
            return Optional.of(product);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error saving product." , e);
        }
    }
}
