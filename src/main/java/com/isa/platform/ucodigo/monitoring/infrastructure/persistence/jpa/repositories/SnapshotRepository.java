package com.isa.platform.ucodigo.monitoring.infrastructure.persistence.jpa.repositories;

import com.isa.platform.ucodigo.monitoring.domain.model.aggregates.Snapshot;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SnapshotRepository extends JpaRepository<Snapshot, String> {
    Optional<List<Snapshot>> findAllByProductId(Long productId);
}
