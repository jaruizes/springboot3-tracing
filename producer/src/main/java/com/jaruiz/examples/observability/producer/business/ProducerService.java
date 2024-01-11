package com.jaruiz.examples.observability.producer.business;

import com.jaruiz.examples.observability.producer.adapters.kafka.KafkaPublishService;
import com.jaruiz.examples.observability.producer.business.model.ProcessData;
import com.jaruiz.examples.observability.producer.business.ports.ProducerServiceBusinessPort;
import io.opentelemetry.instrumentation.annotations.WithSpan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProducerService implements ProducerServiceBusinessPort {

    @Autowired
    private KafkaPublishService publishService;

    @WithSpan
    public ProcessData createProcess(ProcessData processData) {
        int nextValue = processData.getInitValue() * ((int) (Math.random() * 1000));
        long id = (long) (Math.random() * 1000000);
        final ProcessData processDataUpdated = new ProcessData(id, processData.getInitValue(), nextValue);
        publishService.publish(processDataUpdated);

        return processDataUpdated;
    }
}
