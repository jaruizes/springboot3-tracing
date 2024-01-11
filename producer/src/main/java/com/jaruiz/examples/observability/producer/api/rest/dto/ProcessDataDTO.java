package com.jaruiz.examples.observability.producer.api.rest.dto;

import java.io.Serial;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProcessDataDTO implements Serializable {
    @Serial private static final long serialVersionUID = 1L;

    private Long id;
    private Integer initialValue;
    private Integer currentValue;
}
