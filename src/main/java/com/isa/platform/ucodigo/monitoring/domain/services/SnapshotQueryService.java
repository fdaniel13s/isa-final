package com.isa.platform.ucodigo.monitoring.domain.services;

import com.isa.platform.ucodigo.monitoring.domain.model.GetAllSnapshotsByProductId;
import com.isa.platform.ucodigo.monitoring.domain.model.aggregates.Snapshot;

import java.util.List;
import java.util.Optional;

public interface SnapshotQueryService {
    Optional<List<Snapshot>> handle(GetAllSnapshotsByProductId query);
}
