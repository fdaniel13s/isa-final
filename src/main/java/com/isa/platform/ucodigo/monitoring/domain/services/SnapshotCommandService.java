package com.isa.platform.ucodigo.monitoring.domain.services;

import com.isa.platform.ucodigo.monitoring.domain.model.aggregates.Snapshot;
import com.isa.platform.ucodigo.monitoring.domain.model.commands.CreateSnapshotCommand;

import java.util.Optional;

public interface SnapshotCommandService {
    Optional<Snapshot> handle(CreateSnapshotCommand command);
}
