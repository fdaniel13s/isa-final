package com.isa.platform.ucodigo.inventory.interfaces.rest.transform;

import com.isa.platform.ucodigo.inventory.domain.model.commands.CreateProductCommand;
import com.isa.platform.ucodigo.inventory.interfaces.rest.resources.CreateProductResource;

public class CreateProductCommandFromResourceAssembler {
    public static CreateProductCommand fromResource(CreateProductResource resource) {
        return new CreateProductCommand(
                resource.brand(),
                resource.serialNumber(),
                resource.model(),
                resource.monitoringLevel()
        );
    }
}
