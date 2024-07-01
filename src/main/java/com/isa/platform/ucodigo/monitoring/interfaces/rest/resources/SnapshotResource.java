package com.isa.platform.ucodigo.monitoring.interfaces.rest.resources;

public record SnapshotResource(
        Long id,
        String snapshotId,
        Long productId,
        Double temperature,
        Double energy,
        Integer leakage
) {
}
