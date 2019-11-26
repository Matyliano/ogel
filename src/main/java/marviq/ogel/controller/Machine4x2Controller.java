package marviq.ogel.controller;


import marviq.ogel.dto.Machine4x2Dto;
import marviq.ogel.exception.ErrorResponse;
import marviq.ogel.service.Machine4x2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/machine4x2")
public class Machine4x2Controller {

    private final Machine4x2Service machine4x2Service;

    @Autowired
    public Machine4x2Controller(Machine4x2Service machine4x2Service) {
        this.machine4x2Service = machine4x2Service;
    }

    @GetMapping
    public List<Machine4x2Dto> getAll() {
        return machine4x2Service.findAll();
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable(value = "id") Long id) {
        Optional<Machine4x2Dto> machine = machine4x2Service.getMachine(id);
        if (machine.isPresent()) {
            return new ResponseEntity<>(machine.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(new ErrorResponse("The machine was not found", 404), HttpStatus.NOT_FOUND);
    }

    @GetMapping("/totalNetProduction")
    public List<Double> getReport() {
        List<Machine4x2Dto> machineList = machine4x2Service.findAll();
        List<Double> netProductionList = new ArrayList<>();
        for (Machine4x2Dto machine : machineList) {
            double totalNetProduction = machine.getGrossProduction() - machine.getScrap();
            netProductionList.add(totalNetProduction);
        }
        return netProductionList;
    }
}
