package com.isa.platform.ucodigo.monitoring.application.internal.commandservices;

import com.isa.platform.ucodigo.inventory.infrastructure.persistence.jpa.repositories.ProductRepository;
import com.isa.platform.ucodigo.monitoring.domain.model.aggregates.Snapshot;
import com.isa.platform.ucodigo.monitoring.domain.model.commands.CreateSnapshotCommand;
import com.isa.platform.ucodigo.monitoring.domain.services.SnapshotCommandService;
import com.isa.platform.ucodigo.monitoring.infrastructure.persistence.jpa.repositories.SnapshotRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SnapshotCommandServiceImpl implements SnapshotCommandService {
    private final SnapshotRepository snapshotRepository;
    private final ProductRepository productRepository;

    public SnapshotCommandServiceImpl(SnapshotRepository snapshotRepository, ProductRepository productRepository) {
        this.snapshotRepository = snapshotRepository;
        this.productRepository = productRepository;
    }

    @Override
    public Optional<Snapshot> handle(CreateSnapshotCommand command) {
        var product = productRepository.findById(command.productId()).orElseThrow();

        var snapshot = new Snapshot(command,product);
        try {
            snapshotRepository.save(snapshot);
            return Optional.of(snapshot);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error saving snapshot." , e);
        }
    }


}
