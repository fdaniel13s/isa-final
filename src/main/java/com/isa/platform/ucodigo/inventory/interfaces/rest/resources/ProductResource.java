package com.isa.platform.ucodigo.inventory.interfaces.rest.resources;

public record ProductResource(
        Long id,
        String serialNumber,
        String brand,
        String model,
        String monitoringLevel
) {
}
