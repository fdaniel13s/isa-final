package com.isa.platform.ucodigo.inventory.interfaces.rest.transform;

import com.isa.platform.ucodigo.inventory.domain.model.aggregates.Product;
import com.isa.platform.ucodigo.inventory.interfaces.rest.resources.ProductResource;

public class ProductResourceFromEntityAssembler {
    public static ProductResource fromEntity(Product entity) {
        return new ProductResource(
                entity.getId(),
                entity.getSerialNumber(),
                entity.getBrand(),
                entity.getModel(),
                entity.getMonitoringLevel().toString()
        );
    }
}
