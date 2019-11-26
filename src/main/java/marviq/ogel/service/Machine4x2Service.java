package marviq.ogel.service;


import marviq.ogel.converter.Machine4x2Converter;
import marviq.ogel.dto.Machine4x2Dto;
import marviq.ogel.entity.Machine4x2;
import marviq.ogel.repository.Machine4x2Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class Machine4x2Service {

    private final Machine4x2Repository machine4x2Repository;
    private final Machine4x2Converter converter;

    @Autowired
    public Machine4x2Service(Machine4x2Repository machine4x2Repository, Machine4x2Converter converter) {
        this.machine4x2Repository = machine4x2Repository;
        this.converter = converter;
    }


    public List<Machine4x2Dto> findAll() {
        return machine4x2Repository.findAll().stream().map(converter::convert).collect(Collectors.toList());
    }

    public Optional<Machine4x2Dto> getMachine(Long id) {
        Optional<Machine4x2> machineById = machine4x2Repository.findById(id);
        return machineById.map(converter::convert);
    }

}
