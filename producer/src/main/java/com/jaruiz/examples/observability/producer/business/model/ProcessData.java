package com.jaruiz.examples.observability.producer.business.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProcessData {
    private Long id;
    private Integer initValue;
    private Integer currentValue;
}
