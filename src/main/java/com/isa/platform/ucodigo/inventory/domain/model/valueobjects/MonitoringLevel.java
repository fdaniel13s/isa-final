package com.isa.platform.ucodigo.inventory.domain.model.valueobjects;

import lombok.Getter;

/**
 * o), monitoringLevel (Integer, Obligatorio, Valores posibles 1
 * = Essential Monitoring, 2 = Advance Monitoring)
 */
@Getter
public enum MonitoringLevel {
    ESSENTIAL_MONITORING(1), ADVANCE_MONITORING(2);

    private final int value;

    MonitoringLevel(int value) {
        this.value = value;
    }

}
