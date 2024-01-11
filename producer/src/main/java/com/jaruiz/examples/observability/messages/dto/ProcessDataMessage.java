package com.jaruiz.examples.observability.messages.dto;

public class ProcessDataMessage {
    private Long id;
    private Integer initValue;
    private Integer currentValue;

    public ProcessDataMessage(Long id, Integer initValue, Integer finalValue) {
        this.id = id;
        this.initValue = initValue;
        this.currentValue = finalValue;
    }

    public Long getId() {
        return id;
    }

    public Integer getInitValue() {
        return initValue;
    }

    public Integer getCurrentValue() {
        return currentValue;
    }
}
