package com.jaruiz.examples.observability.producer.api.rest;

import java.net.URI;

import com.jaruiz.examples.observability.producer.api.rest.dto.ProcessDataDTO;
import com.jaruiz.examples.observability.producer.business.model.ProcessData;
import com.jaruiz.examples.observability.producer.business.ports.BServiceBusinessPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@Slf4j
public class BRestController {

    @Autowired
    BServiceBusinessPort bService;

    @PostMapping(path = "/b-service", consumes = "application/json", produces = "application/json")
    public ResponseEntity<ProcessDataDTO> updateProcess(@RequestBody final ProcessDataDTO processDataDTO) {
        log.info("Recibiendo petición REST");
        final ProcessData processData = bService.updateProcess(dto2BM(processDataDTO));
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
