package com.jaruiz.examples.observability.consumer.api.kafka;

import com.jaruiz.examples.observability.messages.dto.ProcessDataMessage;
import com.jaruiz.examples.observability.consumer.business.model.ProcessData;
import com.jaruiz.examples.observability.consumer.business.ports.ConsumerBusinessPort;
import io.opentelemetry.instrumentation.annotations.SpanAttribute;
import io.opentelemetry.instrumentation.annotations.WithSpan;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ConsumerService {

    @Autowired
    private ConsumerBusinessPort consumer;

    @KafkaListener(topics = "process", groupId = "consumer")
    @WithSpan
    public void updateProcess(@SpanAttribute ProcessDataMessage processData) {
        log.info("Received message from Kafka [ID: {}, Init value: {}, Current value: {}]", processData.getId(), processData.getInitValue(), processData.getCurrentValue());
        consumer.updateProcess(messageToBM(processData));
    }

    private ProcessData messageToBM(ProcessDataMessage processDataMessage) {
        return new ProcessData(processDataMessage.getId(), processDataMessage.getInitValue(), processDataMessage.getCurrentValue());
    }
}
