package marviq.ogel.controller;

import marviq.ogel.dto.Machine2x2Dto;
import marviq.ogel.exception.ErrorResponse;
import marviq.ogel.service.Machine2x2Service;
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
@RequestMapping("/api/machine2x2")
public class Machine2x2Controller {

    private final Machine2x2Service machine2x2Service;


    @Autowired
    public Machine2x2Controller(Machine2x2Service machine2x2Service) {
        this.machine2x2Service = machine2x2Service;
    }


    @GetMapping
    public List<Machine2x2Dto> getAll() {
        return machine2x2Service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable(value = "id") Long id) {
        Optional<Machine2x2Dto> machine = machine2x2Service.getMachine(id);
        if (machine.isPresent()) {
            return new ResponseEntity<>(machine.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(new ErrorResponse("The machine was not found", 404), HttpStatus.NOT_FOUND);
    }

    @GetMapping("/totalNetProduction")
    public List<Double> getReport() {
        List<Machine2x2Dto> machineList = machine2x2Service.findAll();
        List<Double> netProductionList = new ArrayList<>();
        for (Machine2x2Dto machine : machineList) {
            double totalNetProduction = machine.getGrossProduction() - machine.getScrap();
            netProductionList.add(totalNetProduction);
        }
        return netProductionList;
    }

}
