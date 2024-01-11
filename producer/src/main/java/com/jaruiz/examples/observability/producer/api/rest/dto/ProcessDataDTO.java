package com.jaruiz.examples.observability.producer.api.rest.dto;

import java.io.Serial;
import java.io.Serializable;

public class ProcessDataDTO implements Serializable {
    @Serial private static final long serialVersionUID = 1L;

    private Long id;
    private Integer initialValue;
    private Integer currentValue;

    public ProcessDataDTO() { }

    public ProcessDataDTO(Long id, Integer initialValue, Integer currentValue) {
        this.id = id;
        this.initialValue = initialValue;
        this.currentValue = currentValue;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getInitialValue() {
        return initialValue;
    }

    public void setInitialValue(Integer initialValue) {
        this.initialValue = initialValue;
    }

    public Integer getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(Integer currentValue) {
        this.currentValue = currentValue;
    }
}
