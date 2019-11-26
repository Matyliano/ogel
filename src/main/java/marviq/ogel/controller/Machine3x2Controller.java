package marviq.ogel.controller;


import marviq.ogel.dto.Machine2x2Dto;
import marviq.ogel.dto.Machine3x2Dto;
import marviq.ogel.exception.ErrorResponse;
import marviq.ogel.service.Machine3x2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;


@RestController
@RequestMapping("/api/machine3x2")
public class Machine3x2Controller {

    private final Machine3x2Service machine3x2Service;

    @Autowired
    public Machine3x2Controller(Machine3x2Service machine3x2Service) {
        this.machine3x2Service = machine3x2Service;
    }

    @GetMapping
    public Page<Machine3x2Dto> getAll(@PageableDefault(size = 15) Pageable pageable) {
        return machine3x2Service.findAll(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable(value = "id") Long id) {
        Optional<Machine3x2Dto> machine = machine3x2Service.getMachine(id);
        if (machine.isPresent()) {
            return new ResponseEntity<>(machine.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(new ErrorResponse("The machine was not found", 404), HttpStatus.NOT_FOUND);
    }
}
