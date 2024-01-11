package com.jaruiz.examples.observability.producer.business;

import com.jaruiz.examples.observability.producer.adapters.kafka.PublishService;
import com.jaruiz.examples.observability.producer.business.model.ProcessData;
import com.jaruiz.examples.observability.producer.business.ports.BServiceBusinessPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BService implements BServiceBusinessPort {

    @Autowired
    private PublishService publishService;

    public ProcessData updateProcess(ProcessData processData) {
        if (processData.getCurrentValue() < 0 && processData.getCurrentValue() > -20) {
            throw new RuntimeException("Esto es un fallo deliberado del servicio B");
        }

        final ProcessData processDataUpdated = new ProcessData(processData.getId(), processData.getInitValue(), processData.getCurrentValue() + 10);
        publishService.publish(processDataUpdated);

        return processDataUpdated;
    }
}
