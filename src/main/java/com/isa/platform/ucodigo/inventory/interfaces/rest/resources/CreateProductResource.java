package com.isa.platform.ucodigo.inventory.interfaces.rest.resources;

public record CreateProductResource(
        String serialNumber,
        String brand,
        String model,
        String monitoringLevel
) {
}
