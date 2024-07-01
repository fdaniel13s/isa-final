package com.isa.platform.ucodigo.monitoring.interfaces.rest.transform;

import com.isa.platform.ucodigo.monitoring.domain.model.aggregates.Snapshot;
import com.isa.platform.ucodigo.monitoring.interfaces.rest.resources.SnapshotResource;

public class SnapshotResourceFromEntityAssembler {
    public static SnapshotResource fromEntity(Snapshot snapshot) {
        return new SnapshotResource(
                snapshot.getId(),
                snapshot.getSnapshotId(),
                snapshot.getProduct().getId(),
                snapshot.getTemperature(),
                snapshot.getEnergy(),
                snapshot.getLeakage()
        );
    }
}
