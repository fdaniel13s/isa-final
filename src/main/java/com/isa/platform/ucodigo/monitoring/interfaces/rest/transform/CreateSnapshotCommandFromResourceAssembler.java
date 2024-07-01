package com.isa.platform.ucodigo.monitoring.interfaces.rest.transform;

import com.isa.platform.ucodigo.monitoring.domain.model.commands.CreateSnapshotCommand;
import com.isa.platform.ucodigo.monitoring.interfaces.rest.resources.CreateSnapshotResource;

public class CreateSnapshotCommandFromResourceAssembler {
    public static CreateSnapshotCommand fromResource(CreateSnapshotResource resource) {
        return new CreateSnapshotCommand(
                resource.snapshotId(),
                resource.productId(),
                resource.temperature(),
                resource.energy(),
                resource.leakage()
        );
    }
}
