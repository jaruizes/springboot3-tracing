package com.jaruiz.examples.observability.consumer.api.kafka;

import com.jaruiz.examples.observability.messages.dto.ProcessDataMessage;
import com.jaruiz.examples.observability.consumer.business.model.ProcessData;
import com.jaruiz.examples.observability.consumer.business.ports.ServiceCBusinessPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ConsumerService {

    @Autowired
    private ServiceCBusinessPort serviceC;

    @KafkaListener(topics = "example", groupId = "service-c")
    public void listenGroupFoo(ProcessDataMessage processData) {
        log.info("Received message from Kafka");
        log.info("Process id: " + processData.getId());

        serviceC.updateProcess(messageToBM(processData));
    }

    private ProcessData messageToBM(ProcessDataMessage processDataMessage) {
        return new ProcessData(processDataMessage.getId(), processDataMessage.getInitValue(), processDataMessage.getCurrentValue());
    }
}
