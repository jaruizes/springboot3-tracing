package com.jaruiz.examples.observability.consumer.business.ports;

import com.jaruiz.examples.observability.consumer.business.model.ProcessData;

public interface ConsumerBusinessPort {
    ProcessData updateProcess(ProcessData processData);
}
