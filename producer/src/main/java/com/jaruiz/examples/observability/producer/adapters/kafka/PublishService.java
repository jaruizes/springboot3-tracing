package com.jaruiz.examples.observability.producer.adapters.kafka;

import com.jaruiz.examples.observability.messages.dto.ProcessDataMessage;
import com.jaruiz.examples.observability.producer.business.model.ProcessData;
import com.jaruiz.examples.observability.producer.business.ports.ProcessPublishPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PublishService implements ProcessPublishPort {

    @Value("example")
    private String topicName;

    @Autowired
    private KafkaTemplate<String, ProcessDataMessage> kafkaTemplate;

    @Override public void publish(ProcessData processData) {
        log.info("Publishing to Kafka");
        kafkaTemplate.setObservationEnabled(true);
        kafkaTemplate.send(topicName, bm2Message(processData));
    }

    private ProcessDataMessage bm2Message(ProcessData processData) {
        return new ProcessDataMessage(processData.getId(), processData.getInitValue(), processData.getCurrentValue());
    }
}
