package com.isa.platform.ucodigo.monitoring.interfaces.rest;

import com.isa.platform.ucodigo.monitoring.domain.model.GetAllSnapshotsByProductId;
import com.isa.platform.ucodigo.monitoring.domain.model.aggregates.Snapshot;
import com.isa.platform.ucodigo.monitoring.domain.services.SnapshotCommandService;
import com.isa.platform.ucodigo.monitoring.domain.services.SnapshotQueryService;
import com.isa.platform.ucodigo.monitoring.interfaces.rest.resources.CreateSnapshotResource;
import com.isa.platform.ucodigo.monitoring.interfaces.rest.resources.SnapshotResource;
import com.isa.platform.ucodigo.monitoring.interfaces.rest.transform.CreateSnapshotCommandFromResourceAssembler;
import com.isa.platform.ucodigo.monitoring.interfaces.rest.transform.SnapshotResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@Tag(name = "Snapshots")
public class SnapshotsController {
    private final SnapshotCommandService snapshotCommandService;
    private final SnapshotQueryService snapshotQueryService;

    public SnapshotsController(SnapshotCommandService snapshotCommandService, SnapshotQueryService snapshotQueryService) {
        this.snapshotCommandService = snapshotCommandService;
        this.snapshotQueryService = snapshotQueryService;
    }

    @PostMapping(value = "api/v1/snapshots")
    public ResponseEntity<SnapshotResource> createSnapshot(CreateSnapshotResource resource){
        var command = CreateSnapshotCommandFromResourceAssembler.fromResource(resource);
        var snapshot = snapshotCommandService.handle(command);
        if (snapshot.isEmpty()) return ResponseEntity.badRequest().build();
        var resourceFromEntity = SnapshotResourceFromEntityAssembler.fromEntity(snapshot.get());
        return ResponseEntity.ok(resourceFromEntity);
    }

    @GetMapping(value = "api/v1/products/{productId}/snapshots")
    public ResponseEntity<List<SnapshotResource>> getSnapshotsByProductId(@PathVariable Long productId){
        var query = new GetAllSnapshotsByProductId(productId);
        List<Snapshot> snapshots = snapshotQueryService.handle(query).get();
        List<SnapshotResource> resources = snapshots.stream()
                .map(SnapshotResourceFromEntityAssembler::fromEntity)
                .collect(Collectors.toList());
        return ResponseEntity.ok(resources);
    }
}
