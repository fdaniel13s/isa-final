package com.isa.platform.ucodigo.inventory.domain.model.commands;

public record CreateProductCommand(
        String brand,
        String serialNumber,
        String model,
        String monitoringLevel
) {
}
