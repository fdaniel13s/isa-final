package com.isa.platform.ucodigo.monitoring.application.internal.queryservices;

import com.isa.platform.ucodigo.monitoring.domain.model.GetAllSnapshotsByProductId;
import com.isa.platform.ucodigo.monitoring.domain.model.aggregates.Snapshot;
import com.isa.platform.ucodigo.monitoring.domain.services.SnapshotQueryService;
import com.isa.platform.ucodigo.monitoring.infrastructure.persistence.jpa.repositories.SnapshotRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SnapshotQueryServiceImpl implements SnapshotQueryService {
    private final SnapshotRepository snapshotRepository;
    public SnapshotQueryServiceImpl(SnapshotRepository snapshotRepository) {
        this.snapshotRepository = snapshotRepository;
    }

    @Override
    public Optional<List<Snapshot>> handle(GetAllSnapshotsByProductId query) {
        return snapshotRepository.findAllByProductId(query.productId());
    }


}
