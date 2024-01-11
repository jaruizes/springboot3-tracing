package com.jaruiz.examples.observability.producer.business.ports;

import com.jaruiz.examples.observability.producer.business.model.ProcessData;

public interface BServiceBusinessPort {
    ProcessData updateProcess(ProcessData processData);
}
