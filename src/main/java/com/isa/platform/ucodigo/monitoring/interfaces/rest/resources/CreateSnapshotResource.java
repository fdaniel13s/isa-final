package com.isa.platform.ucodigo.monitoring.interfaces.rest.resources;

public record CreateSnapshotResource(
        String snapshotId,
        Long productId,
        Double temperature,
        Double energy,
        Integer leakage
) {
}
