package com.isa.platform.ucodigo.monitoring.domain.model.commands;

public record CreateSnapshotCommand(
        String snapshotId,
        Long productId,
        Double temperature,
        Double energy,
        Integer leakage
) {
}
