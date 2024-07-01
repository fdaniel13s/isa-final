package com.isa.platform.ucodigo.inventory.application.internal.queryservices;

import com.isa.platform.ucodigo.inventory.domain.model.aggregates.Product;
import com.isa.platform.ucodigo.inventory.domain.model.queries.GetProductById;
import com.isa.platform.ucodigo.inventory.domain.model.queries.GetProductBySerialNumber;
import com.isa.platform.ucodigo.inventory.domain.services.ProductQueryService;
import com.isa.platform.ucodigo.inventory.infrastructure.persistence.jpa.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductQueryServiceImpl implements ProductQueryService {
    private final ProductRepository productRepository;

    public ProductQueryServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    /**
     *
     * @param query
     * @return returns the product with the serial number
     */
    @Override
    public Optional<Product> handle(GetProductBySerialNumber query) {
        return productRepository.findBySerialNumber(query.serialNumber());
    }

    @Override
    public Optional<Product> handle(GetProductById query) {
        return productRepository.findById(query.id());
    }
}
