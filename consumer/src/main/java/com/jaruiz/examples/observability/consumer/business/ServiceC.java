package com.jaruiz.examples.observability.consumer.business;

import com.jaruiz.examples.observability.consumer.business.model.ProcessData;
import com.jaruiz.examples.observability.consumer.business.ports.ServiceCBusinessPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ServiceC implements ServiceCBusinessPort {

    public ProcessData updateProcess(ProcessData processData) {
        final ProcessData processDataUpdated = new ProcessData(processData.getId(), processData.getInitValue(), processData.getCurrentValue() + 10);
        log.info("Updating process");
        log.info("Process updated - current value: " + processDataUpdated.getCurrentValue());

        return processDataUpdated;
    }
}
