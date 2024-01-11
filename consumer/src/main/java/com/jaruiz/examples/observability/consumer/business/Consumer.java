package com.jaruiz.examples.observability.consumer.business;

import com.jaruiz.examples.observability.consumer.business.model.ProcessData;
import com.jaruiz.examples.observability.consumer.business.ports.ConsumerBusinessPort;
import io.opentelemetry.instrumentation.annotations.WithSpan;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class Consumer implements ConsumerBusinessPort {

    @WithSpan
    public ProcessData updateProcess(ProcessData processData) {
        int nextValue = processData.getCurrentValue() * randomInt();
        final ProcessData processDataUpdated = new ProcessData(processData.getId(), processData.getInitValue(), nextValue);
        log.info("Process updated [id: {}, Init value: {}, Current value: {}]", processDataUpdated.getId(), processDataUpdated.getInitValue(), processDataUpdated.getCurrentValue());

        return processDataUpdated;
    }

    private Integer randomInt() {
        return (int) (Math.random() * 10);
    }
}
