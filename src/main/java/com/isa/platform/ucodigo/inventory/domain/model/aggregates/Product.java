package com.isa.platform.ucodigo.inventory.domain.model.aggregates;

import com.isa.platform.ucodigo.inventory.domain.model.commands.CreateProductCommand;
import com.isa.platform.ucodigo.inventory.domain.model.valueobjects.MonitoringLevel;
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
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    private String brand;

    @NotBlank
    @NotNull
    private String serialNumber;

    @NotBlank
    @NotNull
    private String model;

    @NotNull
    @Enumerated(EnumType.ORDINAL)
    private MonitoringLevel monitoringLevel;

    public Product(CreateProductCommand command) {
        this.brand = command.brand();
        this.serialNumber = command.serialNumber();
        this.model = command.model();
        this.monitoringLevel = MonitoringLevel.valueOf(command.monitoringLevel());
    }


}
