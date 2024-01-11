package com.jaruiz.examples.observability.producer.business.ports;

import com.jaruiz.examples.observability.producer.business.model.ProcessData;

public interface ProcessPublishPort {
    void publish(ProcessData processData);
}
