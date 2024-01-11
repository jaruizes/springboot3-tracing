package com.jaruiz.examples.observability.messages.dto;

public class ProcessDataMessage {
    private Long id;
    private Integer initValue;
    private Integer currentValue;

    public ProcessDataMessage() {}
    public ProcessDataMessage(Long id, Integer initValue, Integer currentValue) {
        this.id = id;
        this.initValue = initValue;
        this.currentValue = currentValue;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getInitValue() {
        return initValue;
    }

    public void setInitValue(Integer initValue) {
        this.initValue = initValue;
    }

    public Integer getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(Integer currentValue) {
        this.currentValue = currentValue;
    }
}
