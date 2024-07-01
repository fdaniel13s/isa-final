package com.isa.platform.ucodigo.monitoring.domain.model.aggregates;

import com.isa.platform.ucodigo.inventory.domain.model.aggregates.Product;
import com.isa.platform.ucodigo.monitoring.domain.model.commands.CreateSnapshotCommand;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Snapshot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @NotNull
    private String snapshotId;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @NotNull
    private Double temperature;
    @NotNull
    private Double energy;
    @NotNull
    private Integer leakage;

    public Snapshot(CreateSnapshotCommand command, Product product){
        this.snapshotId = command.snapshotId();
        this.product = product;
        this.temperature = command.temperature();
        this.energy = command.energy();
        this.leakage = command.leakage();
    }


}