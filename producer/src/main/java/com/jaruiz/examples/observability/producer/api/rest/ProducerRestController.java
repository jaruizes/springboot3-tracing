package com.jaruiz.examples.observability.producer.api.rest;

import java.net.URI;

import com.jaruiz.examples.observability.producer.api.rest.dto.ProcessDataDTO;
import com.jaruiz.examples.observability.producer.business.model.ProcessData;
import com.jaruiz.examples.observability.producer.business.ports.ProducerServiceBusinessPort;
import io.opentelemetry.instrumentation.annotations.SpanAttribute;
import io.opentelemetry.instrumentation.annotations.WithSpan;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@Slf4j
public class ProducerRestController {

    @Autowired ProducerServiceBusinessPort producerService;

    @PostMapping(path = "/process", consumes = "application/json", produces = "application/json")
    @WithSpan
    public ResponseEntity<ProcessDataDTO> initProcess(@SpanAttribute @RequestBody final ProcessDataDTO processDataDTO) {
        log.info("Recibiendo petición REST");
        final ProcessData processData = producerService.createProcess(dto2BM(processDataDTO));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                                                  .path("/{id}")
                                                  .buildAndExpand(processData.getId())
                                                  .toUri();

        return ResponseEntity.created(location).body(BM2DTO(processData));
    }

    private ProcessData dto2BM(ProcessDataDTO processDataDTO) {
        return new ProcessData(processDataDTO.getId(), processDataDTO.getInitialValue(), processDataDTO.getCurrentValue());
    }

    private ProcessDataDTO BM2DTO(ProcessData processData) {
        return new ProcessDataDTO(processData.getId(), processData.getInitValue(), processData.getCurrentValue());
    }
}
